package miniproj1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberVO {

	private String memberID;
	private String memberPW;
	private String memberName;
	private String memberADDR;
	private String memberPhone;
	private String memberGen;
	
	private String action;
	private String searchKey;
	
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