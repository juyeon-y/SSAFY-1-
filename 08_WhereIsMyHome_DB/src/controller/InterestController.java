package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.Business;
import dto.Clinic;
import dto.Environment;
import dto.Hospital;
import model.service.InterestService;

@WebServlet("/interest")
public class InterestController extends HttpServlet {

	InterestService interestService;
	public void init(ServletConfig config) throws ServletException {
		interestService = InterestService.getInstance();
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String signParam = request.getParameter("sign");

		HttpSession session = request.getSession(false);
		String loginEmail = (String) session.getAttribute("loginId");
		String path = "index.jsp";
		if (loginEmail == null) {
			response.sendRedirect("user?sign=mvjoin");
		} else {
			if (signParam != null) {
				if ("mvenv".equals(signParam)) {
					List<Environment> list = interestService.getEnvInspInfo(loginEmail);
					request.setAttribute("list", list);
					path = "envInspInfo.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				} else if ("mvbiz".equals(signParam)) {
					List<Business> list = interestService.getBizInfo(loginEmail);
					request.setAttribute("list", list);
					path = "businessInfo.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}else if("mvhospital".equals(signParam)) {
					List<Hospital> list = interestService.getHospitalInfo(loginEmail);
					request.setAttribute("list", list);
					path = "hospitalInfo.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}else if("mvclinic".equals(signParam)) {
					List<Clinic> list = interestService.getClinicInfo(loginEmail);
					request.setAttribute("list", list);
					path = "clinicInfo.jsp";
					RequestDispatcher dispatcher = request.getRequestDispatcher(path);
					dispatcher.forward(request, response);
				}
			}
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

}
