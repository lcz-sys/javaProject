package cn.gdcp.service;

import cn.gdcp.domain.Good;

import java.util.List;

public interface GoodService {

    /*根据商品名查询商品*/
    List<Good> searchGoods(String name);

    /*检索后台商品信息*/
    List<Good> findAllGoods();

    /*根据id查询商品信息*/
    Good get(int id);

    /*更新商品*/
    boolean updateGood(Good good);

    /*添加商品*/
    boolean addGood(Good good);

    /*根据id删除上商品*/
    int deleteGood(int id);

    /*删除选中的商品*/
    int deleteSelectGood(int[] ids);

    /*推送商品*/
    int upGood(int id);

    /*下调商品*/
    int downGood(int id);

    /*获取推荐商品*/
    List<Good> getListByTop(int begin, int size);
    List<Good> getListByTop();

    /*获取热销商品*/
    List<Good> getListOrderSale(int begin, int size);
    List<Good> getListOrderSales();

    /*获取每个类目的商品*/
    List<Good> getListByType(int typeId, int begin, int size);
    List<Good> getListByType(int typeId);

    /*获取最新商品*/
    List<Good> getNewGoods();

}
