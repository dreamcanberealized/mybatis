package com.mikey.mybatis.session;

/**
 * @author mikey
 * @create 2023-07-09 5:17
 */
public interface SqlSessionFactory {

    SqlSession openSession();
}
