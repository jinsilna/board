package kr.or.ddit.board.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;

@WebServlet(urlPatterns={"/boardNewServlet","/boardNewSaveServlet"})
public class BoardNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//요청 URI로 로직 분기 
			String uri = request.getRequestURI();
			System.out.println("userServlet doGet : " + uri);	
			// URI == userAllList
			String bor_Id = request.getParameter("bor_Id");
			request.setAttribute("bor_Id", bor_Id);

			if(uri.equals("/boardNewServlet"))
				boardNewServlet(request, response);
			else if (uri.equals("/boardNewSaveServlet"))
				boardNewSaveServlet(request, response);
	}
	
	private void boardNewServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			System.out.println("boardNewServlet");
			
			//session에서 아이디 가져오기 
			String post_user = ((UserVo)request.getSession().getAttribute("user")).getUserId();
			System.out.println("session에서 아이디 가져오기  : "+ post_user);
			request.getRequestDispatcher("/board/writenew.jsp").forward(request, response);
	}
	
	
	private void boardNewSaveServlet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.getRequestDispatcher("/board/freewritenew.jsp").forward(request, response);
	}

}
