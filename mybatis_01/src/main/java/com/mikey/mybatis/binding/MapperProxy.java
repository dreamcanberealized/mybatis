package com.mikey.mybatis.binding;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author mikey
 * @create 2023-07-09 3:38
 */
public class MapperProxy<T>  implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -6424540398559729838L;

    //接口名称+方法名称作为key
    private Map<String, String> sqlSession;
    private final Class<T> mapperInterface;


    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //Object 提供的 toString、hashCode 等方法是不需要代理执行的
        if(Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(proxy,args);
        } else {
            return "你被代理了 -----" + sqlSession.get(mapperInterface.getName()+"."+method.getName());
        }
    }
}
