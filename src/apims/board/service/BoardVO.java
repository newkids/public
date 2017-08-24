package apims.board.service;

import java.util.Date;

public class BoardVO {
	private int boardNo;
	private String boardTitle;
	private String boardUser;
	private String boardPw;
	private String boardContent;
	private Date boardDate;
	
	public BoardVO(){}
		
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

//	public Date getBoardDate() {
//		return boardDate;
//	}
//
//	public void setBoardDate(Date boardDate) {
//		this.boardDate = boardDate;
//	}

	public String getBoardUser() {
		return boardUser;
	}
	public void setBoardUser(String boardUser) {
		this.boardUser = boardUser;
	}
	public String getBoardPw() {
		return boardPw;
	}
	public void setBoardPw(String boardPw) {
		this.boardPw = boardPw;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
//	public Date getBoardDate() {
//		return boardDate;
//	}
//	public void setBoardDate(Date boardDate) {
//		Date d = new Date();
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        boardDate=sdf.format(d);
//		this.boardDate = boardDate;
//	}
	
	
}
