package cn.hhj.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import cn.hhj.dbc.DatabaseConnection;
import cn.hhj.factory.DAOFactory;
import cn.hhj.service.IDeptService;
import cn.hhj.vo.Dept;

public class DeptServiceImpl implements IDeptService {
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public List<Dept> list() throws SQLException {
		try {
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}
	@Override
	public boolean add(Dept vo) throws SQLException {
		try {
			if(DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doCreate(vo)) {
				vo.setDid(DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findLastId());
				return true;
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}
	@Override
	public Dept editPre(int id) throws SQLException {
		try {
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}
	@Override
	public boolean edit(Dept vo) throws SQLException {
		try {
			if(DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).findById(vo.getDid())!=null) {
				return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doUpdate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}
	@Override
	public boolean delete(Set<Integer> ids) throws SQLException {
		try {
			if(ids.size()==0 || ids==null) {
				return false;
			}
			return DAOFactory.getIDeptDAOInstance(this.dbc.getConnection()).doMoveBatch(ids);
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}
}
