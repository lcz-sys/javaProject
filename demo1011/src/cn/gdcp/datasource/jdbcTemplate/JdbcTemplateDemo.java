package cn.gdcp.datasource.jdbcTemplate;

import cn.gdcp.datasource.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcTemplateDemo {

    public static void main(String[] args) {

        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

        String sql = "insert into account values(null,?,?)";

        int count = template.update(sql, "zhaoliu", 9000);


        System.out.println(count);


    }
}
