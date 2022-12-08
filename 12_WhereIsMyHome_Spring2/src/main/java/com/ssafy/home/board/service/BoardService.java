package com.ssafy.home.board.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.home.board.dto.Board;
import com.ssafy.home.board.mapper.BoardMapper;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;

    public List<Board> selectAll() {
        return boardMapper.selectAll();
    }

    public long write(Board board) {
        long write = boardMapper.write(board);
        boardMapper.createFile(board);
        return write;

    }

    public Board selectOne(int id) {
		return boardMapper.selectOne(id);

	}

    public void editBoard(Board board, int code) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("board", board);
        map.put(code, code);
        boardMapper.updateBoard(board, code);
    }

    public boolean deleteBoard(int code){
        return boardMapper.deleteBoard(code);
    }

    public List<Board> search(String keyword) {
        return boardMapper.search(keyword);
    }
}
