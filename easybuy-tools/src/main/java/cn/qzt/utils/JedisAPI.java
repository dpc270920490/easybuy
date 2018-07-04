package cn.qzt.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Title:  easybuy
 * Description:  SSD
 *
 * @author dc
 * @date2018/7/114:21
 */
public class JedisAPI {

    /**
     * 读取缓存数据库redis连接池的对象
     */
    private JedisPool jedisPool;

    public JedisPool getJedisPool() {
        return jedisPool;
    }

    public void setJedisPool(JedisPool jedisPool) {
        this.jedisPool = jedisPool;
    }


    //执行对redis的操作，获取jedis对象


    public String get(String key){
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get(key);

        jedisPool.returnResource(jedis);

        return value;
    }

    public String set(String key,String value){
        Jedis jedis = jedisPool.getResource();
        String result = jedis.set(key,value);
        jedisPool.returnResource(jedis);
        return result;

    }
    public String set(String key,int seconds,String value) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.setex(key,seconds,value);
        jedisPool.returnResource(jedis);
        return result;
    }
    public Boolean exists(String key){
        Jedis jedis = jedisPool.getResource();
        Boolean result = jedis.exists(key);
        jedisPool.returnResource(jedis);
        return result;
    }
    public Long ttl(String key){
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.ttl(key);
        jedisPool.returnResource(jedis);
        return result;
    }
    public Long del(String key){
        Jedis jedis = jedisPool.getResource();
        Long result = jedis.del(key);
        jedisPool.returnResource(jedis);
        return result;
    }


}
