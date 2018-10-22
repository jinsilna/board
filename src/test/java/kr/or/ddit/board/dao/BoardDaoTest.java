package kr.or.ddit.board.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

import org.junit.Test;

public class BoardDaoTest {

	private BoardDaoInf boardDao = new BoardDao();
 	
	@Test
	public void insertBoard() {
		
		BoardVo boardVo  = new BoardVo();
		
		boardVo.setBor_Id("29");
		boardVo.setBor_Name("자유게시판");
		boardVo.setBor_Use("Y");
		boardVo.setBor_Date("20180808");
		boardVo.setUserId("sally");

		int cnt = boardDao.insertBoard(boardVo);
		
		assertEquals(1, cnt);
		

	}
	@Test
	public void updateBoard(){
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBor_Id("29");
		boardVo.setBor_Name("QNA게시판");
		boardVo.setBor_Use("N");
		boardVo.setUserId("sally");
		boardVo.setBor_Date("20180808");
		
		System.out.println(boardVo);
		
		int cnt = boardDao.updateBoard(boardVo);
		System.out.println("cnt : " + cnt);
		
		
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void selectPostPageList(){
		
		PageVo pagevo = new PageVo();
		
		pagevo.setPage(1);
		pagevo.setPageSize(10);
		
		List<PostVo> postList = boardDao.selectPostList(pagevo);
		
		assertEquals(10, pagevo.getPageSize());
		
	}
}

























