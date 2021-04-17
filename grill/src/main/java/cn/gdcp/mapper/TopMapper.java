package cn.gdcp.mapper;

import cn.gdcp.domain.Top;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopMapper {

    /*获取推荐商品列表*/
    List<Top> findAllTop();

    /*删除*/
    int delete(@Param("id") int id);

    /*添加*/
    boolean add(Top top);

    /*推送商品*/
    int upGood(@Param("id") int id);

    /*下调商品*/
    int downGood(@Param("id") int id);

    Top selectByGoodId(@Param("goodId") int id);
}
