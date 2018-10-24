package kr.or.ddit.util;

import kr.or.ddit.board.model.PostVo;

public class PageVo extends PostVo {
	private int page;
	private int pageSize;
	private int rnum;

	
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	private String bor_Id;
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public String getBor_Id() {
		return bor_Id;
	}
	public void setBor_Id(String bor_Id) {
		this.bor_Id = bor_Id;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public PageVo(){
		
	}
	@Override
	public String toString() {
		return "PageVo [page=" + page + ", pageSize=" + pageSize + ", bor_Id="
				+ bor_Id + "]";
	}
	
	
	
}
