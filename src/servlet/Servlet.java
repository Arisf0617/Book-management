package servlet;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


 
import java.util.Calendar;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat; 

import bean.Bean_user;
import bean.Bean_book;
import bean.Bean_borrowing;
import dao.Dao;

/**
 * Servlet implementation class servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	Dao dao = new Dao();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    private void insert_user(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {//增
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        int uid = Integer.parseInt(request.getParameter("uid"));
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String college= request.getParameter("college");
        String password= request.getParameter("password");
        String identity= request.getParameter("identity");
        Bean_user bean=new Bean_user(uid,name,sex,college,password,identity);
 
        if(dao.insert_user(bean)) {
            request.setAttribute("message", "添加成功");
            request.getRequestDispatcher("add user.jsp").forward(request, response);
        }
    }
    
	private void insert_book(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {//增
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String writer = request.getParameter("writer");
        String press= request.getParameter("press");
        int num = Integer.parseInt(request.getParameter("num"));
        Bean_book bean=new Bean_book(id,name,writer,press,num);
 
        if(dao.insert_book(bean)) {
            request.setAttribute("message", "添加成功");
            request.getRequestDispatcher("add book.jsp").forward(request, response);
        }
    }
	
    private void list(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String uid = request.getParameter("uid");
        //int uid = Integer.parseInt(request.getParameter("id"));
        List<Bean_book> list = dao.list();
        request.setAttribute("list", list);
        request.setAttribute("uid", uid);

        request.getRequestDispatcher("list book.jsp").forward(request,response);
    }
    
    private void Mylist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        String uid_string = request.getParameter("uid");
        int uid  = Integer.parseInt(uid_string);
        //int uid = Integer.parseInt(request.getParameter("id"));
        List<Bean_borrowing> borrower = dao.borrower(uid);
        request.setAttribute("list", borrower);
        request.setAttribute("uid", uid);

        request.getRequestDispatcher("my_list.jsp").forward(request,response);
    }
    
    private void list_admin(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        List<Bean_book> list_admin = dao.list();
        request.setAttribute("list", list_admin);
        request.getRequestDispatcher("delete book.jsp").forward(request,response);
    }
    
    private void list_overtime(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
		
        String uid_string = request.getParameter("uid");
        int uid  = Integer.parseInt(uid_string);
        //int uid = Integer.parseInt(request.getParameter("id"));
        List<Bean_borrowing> list_overtime = dao.list_overtime();
        
        request.setAttribute("list", list_overtime);
        request.setAttribute("uid", uid);

        request.getRequestDispatcher("list_overtime.jsp").forward(request,response);
    }
    
    
    
    @SuppressWarnings("deprecation")
	private void borrow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//改
        // TODO Auto-generated method stub
        request.setCharacterEncoding("utf-8");
        Date date0=new Date();
        date0.setMonth(date0.getMonth()+3);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date=sdf.format(date0);
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String writer = request.getParameter("writer");
        String press = request.getParameter("press");
        
        int num= Integer.parseInt(request.getParameter("num"));
        num=num-1;
        
        String uid_string = request.getParameter("uid");
        int uid  = Integer.parseInt(uid_string);


        Bean_book bean1=new Bean_book(id,name,writer,press,num);
		Bean_borrowing bean2=new Bean_borrowing(id,name,writer,press,date,uid);

        dao.update(bean1);
        dao.insert_borrowing(bean2);
        request.setAttribute("uid", uid);
        request.getRequestDispatcher("Servlet?method=list").forward(request, response);
    }
    
    private void delete_book(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {//删
        // TODO Auto-generated method stub
        request.setCharacterEncoding("UTF-8");
        int id=Integer.parseInt(request.getParameter("id"));
        dao.delete_book(id); //进行数据库的删除操作
        request.setAttribute("message", "删除成功");
        request.getRequestDispatcher("Servlet?method=list_admin").forward(request, response);
    }
    
    private void return_book(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {//删
        // TODO Auto-generated method stub    	
        request.setCharacterEncoding("UTF-8");
        String uid_string = request.getParameter("uid");
        int uid  = Integer.parseInt(uid_string);
        int id=Integer.parseInt(request.getParameter("id"));       
        dao.return_book(id,uid); //进行数据库的删除操作
        request.setAttribute("message", "归还成功");
        request.setAttribute("uid", uid);
        request.getRequestDispatcher("Servlet?method=Mylist").forward(request, response);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String method=request.getParameter("method");
		 if("insert_user".equals(method)) {
			 insert_user(request,response);           
	        }
		 else if("insert_book".equals(method)) {
			 insert_book(request,response);
		 }
	     else if("list".equals(method)) {
	            try {
	                list(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	     }
	     else if("list_overtime".equals(method)) {
	            try {
	                list_overtime(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	     }
	     else if("list_admin".equals(method)) {
	            try {
	                list_admin(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	     }
	     else if("Mylist".equals(method)) {
	            try {
	                Mylist(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }
	     }
	     else if("borrow".equals(method)) {
	            borrow(request,response);
	        }
	     else if("delete_book".equals(method)) {
	        	try {
	                delete_book(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }	            
	        }
	     else if("return_book".equals(method)) {
	        	try {
	                return_book(request,response);
	            } catch (Exception e) {
	                // TODO Auto-generated catch block
	                e.printStackTrace();
	            }	            
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
