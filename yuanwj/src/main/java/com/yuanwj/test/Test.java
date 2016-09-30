package com.yuanwj.test;

import com.yuanwj.entity.User;
import com.yuanwj.dao.IUserMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.io.Resources;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.net.www.http.HttpClient;

import javax.servlet.http.HttpUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URL;

/**
 * Created by bmk on 16-9-19.
 */
public class Test {

    public static void main(String[] args) {
        String uri="https://www.researchgate.net/profile/Baoning_Liu3/publication/307870521_The_genome_sequence_of_allopolyploid_Brassica_juncea_and_analysis_of_differential_homoeolog_gene_expression_influencing_selection/links/57d67de508ae601b39ab3cff.pdf?origin=publication_detail";
        String url="https://www.researchgate.net/search?q=The%20genome%20sequence%20of%20allopolyploid%20Brassica%20juncea%20and%20analysis%20of%20differential%20homoeolog%20gene%20expression%20influencing%20selection";
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(uri);

        try {
            HttpResponse httpResponse=httpclient.execute(httpGet);
            HttpEntity httpEntity=httpResponse.getEntity();
            String result= EntityUtils.toString(httpEntity);
            httpEntity.getContent();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        Reader reader= null;
//        try {
//            reader = Resources.getResourceAsReader("com/yuanwj/mapper/mybatis.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring-mybatis.xml");
        IUserMapper iUserMapper=(IUserMapper) applicationContext.getBean("userMapper");
//        SqlSessionFactory  sqlSessionFactory= new SqlSessionFactoryBuilder().build(reader);
//        SqlSession sqlSession=sqlSessionFactory.openSession();
//        User user=sqlSession.getMapper(IUserMapper.class).selectUserByID(1);
        User user=iUserMapper.findById(1);
        System.out.println(user.getId());
        System.out.println(user.getName());
        System.out.println(user.getPassword());
    }
}
