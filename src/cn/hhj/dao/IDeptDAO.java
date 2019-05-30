package cn.hhj.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.hhj.vo.Dept;

public interface IDeptDAO {
	public List<Dept> findAll()throws SQLException;
	public boolean doCreate(Dept vo)throws SQLException;
	public Integer findLastId()throws SQLException;
	public Dept findById(Integer did)throws SQLException;
	public boolean doUpdate(Dept vo)throws SQLException;
	//批量移动
	public boolean doMoveBatch(Set<Integer> ids)throws SQLException;
}
