package miniproj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.eclipse.jdt.internal.compiler.batch.Main;


public class MemberDAO {
	private static Connection conn = null;
    private static PreparedStatement memberListPstmt = null;
    private static PreparedStatement memberListPstmt2 = null;
    private static PreparedStatement memberViewPstmt = null;
    private static PreparedStatement memberDeletePstmt = null;

	static {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/miniProj_DB",
                    "bituser",
                    "1004"
            );
            System.out.println("연결 성공 대박");
            conn.setAutoCommit(false);

            memberListPstmt = conn.prepareStatement("select * from TB_MEMBER");
            memberListPstmt2 = conn.prepareStatement("select * from TB_MEMBER where memberID like ?");
            memberViewPstmt = conn.prepareStatement("select * from TB_MEMBER where memberID=?");
            memberDeletePstmt = conn.prepareStatement("delete from TB_MEMBER where memberID=?");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

	public List<MemberVO> memberList(MemberVO member){
        List<MemberVO> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            if(member !=null && !member.isEmptySearchKey()) {
            	memberListPstmt2.setString(1, "%" + member.getSearchKey() + "%");
            	System.out.println("DAO 서치키 정상 작동");
            	rs = memberListPstmt2.executeQuery();
            } else {
            	System.out.println("DAO 전체 목록 정상 작동");
            	rs = memberListPstmt.executeQuery();
            }
            
            while (rs.next()) {
                MemberVO memberVO = new MemberVO(
                		  rs.getString("memberID")
                        , rs.getString("memberName")
                        , rs.getString("memberADDR")
                        , rs.getString("memberPhone")
                        , rs.getString("memberGen"));
                list.add(memberVO);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public MemberVO memberView(MemberVO memberVO) {
        MemberVO member = null;
        try {
            memberViewPstmt.setString(1, memberVO.getMemberID());
            System.out.println("DAO 쿼리문 정상 작동");
            ResultSet rs = memberViewPstmt.executeQuery();
            if (rs.next()) {
            	memberVO = new MemberVO(
                		  rs.getString("memberID")
                        , rs.getString("memberName")
                        , rs.getString("memberADDR")
                        , rs.getString("memberPhone")
                        , rs.getString("memberGen")
                		);
            }
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("memberView->" + memberVO);
        return memberVO;
    }
	
	public int memberDelete(MemberVO member) {
        int updated = 0;

        try {
            memberDeletePstmt.setString(1, member.getMemberID());
            updated = memberDeletePstmt.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }

}
