package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controller.*;
import member.dto.Member;
import member.service.MemberService;

public class IdCheckCommand implements Command {
	MemberService memberService;

	public IdCheckCommand() {
		memberService = MemberService.getInstance();
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response, JsonObject json, JsonObject reJson)
			throws ServletException, IOException {
		 String id = json.get("id").getAsString();
         int cnt = memberService.idCheck(id);
         reJson.addProperty("cnt", cnt + "");
	}

}
