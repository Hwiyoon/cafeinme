package com.weduo.cafeinme.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.weduo.cafeinme.member.Member;

@Repository
public class MemberDao implements IMemberDao {

	private JdbcTemplate template;

	// db커넥션 정보를 주입
	@Autowired
	public MemberDao(ComboPooledDataSource dataSource) {
		// TODO Auto-generated constructor stub
		this.template = new JdbcTemplate(dataSource);
	}

	@Override
	public int memberInsert(final Member member) {
		// TODO Auto-generated method stub

		final String sql = "insert into MEMBER (MNAME, MBIRTH, MID, MPW) values(?,?,?,?)";

		int result = template.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, member.getMNAME());
				pstmt.setString(2, member.getMBIRTH());
				pstmt.setString(3, member.getMID());
				pstmt.setString(4, member.getMPW());
			}
		});
		return result;
	}

	@Override
	public Member memberSelect(final Member member) {
		// TODO Auto-generated method stub

		List<Member> members = null;
		final String sql = "select MNAME, MBIRTH, MID, MPW from MEMBER where MID=? AND MPW=?";

		members = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException { // sql에 값 넣어주기
				// TODO Auto-generated method stub
				ps.setString(1, member.getMID());
				ps.setString(2, member.getMPW());
			}
		}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException { // rs으로 받아온 값 Member 객체로 변환
				// TODO Auto-generated method stub
				Member mem = new Member();
				mem.setMID(rs.getString("MID"));
				mem.setMPW(rs.getString("MPW"));
				mem.setMNAME(rs.getString("MNAME"));
				mem.setMBIRTH(rs.getString("MBIRTH"));
				return mem;
			}
		});

		if (members.isEmpty())
			return null;

		return members.get(0);
	}

	@Override
	public Member idCheck(final String MID) {
		// TODO Auto-generated method stub

		final String sql = "select * from MEMBER where MID=?";
		List<Member> members = null;

		members = template.query(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				// TODO Auto-generated method stub
				pstmt.setString(1, MID);
			}
		}, new RowMapper<Member>() {
			@Override
			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				Member mem = new Member();
				mem.setMNAME(rs.getString("MNAME"));
				mem.setMID(rs.getString("MID"));
				mem.setMPW(rs.getString("MPW"));
				mem.setMBIRTH(rs.getString("MBIRTH"));
				return mem;
			}
		});
		
		if (members.isEmpty())
			return null;

		return members.get(0);
	}

	@Override
	public int memberUpdate(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

}
