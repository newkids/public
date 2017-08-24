package apims.cmm;
public class CommonPagingVO {

	/* 페이징 */
	private int userPageIndex = 1;
	private int deptPageIndex = 1;
	private int pageIndex = 1;						// 현재 페이지
    private int firstIndex = 1;						// 시작 인덱스
    private int lastIndex = 1;						// 끝 인덱스
    private int recordCountPerPage = 10;			// 페이지 별 레코드 갯수
    private int pageUnit = 10; 						// 페이징
    private int pageSize = 10;						// 페이징
    
    
    /* 기타 */
    private String thisVersion = "LOCAL";			// 버전


	public int getUserPageIndex() {
		return userPageIndex;
	}


	public void setUserPageIndex(int userPageIndex) {
		this.userPageIndex = userPageIndex;
	}


	public int getDeptPageIndex() {
		return deptPageIndex;
	}


	public void setDeptPageIndex(int deptPageIndex) {
		this.deptPageIndex = deptPageIndex;
	}


	public int getPageIndex() {
		return pageIndex;
	}


	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}


	public int getPageUnit() {
		return pageUnit;
	}


	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}


	public int getPageSize() {
		return pageSize;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


	public int getFirstIndex() {
		return firstIndex;
	}


	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}


	public int getLastIndex() {
		return lastIndex;
	}


	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}


	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}


	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}


	public String getThisVersion() {
		return thisVersion;
	}


	public void setThisVersion(String thisVersion) {
		this.thisVersion = thisVersion;
	}


}
