package cn.gdcp.mapper;

import cn.gdcp.domain.Order;
import cn.gdcp.domain.User;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {

    @Select("select *,o.id oid from orders o, user u where u.id = o.uid")
    @Results({
            @Result(column = "oid",property = "id"),
            @Result(column = "ordertime",property = "ordertime"),
            @Result(column = "total",property = "total"),
            @Result(
                    property = "user",
                    javaType = User.class,
                    column = "uid",
                    one = @One(select = "cn.gdcp.mapper.UserMapper.findById")
            )
    })
    List<Order> findAll();

    @Select("select * from orders where uid=#{id}")
    List<Order> findById(int id);
}
