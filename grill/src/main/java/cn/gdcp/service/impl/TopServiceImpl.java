package cn.gdcp.service.impl;

import cn.gdcp.domain.Top;
import cn.gdcp.mapper.TopMapper;
import cn.gdcp.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("topService")
public class TopServiceImpl implements TopService {

    @Autowired
    private TopMapper topMapper;

    @Override
    public List<Top> findAllTop() {
        return topMapper.findAllTop();
    }

    @Override
    public int delete(int id) {
        return topMapper.delete(id);
    }

    @Override
    public boolean add(Top top) {
        return topMapper.add(top);
    }

    @Override
    public int deleteSelectTop(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = topMapper.delete(id);
            count += num;
        }
        return count;
    }
}
