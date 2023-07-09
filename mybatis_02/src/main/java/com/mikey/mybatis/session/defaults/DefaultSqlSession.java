package com.mikey.mybatis.session.defaults;

import com.mikey.mybatis.binding.MapperRegistry;
import com.mikey.mybatis.session.SqlSession;

/**
 * @author mikey
 * @create 2023-07-09 4:45
 */
public class DefaultSqlSession implements SqlSession {

    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }


    @Override
    public <T> T selectOne(String statement, Object parameter) {
        if(parameter != null) {
            return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
        }
        return (T) ("你被代理了！" + "方法：" + statement);
    }

    @Override
    public <T> T getMapper(Class<T> clazz) {
        return mapperRegistry.getMapper(clazz,this);
    }
}
