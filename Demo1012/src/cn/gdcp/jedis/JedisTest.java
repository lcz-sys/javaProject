package cn.gdcp.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class JedisTest {

    @Test
    public void test1(){

        Jedis jedis = new Jedis();

        jedis.set("username","zhangsan");

        String username = jedis.get("username");

        System.out.println(username);

        jedis.setex("hhh",20,"sdsd");

        jedis.close();

    }

    @Test
    public void test2(){
        Jedis jedis = new Jedis();

        jedis.hset("user","name","lisi");
        jedis.hset("user","age","21");
        jedis.hset("user","gender","male");

        String name = jedis.hget("user", "name");

//        System.out.println(name);

        Map<String, String> user = jedis.hgetAll("user");

        Set<String> keySet = user.keySet();

        for(String key:keySet){
            System.out.println(user.get(key));
        }

        jedis.close();
    }

    @Test
    public void test3(){
        Jedis jedis = new Jedis();

        jedis.lpush("list","a","b","c");
        jedis.rpush("list","a","b","c");

        List<String> list = jedis.lrange("list", 0, -1);

        System.out.println(list);

        String ele = jedis.lpop("list");

        System.out.println(ele);

        jedis.rpop("list");

        jedis.close();
    }

    @Test
    public void test4(){
        Jedis jedis = new Jedis();

        jedis.sadd("set","java","php","c++");

        Set<String> sets = jedis.smembers("set");

        System.out.println(sets);

        jedis.close();
    }

    @Test
    public void test5(){
        Jedis jedis = new Jedis();

        jedis.zadd("zset",1,"1");
        jedis.zadd("zset",2,"3");
        jedis.zadd("zset",3,"2");


        Set<String> zset = jedis.zrange("zset", 0, -1);

        System.out.println(zset);

        jedis.close();

    }

}
