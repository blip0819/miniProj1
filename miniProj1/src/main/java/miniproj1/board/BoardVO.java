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
	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private String bwriter;
		
	private String action;
	private String searchKey;
	
	public BoardVO(int bno, String btitle, Date bdate, String bwriter) {
		this.bno =bno;
		this.btitle =btitle;
		this.bdate =bdate;
		this.bwriter =bwriter;
	}
	
	public boolean isEmptySearchKey() {
		return searchKey==null || searchKey.length() ==0;
	}

	public BoardVO(int bno, String btitle, String bcontent,  String bwriter, Date bdate) {
		this.bno = bno;
		this.btitle =btitle;
		this.bcontent = bcontent;
		this.bwriter =bwriter;
		this.bdate =bdate;
	}
}
