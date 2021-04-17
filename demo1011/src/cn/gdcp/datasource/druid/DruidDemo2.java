package cn.gdcp.datasource.druid;

import cn.gdcp.datasource.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DruidDemo2 {

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            conn = JDBCUtils.getConnection();

            conn.setAutoCommit(false);

            String sql = "insert into account values(null,?,?)";

            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,"wangwu");
            pstmt.setDouble(2,3000);

            pstmt.executeUpdate();

            conn.commit();

        } catch (Exception e) {
            if(conn != null){
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt,conn);
        }

    }
}
