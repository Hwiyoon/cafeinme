package com.weduo.cafeinme.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.weduo.cafeinme.member.Member;
import com.weduo.cafeinme.member.dao.MemberDao;

@Service
public class MemberService implements IMemberService {

	@Autowired
	MemberDao dao;

	@Override
	public void memberRegister(Member member) {
		// TODO Auto-generated method stub
		int result = dao.memberInsert(member);
		if (result == 0) {
			System.out.println("Join Fail!!");
		} else {
			System.out.println("Join Success!!");
		}
	}

	@Override
	public Member memberSearch(Member member) {
		// TODO Auto-generated method stub
		Member mem = dao.memberSelect(member);

		if (mem == null) {
			System.out.println("Login Fail!!");
		} else {
			System.out.println("Login Success!!");
		}

		return mem;
	}

	@Override
	public Member idCheck(String MID) {
		// TODO Auto-generated method stub
		Member result = dao.idCheck(MID);
		return result;
	}

	@Override
	public Member memberModify(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int memberRemove(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
