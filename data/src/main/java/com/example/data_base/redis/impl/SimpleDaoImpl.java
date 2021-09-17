package com.example.data_base.redis.impl;

import com.example.data_base.redis.dao.SimpleDao;

import java.util.Map;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/8/13 16:17
 */
public class SimpleDaoImpl implements SimpleDao {

//    private RedisTemplate

    @Override
    public void setValue(String key, Map<String, Object> value) {

    }

    @Override
    public void setValue(String key, String value) {

    }

    @Override
    public void setValue(String key, Object value) {

    }

    @Override
    public Object getMapValue(String key) {
        return null;
    }

    @Override
    public Object getValue(String key) {
        return null;
    }
}
