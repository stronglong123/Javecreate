package com.common.generate.javacreate.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

@Component
public class StringRedisHelper {
   
    private static final Logger LOGGER = LoggerFactory.getLogger(StringRedisHelper.class);

    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;
    
    /**
     * scan 实现
     * @param pattern   表达式
     * @param consumer  对迭代到的key进行操作
     */
    public void scan(String pattern, Consumer<byte[]> consumer) {
        this.stringRedisTemplate.execute((RedisConnection connection) -> {
            try (Cursor<byte[]> cursor = connection.scan(ScanOptions.scanOptions().count(1000).match(pattern).build())) {
                cursor.forEachRemaining(consumer);
                return null;
            } catch (IOException e) {
            	LOGGER.error("正则匹配错误", e);
            }
			return connection;
        });
    }

    public List<String> scanKeys(String hashkey, String key){
        try {
        	List<String> keys = new ArrayList<>();
            Cursor<Entry<Object, Object>> cursor = stringRedisTemplate.opsForHash().scan(hashkey,
                    ScanOptions.scanOptions().match(key+"*").count(1000).build());
            while (cursor.hasNext()) {
                String currentkey = (String) cursor.next().getKey();
                keys.add(currentkey);
            }
            /** 关闭scan */
            cursor.close();
            return keys;
        } catch (IOException e) {
        	LOGGER.error("查询key值错误", e);
        }
        return new ArrayList<>();
    }

    /**
     * 获取符合条件的key
     * @param pattern   表达式
     * @return
     */
    public List<String> keys(String pattern) {
        List<String> keys = new ArrayList<>();
        this.scan(pattern, item -> {
            /** 符合条件的key */
            String key = new String(item,StandardCharsets.UTF_8);
            keys.add(key);
        });
        return keys;
    }

    public List<String> getKeys(List<String> keys) {
        return stringRedisTemplate.opsForValue().multiGet(keys);
    }
    
    public String getKey(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }
    
    public List<Object> hgetKey(String hashKey, Collection<Object> keys) {
        return stringRedisTemplate.opsForHash().multiGet(hashKey, keys);
    }

    public void setKey(String key, String value) {
    	stringRedisTemplate.opsForValue().set(key, value);
    }

    public void setKey(String key, String value, long timeout, TimeUnit timeunit) {
    	stringRedisTemplate.opsForValue().set(key, value, timeout, timeunit);
    }
    
    public boolean hasKey(String key) {
    	return stringRedisTemplate.hasKey(key);
    }

    public void setKeyInMinute(String key, String value, long timeout) {
    	stringRedisTemplate.opsForValue().set(key, value, timeout, TimeUnit.MINUTES);
    }

    public void hsetKey(String hashKey, String key, String value) {
    	if (!stringRedisTemplate.opsForHash().hasKey(hashKey, key)) {
    		stringRedisTemplate.opsForHash().put(hashKey, key, value);  
    	}
    }

    public void hsetAllKey(String hashKey, Map<String, String> map) {
    	stringRedisTemplate.opsForHash().putAll(hashKey, map);
    }
    
    public void clearKey(String key) {
    	stringRedisTemplate.delete(key);
    }
}