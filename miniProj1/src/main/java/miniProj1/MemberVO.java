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
}