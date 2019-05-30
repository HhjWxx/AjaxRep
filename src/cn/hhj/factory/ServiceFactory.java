package cn.hhj.factory;

import cn.hhj.service.IDeptService;
import cn.hhj.service.IMemberService;
import cn.hhj.service.IMenuService;
import cn.hhj.service.impl.DeptServiceImpl;
import cn.hhj.service.impl.MemberServiceImpl;
import cn.hhj.service.impl.MenuServiceImpl;

public class ServiceFactory {
	public static IMemberService getIMemberServiceInstance() {
		return new MemberServiceImpl();
	}
	public static IMenuService getIMenuServiceInstance() {
		return new MenuServiceImpl();
	}
	public static IDeptService getIDeptServiceInstance() {
		return new DeptServiceImpl();
	}
}
