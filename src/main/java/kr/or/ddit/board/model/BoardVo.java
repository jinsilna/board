package kr.or.ddit.board.model;

public class BoardVo {
	// 게시판 
	private String bor_Id;   // 게시판 아이디
	private String bor_Name; // 게시판 이름 
	private String bor_Use;  // 게시판 사용여부
	private String userId;   // 회원아이디
	private String bor_Date; // 게시판 등록일
	
	//----------------------------------------------------------------------
	@Override
	public String toString() {
		return "BoardVo [bor_Id=" + bor_Id + ", bor_Name=" + bor_Name
				+ ", bor_Use=" + bor_Use + ", userId=" + userId + ", bor_Date="
				+ bor_Date + "]";
	}
	public String getBor_Id() {
		return bor_Id;
	}
	public void setBor_Id(String bor_Id) {
		this.bor_Id = bor_Id;
	}
	public String getBor_Name() {
		return bor_Name;
	}
	public void setBor_Name(String bor_Name) {
		this.bor_Name = bor_Name;
	}
	public String getBor_Use() {
		return bor_Use;
	}
	public void setBor_Use(String bor_Use) {
		this.bor_Use = bor_Use;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getBor_Date() {
		return bor_Date;
	}
	public void setBor_Date(String bor_Date) {
		this.bor_Date = bor_Date;
	}
	public BoardVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
