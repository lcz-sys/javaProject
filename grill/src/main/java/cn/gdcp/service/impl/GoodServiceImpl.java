package cn.gdcp.service.impl;

import cn.gdcp.domain.Good;
import cn.gdcp.mapper.GoodMapper;
import cn.gdcp.mapper.TopMapper;
import cn.gdcp.mapper.TypeMapper;
import cn.gdcp.service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service("goodService")
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodMapper goodMapper;

    @Autowired
    private TopMapper topMapper;

    @Autowired
    private TypeMapper typeMapper;

    /*封装商品*/
    private List<Good> packGood(List<Good> list) {
        for (Good good:list) {
            good=packGood(good);
        }
        return list;
    }

    /*封装商品 */
    private Good packGood(Good good){
        if (good !=null){
            good.setType(typeMapper.get(good.getTypeId()));//类目信息
            good.setTop(topMapper.selectByGoodId(good.getId()));
        }
        return good;
    }

    /*获取最新的商品*/
    public List<Good> getList(int begin, int size) {
        return packGood(goodMapper.selectList(begin,size));
    }

    @Override
    public List<Good> searchGoods(String name) {
        return goodMapper.selectGoodByName(name);
    }

    @Override
    public List<Good> findAllGoods() {
        return goodMapper.findAllGoods();
    }

    @Override
    public Good get(int id) {
        return goodMapper.get(id);
    }

    @Override
    public boolean updateGood(Good good) {
        return goodMapper.updateGood(good);
    }

    @Override
    public boolean addGood(Good good) {
        return goodMapper.addGood(good);
    }

    @Override
    public int deleteGood(int id) {
        return goodMapper.deleteGood(id);
    }

    @Override
    public int deleteSelectGood(int[] ids) {
        int count = 0;
        for (int id :
                ids) {
            int num = goodMapper.deleteGood(id);
            count += num;
        }
        return count;
    }

    @Override
    public int upGood(int id) {
        return topMapper.upGood(id);
    }

    @Override
    public int downGood(int id) {
        return topMapper.downGood(id);
    }

    @Override
    public List<Good> getListByTop(int begin, int size) {
        return packGood(goodMapper.getListByTop(begin,size));
    }

    @Override
    public List<Good> getListByTop() {
        return packGood(goodMapper.getListByTops());
    }

    @Override
    public List<Good> getListOrderSale(int begin, int size) {
        return packGood(goodMapper.getListOrderSale(begin,size));
    }

    @Override
    public List<Good> getListOrderSales() {
        return packGood(goodMapper.getListOrderSales());
    }

    @Override
    public List<Good> getListByType(int typeId, int begin, int size) {
        return typeId > 0 ? packGood(goodMapper.getListByType(typeId,
                begin,size)) : this.getList(begin,size);
    }

    @Override
    public List<Good> getListByType(int typeId) {
        return packGood(goodMapper.selectListByType(typeId));
    }

    @Override
    public List<Good> getNewGoods() {
        return goodMapper.getNewGoods();
    }

}
