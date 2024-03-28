package miniproj1;

import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import lombok.experimental.var;
import miniproj1.member.MemberDAO;

public class Test {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
//		List<MemberVO> memberVOs = memberDAO.memberList();
//		
//		for(var member : memberVOs) {
//			System.out.println(member);
//		}
//		
		System.out.println("야 성공했냐?");
		
//		MemberVO m = memberDAO.memberView("blip0819");
//		
//		System.out.println(m);
//		
//		int updatedreal =memberDAO.memberDelete("ddsss");
//		System.out.println(updatedreal);
	}
}
