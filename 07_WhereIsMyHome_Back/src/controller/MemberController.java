package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
import model.service.MemberService;


@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	MemberService memberService;
	public void init(ServletConfig config) throws ServletException {
		memberService = MemberService.getInstance();
	}

	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String signParam = request.getParameter("sign");

		if (signParam != null) {
			String path = "index.jsp";
			if ("mvjoin".equals(signParam)) {
				path = "login.jsp";
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else if ("mvInfo".equals(signParam)) {
				HttpSession session = request.getSession(false);
				String id = (String) session.getAttribute("loginId");
				if (id != null) {
					try {
						Member member = memberService.get(id);
						request.setAttribute("info", member);
						path = "userInfo.jsp";
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} else if ("mvUpdateInfo".equals(signParam)) {
				HttpSession session = request.getSession(false);
				String id = (String) session.getAttribute("loginId");
				if (id != null) {
					try {
						Member member = memberService.get(id);
						request.setAttribute("info", member);
						path = "userInfo_update.jsp";
					} catch (Exception e) {
						e.printStackTrace();
					}
				} 
				RequestDispatcher dispatcher = request.getRequestDispatcher(path);
				dispatcher.forward(request, response);
			} 
		} else {
			PrintWriter out = response.getWriter();
			
			JsonObject reJson = new JsonObject();
			JsonObject json = (JsonObject) JsonParser.parseReader(request.getReader());
			String sign = json.get("sign").getAsString();
			
			if (sign != null) {
				if (sign.equals("login")) {
					String id = json.get("id").getAsString();
					String pw = json.get("pw").getAsString();

					Member member = memberService.login(id, pw);
					if (member != null) {
						HttpSession session = request.getSession();
						session.setAttribute("loginId", id);
						reJson.addProperty("loginId", id);
					} else {
						reJson.addProperty("msg", "로그인에 실패하였습니다.");
					}
				} else if (sign.equals("logout")) {
					HttpSession session = request.getSession(false);
					if (session != null) session.invalidate();
					reJson.addProperty("msg", "로그아웃 되었습니다.");
				} else if (sign.equals("joinMember")) {
					String id = json.get("id").getAsString();
					String pw = json.get("pw").getAsString();
					String email = json.get("email").getAsString();
					boolean check = memberService.checkId(id);
					if (check) {
						int i = memberService.regist(new Member(id, pw, email));
						if (i > 0) {
							reJson.addProperty("msg", id + "님 환영합니다.");
						} else {
							reJson.addProperty("msg", "회원가입을 실패하였습니다.");
						}
					} else {
						reJson.addProperty("msg", "이미 있는 아이디입니다.");
					}
				} else if (sign.equals("updateMember")) {
					HttpSession session = request.getSession(false);
					String id = (String) session.getAttribute("loginId");
					String pw = json.get("pw").getAsString();
					String email = json.get("email").getAsString();
					int i = memberService.update(new Member(id, pw, email));
					if (i > 0) {
						reJson.addProperty("msg", "정보를 수정하였습니다.");
					} else {
						reJson.addProperty("msg", "정보수정에 실패하였습니다.");
					}
				} else if (sign.equals("deleteMember")) {
					HttpSession session = request.getSession(false);
					String id = (String) session.getAttribute("loginId");
					memberService.delete(id);
				} 
			} else {
				reJson.addProperty("msg", "error");
			}
			
			out.append(reJson.toString());
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
