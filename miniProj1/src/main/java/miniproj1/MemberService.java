package miniproj1;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

public class MemberService {
	private static final long serialVersionUID = 1L;
	      
	MemberDAO memberDAO = new MemberDAO();
	/**
	* @see HttpServlet#HttpServlet()
	*/
	public MemberService() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

	    public List<MemberVO> memberList(MemberVO member) throws ServletException, IOException {
			return memberDAO.memberList(member);
		}
		
		public MemberVO memberView(MemberVO member) throws ServletException, IOException {
			return memberDAO.memberView(member);
		}
		
		public int memberDelete(MemberVO member) throws ServletException, IOException {
			return memberDAO.memberDelete(member);
		}
		
		
}
