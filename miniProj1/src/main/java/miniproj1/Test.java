package miniProj1;

import java.util.List;

import org.eclipse.jdt.internal.compiler.batch.Main;

import lombok.experimental.var;

public class Test {

	public static void main(String[] args) {
		
		MemberDAO memberDAO = new MemberDAO();
//		List<MemberVO> memberVOs = memberDAO.list();
//		
//		for(var member : memberVOs) {
//			System.out.println(member);
//		}
//		
//		System.out.println("야 성공했냐?");
		
		MemberVO m = memberDAO.view("blip0819");
		
		System.out.println(m);
		
	}
}
