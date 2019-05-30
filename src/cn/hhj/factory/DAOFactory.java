package cn.hhj.factory;

import java.sql.Connection;

import cn.hhj.dao.IDeptDAO;
import cn.hhj.dao.IMemberDAO;
import cn.hhj.dao.IMenuDAO;
import cn.hhj.dao.impl.DeptDAOImpl;
import cn.hhj.dao.impl.MemberDAOImpl;
import cn.hhj.dao.impl.MenuDAOImpl;

public class DAOFactory {
	public static IMemberDAO getIMemberDAOInstance(Connection conn) {
		return new MemberDAOImpl(conn);
	}
	public static IMenuDAO getIMenuDAOInstance(Connection conn) {
		return new MenuDAOImpl(conn);
	}
	public static IDeptDAO getIDeptDAOInstance(Connection conn) {
		return new DeptDAOImpl(conn);
	}
}
