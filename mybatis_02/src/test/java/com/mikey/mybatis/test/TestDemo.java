package com.mikey.mybatis.test;


import com.mikey.mybatis.binding.MapperRegistry;
import com.mikey.mybatis.session.SqlSession;
import com.mikey.mybatis.session.SqlSessionFactory;
import com.mikey.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.mikey.mybatis.test.dao.UserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author mikey
 * @create 2023-07-09 3:49
 */
public class TestDemo {

    private Logger logger = LoggerFactory.getLogger(TestDemo.class);

    @Test
    public void test(){
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.mikey.mybatis.test.dao");

        // 2. 从 SqlSession工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");

        logger.info("执行结果:{}",res);
    }


}
