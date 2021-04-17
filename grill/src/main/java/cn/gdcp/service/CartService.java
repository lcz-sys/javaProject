package cn.gdcp.service;

import cn.gdcp.domain.Cart;

import java.util.List;

public interface CartService {

    /*获取购物车数量*/
    int getCount(int userId);

    /*获取购物车列表*/
    List<Cart> getList(int userId);

    /*添加购物车*/
    boolean save(int goodId, int count, int userId);
    boolean save(int goodId, int userId);

    /*购物车总金额*/
    int getTotal(int userId);

    boolean cartDel(int id);

    boolean add(int id);

    boolean less(int id);

    /*清空购物车*/
    boolean clean(int userId);
}
