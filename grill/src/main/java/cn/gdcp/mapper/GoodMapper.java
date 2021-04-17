package cn.gdcp.mapper;

import cn.gdcp.domain.Good;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodMapper {

    /*显示商品*/
    List<Good> findAllGoods();

    /*根据商品名查询商品*/
    List<Good> selectGoodByName(@Param("name") String name);

    /*添加商品*/
    boolean addGood(Good good);

    /*删除商品*/
    int deleteGood(@Param("id") int id);

    /*修改后台商品信息*/
    boolean updateGood(Good good);

    /*id获取商品信息*/
    Good get(@Param("id") int id);

    /*获取推荐商品*/
    List<Good> getListByTop(@Param(value = "begin") int begin, @Param(value = "size") int size);

    List<Good> getListByTops();

    /*获取热销商品*/
    List<Good> getListOrderSale(@Param(value = "begin") int begin, @Param(value = "size") int size);

    List<Good> getListOrderSales();

    /*获取每个类目的商品*/
    List<Good> getListByType(@Param(value = "typeId") int typeId, @Param(value = "begin") int begin, @Param(value = "size") int size);

    /*获取最新的商品*/
    List<Good> selectList(@Param(value = "begin") int begin, @Param(value = "size") int size);

    /*获取最新上市的商品*/
    List<Good> getNewGoods();

    /*根据商品类型获取商品列表*/
    List<Good> selectListByType(@Param("typeId") int typeId);

    /*减少库存*/
    boolean updateStock(@Param("id") int id, @Param("stock") int stock);

    /*增加销量*/
    boolean updateSales(@Param("id") int id, @Param("sales") int sales);

}
