package member.controller;

import com.google.gson.JsonObject;
import controller.Command;
import member.dto.Member;
import member.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberInsertCommand implements Command {
    MemberService memberService;

    public MemberInsertCommand() {
        memberService = MemberService.getInstance();
    }

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response, JsonObject json, JsonObject reJson)
            throws ServletException, IOException {
        String id = json.get("id").getAsString();
        String pw = json.get("pw").getAsString();
        String name = json.get("name").getAsString();
        if(id != null && !id.trim().equals("") && pw != null && name != null) {
            Member member = new Member(id, pw, name);
            int i = memberService.memberInsert(member); //이거 리턴 값 관련 수정해야됨.
            if(i > 0) {
                reJson.addProperty("msg", "회원가입 성공");
                reJson.addProperty("flag", true);
            } else {
                reJson.addProperty("msg", "회원가입 실패");
            }
        } else {
            reJson.addProperty("msg", "모든 내용을 입력해주세요.");
        }
    }
}
