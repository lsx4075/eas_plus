package com.jxd.eas.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName SqlSessionUtil
 * @Description TODO
 * @Author 刘双喜
 * @Date 2026/9/1 18:27
 * @Version 1.0
 */
public class SqlSessionUtil {
    public static SqlSession getSession() {
        //SqlSession对象是mybatis提供的会话对象
        //代表mybatis和数据库之间的会话，相当于以前的Connection对象
        SqlSession sqlSession = null;
        //加载主配置文件
        try {
            InputStream in = Resources.getResourceAsStream("config.xml");
            //根据连接信息创建会话工厂对象
            SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(in);
            //根据工厂对象得到会话对象
            sqlSession = sf.openSession(true);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;
    }
}
