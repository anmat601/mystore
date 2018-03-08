package MyStoreWeb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import mystore.bean.BeanManager;
import mystore.dao.ItemDataDao;
import mystore.service.ItemManagement;
import mystore.model.ItemData;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class ItemServlet
 */
//@WebServlet("/ItemServlet")
public class ItemServlet extends HttpServlet {
	final static Logger logger = LogManager.getLogger(ItemServlet.class);
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ItemServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("this is item servlet");
		try{  

			List<ItemData> itemList =new ArrayList<ItemData>();

			itemList =((ItemManagement)BeanManager.getContext().getBean("itemManagement")).GetAllItems();

			for(int i=0;i<itemList.size();i++)
			{
				System.out.println(itemList.get(i));
			}
			
		/*	PrintWriter writer =response.getWriter();
			String itemName = request.getParameter("itemName");
			writer.append(itemName);
			int price =((ItemManagement)BeanManager.getContext().getBean("itemManagement")).getPriceOfItem(itemName);
			response.getWriter().append("Price of the item: "+price);*/

			//Connection con =((DriverManagerDataSource)BeanManager.getContext().getBean("dataSource")).getConnection();
			//Connection con=DriverManager.getConnection(  
			//	"jdbc:mysql://localhost:3306/ejb","root","sqlpassword");  
			//	Statement stmt=con.createStatement();  
			//	ResultSet rs=stmt.executeQuery("select * from item_data");  
			//	while(rs.next())  
			//		System.out.println(rs.getString(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));    
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		}  
	}  



	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
