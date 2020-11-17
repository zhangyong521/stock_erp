package com.zy.cache;

import com.alibaba.fastjson.JSON;


/**
 * @Author: 张勇
 * @Blog: https://blog.csdn.net/zy13765287861
 * @Version: 1.0
 * @Date: 2020-11-17 16:20
 * @PS:
 */
public class CacheBean {
    private String key;

    private Object value;

    public CacheBean() {
    }

    public CacheBean(String key, Object value) {
        super();
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return JSON.toJSON(value).toString();
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
