package kr.or.ddit.board.service;

import static org.junit.Assert.assertEquals;
import kr.or.ddit.board.model.BoardVo;

import org.junit.Test;

public class BoardServiceTest {

	private BoardServiceInf boardService;
 	
	@Test
	public void insertBoard() {
		
		BoardVo boardVo  = new BoardVo();
		
		boardVo.setBor_Id("29");
		boardVo.setBor_Name("자유게시판");
		boardVo.setBor_Use("Y");

		int cnt = boardService.insertBoard(boardVo);
		
		assertEquals(1, cnt);
		

	}
	@Test
	public void updateBoard(){
		
		BoardVo boardVo = new BoardVo();
		
		boardVo.setBor_Id("29");
		boardVo.setBor_Name("QNA게시판");
		boardVo.setBor_Use("N");
		
		
		int cnt = boardService.updateBoard(boardVo);
		
		assertEquals(1, cnt);
	}
}

























