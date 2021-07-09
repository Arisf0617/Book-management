package servlet;


import java.io.IOException;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    }
 		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		//1 获得用户输入的验证码
        String verifyCode = request.getParameter("ValiImage");
        //2 获得服务器session 存放数据 ,如果没有返回null
        String sessionCacheData = (String) request.getSession().getAttribute("Valicode");
        // *将服务器缓存session数据移除
        request.getSession().removeAttribute("Valicode");
        // ** 判断服务器是否存在
        if(sessionCacheData == null){
        	request.setAttribute("message", "请不要重复提交");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        //3 比较
        if(! sessionCacheData.equalsIgnoreCase(verifyCode)){
            //用户输入错误
            // * 存放request作用域
        	request.setAttribute("message", "验证码输入错误");
            // * 请求转发
            request.getRequestDispatcher("login.jsp").forward(request, response);        
            return;
        }
		
		int uid=Integer.parseInt(request.getParameter("uid"));
		String pass=String.valueOf(request.getParameter("password"));
		String identity=String.valueOf(request.getParameter("identity"));

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(new Date());
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/book system?&useSSL=false&serverTimezone=UTC";
			String username="root";
			String password="whyjlbcdy2001";
			Connection conn=DriverManager.getConnection(url,username,password);
			
			String sql="select * from user_information where uid='"+uid+"'and password='"+pass+"'and identity='"+identity+"'";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				System.out.println(date+"  "+uid+" "+"login"+""+identity);
				System.out.println();
				request.setAttribute("uid", uid);
				if(identity.equals("读者")){
					request.getRequestDispatcher("user_index.jsp").forward(request,response);
				}
				if(identity.equals("管理员")){
					request.getRequestDispatcher("admin_index.jsp").forward(request,response);
				}
			}else{
				request.setAttribute("message", "用户名或密码错误");
				request.getRequestDispatcher("login.jsp").forward(request,response);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}


