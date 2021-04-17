package cn.gdcp.service.impl;

import cn.gdcp.domain.Cart;
import cn.gdcp.domain.Good;
import cn.gdcp.domain.Item;
import cn.gdcp.domain.Order;
import cn.gdcp.interceptor.ExceptionInterceptor;
import cn.gdcp.mapper.CartMapper;
import cn.gdcp.mapper.GoodMapper;
import cn.gdcp.mapper.ItemMapper;
import cn.gdcp.mapper.OrderMapper;
import cn.gdcp.service.CartService;
import cn.gdcp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private GoodMapper goodMapper;

    @Override
    public List<Order> getOrderList() {
        return orderMapper.getOrderList();
    }

    @Override
    public List<Order> getListByStatus(byte status) {
        return orderMapper.getListByStatus(status);
    }

    @Override
    public int delete(int id) {
        return orderMapper.delete(id);
    }

    @Override
    public boolean send(int id) {
        Order order = orderMapper.get(id);
        byte status = order.getStatus();
        if (status == 2) {
            return orderMapper.send(id);
        }
        return false;
    }

    @Override
    public boolean complete(int id) {
        Order order = orderMapper.get(id);
        byte status = order.getStatus();
        if (status == 3) {
            return orderMapper.complete(id);
        }
        return false;
    }

    @Override
    public int deleteSelectOrders(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = orderMapper.delete(id);
            count += num;
        }
        return count;
    }

    @Override
    public boolean sendSelectOrders(int[] ids) {
        for (int id :
                ids) {
            Order order = orderMapper.get(id);
            byte status = order.getStatus();
            if (status != 2) {
                return false;
            }
            orderMapper.send(id);
        }
        return true;
    }

    @Override
    public boolean completeSelectOrders(int[] ids) {
        for (int id :
                ids) {
            Order order = orderMapper.get(id);
            byte status = order.getStatus();
            if (status != 3) {
                return false;
            }
            orderMapper.complete(id);
        }
        return true;
    }

    @Override
    public List<Order> searchOrders(String username, String start_time, String end_time) {
        return orderMapper.selectOrderByUsernameOrTime(username, start_time, end_time);
    }

    @Override
    public List<Order> searchOrderByMore(byte status, String username, String start_time, String end_time) {
        return orderMapper.selectOrderByMore(status, username, start_time, end_time);
    }

    @Override
    public List<Order> getListByUserId(int id) {
        return orderMapper.getListByUserId(id);
    }

    @Transactional
    public int save(int userId) throws ExceptionInterceptor.MyException {

        List<Cart> cartList = cartMapper.selectListByUseId(userId);
//        System.out.println(cartList);

        /*验证库存*/
        for (Cart cart : cartList) {
            if (cart.getGood().getStock() < cart.getAmount()) {
                throw new ExceptionInterceptor.MyException("商品[" + cart.getGood().getName() + "]库存不足！");
            }
            //减少库存
            goodMapper.updateStock(cart.getGood().getId(), cart.getAmount());
            //增加销量
            goodMapper.updateSales(cart.getGood().getId(), cart.getAmount());
        }
        int total = 0;
        for (Cart cart : cartList) {
            total += cart.getGood().getPrice() * cart.getAmount();
        }
        Order order = new Order();
        order.setUserId(userId);
        order.setTotal(total);
        order.setAmount(cartList.size());
        order.setStatus(Order.STATUS_UNPAY);
        order.setSystime(new Date());
        orderMapper.insert(order);
        int orderId = order.getId();
        for (Cart cart : cartList) {
            Item item = new Item();
            item.setOrderId(orderId);
            item.setGoodId(cart.getGoodId());
            item.setPrice(cart.getGood().getPrice());
            item.setAmount(cart.getAmount());
            itemMapper.insert(item);
        }
        //清空购物车
        cartMapper.deleteByUserId(userId);
        return orderId;
    }

    @Override
    public int Immediatelysave(int userId, Good good, int count) throws ExceptionInterceptor.MyException {

        /*验证库存*/
        if (good.getStock() - count < 0) {
            throw new ExceptionInterceptor.MyException("商品[" + good.getName() + "]库存不足！");
        }
        //减少库存
        goodMapper.updateStock(good.getId(), count);
        //增加销量
        goodMapper.updateSales(good.getId(), count);

        int total = good.getPrice() * count;
        Order order = new Order();
        order.setUserId(userId);
        order.setTotal(total);
        order.setAmount(count);
        order.setStatus(Order.STATUS_UNPAY);
        order.setSystime(new Date());
        orderMapper.insert(order);

        int orderId = order.getId();
        Item item = new Item();
        item.setOrderId(orderId);
        item.setGoodId(good.getId());
        item.setPrice(good.getPrice());
        item.setAmount(count);
        itemMapper.insert(item);

        return orderId;
    }

    @Override
    public Order get(int id) {
        return orderMapper.get(id);
    }

    @Override
    public boolean pay(Order order) {
        Order older = orderMapper.get(order.getId());
        older.setStatus(Order.STATUS_PAYED);
        older.setPaytype(order.getPaytype());
        older.setName(order.getName());
        older.setPhone(order.getPhone());
        older.setAddress(order.getAddress());
        boolean flag = orderMapper.update(older);
        if (flag) {
            return true;
        }
        return false;
    }

}
