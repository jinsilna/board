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
	public List<PageVo> selectBoardPageList(PageVo pageVo);

	
	/**  * Method   : getBoardCnt
	  * 작성자 : PC 
	  * 변경이력 :  
	  * @return
	  * Method 설명 :  게시판 전체 건수 조회 
	*/
	int getBoardCnt();

	
	
	/**
	 * Method : selectPost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param post_Id
	 * @return
	 * Method 설명 :	post_Id로 상세정보를 조회하기위해 
	 */
	PostVo selectPost(String post_Id);
	
	//===================================================================
	
	/*List<PostVo> postList();*/
	/**
	 * Method : chekborId
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param: ostVo
	 * @return
	 * Method 설명 : chekborId post에서 bor_id를 가져오기위해 필요한 쿼리 
	 */
	PostVo checkboarId(String bor_Id);

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
	 * Method : insertPost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 생성 (추가)
	 */
	int insertPost(PostVo postVo);
	
	
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
	 * Method : updatePost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 수정 
	 */
	int updatePost(PostVo postVo);
	
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




	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
