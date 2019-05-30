package cn.hhj.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

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
import cn.hhj.vo.Dept;

@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri=request.getRequestURI();
		String status=uri.substring(uri.lastIndexOf("/")+1);
		if(status!=null) {
			try {
				Method met=this.getClass().getMethod(status,HttpServletRequest.class,HttpServletResponse.class);
				met.invoke(this, request,response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result[]=(String[])request.getParameter("ids").split(":");
		Set<Integer> ids=new HashSet<Integer>();
		for(int x=0;x<result.length;x++) {
			ids.add(Integer.parseInt(result[x]));
		}
		
		try {
			response.getWriter().print(ServiceFactory.getIDeptServiceInstance().delete(ids));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void editPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		int did=Integer.parseInt(request.getParameter("did"));
		try {
			Dept vo=ServiceFactory.getIDeptServiceInstance().editPre(did);
			response.getWriter().print(vo.getDid()+":"+vo.getDname()+":"+vo.getLoc());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dept vo=new Dept();
		vo.setDid(Integer.parseInt(request.getParameter("did")));
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		try {
			boolean flag=ServiceFactory.getIDeptServiceInstance().edit(vo);
			response.getWriter().print(flag);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dept vo=new Dept();
		vo.setDname(request.getParameter("dname"));
		vo.setLoc(request.getParameter("loc"));
		try {
			boolean flag=ServiceFactory.getIDeptServiceInstance().add(vo);
			response.getWriter().print(flag+":"+vo.getDid());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		try {
			Document document = DocumentHelper.createDocument();
			Iterator<Dept> iter=ServiceFactory.getIDeptServiceInstance().list().iterator();
			Element deptsElement=document.addElement("depts");
			while(iter.hasNext()) {
				Dept vo=iter.next();
				Element deptElement=deptsElement.addElement("dept");
				Element didElement=deptElement.addElement("did");
				Element dnameElement=deptElement.addElement("dname");
				Element locElement=deptElement.addElement("loc");
				didElement.setText(String.valueOf(vo.getDid()));
				dnameElement.setText(vo.getDname());
				locElement.setText(vo.getLoc());
			}
			// 5、进行输出数据的操作准备
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("UTF-8");
			// 6、XML支持OutputStream、Writer输出
			XMLWriter out = new XMLWriter(response.getWriter());
			out.write(document);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
