package cn.gdcp.service;


import cn.gdcp.domain.Good;
import cn.gdcp.domain.Order;
import cn.gdcp.interceptor.ExceptionInterceptor;

import java.util.List;

public interface OrderService {

    /*获取全部订单*/
    List<Order> getOrderList();

    /*根据订单状态获取订单*/
    List<Order> getListByStatus(byte status);

    /*删除订单*/
    int delete(int id);

    /*发货*/
    boolean send(int id);

    /*完成订单*/
    boolean complete(int id);

    /*删除选中的订单*/
    int deleteSelectOrders(int[] ids);

    /*发货选中的订单*/
    boolean sendSelectOrders(int[] ids);

    /*完成选中的订单*/
    boolean completeSelectOrders(int[] ids);

    /*搜索*/
    List<Order> searchOrders(String username, String start_time, String end_time);

    /*多条件查询*/
    List<Order> searchOrderByMore(byte status, String username, String start_time, String end_time);

    /*根据id查询密码*/
    List<Order> getListByUserId(int id);

    /*下订单*/
    int save(int userId) throws ExceptionInterceptor.MyException;

    /*根据id获取订单*/
    Order get(int id);

    boolean pay(Order order);

    int Immediatelysave(int userId, Good good,int count) throws ExceptionInterceptor.MyException;
}
