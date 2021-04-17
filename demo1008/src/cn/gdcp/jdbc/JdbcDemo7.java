package cn.gdcp.jdbc;

import cn.gdcp.domain.Emp;
import cn.gdcp.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JdbcDemo7 {

    public static List<Emp> findAll(){

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<Emp> list = new ArrayList<>();

        try {

            conn = JDBCUtils.getConnection();
            stmt = conn.createStatement();

            String sql = "select * from emp";

            rs = stmt.executeQuery(sql);

            Emp emp = null;

            while (rs.next()){
                emp = new Emp();
                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJoindate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));

                list.add(emp);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,stmt,conn);
        }

        return list;
    }


    public static void main(String[] args) {

        List<Emp> empList = findAll();

        for(Emp emp:empList){
            System.out.println(emp);
        }

    }
}
