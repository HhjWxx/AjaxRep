package cn.hhj.service;

import java.sql.SQLException;

import cn.hhj.vo.Member;

public interface IMemberService {
	public boolean checkMid(String mid)throws SQLException;
	public boolean regist(Member vo)throws SQLException;
}
