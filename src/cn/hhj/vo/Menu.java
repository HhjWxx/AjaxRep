package cn.hhj.vo;

import java.io.Serializable;

public class Menu implements Serializable {
	private Integer mid;
	private String title;
	private Menu fmenu=null;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Menu getFmenu() {
		return fmenu;
	}
	public void setFmenu(Menu fmenu) {
		this.fmenu = fmenu;
	}
	
}
