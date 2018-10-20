package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.PageVo;

public class UserService implements UserServiceInf {
	    UserDao userdao = new UserDao();
		
	
		@Override
		public UserVo selectUser(String userid){
			return userdao.selectUser(userid);
		}
	
		
	
		
	
		
}














