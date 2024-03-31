package miniproj1.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import miniproj1.board.BoardDAO;

public class BoardService {
	private static final long serialVersionUID = 1L;
    
	BoardDAO boardDAO = new BoardDAO();
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public BoardService() {
		super();
        // TODO Auto-generated constructor stub
	}
	
	public List<BoardVO> boardList(BoardVO board) throws ServletException, IOException {
		return boardDAO.boardList(board);
	}
	
	public BoardVO boardView(BoardVO board) throws ServletException, IOException {
		return boardDAO.boardView(board);
	}
	
	public int boardDelete(BoardVO board)throws ServletException, IOException {
		return boardDAO.boardDelete(board);
	}
	
	public BoardVO boardUpdateForm(BoardVO board)throws ServletException, IOException {
		return boardDAO.boardView(board);
	}
	
	public int boardUpdate(BoardVO board) throws ServletException, IOException {
		return boardDAO.boardUpdate(board);
	}
	
	public BoardVO boardInsertForm(BoardVO board) throws ServletException, IOException {
		return boardDAO.boardView(board);
	}
	
	public int boardInsert(BoardVO board) throws ServletException, IOException  {
		return boardDAO.boardInsert(board);
	}

	public int boardClear(BoardVO board) throws ServletException, IOException {
		return boardDAO.boardClear(board);
	}
	
	public int getTotalBoardCount() {
	    return boardDAO.getTotalBoardCount();
	}
}
