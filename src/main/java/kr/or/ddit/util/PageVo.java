package kr.or.ddit.util;

public class PageVo {
	private int page;
	private int pageSize;
	
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
