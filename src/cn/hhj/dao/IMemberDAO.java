package cn.hhj.dao;

import java.sql.SQLException;
import java.util.Set;

import cn.hhj.vo.Member;

public interface IMemberDAO {
	public Member findById(String mid) throws SQLException;
	public boolean doCreate(Member vo)throws SQLException;

}
