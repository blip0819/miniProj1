package miniproj1;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import miniproj1.*;

public class MemberController {
	private static final long serialVersionUID = 1L;

	MemberService memberService = new MemberService();
    /**
     * @see HttpServlet#HttpServlet()
     */
		
    public MemberController() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Object memberList(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
		System.out.println("목록");
		
		List<MemberVO> list = memberService.memberList(member);
		System.out.println("컨트롤러까지는 성공");
		request.setAttribute("list", list);
		return "memberList";
	}
	
    public Object memberView(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
        System.out.println("상세보기");

        request.setAttribute("member", memberService.memberView(member));
        System.out.println("컨트롤러 왔다갔다 성공" + request.getAttribute("member"));
        return "memberView";
    }

    public Object memberDelete(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
		System.out.println("회원탈퇴");
        
        int updated = memberService.memberDelete(member);
        Map<String, Object> map = new HashMap<>();
        if (updated == 1) {
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "요청이 완료되지 않았습니다. 다시 시도해주세요.");
		}
       return map;
	}

}











