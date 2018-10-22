package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.util.PageVo;

/**
 * Servlet implementation class FreeBoardClickServlet
 */
@WebServlet(urlPatterns={"/boardDetailServlet","/boardPaging"})

public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//요청 URI로 로직 분기 
				String uri = request.getRequestURI();
				System.out.println("userServlet doGet : " + uri);	
				// URI == userAllList
				String bor_Name = request.getParameter("bor_Name");
				if(uri.equals("/boardPaging"))
					request.setAttribute("bor_Name", bor_Name);
					boardPaging(request, response);
					//boradList(request, response);			
				//request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	
	}
	
	/* paging 처리 */
	private void boardPaging(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		// userservice 생성
		BoardServiceInf  boardService = new BoardService();
		
		// userPageList 호출: 메소드 인자 - pageVo - page, pageSize
		PageVo pagevo = new PageVo();
		pagevo.setBor_Id(request.getParameter("bor_Id"));
		pagevo.setPage(Integer.parseInt(request.getParameter("page")));
		pagevo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		
		Map<String,Object> resultMap = boardService.selectPostList(pagevo);
		
		// 페이지 리스트
		List<PostVo> postPageList= (List<PostVo>)resultMap.get("postList");
		// 페이지 건수 
		int pageCnt = (int)resultMap.get("pageCnt");
		// 단일 요청 건에는 request 객체에 저장한다. 
		request.setAttribute("postPageList", postPageList);
		request.setAttribute("pageCnt", pageCnt);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardPagingList.jsp");
		rd.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
