package cn.hhj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.hhj.dao.IMenuDAO;
import cn.hhj.vo.Menu;

public class MenuDAOImpl implements IMenuDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	public MenuDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<Menu> findAll() throws SQLException {
		List<Menu> all=new ArrayList<Menu>();
		String sql="SELECT mid,title FROM menu WHERE fmid IS NULL";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()) {
			Menu vo=new Menu();
			vo.setMid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			all.add(vo);
		}
		return all;
	}

	@Override
	public List<Menu> findAllSub(Integer fmid) throws SQLException {
		List<Menu> all=new ArrayList<Menu>();
		String sql="SELECT mid,title,fmid FROM menu WHERE fmid=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, fmid);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()) {
			Menu vo=new Menu();
			vo.setMid(rs.getInt(1));
			vo.setTitle(rs.getString(2));
			all.add(vo);
		}
		return all;
	}

}
