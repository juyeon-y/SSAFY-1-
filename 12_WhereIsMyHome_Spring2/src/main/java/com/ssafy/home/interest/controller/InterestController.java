package com.ssafy.home.interest.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.home.interest.service.InterestService;
import com.ssafy.home.member.dto.Member;
import com.ssafy.home.interest.dto.Environment;
import com.ssafy.home.interest.dto.Business;


@Controller
@RequestMapping("/interest")
public class InterestController {
	
	@Autowired InterestService interestService;

	@GetMapping("/mvenv")
	public String mvEnv(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		List<Environment> list = interestService.selectEnvInspInfo(member.getEmail());
		request.setAttribute("list", list);
		return "envInspInfo";
	}
	
	@GetMapping("/mvbiz")
	public String mvBiz(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		List<Business> list = interestService.selectBizInfo(member.getEmail());
		request.setAttribute("list", list);
		return "businessInfo";
	}
	
	@GetMapping("/mvhospital")
	public String mvHospital(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		List<Business> list = interestService.selectHospitalInfo(member.getEmail());
		request.setAttribute("list", list);
		return "hospitalInfo";
	}
	
	@GetMapping("/mvclinic")
	public String mvClinic(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Member member = (Member) session.getAttribute("member");
		List<Business> list = interestService.selectClinicInfo(member.getEmail());
		request.setAttribute("list", list);
		return "clinicInfo";
	}
	
	
	
	
	
}
