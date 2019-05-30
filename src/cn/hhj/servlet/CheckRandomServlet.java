package cn.hhj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet("/CheckRandomServlet")
public class CheckRandomServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//1、接受用户发送而来的验证码数据
		String code=request.getParameter("code");
		String rand=(String) request.getSession().getAttribute("sRand");
		//2、通过session取出生成的数据
		if(code==null || "".equals(code)) {//不能够使用
			response.getWriter().print(false);
		}else {
			response.getWriter().print(code.equalsIgnoreCase(rand));
		}
	}
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
