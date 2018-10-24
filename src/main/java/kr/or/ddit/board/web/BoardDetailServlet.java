package kr.or.ddit.board.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.border.Border;

import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.model.PostVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.util.PageVo;

/**
 * Servlet implementation class FreeBoardClickServlet
 */
@WebServlet(urlPatterns={"/boardDetailServlet","/boardPaging","/postDetail" ,"/postUpdate","/postUpdateSave"})

public class BoardDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//요청 URI로 로직 분기 
				String uri = request.getRequestURI();
				System.out.println("userServlet doGet : " + uri);	
				// URI == userAllList
				String bor_Name = request.getParameter("bor_Name");
				request.setAttribute("bor_Name", bor_Name);

				if(uri.equals("/boardPaging"))
					boardPaging(request, response);
				else if (uri.equals("/postDetail"))
					postDetail(request, response);
				else if (uri.equals("/postUpdate"))
					postUpdate(request, response);
				else if (uri.equals("/postUpdateSave"))
					postUpdateSave(request, response);
				
				
					//boradList(request, response);			
				//request.getRequestDispatcher("/board/boardDetail.jsp").forward(request, response);
	
	}
	
	/* paging 처리 */
	private void boardPaging(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String post_user = ((UserVo)request.getSession().getAttribute("user")).getUserId();
		System.out.println("session에서 아이디 가져오기  boardPaging : "+ post_user);
		
		String bor_Id = request.getParameter("bor_Id");
		
		PageVo pageVo = new PageVo();
		
		//Integer.parseInt-> 숫자로 변환
		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
		pageVo.setBor_Id(bor_Id);
		
		BoardServiceInf postService = new BoardService();
		
		Map<String , Object> resultMap = postService.selectBoardPageList(pageVo);
		
		List<PostVo> pageList = (List<PostVo>)resultMap.get("pageList");


		// 페이지 건수 
		int pageCnt = (int)resultMap.get("pageCnt");
		
		// request 객체에 저장 
		request.setAttribute("pageList", pageList);
		request.setAttribute("pageCnt", pageCnt);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardPagingList.jsp");
		rd.forward(request, response);
	}
	
	private void postDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		BoardServiceInf boardService = new BoardService();
		
		String post_Id = request.getParameter("post_Id");
		String postTitle = request.getParameter("postTitle");
		String postText = request.getParameter("postText");
		
		PostVo selectPost = boardService.selectPost(post_Id);
		
		System.out.println("selectPost : "  + selectPost.getPost_Cotent());
		
		request.setAttribute("selectPost", selectPost);
		// 사용자 상세 화면으로 위임 
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
		rd.forward(request, response);
		System.out.println(selectPost);
	}
	
	private void postUpdate(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String postId = request.getParameter("postId");
		String postTitle = request.getParameter("postTitle");
		String postText = request.getParameter("postText");

		request.setAttribute("postId", postId);
		request.setAttribute("postTitle", postTitle);
		request.setAttribute("postText", postText);
		
		System.out.println("이소형님"+postId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardUpdate.jsp");
		
		
		rd.forward(request, response);
	}
	
	private void postUpdateSave(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		BoardServiceInf boardService = new BoardService();
		
		String postId = request.getParameter("postId");
		String postTitle = request.getParameter("postTitle");
		String postText = request.getParameter("postText");
		
		System.out.println("postUpdateSave" + postId);
		System.out.println("postUpdateSave" + postTitle);
		System.out.println("postUpdateSave" + postText);
		
		PostVo postvo = new PostVo();
		postvo.setPost_Id(postId);
		postvo.setPost_Title(postTitle);
		postvo.setPost_Cotent(postText);

		System.out.println("postUpdateSave : "  + postvo);
		
		int updatepost = boardService.updatePost(postvo);
		
		request.setAttribute("postvo", postvo);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardDetail.jsp");
		rd.forward(request, response);

		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
