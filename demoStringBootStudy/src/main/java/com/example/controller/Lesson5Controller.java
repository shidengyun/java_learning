package com.example.controller;

import com.example.CommonHelper.StringHelpper;
import com.example.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Lesson5Controller {

    @RequestMapping(value = "/getUser",method = RequestMethod.GET)
    public String getUser(int id) {
        try {
            String resource = "mybatis-config.xml";

            Reader reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sessionFactory.openSession();

            String statement = "com.example.mapping.userMapper.getUser";
            User user = session.selectOne(statement, id);

            session.commit();

            return user.getName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping(value = "/batchInsert",method = RequestMethod.GET)
    public int batchInsert() {
        try {

            List<User> users =  new ArrayList<User>();
            Random random=new Random();
            for(int i=0;i<3;i++) {

                User user=new User();

                user.setName(StringHelpper.getRandomString(5));
                user.setAge(10);
                user.setId(random.nextInt(1000000));

                users.add(user);
            }

            String resource = "mybatis-config.xml";

            Reader reader = Resources.getResourceAsReader(resource);

            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SqlSession session = sessionFactory.openSession(ExecutorType.BATCH);

            String statement = "com.example.mapping.userMapper.batchInsert";
            int result = session.insert(statement, users);

            session.commit();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }
}
