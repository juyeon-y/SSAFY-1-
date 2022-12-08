package com.ssafy.home.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.home.member.dto.Member;

public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession session = request.getSession(false);
		if (session != null) {
			Member m = (Member) session.getAttribute("member");
			if (m != null) {
				return true;
			}
		}
		response.sendRedirect("/member/loginForm");
		return false;
	}

}
