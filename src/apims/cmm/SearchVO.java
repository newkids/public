package apims.cmm;
public class SearchVO extends CommonPagingVO{
	private String sType;		// 조회조건 Type	ex) "title" / "contents" / "empNO" / ....
	private String sText;		// 검색어
	private String sBeginDate;	// 시작일
	private String sEndDate;	// 종료일
	
	
	public String getsType() {
		return sType;
	}
	public void setsType(String sType) {
		this.sType = sType;
	}
	public String getsText() {
		return sText;
	}
	public void setsText(String sText) {
		this.sText = sText;
	}
	public String getsBeginDate() {
		return sBeginDate;
	}
	public void setsBeginDate(String sBeginDate) {
		this.sBeginDate = sBeginDate;
	}
	public String getsEndDate() {
		return sEndDate;
	}
	public void setsEndDate(String sEndDate) {
		this.sEndDate = sEndDate;
	}
}
