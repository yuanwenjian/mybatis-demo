//package com.yuanwj.test;
//
//import com.yuanwj.entity.User;
//import com.yuanwj.dao.IUserMapper;
//import org.apache.ibatis.io.Resources;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.io.IOException;
//import java.io.Reader;
//
///**
// * Created by bmk on 16-9-19.
// */
//public class Test {
//
//    public static void main(String[] args) {
//        Reader reader= null;
//        try {
//            reader = Resources.getResourceAsReader("com/yuanwj/mapper/mybatis.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-mybatis.xml");
//        IUserMapper iUserMapper=(IUserMapper) applicationContext.getBean("userMapper");
////        SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
////        SqlSession sqlSession=sqlSessionFactory.openSession();
////        User user=sqlSession.getMapper(IUserMapper.class).selectUserByID(1);
//        User user=iUserMapper.selectUserByID(1);
//        System.out.println(user.getId());
//        System.out.println(user.getName());
//        System.out.println(user.getPassword());
//    }
//}
