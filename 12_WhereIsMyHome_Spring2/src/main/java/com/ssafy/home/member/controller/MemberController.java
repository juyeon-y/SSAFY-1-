package com.ssafy.home.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.home.member.dto.InterestCity;
import com.ssafy.home.member.dto.Member;
import com.ssafy.home.member.service.MemberService;

@Controller
@RequestMapping("/member")
public class MemberController {

	@Autowired
	MemberService memberService;

	@GetMapping("/loginForm")
	public String loginForm() {
		return "login";
	}

	@GetMapping("/mvInfo")
	public String mvInfo(HttpServletRequest request) {

		HttpSession session = request.getSession(false);
		Member m = (Member) session.getAttribute("member");
		if (m != null) {
			try {
				Member member = memberService.selectOne(m.getEmail());
				InterestCity interestCity = memberService.selectInterestCity(member.getEmail());
				System.out.println(interestCity);
				request.setAttribute("interest",interestCity);
				request.setAttribute("info", member);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "userInfo";
	}

	@PostMapping("/login")
	@ResponseBody
	public String login(@RequestBody Member m, HttpServletRequest request) throws Exception {
		// System.out.println(+m);
		Member m2 = memberService.login(m);
		// System.out.println(m2);
		if (m2 != null) {
			HttpSession session = request.getSession();
			session.setAttribute("member", m2);
			return m2.getEmail();
		} else {
			return "fail";
		}
	}

	@PostMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		if (session != null)
			session.invalidate();
		return "로그아웃 되었습니다.";
	}

	@PostMapping("/joinMember")
	@ResponseBody
	public String join(@RequestBody Map<String, String> map) {

		String email = map.get("email");
		String pw = map.get("pw");
		String name = map.get("name");
		String nickname = map.get("nickname");

		String sido = map.get("loginsido");
		String gugun = map.get("logingugun");
		String dong = map.get("logindong");
		int cnt = memberService.checkEmail(email);
		if (cnt == 0) {
			boolean i = memberService.regist(new InterestCity(email, sido, gugun, dong),
					new Member(email, name, pw, nickname));
			if (i)
				return nickname + "님 환영합니다.";
			else
				return "fail"; // 회원가입 실패
		} else
			return "id duplicate"; // 아이디 중복
	}

	@GetMapping("/update")
	public String updateForm(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		model.addAttribute("member", member);
		return "userInfo_update";
	}

	@PostMapping("/update")
	public String updateMember(@RequestBody Map<String, String> map ) {
		System.out.println("MemberController.updateMember");
		String email = map.get("email");
		String pw = map.get("pw");
		String name = map.get("name");
		String nickname = map.get("nickname");

		String sido = map.get("loginsido");
		String gugun = map.get("logingugun");
		String dong = map.get("logindong");

		memberService.update(new InterestCity(email, sido, gugun, dong),
				new Member(email, name, pw, nickname));
		System.out.println("MemberController.updateMember");

		return "redirect:/member/mvInfo";
	}
}
