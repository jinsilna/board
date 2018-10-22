package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/freeBoardNewSaveservlet")
public class FreeBoardNewSaveservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/freeboardPagingList.jsp").forward(request, response);

		// BOARD
		// 전체리스트 뽑아오기 
		BoardServiceInf boardService = new BoardService();
		
		List<BoardVo> boardList = boardService.allboard();
		System.out.println("(Servlet) boardList : " + boardList);

		request.setAttribute("boardList", boardList);	
		request.getRequestDispatcher("/board/boardCreate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
