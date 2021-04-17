package cn.gdcp.service.impl;

import cn.gdcp.domain.Good;
import cn.gdcp.domain.Type;
import cn.gdcp.mapper.TypeMapper;
import cn.gdcp.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("typeService")
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeMapper typeMapper;

    public List<Type> findAll() {
        List<Type> typeList = typeMapper.findAll();
        return typeList;
    }

    public Type selectByTypeName(String name) {
        return null;
    }

    public Type get(int id) {
        return typeMapper.get(id);
    }

    public int getCount() {
        return typeMapper.getCount();
    }

    public List<Good> getListByType(int id, int page, int size) {
        return null;
    }

    public int deleteType(int id) {
        return typeMapper.deleteType(id);
    }

    public boolean typeAdd(Type type) {
        return typeMapper.typeAdd(type);
    }

    public boolean update(Type type) {
        return typeMapper.update(type);
    }

    @Override
    public int deleteSelectType(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = typeMapper.deleteType(id);
            count += num;
        }
        return count;
    }
}
