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

import dto.InterestCity;
import dto.User;
import model.service.UserService;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserService userService;
	public void init(ServletConfig config) throws ServletException {
		userService = UserService.getInstance();
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
						User user = userService.get(id);
						String interestLocation = userService.getInterestCity(id);
						request.setAttribute("info", user);
						request.setAttribute("interest", interestLocation);
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
						User member = userService.get(id);
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
					String email = json.get("email").getAsString();
					String pw = json.get("pw").getAsString();

					User user = userService.login(email, pw);
					String interestCity = userService.getInterestCity(email);
					if (user != null) {
						HttpSession session = request.getSession();
						session.setAttribute("loginId", email);
						reJson.addProperty("loginId", email);
					} else {
						reJson.addProperty("msg", "로그인에 실패하였습니다.");
					}
				} else if (sign.equals("logout")) {
					HttpSession session = request.getSession(false);
					if (session != null) session.invalidate();
					reJson.addProperty("msg", "로그아웃 되었습니다.");
				} else if (sign.equals("joinUser")) {
					String email = json.get("email").getAsString();
					String pw = json.get("pw").getAsString();
					String name = json.get("name").getAsString();
					String nickname = json.get("nickname").getAsString();
					
					String sido = json.get("loginsido").getAsString();
					String gugun = json.get("logingugun").getAsString();
					String dong = json.get("logindong").getAsString();
					boolean check = userService.checkEmail(email);
					if (check) {
						boolean i = userService.regist(new InterestCity(email, sido, gugun, dong), new User(email, name, pw, nickname));
						if (i) {
							reJson.addProperty("msg", nickname + "님 환영합니다.");
						} else {
							reJson.addProperty("msg", "회원가입을 실패하였습니다.");
						}
					} else {
						reJson.addProperty("msg", "이미 있는 아이디입니다.");
					}
				} else if (sign.equals("updateUser")) {
					HttpSession session = request.getSession(false);
					String email = (String) session.getAttribute("loginId");
					String pw = json.get("pw").getAsString();
					String name = json.get("name").getAsString();
					String nickname = json.get("nickname").getAsString();
					
					String sido = json.get("loginsido").getAsString();
					String gugun = json.get("logingugun").getAsString();
					String dong = json.get("logindong").getAsString();
					boolean i = userService.update(new InterestCity(email, sido, gugun, dong), new User(email, name, pw, nickname));
					if (i) {
						reJson.addProperty("msg", "정보를 수정하였습니다.");
					} else {
						reJson.addProperty("msg", "정보수정에 실패하였습니다.");
					}
				} else if (sign.equals("deleteUser")) {
					HttpSession session = request.getSession(false);
					String id = (String) session.getAttribute("loginId");
					userService.delete(id);
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
