package com.example.data_base.redis.dao;

import java.util.Map;

/**
 * 类描述：
 *
 * @author fengna
 * @since 2021/8/13 16:13
 */
public interface SimpleDao {

    void setValue(String key, Map<String, Object> value);

    void setValue(String key, String value);

    void setValue(String key, Object value);

    Object getMapValue(String key);

    Object getValue(String key);

}
