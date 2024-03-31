package miniproj1.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;


public class BoardController {
	private static final long serialVersionUID = 1L;
	BoardService boardService = new BoardService();
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public BoardController() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Object boardList(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("목록");
				
		List<BoardVO> list = boardService.boardList(board);
		request.setAttribute("list", list);
		return "boardList";
	}

	public Object boardView(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("상세보기");
		request.setAttribute("board", boardService.boardView(board));
		return "boardView";
	}

	public Object boardDelete(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		int updated = boardService.boardDelete(board);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 삭제에 실패하였습니다");
		}
		
		return "boardDelete";
		
	}
	
	public Object boardClear(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
	    int totalBoardCount = boardService.getTotalBoardCount();
	    int updated = boardService.boardClear(board);
	    
	    Map<String, Object> map = new HashMap<>();
	    if (updated == totalBoardCount) { // 성공
	        map.put("status", 0);
	    } else {
	        map.put("status", -99);
	        map.put("statusMessage", "게시물 전체 삭제에 실패하였습니다");
	    }
	    
	    return "boardList";
	}


	public Object boardUpdateForm(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("게시글 수정 화면");
		request.setAttribute("board", boardService.boardUpdateForm(board));
		return "boardUpdateForm";
	}

	public Object boardUpdate(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("게시글 수정 완료");
		
		int updated = boardService.boardUpdate(board);
		
		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시물 수정에 실패하였습니다.");
		}
		
		return map;
	}

	public Object boardInsertForm(HttpServletRequest request) throws ServletException, IOException {
		System.out.println("게시글 작성 화면");
		return "boardInsertForm";
	}

	public Object boardInsert(HttpServletRequest request, BoardVO board) throws ServletException, IOException {
		System.out.println("게시글 게시 완료");
		
		int updated = boardService.boardInsert(board);

		Map<String, Object> map = new HashMap<>();
		if (updated == 1) { //성공
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "게시글 작성에 실패했습니다.");
		}
		return map;
	}
	

}
