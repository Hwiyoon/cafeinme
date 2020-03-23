//package com.weduo.cafeinme.member.dao;
//
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//import javax.inject.Inject;
//
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.PreparedStatementSetter;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Repository;
//
//import com.weduo.cafeinme.member.Member;
//
//@Repository
//public class dao_mybatis implements IMemberDao {
//	
//	private JdbcTemplate template;
//	
//	@Inject
//	private SqlSession session;
//	
//	private static String namespace="com.weduo.cafeinme.member.dao.MemberDAO";
//
//	@Override
//	public int memberInsert(Member member) {
//		// TODO Auto-generated method stub
//		session.insert(namespace + ".join", member);
//		return 0;
//	}
//
//	@Override
//	public Member memberSelect(final Member member) {
//		// TODO Auto-generated method stub
//		
//		List<Member> members = null;
//		final String sql = "select MNAME, MBIRTH, MID, MPW from MEMBER where MID=? AND MPW=?";
//		
//		members = template.query(sql, new PreparedStatementSetter() {
//			@Override
//			public void setValues(PreparedStatement ps) throws SQLException {	//sql에 값 넣어주기
//				// TODO Auto-generated method stub
//				ps.setString(1, member.getMID());
//				ps.setString(2, member.getMPW());
//			}
//		}, new RowMapper<Member>() {
//			@Override
//			public Member mapRow(ResultSet rs, int rowNum) throws SQLException {	//rs으로 받아온 값 Member 객체로 변환
//				// TODO Auto-generated method stub
//				Member mem = new Member();
//				mem.setMID(rs.getString("MID"));
//				mem.setMPW(rs.getString("MPW"));
//				mem.setMNAME(rs.getString("MNAME"));
//				mem.setMBIRTH(rs.getString("MBIRTH"));
//				return mem;
//			}
//		});
//		
//		if(members.isEmpty())	return null;
//		
//		return members.get(0);
//	}
//	
//	@Override
//	public Member idCheck(String MID) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int memberUpdate(Member member) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//
//	@Override
//	public int memberDelete(Member member) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
//	
//
//
//}
