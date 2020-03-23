package com.weduo.cafeinme.member.service;

import com.weduo.cafeinme.member.Member;

public interface IMemberService {
	void memberRegister(Member member);
	Member memberSearch(Member member);
	Member memberModify(Member member);
	int memberRemove(Member member);
	Member idCheck(String MID);

}
