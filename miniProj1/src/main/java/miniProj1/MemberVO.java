package miniProj1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
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