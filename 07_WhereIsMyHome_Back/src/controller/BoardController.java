package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import dto.Member;
import dto.Notice;
import model.service.BoardService;

@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	BoardService boardService;
	public void init(ServletConfig config) throws ServletException {
		boardService = BoardService.getInstance();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String signParam = request.getParameter("sign");
		
		if (signParam != null) {
			String path = "index.jsp";
			if ("mvnotice".equals(signParam)) {
				List<Notice> notices = boardService.selectNoticeAll();
				request.setAttribute("notices", notices);
				path = "notice.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			}else if("mvboardedit".equals(signParam)) {
				int idx = Integer.parseInt(request.getParameter("idx"));
				
				request.setAttribute("board",boardService.selectNoticeByIdx(idx));
				RequestDispatcher dispatcher = request.getRequestDispatcher("boardview.jsp");
				dispatcher.forward(request, response);
				
			}else if("boardedit".equals(signParam)) {
				int idx = Integer.parseInt(request.getParameter("idx"));
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				String writer = request.getParameter("writer");
				
				if(boardService.updateNotice(new Notice(idx,title,contents,writer))) {
					List<Notice> notices = boardService.selectNoticeAll();
					request.setAttribute("notices", notices);
					RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
					dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}else if("mvboardview".equals(signParam)) {
				int idx = Integer.parseInt(request.getParameter("idx"));
				Notice board = boardService.selectNoticeByIdx(idx);
				request.setAttribute("board",board);
				
				board.setHits(board.getHits()+1);
				boardService.updateHits(board);
				RequestDispatcher dispatcher = request.getRequestDispatcher("noticeview.jsp");
				dispatcher.forward(request, response);
			}else if("mvboardwrite".equals(signParam)) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("boardwrite.jsp");
				dispatcher.forward(request, response);
			}else if("boardwrite".equals(signParam)) {
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				String writer = request.getParameter("writer");
				
				if(boardService.registNotice(new Notice(title,contents,writer))) {
					List<Notice> notices = boardService.selectNoticeAll();
					request.setAttribute("notices", notices);
					RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
					dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}else if("boarddelete".equals(signParam)) {
				int idx = Integer.parseInt(request.getParameter("idx"));
				
				if(boardService.deleteNotice(idx)) {
					List<Notice> notices = boardService.selectNoticeAll();
					request.setAttribute("notices", notices);
					RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
					dispatcher.forward(request, response);
				}else {
					RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
					dispatcher.forward(request, response);
				}
			}else if("searchNotice".equals(signParam)) {
				String str = request.getParameter("str");
				List<Notice> notices = boardService.selectNoticeByTitle(str);
				request.setAttribute("notices", notices);
				RequestDispatcher dispatcher = request.getRequestDispatcher("notice.jsp");
				dispatcher.forward(request, response);
			}
		} else {
			PrintWriter out = response.getWriter();
			
			JsonObject reJson = new JsonObject();
			JsonObject json = (JsonObject) JsonParser.parseReader(request.getReader());
			String sign = json.get("sign").getAsString();
			
			if (sign != null) {
				if (sign.equals("login")) {
					
				}
			} else {
				reJson.addProperty("msg", "error");
			}
			
			out.append(reJson.toString());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}

}
