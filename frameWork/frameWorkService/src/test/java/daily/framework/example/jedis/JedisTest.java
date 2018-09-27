package daily.framework.example.jedis;

import daily.framework.TestSupport;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest extends TestSupport {
    private static final Logger LOGGER = LoggerFactory.getLogger(JedisTest.class);

    //注入ShardedJedisPool
    @Autowired
    private JedisPool jedisPool;//注入JedisPool

    @Test
    public void  test() {
        //获取ShardedJedis对象
        Jedis jedis = jedisPool.getResource();
        //存入键值对
        jedis.set("key1", "hello jedis one");
        //根据键值获得数据
        String result = jedis.get("key1");
        LOGGER.info("result-------- is {}",result);
        //回收ShardedJedis实例
        jedis.close();
    }


}
