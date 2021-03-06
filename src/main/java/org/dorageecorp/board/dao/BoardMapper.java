package org.dorageecorp.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.board.model.Board;

@Mapper
public interface BoardMapper {

	public void create(Board board);

	public Board read(Integer bno);

	public void update(Board board);

	public void delete(Integer bno);

	public List<Board> listAll();
}