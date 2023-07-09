package com.mikey.mybatis.session.defaults;

import com.mikey.mybatis.binding.MapperRegistry;
import com.mikey.mybatis.session.SqlSession;
import com.mikey.mybatis.session.SqlSessionFactory;

/**
 * @author mikey
 * @create 2023-07-09 5:18
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {

    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
