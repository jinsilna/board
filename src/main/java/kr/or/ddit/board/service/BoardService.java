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
	public Map<String, Object> selectBoardPageList(PageVo pageVo) {

		List<PostVo> postList = boardDao.selectBoardPageList(pageVo);
		int totalBoardCnt = boardDao.getPostCnt();
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("postList",postList);
		resultMap.put("pageCnt",(int)Math.ceil((double)totalBoardCnt/pageVo.getPageSize()));
		
		return resultMap;
	}
	
	
	@Override
	public int getPostCnt() {
		return 0;
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
