package cn.hhj.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private String mid;
	private String password;
	public void setMid(String mid) {
		this.mid = mid;
	}
	public String getMid() {
		return mid;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return password;
	}
}
