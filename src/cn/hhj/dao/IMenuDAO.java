package cn.hhj.dao;

import java.sql.SQLException;
import java.util.List;

import cn.hhj.vo.Menu;

public interface IMenuDAO {
	/**
	 * 列出全部的一级菜单	
	 * @return 返回所有的父菜单项为null的结果
	 * @throws SQLException
	 */
	public List<Menu> findAll()throws SQLException;
	/**
	 * 根据指定的菜单编号查询子菜单
	 * @param fmid
	 * @return
	 * @throws SQLException
	 */
	public List<Menu> findAllSub(Integer fmid)throws SQLException;
}
