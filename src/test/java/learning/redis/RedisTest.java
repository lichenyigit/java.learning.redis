package learning.redis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisTest {

    @Test
    public void mapTest(){
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMinIdle(2);//最小空闲连接:连接池中容许保持空闲状态的最小连接数量,低于这个数量将创建新的连接,如果设置为0则不创建
        poolConfig.setMaxTotal(8);
        poolConfig.setMaxIdle(8);//最大空闲连接:连接池中容许保持空闲状态的最大连接数量,超过的空闲连接将被释放,如果设置为负数表示不限制

        JedisPool shardInfo = new JedisPool(poolConfig, "116.62.121.43", 6380, 30000, "redislichenyi", 0);
        Jedis jedis = shardInfo.getResource();
        jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
    }

}
