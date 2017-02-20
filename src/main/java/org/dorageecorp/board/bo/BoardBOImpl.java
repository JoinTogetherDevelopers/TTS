package org.dorageecorp.board.bo;

import java.util.List;

import org.dorageecorp.board.dao.BoardMapper;
import org.dorageecorp.board.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardBOImpl implements BoardBO {

	@Autowired
	private BoardMapper boardDao;

	@Override
	public void regist(Board model) throws Exception {
		boardDao.create(model);
	}

	@Override
	public Board read(Integer bno) throws Exception {
		return boardDao.read(bno);
	}

	@Override
	public void modify(Board board) throws Exception {
		boardDao.update(board);
	}

	@Override
	public void remove(Integer bno) throws Exception {
		boardDao.delete(bno);
	}

	@Override
	public List<Board> listAll() throws Exception {
		return boardDao.listAll();
	}
}