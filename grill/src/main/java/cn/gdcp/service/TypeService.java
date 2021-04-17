package cn.gdcp.service;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Type;

import java.util.List;

public interface TypeService {

    /*查询全部*/
    List<Type> findAll();

    /*通过分类名获取（验证）*/
    Type selectByTypeName(String name);


    /*根据id查询 */
    Type get(int id);

    /*获取总数*/
    int getCount();

    List<Good> getListByType(int id, int page, int size);


    //后台
    /*后台 删除类目根据id*/
    int deleteType(int id);

    /*后台添加类目管理*/
    boolean typeAdd(Type type);

    /*后台修改类目信息*/
    boolean update(Type type);

    /*批量删除类目*/
    int deleteSelectType(int[] ids);

}
