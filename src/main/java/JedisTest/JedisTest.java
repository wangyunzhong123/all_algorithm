package JedisTest;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * Created by yzwang on 2019/3/24.
 */
public class JedisTest {

    public static void main(String[] args) {

        //连接redis ，redis的默认端口是6379

        Jedis  jedis = new Jedis("localhost",6379);
        //验证密码，如果没有设置密码这段代码省略
        jedis.auth("password");

        jedis.connect();//连接

        jedis.disconnect();//断开连接

        Set<String> keys = jedis.keys("*"); //列出所有的key
        //移除给定的一个或多个key,如果key不存在,则忽略该命令.
        jedis.del("key1");
        jedis.del("key1","key2","key3","key4","key5");

        //移除给定key的生存时间(设置这个key永不过期)
        jedis.persist("key1");
    }
}
