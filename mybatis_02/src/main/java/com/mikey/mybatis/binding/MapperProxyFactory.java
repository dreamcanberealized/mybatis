package com.mikey.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 代理工厂
 * @author mikey
 * @create 2023-07-09 3:32
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInterFace(Map<String,String> sqlSession) {
        MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),new Class[]{mapperInterface},mapperProxy);
    }
}
