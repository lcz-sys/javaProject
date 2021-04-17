package cn.gdcp.datasource.jdbcTemplate;

import cn.gdcp.datasource.domain.Emp;
import cn.gdcp.datasource.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class JdbcTemplateDemo2 {

    @Test
    public void test(){
        JdbcTemplate tp = new JdbcTemplate(JDBCUtils.getDataSource());

//        String sql = "update emp set salary = ? where id = ?";
        String sql = "select * from emp";

        List<Emp> list = tp.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {

                Emp emp = new Emp();

                emp.setId(rs.getInt("id"));
                emp.setEname(rs.getString("ename"));
                emp.setJob_id(rs.getInt("job_id"));
                emp.setMgr(rs.getInt("mgr"));
                emp.setJoindate(rs.getDate("joindate"));
                emp.setSalary(rs.getDouble("salary"));
                emp.setBonus(rs.getDouble("bonus"));
                emp.setDept_id(rs.getInt("dept_id"));

                return emp;
            }
        });

        for (Emp emp:list){
            System.out.println(emp);
        }

    }

    @Test
    public void test2(){
        JdbcTemplate tp = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "select * from emp";

        List<Emp> list = tp.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));

        for (Emp emp:list){
            System.out.println(emp);
        }

        String sql2 = "select count(id) from emp";

        Long total = tp.queryForObject(sql2, Long.class);

        System.out.println(total);
    }


}
