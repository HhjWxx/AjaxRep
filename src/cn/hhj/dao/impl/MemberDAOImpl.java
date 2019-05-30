package cn.hhj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.hhj.dao.IMemberDAO;
import cn.hhj.vo.Member;

public class MemberDAOImpl implements IMemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	public MemberDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public Member findById(String mid) throws SQLException {
		Member vo=null;
		String sql="SELECT mid,password FROM member WHERE mid=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, mid);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			vo=new Member();
			vo.setMid(rs.getString(1));
			vo.setPassword(rs.getString(2));
		}
		return vo;
	}

	@Override
	public boolean doCreate(Member vo) throws SQLException {
		String sql="INSERT INTO member(mid,password) VALUES(?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getMid());
		this.pstmt.setString(2, vo.getPassword());
		System.out.println("增加完成：mid="+vo.getMid());
		return this.pstmt.executeUpdate()>0;
	}
	
}
