package miniproj1;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO = new MemberDAO();
	MemberController memberController = new MemberController();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberServlet() {
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
		MemberVO memberVO = null;
		if (contentType == null || contentType.startsWith("application/x-www-form-urlencoded")) {
			memberVO = objectMapper.convertValue(convertMap(request.getParameterMap()), MemberVO.class);
		} else if (contentType.startsWith("application/json")) {
			memberVO = objectMapper.readValue(request.getInputStream(), MemberVO.class);
		}
		System.out.println("memberVO " + memberVO);
		
		String action = memberVO.getAction();
		Object result = switch(action) {
		case "memberList" -> memberController.memberList(request, memberVO);
		case "memberView" -> memberController.memberView(request, memberVO);
		case "memberDelete" -> memberController.memberDelete(request, memberVO);
		default -> "";
		};
		
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/member/"+action+".jsp");
			rd.forward(request, response);
		}
}
