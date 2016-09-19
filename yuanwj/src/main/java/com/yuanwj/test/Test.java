package com.yuanwj.test;

import com.yuanwj.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.Reader;

/**
 * Created by bmk on 16-9-19.
 */
public class Test {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;
    static {
        try {
            reader=Resources.getResourceAsReader("mapper/configuaration.xml");
            sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("com.yuanwj.mapper.UserMapper.selectUserByID",1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}
