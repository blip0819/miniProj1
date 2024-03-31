package miniproj1.board;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {
	private String bno;
	private String btitle;
	private String bcontent;
	private String bdate;
	private String bwriter;
		
	private String action;
	private String searchKey;
	

	public boolean isEmptySearchKey() {
		return searchKey==null || searchKey.length() ==0;
	}


//	public BoardVO(String bno, String btitle, String bdate, String bwriter) {
//		this(bno, btitle, bdate, bwriter, "", "", "");
//	}

	public BoardVO(String bno, String btitle, String bcontent, String bwriter, String bdate) {
		this.bno=bno;
		this.btitle=btitle;
		this.bcontent=bcontent;
		this.bwriter=bwriter;
		this.bdate=bdate;
	}


	public BoardVO(String bno, String btitle, String bwriter, String bdate) {
		this.bno=bno;
		this.btitle=btitle;
		this.bwriter=bwriter;
		this.bdate=bdate;
	}

	
}
