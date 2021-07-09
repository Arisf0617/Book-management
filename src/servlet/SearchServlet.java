package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Bean_book;
import dao.Dao;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String cxfs=request.getParameter("cxfs");
        System.out.print(cxfs);
        
        String str=request.getParameter("value");
		 Dao dao=new Dao();
		 List<Bean_book> list = null;
		 
		 try {
			 if("1".equals(cxfs)){
				 	list=dao.searchByName(str);
			 	} 
			 if("2".equals(cxfs)){
				 	list=dao.searchByWriter(str);
			 	} 
		 	} catch (SQLException e) {
		 		// TODO 自动生成的 catch 块
		 		e.printStackTrace();
		 	}
		 request.setAttribute("list", list);
		 request.getRequestDispatcher("list book.jsp").forward(request,response);
		 System.out.print(list.size());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
