package cn.hhj.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.hhj.vo.Dept;

public interface IDeptService {
	public List<Dept> list()throws SQLException;
	public boolean add(Dept vo)throws SQLException;
	public Dept editPre(int id)throws SQLException;
	public boolean edit(Dept vo)throws SQLException;
	public boolean delete(Set<Integer> ids)throws SQLException;
}
