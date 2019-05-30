package cn.hhj.service;

import java.sql.SQLException;
import java.util.List;

import cn.hhj.vo.Menu;

public interface IMenuService {
	public List<Menu> list()throws SQLException;
	public List<Menu> listSub(int fmid)throws SQLException;
}
