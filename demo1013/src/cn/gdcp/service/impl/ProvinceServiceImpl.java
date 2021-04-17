package cn.gdcp.service.impl;

import cn.gdcp.dao.ProvinceDao;
import cn.gdcp.dao.impl.ProvinceDaoImpl;
import cn.gdcp.domain.Province;
import cn.gdcp.jedis.JedisPoolUtils;
import cn.gdcp.service.ProvinceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import redis.clients.jedis.Jedis;

import java.util.List;

public class ProvinceServiceImpl implements ProvinceService {

    private ProvinceDao dao = new ProvinceDaoImpl();

    @Override
    public List<Province> findAll() {
        return dao.findAll();
    }

    @Override
    public String findAllJson() {

        Jedis jedis = JedisPoolUtils.getJedis();

        String province_json = jedis.get("province");

//        System.out.println(province_json);

        if (province_json == null || province_json.length() == 0) {

            List<Province> list = findAll();

            ObjectMapper mapper = new ObjectMapper();
            try {
                province_json = mapper.writeValueAsString(list);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

            jedis.set("province", province_json);
            jedis.close();
        }

        return province_json;
    }
}
