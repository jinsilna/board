package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public interface BoardDaoInf {

	//===============================================================
	// POST
	/**
	 * Method : selectPostList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : page List 
	 */
	public List<PostVo> selectPostList(PageVo pageVo);
	
	
	List<PostVo> postList();

	

	//--------------------------------------------------------------------
	// BOARD
	/**
	 * Method : insertBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 생성(추가)
	 */
	int insertBoard(BoardVo boardVo);
	
	
	
	/**
	 * Method : updateBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 수정 
	 */
	int updateBoard(BoardVo boardVo);
	
	
	/**
	 * Method : checkidboard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardId
	 * @return
	 * Method 설명 : 게시판 작성자 판단 
	 */
	BoardVo checkidboard(String bor_Id);
	
	
	
	/**
	 * Method : allboard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 가져오는 
	 */
	List<BoardVo> allboard();
	
	/**
	 * Method : boarduse
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 사용여부 체크
	 */
	List<BoardVo> boarduse();




	int getPostCnt();



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
