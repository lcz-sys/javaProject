package cn.gdcp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcDemo3 {

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");

             Statement stmt = conn.createStatement()) {

            Class.forName("com.mysql.jdbc.Driver");

//            String sql = "update account set balance = balance - 50 where name='zhangsan'";

            String sql = "insert account value(null,'wangwu',10000)";

            int count = stmt.executeUpdate(sql);

            System.out.println("受影响的行数:" + count);

            if (count > 0) {
                System.out.println("执行成功");
            } else {
                System.out.println("执行失败");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
