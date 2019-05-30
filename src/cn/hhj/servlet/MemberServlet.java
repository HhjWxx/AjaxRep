package cn.hhj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.hhj.factory.ServiceFactory;
import cn.hhj.vo.Member;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/MemberServlet/*")
public class MemberServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri =request.getRequestURI();
		String status=uri.substring(uri.lastIndexOf("/")+1);
		if(status!=null) {
			try {
				Method met=this.getClass().getMethod(status,HttpServletRequest.class,HttpServletResponse.class);
				met.invoke(this,request, response);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	public void regist(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String mid=request.getParameter("mid");
		String password=request.getParameter("password");
		if(mid!=null && password!=null) {
			Member vo=new Member();
			password=new cn.hhj.util.MD5().getMD5ofStr(password);
			vo.setMid(mid);
			vo.setPassword(password);
			try {
			ServiceFactory.getIMemberServiceInstance().regist(vo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void checkMid(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException  {
		String mid=request.getParameter("mid");
		if(mid==null || "".equals(mid)) {
			response.getWriter().print(false);//表示此处无法使用
		}else {
			try {
				response.getWriter().print(!ServiceFactory.getIMemberServiceInstance().checkMid(mid));
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
