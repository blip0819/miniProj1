package miniproj1.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    BoardController boardController = new BoardController();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	
	
	private Map<String, Object> convertMap(Map<String, String[]> map) {
		Map<String, Object> result = new HashMap<>();

		for (var entry : map.entrySet()) {
			if (entry.getValue().length == 1) {
				result.put(entry.getKey(), entry.getValue()[0]);
			} else {
				result.put(entry.getKey(), entry.getValue());
			}
		}
		
		return result;
	}
	
	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contentType = request.getContentType();
		
		ObjectMapper objectMapper = new ObjectMapper();
		BoardVO boardVO = null;
		if (contentType == null || contentType.startsWith("application/x-www-form-urlencoded")) {
			boardVO = objectMapper.convertValue(convertMap(request.getParameterMap()), BoardVO.class);
		} else if (contentType.startsWith("application/json")) {
			boardVO = objectMapper.readValue(request.getInputStream(), BoardVO.class);
		}
		
		String action = boardVO.getAction();
		Object result = switch(action) {
			case "boardList" -> boardController.boardList(request, boardVO);
			case "boardView" -> boardController.boardView(request, boardVO);
			case "boardDelete" -> boardController.boardDelete(request, boardVO);
			case "boardUpdateForm" -> boardController.boardUpdateForm(request, boardVO);
			case "boardUpdate" -> boardController.boardUpdate(request, boardVO);
			case "boardInsertForm" -> boardController.boardInsertForm(request, boardVO);
			case "boardInsert" -> boardController.boardInsert(request, boardVO);
			default -> "";
		};
		
		if (result instanceof Map map) {
			//json 문자열을 리턴 
			response.setContentType("application/json;charset=UTF-8");
			response.getWriter().append(objectMapper.writeValueAsString(map));
			System.out.println("hihi 문자열 : " + result);
			} 
		else if (result instanceof String url) {
				if (url.startsWith("redirect:")) {
					//리다이렉트 
					response.sendRedirect(url.substring("redirect:".length()));
//					System.out.println("hihi 리디렉션 : " + result);
				} else {
					//포워딩 
					RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/board/"+url+".jsp");
					rd.forward(request, response);
					System.out.println("hihi 포워딩 : " + result);
			}
		}
	}
}
