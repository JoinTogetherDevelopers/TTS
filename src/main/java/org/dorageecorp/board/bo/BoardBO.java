package org.dorageecorp.board.bo;

import java.util.List;

import org.dorageecorp.board.model.Board;

public interface BoardBO {

	public void regist(Board model) throws Exception;

	public Board read(Integer bno) throws Exception;

	public void modify(Board board) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<Board> listAll() throws Exception;
}
