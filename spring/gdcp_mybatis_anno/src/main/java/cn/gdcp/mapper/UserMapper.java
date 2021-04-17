package cn.gdcp.mapper;

import cn.gdcp.domain.Order;
import cn.gdcp.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from user")
    List<User> findAll();

    @Insert("insert into user values (#{id},#{username},#{password},#{birthday})")
    void save(User user);

    @Update("update user set username = #{username},password = #{password} where id = #{id}")
    void update(User user);

    @Delete("delete from user where id = #{id}")
    void delete(int id);

    @Select("select * from user where id = #{id}")
    User findById(int id);

    @Select("select *,o.id oid from orders o, user u where u.id = o.uid")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(column = "birthday",property = "birthday"),
            @Result(
                    property = "orderList",
                    column = "uid",
                    javaType = List.class,
                    many = @Many(select = "cn.gdcp.mapper.OrderMapper.findById")
            )
    })
    List<User> findUserAndOrderAll();

    @Select("select * from user")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(column = "username",property = "username"),
            @Result(column = "password",property = "password"),
            @Result(
                    column = "id",
                    javaType = List.class,
                    property = "roleList",
                    many = @Many(select = "cn.gdcp.mapper.RoleMapper.findByUid")
            )
    })
    List<User> findUserAndRoleAll();
}
