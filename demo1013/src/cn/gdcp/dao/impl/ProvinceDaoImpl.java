package cn.gdcp.dao.impl;

import cn.gdcp.dao.ProvinceDao;
import cn.gdcp.domain.Province;
import cn.gdcp.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {

//        System.out.println(123);

        String sql = "select * from province";

        List<Province> list = template.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

//        System.out.println(list);
        return list;
    }
}
