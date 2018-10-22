package kr.or.ddit.board.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.util.PageVo;

public class BoardService implements BoardServiceInf{

	BoardDaoInf boardDao = new BoardDao();
	
	
	// POST
	//--------------------------------------------------------------------------------
	
	@Override
	public Map<String, Object> selectPostList(PageVo pageVo) {
		
		List<PostVo> pageList = boardDao.selectPostList(pageVo);
		
		// 페이지 네비게이션을 위한 전체 유저 리스트 조회 
		int totalUserCnt = boardDao.getPostCnt();
		
		// 결과를 담는 map 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageList", pageList);
		resultMap.put("pageCnt", (int)Math.ceil((double)totalUserCnt/pageVo.getPageSize()));
		
		return resultMap;
	}

	@Override
	public int getPostCnt() {
		return boardDao.getPostCnt();
	}
	

	// BOARD
	//================================================================================
	@Override
	public int insertBoard(BoardVo boardVo) {
		return boardDao.insertBoard(boardVo);
	}
	
	@Override
	public int updateBoard(BoardVo boardVo) {
		return boardDao.updateBoard(boardVo);
	}


	@Override
	public BoardVo checkidboard(String bor_Id) {
		return boardDao.checkidboard(bor_Id);
	}

	@Override
	public List<BoardVo> allboard() {
		return boardDao.allboard();
	}

	@Override
	public List<BoardVo> boarduse() {
		return boardDao.boarduse();
	}


	


}
