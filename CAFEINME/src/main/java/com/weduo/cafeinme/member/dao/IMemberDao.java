package com.weduo.cafeinme.member.dao;

import com.weduo.cafeinme.member.Member;

public interface IMemberDao {
	int memberInsert(Member member);
	Member memberSelect(Member member);
	int memberUpdate(Member member);
	int memberDelete(Member member);
	Member idCheck(String MID);

}
