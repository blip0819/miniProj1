package miniProj1;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	MemberDAO memberDAO = new MemberDAO();
       
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

	private void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		switch(action) {
		case "memberList" -> memberList(request, response);
		case "memberView" -> memberView(request, response);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/member/" + action + ".jsp");
	    rd.forward(request, response);
	}

	private void memberView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("상세보기");
        String memberID = request.getParameter("memberID");
        
        MemberVO memberVO = memberDAO.view(memberID);
        request.setAttribute("member", memberVO);
    }

	private void memberList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("목록");
		
		List<MemberVO> list = memberDAO.list();
		request.setAttribute("list", list);
	}

}
