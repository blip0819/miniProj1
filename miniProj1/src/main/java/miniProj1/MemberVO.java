package miniProj1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	String memberID;
	String memberPW;
	String memberName;
	String memberADDR;
	String memberPhone;
	String memberGen;
	
	public MemberVO(String memberID, String memberName, String memberADDR, String memberPhone, String memberGen) {
		this.memberID=memberID;
		this.memberName=memberName;
		this.memberADDR=memberADDR;
		this.memberPhone=memberPhone;
		this.memberGen=memberGen;
	}
}