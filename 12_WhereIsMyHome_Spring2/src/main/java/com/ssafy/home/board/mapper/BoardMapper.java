package com.ssafy.home.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.ssafy.home.board.dto.Board;

@Mapper
@Repository
public interface BoardMapper {

	List<Board> selectAll() throws DataAccessException;

	long write(Board board);

	void createFile(Board board);

	Board selectOne(int code);

	void updateBoard(Board board, int code);

	boolean deleteBoard(int code);

	List<Board> search(String keyword);
}
