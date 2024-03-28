package miniproj1.board;

import java.io.IOException;
import java.util.List;

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

	public Object boardView(HttpServletRequest request, BoardVO board) {
		System.out.println("상세보기");
		return null;
	}

	public Object boardDelete(HttpServletRequest request, BoardVO board) {
		System.out.println("게시글 삭제");
		int updated = boardService.boardDelete(board);
		if (updated == 1) {
			return "boardDelete";
		} else {
			return null;
		}
	}

	public Object boardUpdateForm(HttpServletRequest request, BoardVO board) {
		System.out.println("게시글 수정 화면");
		request.setAttribute("board", boardService.boardUpdate(board));
		return "boardUpdateForm";
	}

	public Object boardUpdate(HttpServletRequest request, BoardVO board) {
		System.out.println("게시글 수정 완료");
		int updated = boardService.boardUpdate(board);
		if (updated == 1) {
			return "boardUpdate";
		} else {
			return null;
		}
	}

	public Object boardInsertForm(HttpServletRequest request, BoardVO board) {
		System.out.println("게시글 작성 화면");
		return "boardInsertForm";
	}

	public Object boardInsert(HttpServletRequest request, BoardVO board) {
		System.out.println("게시글 작성 완료");
		int updated = boardService.boardInsert(board);
		if (updated == 1) {
			return "boardInsert";
		} else {
			return null;
		}

	}
	

}
