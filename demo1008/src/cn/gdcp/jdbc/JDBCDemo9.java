package cn.gdcp.jdbc;

import cn.gdcp.util.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCDemo9 {

    public static void main(String[] args) {

        Connection conn = null;

        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            conn = JDBCUtils.getConnection();

            conn.setAutoCommit(false);

            String sql1 = "update account set balance = balance + ? where id = ?";
            String sql2 = "update account set balance = balance - ? where id = ?";

            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);

            pstmt1.setDouble(1, 500);
            pstmt1.setInt(2, 1);

            pstmt2.setDouble(1, 500);
            pstmt2.setInt(2, 2);

            pstmt1.executeUpdate();

//            int i = 1 / 0;

            pstmt2.executeUpdate();

            conn.commit();

        } catch (Exception e) {

            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

            e.printStackTrace();
        } finally {
            JDBCUtils.close(pstmt1, conn);
            JDBCUtils.close(pstmt2, null);
        }

    }
}
