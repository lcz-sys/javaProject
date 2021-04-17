package cn.gdcp.service;

import cn.gdcp.domain.Top;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopService {

    /*获取推荐商品列表*/
    List<Top> findAllTop();

    /*删除*/
    int delete(@Param("id") int id);

    /*添加*/
    boolean add(Top top);

    /*批量删除推荐*/
    int deleteSelectTop(int[] ids);

}
