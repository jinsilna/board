package kr.or.ddit.board.login;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserServiceInf userService = new UserService();
		
		
		String userId =  request.getParameter("userId");
		String password = request.getParameter("password");
		
		UserServiceInf service = new UserService();		
		UserVo uservo  = service.selectUser(userId);
		
		
		//게시판 목록 출력
		BoardServiceInf boardService = new BoardService();
		
		// 게시판 사용을 Y로 해놓은거 
		List<BoardVo> boarduse = boardService.boarduse();
		

		// 게시판 전체 가져오기 
		List<BoardVo> boardList = boardService.allboard();
		
		HttpSession session = request.getSession();
		session.setAttribute("boarduse", boarduse);
		session.setAttribute("user", uservo);
		session.setAttribute("boardList", boardList);
		

		if(userId.equals(uservo.getUserId()) && password.equals(uservo.getPass())){
			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response); 
		}else{
			RequestDispatcher rd = request.getRequestDispatcher("/login/login.jsp");
			rd.forward(request, response); 
		}

	
	}
}
