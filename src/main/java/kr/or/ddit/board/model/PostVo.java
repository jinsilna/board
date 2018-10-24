package kr.or.ddit.board.model;

public class PostVo {
	  // 게시글
		private String post_Id;
		private String post_Title;
		private String post_Cotent;
		private String post_Del;
		private String userId;
		private String post_Date;
		private String post_IdFather;
		private String bor_Id;
		private int rnum;
		
		public String getPost_Id() {
			return post_Id;
		}
		public void setPost_Id(String post_Id) {
			this.post_Id = post_Id;
		}
		public String getPost_Title() {
			return post_Title;
		}
		public void setPost_Title(String post_Title) {
			this.post_Title = post_Title;
		}
		
		public String getPost_Cotent() {
			return post_Cotent;
		}
		public void setPost_Cotent(String post_Cotent) {
			this.post_Cotent = post_Cotent;
		}
		public String getPost_Del() {
			return post_Del;
		}
		public void setPost_Del(String post_Del) {
			this.post_Del = post_Del;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getPost_Date() {
			return post_Date;
		}
		public void setPost_Date(String post_Date) {
			this.post_Date = post_Date;
		}
		public String getPost_IdFather() {
			return post_IdFather;
		}
		public void setPost_IdFather(String post_IdFather) {
			this.post_IdFather = post_IdFather;
		}
		public String getBor_Id() {
			return bor_Id;
		}
		public void setBor_Id(String bor_Id) {
			this.bor_Id = bor_Id;
		}
		public int getRnum() {
			return rnum;
		}
		public void setRnum(int rnum) {
			this.rnum = rnum;
		}
		@Override
		public String toString() {
			return "PostVo [post_Id=" + post_Id + ", post_Title=" + post_Title
					+ ", post_Content=" + post_Cotent + ", post_Del="
					+ post_Del + ", userId=" + userId + ", post_Date="
					+ post_Date + ", post_IdFather=" + post_IdFather
					+ ", bor_Id=" + bor_Id + ", rnum=" + rnum + "]";
		}
		
		
}
