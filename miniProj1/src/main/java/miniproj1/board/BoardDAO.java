package miniproj1.board;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {
	private static Connection conn = null;
    private static PreparedStatement boardListPstmt = null;
    private static PreparedStatement boardListPstmt2 = null;
    private static PreparedStatement boardViewPstmt = null;
    private static PreparedStatement boardDeletePstmt = null;
    private static PreparedStatement boardUpdatePstmt = null;
    private static PreparedStatement boardInsertPstmt = null;

    static {

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mariadb://localhost:3306/miniProj_DB",
                    "bituser",
                    "1004"
            );
            System.out.println("연결 성공");
            conn.setAutoCommit(false);

            boardListPstmt = conn.prepareStatement("select * from TB_BOARD");
            boardListPstmt2 = conn.prepareStatement("select * from TB_BOARD where btitle like ?");
            boardViewPstmt = conn.prepareStatement("select * from TB_BOARD where bno = ?");
            boardDeletePstmt = conn.prepareStatement("delete from TB_BOARD where bno = ?");
            boardUpdatePstmt = conn.prepareStatement("update TB_BOARD set btitle=?, bcontent=? where bno=?");
            boardInsertPstmt = conn.prepareStatement("insert into TB_BOARD (btitle, bcontent, bdate) values (?, ?, NOW())");
            
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

		public List<BoardVO> boardList(BoardVO board) {
			List<BoardVO> list = new ArrayList<>();
	        try {
	            ResultSet rs = null;
	            if(board !=null && !board.isEmptySearchKey()) {
	            	boardListPstmt2.setString(1, "%" + board.getSearchKey() + "%");
	            	System.out.println("DAO 서치키 정상 작동");
	            	rs = boardListPstmt2.executeQuery();
	            } else {
	            	System.out.println("DAO 전체 목록 정상 작동");
	            	rs = boardListPstmt.executeQuery();
	            }

	            while (rs.next()) {
	                BoardVO boardVO = new BoardVO(
	                		  rs.getString("bno")
	                        , rs.getString("btitle")
	                        , rs.getString("bwriter")
	                        , rs.getString("bdate")
	                        );
	                list.add(boardVO);
	            }
	            rs.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
			}
		
		public BoardVO boardView(BoardVO boardVO) {
			try {
		        boardViewPstmt.setString(1, boardVO.getBno());
		        ResultSet rs = boardViewPstmt.executeQuery();
		        if (rs.next()) {
		        	boardVO = new BoardVO(
		        			rs.getString("bno"),
		                    rs.getString("btitle"),
		                    rs.getString("bcontent"),
		                    rs.getString("bwriter"),
		                    rs.getString("bdate")
		            );
		        }
		        rs.close();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    
		    System.out.println(boardVO);
		    return boardVO;
		}
		
		public int boardDelete(BoardVO board) {
			int updated = 0;
			try {
				boardDeletePstmt.setString(1, board.getBno());
	            updated = boardDeletePstmt.executeUpdate();
	            conn.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return updated;
		}
		
		public int boardUpdate(BoardVO board) {
//			System.out.println("업데이트 DAO 진입 성공 : " + board);
			int updated = 0;
			try {
				boardUpdatePstmt.setString(1, board.getBtitle());
				boardUpdatePstmt.setString(2, board.getBcontent());
				boardUpdatePstmt.setString(3, board.getBno());
	            updated = boardUpdatePstmt.executeUpdate();
	            conn.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return updated;
		}
		
		public int boardInsert(BoardVO board) {
			int updated = 0;
			try {
				boardInsertPstmt.setString(1, board.getBtitle());
				boardInsertPstmt.setString(2, board.getBcontent());
	            updated = boardInsertPstmt.executeUpdate();
	            conn.commit();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
			return updated;
		}

}
