package cn.gdcp.mapper;

import cn.gdcp.domain.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    /*获取全部订单*/
    List<Order> getOrderList();

    /*根据订单状态获取订单*/
    List<Order> getListByStatus(@Param("status") byte status);

    /*根据id获取订单*/
    Order get(int id);

    /*删除订单*/
    int delete(int id);

    /*发货*/
    boolean send(int id);

    /*完成订单*/
    boolean complete(int id);

    /*根据用户名或者时间查询订单*/
    List<Order> selectOrderByUsernameOrTime(@Param("username") String username, @Param("start_time") String start_time, @Param("end_time") String end_time);

    /*多条件查询*/
    List<Order> selectOrderByMore(@Param("status") byte status, @Param("username") String username, @Param("start_time") String start_time, @Param("end_time") String end_time);

    /*根据用户id查询订单*/
    List<Order> getListByUserId(@Param("userId") int id);

    /*添加订单*/
    boolean insert(Order order);

    /*修改订单*/
    boolean update(Order order);
}
