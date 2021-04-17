package cn.gdcp.mapper;

import cn.gdcp.domain.Item;

import java.util.List;

public interface ItemMapper {

    /*获取订单中的商品信息*/
    List<Item> selectList(int orderId);

    /*向订单中注入商品信息*/
    void insert(Item item);

}
