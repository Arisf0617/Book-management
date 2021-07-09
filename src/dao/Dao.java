package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Bean_user;
import bean.Bean_book;
import bean.Bean_borrowing;
import db.DBUtil;

public class Dao {
	//dao层
    private DBUtil dbutil=new DBUtil();

    
public Dao() {
    // TODO Auto-generated constructor stub
}
public boolean insert_user(Bean_user bean) {//插入读者数据的方法
    boolean f=false;
    String sql="insert into user_information(uid,name,sex,college,password,identity) values('"+bean.getUid()+"','"+bean.getName()+"','"+bean.getSex()+"','"+bean.getCollege()+"','"+bean.getPassword()+"','"+bean.getIdentity()+"')";
    Connection conn=DBUtil.getConnection();//数据库连接，加载驱动
    Statement state=null;
    try
    {
        state=conn.createStatement();//实例化Statement对象,方便对sql语句进行操作
        System.out.println(conn);
        state.executeUpdate(sql);
        f=true;
        //执行数据库更新操作用于执行INSERT、UPDATE或DELETE语句以及SQLDDL（数据定义语言）语句，
        //例如CREATETABLE和DROPTABLE,（创建表和删除表）
    }catch(Exception e)//当try语句中s出现异常时，会执行catch中的语句
      {
        e.printStackTrace();//捕获异常的语句
      }
     finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
     {
         DBUtil.close(conn);
     }
    return f;
}

public boolean insert_book(Bean_book bean) {//插入图书数据的方法
    boolean f=false;
    String sql="insert into book_information(id,name,writer,press,num) values('"+bean.getId()+"','"+bean.getName()+"','"+bean.getWriter()+"','"+bean.getPress()+"','"+bean.getNum()+"')";
    Connection conn=DBUtil.getConnection();//数据库连接，加载驱动
    Statement state=null;
    try
    {
        state=conn.createStatement();//实例化Statement对象,方便对sql语句进行操作
        System.out.println(conn);
        state.executeUpdate(sql);
        f=true;
        //执行数据库更新操作用于执行INSERT、UPDATE或DELETE语句以及SQLDDL（数据定义语言）语句，
        //例如CREATETABLE和DROPTABLE,（创建表和删除表）
    }catch(Exception e)//当try语句中s出现异常时，会执行catch中的语句
      {
        e.printStackTrace();//捕获异常的语句
      }
     finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
     {
         DBUtil.close(conn);
     }
    return f;
}

public boolean insert_borrowing(Bean_borrowing bean) {//插入图书数据的方法
    boolean f=false;
    String sql="insert into borrowing_information(id,name,writer,press,date,borrower) values('"+bean.getId()+"','"+bean.getName()+"','"+bean.getWriter()+"','"+bean.getPress()+"','"+bean.getDate()+"','"+bean.getBorrower()+"')";
    Connection conn=DBUtil.getConnection();//数据库连接，加载驱动
    Statement state=null;
    try
    {
        state=conn.createStatement();//实例化Statement对象,方便对sql语句进行操作
        System.out.println(conn);
        state.executeUpdate(sql);
        f=true;
        //执行数据库更新操作用于执行INSERT、UPDATE或DELETE语句以及SQLDDL（数据定义语言）语句，
        //例如CREATETABLE和DROPTABLE,（创建表和删除表）
    }catch(Exception e)//当try语句中s出现异常时，会执行catch中的语句
      {
        e.printStackTrace();//捕获异常的语句
      }
     finally //finally作为异常处理的一部分，它只能用在try/catch语句中，并且附带一个语句块，表示这段语句最终一定会被执行（不管有没有抛出异常），经常被用在需要释放资源的情况下。
     {
         DBUtil.close(conn);
     }
    return f;
}



public List<Bean_book> list(){//查询所有方法
    String sql="select * from book_information order by id ASC";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    List<Bean_book> list=new ArrayList<>();
    ResultSet rs=null;
    Bean_book bean=null;
    try {
        st=conn.createStatement();
        st.executeQuery(sql);
        rs=st.executeQuery(sql);
        while(rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String press = rs.getString("press");
            int num=rs.getInt("num");
            bean=new Bean_book(id,name,writer,press,num);
            list.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return list;
}

public List<Bean_borrowing> borrower(int uid){//查询所有方法
    String sql="select * from borrowing_information where borrower='"+uid+"' order by date ASC";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    List<Bean_borrowing> borrower=new ArrayList<>();
    ResultSet rs=null;
    Bean_borrowing bean=null;
    try {
        st=conn.createStatement();
        st.executeQuery(sql);
        rs=st.executeQuery(sql);
        while(rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String press = rs.getString("press");
            String date = rs.getString("date");
            bean=new Bean_borrowing(id,name,writer,press,date,uid);
            borrower.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return borrower;
}

public List<Bean_borrowing> list_overtime(){//查询过期书
	
    Date date=new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	String now=sdf.format(date);
	
    String sql="select * from borrowing_information where date < '"+now+"' order by date ASC";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    List<Bean_borrowing> list_overtime=new ArrayList<>();
    ResultSet rs=null;
    Bean_borrowing bean=null;
    try {
        st=conn.createStatement();
        st.executeQuery(sql);
        rs=st.executeQuery(sql);
        while(rs.next()) {
            int id=rs.getInt("id");
            int borrower=rs.getInt("borrower");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String press = rs.getString("press");
            String date1 = rs.getString("date");
            bean=new Bean_borrowing(id,name,writer,press,date1,borrower);
            list_overtime.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return list_overtime;
}


public List<Bean_book> searchByName(String str) throws SQLException{//查询条件方法
    String sql="select * from book_information where(name like '%"+str+"%')";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    PreparedStatement pt = conn.prepareStatement(sql);
    List<Bean_book> search=new ArrayList<>();
    ResultSet rs=null;
    Bean_book bean=null;
    try {
      pt=conn.prepareStatement(sql);
        rs=pt.executeQuery();
        while(rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String press = rs.getString("press");
            int num=rs.getInt("num");
            bean=new Bean_book(id,name,writer,press,num);
            search.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return search;
}

public List<Bean_book> searchByWriter(String str) throws SQLException{//查询条件方法
    String sql="select * from book_information where(writer like '%"+str+"%')";
    Connection conn=DBUtil.getConnection();
    Statement st=null;
    PreparedStatement pt = conn.prepareStatement(sql);
    List<Bean_book> search=new ArrayList<>();
    ResultSet rs=null;
    Bean_book bean=null;
    try {
      pt=conn.prepareStatement(sql);
        rs=pt.executeQuery();
        while(rs.next()) {
            int id=rs.getInt("id");
            String name = rs.getString("name");
            String writer = rs.getString("writer");
            String press=rs.getString("press");
            int num=rs.getInt("num");
            bean=new Bean_book(id,name,writer,press,num);
            search.add(bean);
        }
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally {
        DBUtil.close(rs, st, conn);
    }
    return search;
}

public boolean update(Bean_book bean) {//更新自减方法
	String sql="update book_information set num='"+bean.getNum()+"',name='"+bean.getName()+"',writer='"+bean.getWriter()+"',press='"+bean.getPress()+"'where id='"+bean.getId()+"'";
    Connection conn=DBUtil.getConnection();
    boolean f=false;
    Statement st=null;
    try {
        st=conn.createStatement();
        st.executeUpdate(sql);
        f=true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return f;
}

public boolean delete_book(int id ) {//删除方法
    String sql="delete from book_information where id='"+id+"'";
    boolean f=false;
    Connection conn =DBUtil.getConnection();
    Statement st=null;
    try {
        st=conn.createStatement();
        st.executeUpdate(sql);
        f=true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally{
        DBUtil.close(st, conn);
    }
    return f;
}

public boolean return_book(int id,int uid ) {//删除方法
    String sql="delete from borrowing_information where id='"+id+"' and borrower='"+uid+"'";
    boolean f=false;
    Connection conn =DBUtil.getConnection();
    Statement st=null;
    try {
        st=conn.createStatement();
        st.executeUpdate(sql);
        f=true;
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    finally{
        DBUtil.close(st, conn);
    }
    return f;
}

}
