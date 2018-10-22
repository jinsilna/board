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
@WebServlet(urlPatterns={"/freeBoardDetailServlet","/freeBoardPaging"})

public class FreeBoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/board/freeboardDetail.jsp").forward(request, response);
		//요청 URI로 로직 분기 
				String uri = request.getRequestURI();
				System.out.println("userServlet doGet : " + uri);	
				// URI == userAllList
				if(uri.equals("/freeBoardPaging"))
					freeBoardPaging(request, response);
					//boradList(request, response);
			
	
				
	}



	@SuppressWarnings("unchecked")
	private void freeBoardPaging(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("freeBoardPaging");	

		// userservice 생성
		BoardServiceInf  boardService = new BoardService();
		

		System.out.println(1);
		// userPageList 호출: 메소드 인자 - pageVo - page, pageSize

		PageVo pagevo = new PageVo();
		pagevo.setPage(Integer.parseInt(request.getParameter("page")));
		pagevo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		System.out.println(pagevo);

		System.out.println(pagevo.getPageSize());
		Map<String,Object> resultMap = boardService.selectBoardPageList(pagevo);
		
		// 페이지 리스트
		List<PostVo> boardPageList= (List<PostVo>)resultMap.get("postList");

				
		System.out.println("boardPageList : " +boardPageList.toString());

		// 페이지 건수 
		int pageCnt = (int)resultMap.get("pageCnt");

		// 단일 요청 건에는 request 객체에 저장한다.
		request.setAttribute("boardPageList", boardPageList);
		request.setAttribute("pageCnt", pageCnt);

		// forward ( userAllList.jsp --> userPagingList.jsp )
		RequestDispatcher rd = request.getRequestDispatcher("/board/freeBoardPagingList.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
