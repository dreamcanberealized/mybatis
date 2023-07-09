package com.mikey.mybatis.session;

/** 定义sql的标准
 * @author mikey
 * @create 2023-07-09 4:38
 */
public interface SqlSession {




    /**
     * 返回一条记录
     * @param statement
     * @param parameter
     * @param <T>
     * @return
     */
    <T> T selectOne(String statement, Object parameter);


    /**
     * 获取一个映射器
     * @param clazz
     * @param <T>
     * @return
     */
    <T> T getMapper(Class<T> clazz);
}
