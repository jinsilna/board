package kr.or.ddit.board.model;

public class CommentsVo {

	// 댓글
	private String com_Id;
	private String com_Content;
	private String userId;
	private String com_Date;
	@Override
	public String toString() {
		return "CommentsVo [com_Id=" + com_Id + ", com_Content=" + com_Content
				+ ", userId=" + userId + ", com_Date=" + com_Date + "]";
	}
	public String getCom_Id() {
		return com_Id;
	}
	public void setCom_Id(String com_Id) {
		this.com_Id = com_Id;
	}
	public String getCom_Content() {
		return com_Content;
	}
	public void setCom_Content(String com_Content) {
		this.com_Content = com_Content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getCom_Date() {
		return com_Date;
	}
	public void setCom_Date(String com_Date) {
		this.com_Date = com_Date;
	}
	public CommentsVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
