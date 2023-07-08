package com.mikey.mybatis.test;

import com.mikey.mybatis.binding.MapperProxyFactory;
import com.mikey.mybatis.test.dao.UserDao;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author mikey
 * @create 2023-07-09 3:49
 */
public class test {


    @Test
    public void test(){
        Map<String,String> sql = new HashMap<>();
        MapperProxyFactory<UserDao> tMapperProxyFactory = new MapperProxyFactory<>(UserDao.class);
        sql.put("com.mikey.mybatis.test.dao.UserDao.queryUserName","执行的操作");
        UserDao userDao = tMapperProxyFactory.newInterFace(sql);
        String s = userDao.queryUserName("1");
        System.out.println(s);

    }
}
