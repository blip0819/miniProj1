package miniproj1.member;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	private String memberID;
	private String memberPW;
	private String memberPW2;
	private String memberName;
	private String memberADDR;
	private String memberPhone;
	private String memberGen;
//	private List<String> memberHobbies;
	
	private String action;
	private String searchKey;
	
//	public MemberVO(String memberID, String memberName, String memberADDR, String memberPhone, String memberGen, List<String> memberHobbies) {
//		this.memberID=memberID;
//		this.memberName=memberName;
//		this.memberADDR=memberADDR;
//		this.memberPhone=memberPhone;
//		this.memberGen=memberGen;
//		this.memberHobbies=memberHobbies;
//	}

	public MemberVO(String memberID, String memberName, String memberADDR, String memberPhone, String memberGen) {
		this.memberID=memberID;
		this.memberName=memberName;
		this.memberADDR=memberADDR;
		this.memberPhone=memberPhone;
		this.memberGen=memberGen;
	}
	
	
	public boolean isEmptySearchKey() {
		return searchKey==null || searchKey.length() ==0;
	}
}