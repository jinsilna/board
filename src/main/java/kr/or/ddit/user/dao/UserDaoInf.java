package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public interface UserDaoInf {
	
	
	UserVo selectUser(String userid);
	
	
	


}