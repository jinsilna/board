package kr.or.ddit.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.util.PageVo;

public class BoardDao implements BoardDaoInf{

	
	
	// POST
	//============================================================================
	/**
	 * Method : selectBoardPageList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 페이징 처리를 위한 
	 */
	@Override
	public List<PostVo> selectBoardPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		List<PostVo>postList = session.selectList("post.selectBoardPageList",pageVo);
		
		session.close();
		return postList;
	}



	@Override
	public int getPostCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		int totalUserCnt= session.selectOne("post.getpostCnt");
		session.close();
		
		return totalUserCnt;
	}
	
	// BOARD
	//============================================================================
	
	
	/**
	 * Method : checkidboard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardId
	 * @return
	 * Method 설명 : 게시판 아이디 체크 
	 */
	@Override
	public BoardVo checkidboard(String bor_Id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		BoardVo boardVo = session.selectOne(bor_Id);
		session.close();
		
		return boardVo;
	}

	/**
	 * Method : allboard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 전체 가져오는 
	 */
	@Override
	public List<BoardVo> allboard() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();

		List<BoardVo> allboard= session.selectList("board.allboard");
		session.close();
		return allboard;
	}

	/**
	 * Method : boarduse
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 게시판 사용여부 체크
	 */
	@Override
	public List<BoardVo> boarduse() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();

		List<BoardVo> boarduse= session.selectList("board.boarduse");
		session.close();		
		return boarduse;
	}

	/**
	 * Method : insertBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 추가 
	 */
	@Override
	public int insertBoard(BoardVo boardVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertBoard = session.insert("board.insertBoard",boardVo);
		
		session.commit(); // 커밋 반드시
		session.close();
	
		return insertBoard;
	}
	/**
	 * Method : updateBoard
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param boardVo
	 * @return
	 * Method 설명 : 게시판 수정 
	 */
	@Override
	public int updateBoard(BoardVo boardVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		int updateBoard = session.insert("board.updateBoard",boardVo);
		
		session.commit(); // 커밋 반드시
		session.close();
	
		return updateBoard;
	}
	
	

}
