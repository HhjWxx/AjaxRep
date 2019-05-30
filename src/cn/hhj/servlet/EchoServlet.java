package cn.hhj.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
@WebServlet(urlPatterns="/EchoServlet")
public class EchoServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest requeset, HttpServletResponse response) throws ServletException, IOException {
		requeset.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String param=requeset.getParameter("msg");//假设参数名称为msg
		PrintWriter out=response.getWriter();
		out.print("ECHO:"+param);
	}
	@Override
	public void doPost(HttpServletRequest requeset, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(requeset, response);
	}
}
