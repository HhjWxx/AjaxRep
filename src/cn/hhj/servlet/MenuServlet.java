package cn.hhj.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import cn.hhj.factory.ServiceFactory;
import cn.hhj.vo.Menu;

@WebServlet("/MenuServlet/*")
public class MenuServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String status = uri.substring(uri.lastIndexOf("/") + 1);
		if (status != null) {
			try {
				Method met = this.getClass().getMethod(status, HttpServletRequest.class, HttpServletResponse.class);
				met.invoke(this, request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			// 1、将所有的数据取出，业务层不处理数据，只是将数据返回为控制层
			List<Menu> all = ServiceFactory.getIMenuServiceInstance().list();
			// 2、创建Document兑现
			Document document = DocumentHelper.createDocument();
			// 3、创建menus根节点
			Element menusEle = document.addElement("munus");
			// 4、设置menus中的所有子节点，每一个子节点的名字为menu
			Iterator<Menu> iter = all.iterator();
			while (iter.hasNext()) {
				Menu vo = iter.next();
				Element menuEle = menusEle.addElement("menu");
				Element midEle = menuEle.addElement("mid");
				Element titleEle = menuEle.addElement("title");
				midEle.setText(String.valueOf(vo.getMid()));
				titleEle.setText(String.valueOf(vo.getTitle()));
			}
			// 5、进行输出数据的操作准备
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			// 6、XML支持OutputStream、Writer输出
			XMLWriter out = new XMLWriter(response.getWriter());
			out.write(document);
			System.out.println("执行完成");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void listSub(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int fmid=Integer.parseInt(request.getParameter("mid"));
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			// 1、将所有的数据取出，业务层不处理数据，只是将数据返回为控制层
			List<Menu> all = ServiceFactory.getIMenuServiceInstance().listSub(fmid);
			// 2、创建Document兑现
			Document document = DocumentHelper.createDocument();
			// 3、创建menus根节点
			Element menusEle = document.addElement("menus");
			// 4、设置menus中的所有子节点，每一个子节点的名字为menu
			Iterator<Menu> iter = all.iterator();
			while (iter.hasNext()) {
				Menu vo = iter.next();
				Element menuEle = menusEle.addElement("menu");
				Element midEle = menuEle.addElement("mid");
				Element titleEle = menuEle.addElement("title");
				midEle.setText(String.valueOf(vo.getMid()));
				titleEle.setText(String.valueOf(vo.getTitle()));
			}
			// 5、进行输出数据的操作准备
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			// 6、XML支持OutputStream、Writer输出
			XMLWriter out = new XMLWriter(response.getWriter());
			out.write(document);
			System.out.println("执行完成");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
