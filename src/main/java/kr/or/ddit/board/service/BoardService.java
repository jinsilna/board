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
	
	public Map<String, Object> selectBoardPageList(PageVo pageVo) {
		// 페이지에 해당 하는 유저 리스트(1~10건) 
		List<PageVo> pageList = boardDao.selectBoardPageList(pageVo);
		System.out.println("Service pageList : " + pageList);
		
		// 페이지 내비게이션을 위한 전체 유저 리스트 조회 
		int totalBoardCnt = boardDao.getBoardCnt();
		
		System.out.println("totalBoardCnt : " +totalBoardCnt);
		
		//리턴해야 하는게 두건일경우에는 (Map)
		// 결과를 담는 map
		Map<String , Object> resultMap = new HashMap<String , Object>();
		
		resultMap.put("pageList",pageList);
		//Math.ceil가 올림해주는 부분 
		resultMap.put("pageCnt",
				(int)Math.ceil((double)totalBoardCnt / pageVo.getPageSize()));
		
		return resultMap;
	}


	@Override
	public int getBoardCnt() {
		return boardDao.getBoardCnt();
	}
	/*public List<PostVo> postList(){
		return boardDao.postList();
	}*/
	


	@Override
	public PostVo selectPost(String post_Id) {
		return boardDao.selectPost(post_Id);
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

	@Override
	public PostVo checkboarId(String bor_Id) {
		return boardDao.checkboarId(bor_Id);
	}


	@Override
	public int updatePost(PostVo postVo) {
		return boardDao.updatePost(postVo);
	}


	@Override
	public int insertPost(PostVo postVo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
