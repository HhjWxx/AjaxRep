package cn.hhj.servlet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns="/ReverseServlet",asyncSupported=true)
public class ReverseServlet  extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		AsyncContext asc=request.startAsync();//启动反向Ajax
		asc.start(new MessageThread(asc));//启用一个线程来进行处理	
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
	class MessageThread implements Runnable{
		public AsyncContext asc;
		public MessageThread(AsyncContext asc) {
			this.asc=asc;
		}
		@Override
		public void run() {
			String msg =this.asc.getRequest().getParameter("msg");
			try {
				this.asc.getResponse().getWriter().print(msg);
				this.asc.complete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
