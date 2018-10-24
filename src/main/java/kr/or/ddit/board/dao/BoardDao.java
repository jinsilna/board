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

	
	
	//=======POST=======================================================
	/**
	 * Method : selectBoardPageList
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param pageVo
	 * @return
	 * Method 설명 : 페이징 처리를 위한 
	 */
	@Override
	public List<PageVo> selectBoardPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
	
		List<PageVo> pageList = session.selectList("post.selectPostPageList", pageVo);
		
		session.close();
		
		// 매개변수가 없어서 값을 주지 않아도 된다 
		// 여러건을 조회할때에는 selectList를 사용한다
		// selectOne : 데이터가 한건 일 떄 
		// 메소드 인자 : 문자열 = 네임스페이스(일반적으로 모듈명을 이용) .쿼리아이디 
		return pageList;
	}
	/*
	public List<PostVo> postList(){
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<PostVo>postlist = session.selectList("post.postList");
		session.close();
		return postlist;
		
	}*/

	/**
	 * Method : getBoardCnt
	 * 작성자 : pc07
	 * 변경이력 :
	 * @return
	 * Method 설명 : 계층형 답글 가져오기 
	 */

	@Override
	public int getBoardCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		// selectOne : 데이터가 한건일때 사용하는것.
		// selectList : 데이터가 여러건일때
		// 메소드 인자  :  문자열 = 네임스페이스( 모듈명 )  , 쿼리 아이디 ( 쿼리) 
		int totalUserCnt= session.selectOne("post.getpostCnt");
		session.close();
		
		return totalUserCnt;
	}
	
	
	//============BOARD=====================================================
	
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
	 * Method : insertPost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 추가 
	 */
	@Override
	public int insertPost(PostVo postVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertPost = session.insert("post.insertPost",postVo);
		session.commit(); // 커밋 반드시
		session.close();
		return insertPost;
	}

	
	
	
	@Override
	public PostVo checkboarId(String bor_Id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		PostVo postVo = session.selectOne(bor_Id);
		//System.out.println("checkboarId : "  + bor_Id);
		session.close();
		
		return postVo;
	}
	
	
	
	
	/**
	 * Method : selectPost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param post_Id
	 * @return
	 * Method 설명 : 게시글에서 상세정보 조회를 위해 필요함 
	 */
	@Override
	public PostVo selectPost(String post_Id) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		
		PostVo postVo = session.selectOne("post.selectPost",post_Id);
		//System.out.println("selectPost" + post_Id);
		
		return postVo;
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
		int updateBoard = session.update("board.updateBoard",boardVo);
		
		//System.out.println( "dao 입니다 " + boardVo.toString());
		session.commit(); // 커밋 반드시
		//System.out.println(1);
		session.close();
	
		return updateBoard;
	}

	/**
	 * Method : updatePost
	 * 작성자 : pc07
	 * 변경이력 :
	 * @param postVo
	 * @return
	 * Method 설명 : 게시글 수정 
	 */
	@Override
	public int updatePost(PostVo postVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session= factory.openSession();
		int updateBoard = session.update("post.updatePost",postVo);
		//System.out.println( "dao 입니다 " + boardVo.toString());
		session.commit(); // 커밋 반드시
		//System.out.println(1);
		session.close();
		return updateBoard;
	}

	


}
