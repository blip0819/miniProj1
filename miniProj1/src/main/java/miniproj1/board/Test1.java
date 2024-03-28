package miniproj1.board;

public class Test1 {
	public static void main(String[] args) {
		
		BoardDAO boardDAO = new BoardDAO();
		
		BoardVO boardVO =BoardVO.builder()
				.btitle("ckckckc")
				.bcontent("dldkdk")
				.build();
		
		int udpate = boardDAO.boardInsert(boardVO);
		
		System.out.println("ddd : " + udpate);
	}

}
