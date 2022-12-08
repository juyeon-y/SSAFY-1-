package com.ssafy.home.board.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssafy.home.board.dto.Board;
import com.ssafy.home.board.dto.FileInfoDto;
import com.ssafy.home.board.service.BoardService;
import com.ssafy.home.member.dto.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/board")
public class BoardController {

    private final Logger log = LoggerFactory.getLogger(BoardController.class);
    @Autowired
    BoardService boardService;

    @PostMapping("/selectAll")
    @ResponseBody
    public PageInfo<Board> selectAll(HttpServletRequest request, @RequestParam String keyword) {
        System.out.println(request.getParameter("pageNum"));
        log.info("keyword = {} ", keyword);
        PageHelper.startPage(request);
        List<Board> list = boardService.search(keyword);
        return PageInfo.of(list);
    }

    @GetMapping("/mvBoard")
    public String mvBoard() {
        // List<Board> list=boardService.selectAll();
        // request.setAttribute("boards", list);
        return "board";
    }

    @GetMapping("/write")
    public String writeBoard(HttpSession session) {
        System.out.println("글쓰기 메소드 호출");
        // CSRF 토큰 발행
        String csrfToken = UUID.randomUUID().toString();
        System.out.println("token.toString: " + csrfToken);
        session.setAttribute("CSRF_TOKEN", csrfToken);
        return "boardwrite";
    }

    @PostMapping("/write")
    @ResponseBody
    public String writeBoard(Board board, String csrf_token, HttpSession session, HttpServletRequest request, @RequestParam("file") MultipartFile[] files) {
        System.out.println("받은 토큰 : " + csrf_token);
        String CSRF_TOKEN = (String) session.getAttribute("CSRF_TOKEN");
        if (CSRF_TOKEN != null && CSRF_TOKEN.equals(csrf_token)) {

            String folderPath = "./files";
            File folder = new File(folderPath);
            if (!folder.exists()) {
                folder.mkdirs();
            }
            System.out.println(folder.getAbsolutePath());
            List<FileInfoDto> fileInfos = new ArrayList<>();
            String today = new SimpleDateFormat("yyMMdd").format(new Date());
            for (MultipartFile mfile : files) { // 선택한 파일들을 가져와서 루프
                System.out.println(mfile.getOriginalFilename());
                FileInfoDto fileInfoDto = new FileInfoDto();
                String originalFileName = mfile.getOriginalFilename(); // 파일명 구해서
                assert originalFileName != null;
                if (!originalFileName.isEmpty()) {
                    String saveFileName = UUID.randomUUID()
                            + originalFileName.substring(originalFileName.lastIndexOf('.'));
                    fileInfoDto.setSaveFolder(today);
                    fileInfoDto.setOriginalFile(originalFileName);
                    fileInfoDto.setSaveFile(saveFileName);
                    try {
                        File dest = new File(folder.getAbsolutePath(), saveFileName);
                        mfile.transferTo(dest); // 파일을 내가 지정한 path에 저장해둔다.
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                fileInfos.add(fileInfoDto);
            }
            board.setFileInfos(fileInfos);
            long cnt = boardService.write(board);
            if (cnt > 0) {
                return "ok!!!!!!!!!!!!!!!!!!!!!!!!!";
            }
            return "write fail";

        } else {
            System.out.println(request.getRemoteAddr() + "해킹 시도 감지");
        }
        return "fail";
    }

    @GetMapping("{id}")
    public String boardView(@PathVariable int id, Model model) {

        Board board = boardService.selectOne(id);
        log.info("board = {}", board.toString());
        model.addAttribute("board", board);
        return "boardview";
    }

    @GetMapping("/edit/{code}")
    public String editForm(@PathVariable int code, Model model, HttpServletRequest request) {

        Board board = boardService.selectOne(code);
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        model.addAttribute("board", board);
        if (member != null) {
            return "/boardedit";
        } else {
            return "redirect:/member/loginForm";
        }
    }

    @PostMapping("/edit/{code}")
    public String editBoard(Board board, @PathVariable int code) {

        System.out.println("board = " + board);
        log.info("board = {}", board.toString());
        boardService.editBoard(board, code);

        return "redirect:/board/" + code;
    }

    @GetMapping("/delete/{code}")
    public String deleteBoard(@PathVariable int code) {
        Board board = boardService.selectOne(code);
        boardService.deleteBoard(code);
        return "redirect:/board/mvBoard";
    }

    @GetMapping("/search")
    public String searchBoard(@RequestParam String keyword) {
        List<Board> search = boardService.search(keyword);
        return null;
    }
}
