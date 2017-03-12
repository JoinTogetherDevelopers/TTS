package org.dorageecorp.board.dao;

import org.apache.ibatis.annotations.Mapper;
import org.dorageecorp.board.model.Member;

@Mapper
public interface MemberMapper {

	public String getTime();

	public void insertMember(Member member);

}