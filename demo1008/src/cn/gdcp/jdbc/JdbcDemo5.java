package cn.gdcp.jdbc;

import java.sql.*;

public class JdbcDemo5 {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql:///db1", "root", "root");
            stmt = conn.createStatement();

            String sql = "select * from account";

            res = stmt.executeQuery(sql);

            while (res.next()) {
                int id = res.getInt(1);
                String name = res.getString("name");
                double balance = res.getDouble(3);

                System.out.println(id + "," + name + "," + balance);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
