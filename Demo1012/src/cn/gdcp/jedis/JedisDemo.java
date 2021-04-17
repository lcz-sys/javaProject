package cn.gdcp.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class JedisDemo {

    @Test
    public void test(){
        Jedis jedis = JedisPoolUtils.getJedis();

        jedis.set("haha","xixi");

        jedis.close();
    }

    @Test
    public void test2(){
        Jedis jedis = JedisPoolUtils.getJedis();

        String str = jedis.get("haha");

        System.out.println(str);
    }
}
