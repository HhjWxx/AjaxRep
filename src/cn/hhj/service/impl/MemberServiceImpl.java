package cn.hhj.service.impl;

import java.sql.SQLException;

import cn.hhj.dbc.DatabaseConnection;
import cn.hhj.factory.DAOFactory;
import cn.hhj.service.IMemberService;
import cn.hhj.vo.Member;

public class MemberServiceImpl implements IMemberService{
	private DatabaseConnection dbc=new DatabaseConnection();
	@Override
	public boolean checkMid(String mid) throws SQLException {
		try {
			return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(mid)!=null;
		} catch (Exception e) {
			throw e;
		} finally {
			if (this.dbc != null) {
				this.dbc.close();
			}
		}
	}

	@Override
	public boolean regist(Member vo) throws SQLException {
	try {
		if(DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).findById(vo.getMid())==null) {
			return DAOFactory.getIMemberDAOInstance(this.dbc.getConnection()).doCreate(vo);
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
}
