package cn.hhj.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import cn.hhj.dao.IDeptDAO;
import cn.hhj.vo.Dept;

/**
 * dev分支修改的内容
 * @author Administrator
 *
 */
public class DeptDAOImpl implements IDeptDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	public DeptDAOImpl(Connection conn) {
		this.conn=conn;
	}
	@Override
	public List<Dept> findAll() throws SQLException {
		List<Dept> all=new ArrayList<Dept>();
		String sql="SELECT did,dname,loc FROM dept";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()) {
			Dept vo=new Dept();
			vo.setDid(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
			all.add(vo);
		}
		return all;
	}
	@Override
	public boolean doCreate(Dept vo) throws SQLException {
		String sql="INSERT INTO dept(dname,loc) VALUES(?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getDname());
		this.pstmt.setString(2, vo.getLoc());
		return this.pstmt.executeUpdate()>0;
	}
	@Override
	public Integer findLastId() throws SQLException {
		String sql="SELECT LAST_INSERT_ID()";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	@Override
	public Dept findById(Integer did) throws SQLException {
		Dept vo=null;
		String sql="SELECT did,dname,loc FROM dept WHERE did=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setInt(1, did);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			vo=new Dept();
			vo.setDid(rs.getInt(1));
			vo.setDname(rs.getString(2));
			vo.setLoc(rs.getString(3));
		}
		return vo;
	}
	@Override
	public boolean doUpdate(Dept vo) throws SQLException {
		String sql="UPDATE dept SET dname=?,loc=? WHERE did=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getDname());
		this.pstmt.setString(2, vo.getLoc());
		this.pstmt.setInt(3, vo.getDid());
		return this.pstmt.executeUpdate()>0;
	}
	@Override
	public boolean doMoveBatch(Set<Integer> ids) throws SQLException {
		StringBuffer buf=new StringBuffer();
		buf.append("DELETE FROM dept WHERE did IN(");
		Iterator<Integer> iter=ids.iterator();
		while(iter.hasNext()) {
			buf.append(iter.next()).append(",");
		}
		buf.delete(buf.length()-1, buf.length());
		buf.append(")");
		this.pstmt=this.conn.prepareStatement(buf.toString());
		return this.pstmt.executeUpdate()==ids.size();
	}
}
