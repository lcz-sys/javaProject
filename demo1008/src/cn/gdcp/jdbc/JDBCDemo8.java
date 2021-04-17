package cn.gdcp.jdbc;

import cn.gdcp.util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class JDBCDemo8 {

    public static boolean login(String username, String password){

        if(username == null || password == null){
            return false;
        }

        Connection conn = null;
//        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();
//            stmt = conn.createStatement();

            String sql = "select * from user where username = ? and password = ?";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,username);
            pstmt.setString(2,password);

//            rs = stmt.executeQuery(sql);
            rs = pstmt.executeQuery();

            return rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,pstmt,conn);
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("请输入用户名:");
        String username = sc.next();

        System.out.println("请输入密码:");
        String password = sc.next();

        boolean flag = login(username, password);

        if(flag){
            System.out.println("登录成功");
        }else{
            System.out.println("登录失败");
        }

    }

}
