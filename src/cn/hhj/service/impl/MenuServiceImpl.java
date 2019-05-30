package cn.hhj.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.hhj.dbc.DatabaseConnection;
import cn.hhj.factory.DAOFactory;
import cn.hhj.service.IMenuService;
import cn.hhj.vo.Menu;

public class MenuServiceImpl implements IMenuService {
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public List<Menu> list() throws SQLException {
		try {
			return DAOFactory.getIMenuDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}

	@Override
	public List<Menu> listSub(int fmid) throws SQLException {
		try {
			return DAOFactory.getIMenuDAOInstance(this.dbc.getConnection()).findAllSub(fmid);
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}

}
