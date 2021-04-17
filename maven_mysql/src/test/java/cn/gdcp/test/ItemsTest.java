package cn.gdcp.test;

import cn.gdcp.dao.ItemsDao;
import cn.gdcp.dao.impl.ItemsDaoImpl;
import cn.gdcp.domain.Items;
import org.junit.Test;

import java.util.List;

public class ItemsTest {

    @Test
    public void findAll(){
        ItemsDao itemsDao = new ItemsDaoImpl();

        List<Items> list = itemsDao.findAll();

        for(Items items:list){
            System.out.println(items);
        }
    }

}
