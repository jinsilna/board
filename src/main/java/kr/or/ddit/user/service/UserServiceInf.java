package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public interface UserServiceInf {
	
	
	UserVo selectUser(String userid);
	
	
	

}