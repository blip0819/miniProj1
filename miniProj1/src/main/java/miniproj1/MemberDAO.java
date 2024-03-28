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
    private static PreparedStatement memberUpdatePstmt = null;
    private static PreparedStatement memberInsertPstmt = null;
    
    private static PreparedStatement memberPWValidPstmt = null;
    private static PreparedStatement memberIDValidPstmt = null;

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
            memberUpdatePstmt = conn.prepareStatement("update TB_MEMBER set memberName=?, memberPW=?, memberADDR=?, memberPhone=?, memberGen=? where memberID=?");
            memberInsertPstmt = conn.prepareStatement("insert into TB_MEMBER (memberID, memberName, memberPW, memberADDR, memberPhone, memberGen) values (?, ?, ?, ?, ?, ?)");
            
            memberPWValidPstmt = conn.prepareStatement("select memberPW from TB_MEMBER where memberPW=?");
            memberIDValidPstmt = conn.prepareStatement("select userid from users where userid=?");
            
            
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
                        , rs.getString("memberGen")
                        );
                list.add(memberVO);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
	
	public MemberVO memberView(MemberVO memberVO) {
	    try {
	        memberViewPstmt.setString(1, memberVO.getMemberID());
	        System.out.println("DAO 쿼리문 정상 작동");
	        ResultSet rs = memberViewPstmt.executeQuery();
	        if (rs.next()) {
	        	memberVO = new MemberVO(
	                    rs.getString("memberID"),
	                    rs.getString("memberName"),
	                    rs.getString("memberADDR"),
	                    rs.getString("memberPhone"),
	                    rs.getString("memberGen")
	            );
//	            // 취미 정보 조회
//	            memberVO.setMemberHobbies(getMemberHobbies(memberVO.getMemberID()));
	        }
	        rs.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    System.out.println(memberVO);
	    return memberVO;
	}

//	private List<String> getMemberHobbies(String memberID) throws SQLException {
//	    List<String> hobbies = new ArrayList<>();
//	    PreparedStatement selectPstmt = conn.prepareStatement("SELECT memberHOBBY FROM TB_MEMHOBBY WHERE memberID=?");
//	    selectPstmt.setString(1, memberID);
//	    ResultSet rs = selectPstmt.executeQuery();
//	    while (rs.next()) {
//	        hobbies.add(rs.getString("memberHOBBY"));
//	    }
//	    return hobbies;
//	}
	
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

	public int memberUpdate(MemberVO member) {
	    int updated = 0;

	    try {
	        memberUpdatePstmt.setString(1, member.getMemberName());
	        memberUpdatePstmt.setString(2, member.getMemberPW());
	        memberUpdatePstmt.setString(3, member.getMemberADDR());
	        memberUpdatePstmt.setString(4, member.getMemberPhone());
	        memberUpdatePstmt.setString(5, member.getMemberGen());
	        memberUpdatePstmt.setString(6, member.getMemberID());
//	        // 취미 정보를 업데이트
//	        updateMemberHobbies(member.getMemberID(), member.getMemberHobbies());
	        updated = memberUpdatePstmt.executeUpdate();
	        
	        conn.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return updated;
	}
	
	public int memberInsert(MemberVO member) {
	    int updated = 0;

	    try {
	        memberInsertPstmt.setString(1, member.getMemberID());
	        memberInsertPstmt.setString(2, member.getMemberName());
	        memberInsertPstmt.setString(3, member.getMemberPW());
	        memberInsertPstmt.setString(4, member.getMemberADDR());
	        memberInsertPstmt.setString(5, member.getMemberPhone());
	        memberInsertPstmt.setString(6, member.getMemberGen());
	        
	        updated = memberInsertPstmt.executeUpdate();
	        
	        conn.commit();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return updated;
	}
	
	
	
	
	public boolean validationPassword(String memberPW){
        boolean result = false;
        try {
        	memberPWValidPstmt.setString(1, memberPW);
            ResultSet rs = memberPWValidPstmt.executeQuery();
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	
	public boolean validationID(String memberID){
        boolean result = false;
        try {
            memberIDValidPstmt.setString(1, memberID);
            ResultSet rs = memberIDValidPstmt.executeQuery();
            if (rs.next()) {
                result = true;
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
    }
        return result;
    }
	
	
//	private void updateMemberHobbies(String memberID, List<String> hobbies) throws SQLException {
//	    // 기존의 취미 정보 삭제
//	    deleteMemberHobbies(memberID);
//	    // 새로운 취미 정보 입력
//	    insertMemberHobbies(memberID, hobbies);
//	}
//
//	private void deleteMemberHobbies(String memberID) throws SQLException {
//	    PreparedStatement deletePstmt = conn.prepareStatement("DELETE FROM TB_MEMHOBBY WHERE memberID=?");
//	    deletePstmt.setString(1, memberID);
//	    deletePstmt.executeUpdate();
//	}
//
//	private void insertMemberHobbies(String memberID, List<String> hobbies) throws SQLException {
//	    PreparedStatement insertPstmt = conn.prepareStatement("INSERT INTO TB_MEMHOBBY (memberID, memberHOBBY) VALUES (?, ?)");
//	    for (String hobby : hobbies) {
//	        insertPstmt.setString(1, memberID);
//	        insertPstmt.setString(2, hobby);
//	        insertPstmt.executeUpdate();
//	    }
//
//	}
}
