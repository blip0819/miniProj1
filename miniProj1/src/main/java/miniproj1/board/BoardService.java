package miniproj1.board;

import java.util.List;

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
	
	public List<BoardVO> boardList(BoardVO board){
		return boardDAO.boardList(board);
	}
	
	public BoardVO boardView(BoardVO board){
		return boardDAO.boardView(board);
	}
	
	public int boardDelete(BoardVO board){
		return boardDAO.boardDelete(board);
	}
	
	public BoardVO boardUpdateForm(BoardVO board){
		return boardDAO.boardView(board);
	}
	
	public int boardUpdate(BoardVO board){
		return boardDAO.boardUpdate(board);
	}
	
	public BoardVO boardInsertForm(BoardVO board){
		return boardDAO.boardView(board);
	}
	
	public int boardInsert(BoardVO board){
		return boardDAO.boardInsert(board);
	}
}
