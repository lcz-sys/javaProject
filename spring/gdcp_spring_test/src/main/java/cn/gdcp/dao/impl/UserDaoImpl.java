package cn.gdcp.dao.impl;

import cn.gdcp.dao.UserDao;
import cn.gdcp.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    public List<User> findAll() {
        List<User> userList = jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper<User>(User.class));
        return userList;
    }

    public Long save(final User user) {
//        jdbcTemplate.update("insert into sys_user values (null,?,?,?,?)", user.getUsername(), user.getEmail(), user.getPassword(), user.getPhoneNum());

        PreparedStatementCreator creator = new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement = connection.prepareStatement("insert into sys_user values (null,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

                preparedStatement.setString(1,user.getUsername());
                preparedStatement.setString(2,user.getEmail());
                preparedStatement.setString(3,user.getPassword());
                preparedStatement.setString(4,user.getPhoneNum());

                return preparedStatement;
            }
        };

        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(creator,keyHolder);

        long userId = keyHolder.getKey().longValue();

        return userId;
    }

    public void SaveUserRoleRel(Long userId, Long[] roles) {

        for (Long roleId : roles) {
            jdbcTemplate.update("insert into sys_user_role values (?,?)",userId,roleId);
        }

    }

    public void delUser(Long userId) {
        jdbcTemplate.update("delete from sys_user where id = ?", userId);
    }

    public void delUserRoleRel(Long userId) {
        jdbcTemplate.update("delete from sys_user_role where userId = ?", userId);
    }
}
