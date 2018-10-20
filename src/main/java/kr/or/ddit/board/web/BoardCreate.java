package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.net.aso.b;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@WebServlet("/boardCreate")
public class BoardCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	/*	// BOARD
		// 전체리스트 뽑아오기 
		BoardServiceInf boardService = new BoardService();
		
		List<BoardVo> boardList = boardService.allboard();
		System.out.println("(Servlet) boardList : " + boardList);

		request.setAttribute("boardList", boardList);	
		request.getRequestDispatcher("/board/boardCreate.jsp").forward(request, response);*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardservice = new BoardService();
		String bor_Name = request.getParameter("bor_Name");
		String userId = request.getParameter("userId");
		String bor_Use = request.getParameter("bor_Use");
		String bor_Id = request.getParameter("bor_Id");

		BoardVo boardvo = new BoardVo();	
		
		boardvo.setBor_Id(bor_Id);
		boardvo.setBor_Name(bor_Name);
		boardvo.setBor_Use(bor_Use);
		boardvo.setUserId(userId);
		
		
		//게시판 추가 부분 
		if(bor_Id == null){
			boardvo.setBor_Name(request.getParameter("bor_Name"));
			boardvo.setUserId(request.getParameter("userId"));
			boardvo.setBor_Use(request.getParameter("bor_Use"));

			System.out.println(" 게시판 생성  : " + boardvo);

			int insertboard = boardservice.insertBoard(boardvo);

			request.setAttribute("boardvo", boardvo);

			//게시판 수정 부분 
		}else{
			boardvo.setBor_Name(request.getParameter("bor_Name"));
			boardvo.setUserId(request.getParameter("userId"));
			boardvo.setBor_Use(request.getParameter("bor_Use"));

			System.out.println(" 게시판 수정  : " + boardvo);

			int updateboard = boardservice.updateBoard(boardvo);

			request.setAttribute("boardvo", boardvo);
		}


	}

}































