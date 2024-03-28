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
		request.setAttribute("list", list);
		return "memberList";
	}
	
    public Object memberView(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
        System.out.println("상세보기");
        request.setAttribute("member", memberService.memberView(member));
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
       return "memberDelete";
	}
    
    public Object memberUpdateForm(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
    	System.out.println("회원 정보 수정 화면");
    	request.setAttribute("member", memberService.updateForm(member));
		return "memberUpdateForm";
	}
    
    public Object memberUpdate(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
    	System.out.println("회원탈퇴");
        
        int updated = memberService.memberUpdate(member);
        Map<String, Object> map = new HashMap<>();
        if (updated == 1) {
			map.put("status", 0);
		} else {
			map.put("status", -99);
			map.put("statusMessage", "회원가입이 완료되지 않았습니다. 다시 시도해주세요.");
		}
       return map;
	}

	public Object signUpForm(HttpServletRequest request) throws ServletException, IOException {
    	System.out.println("회원 가입 화면");
		return "signUpForm";
	}
	
	public Object memberInsert(HttpServletRequest request, MemberVO member) throws ServletException, IOException {
		System.out.println("회원 가입");
		System.out.println("mem : " + member);
		Map<String, Object> map = new HashMap<>();
		
		if (member.getMemberID() == null  || member.getMemberID().length() == 0) {
			map.put("status", -1);
			map.put("statusMessage", "사용자 아이디는 null 이거나 길이가 0인 문자열을 사용할 수 없습니다");
		} else {
			//1. 처리
			int updated = memberService.memberInsert(member);
			
			if (updated == 1) { //성공
				map.put("status", 0);
			} else {
				map.put("status", -99);
				map.put("statusMessage", "회원 가입이 실패하였습니다");
			}
		}
		return map;
	}

	
	public Object existedMemberID(HttpServletRequest request, MemberVO memberVO) throws ServletException, IOException {
		System.out.println("existUserId userid->" + memberVO.getMemberID());
		MemberVO existedMember = memberService.memberView(memberVO);
		Map<String, Object> map = new HashMap<>();
		System.out.println(existedMember);
		
		if (existedMember == null) { //사용가능한 아이디
			map.put("existedMember", false);
		} else { //사용 불가능 아아디 
			map.put("existedMember", true);
		}
		return map;
	}

}











