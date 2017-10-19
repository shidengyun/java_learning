package com.example.controller;


import com.example.model.Doublechecklocking;
import com.example.model.EnumSingleton;
import com.example.model.Student;
import com.example.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class ServiceController {
    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String say(){
        //数组容器
        List<Integer> list = new ArrayList<Integer>();
        Date dateBegin=new Date();
        Random random=new Random();
        //随机数
        Integer item=random.nextInt(10000);
        //变量填充
        for(int i=0;i<1000;i++) {
            while(true) {
                if(!list.contains(item)) {
                    list.add(item);
                    break;
                }else {
                    item=random.nextInt(10000);
                }
            }
        }
        //排序
        Collections.sort(list);
        Date dateEnd=new Date();
        //运行时间
       // System.out.println("运行毫秒数: "+ (dateEnd.getTime()- dateBegin.getTime()));
        //运行值
       // System.out.println(list.toString());

        return "运行毫秒数: "+ (dateEnd.getTime()- dateBegin.getTime())+list.toString();
    }
    @RequestMapping(value = "/Lombok",method = RequestMethod.GET)
    public String Lombok(){

        User user=new User();
        user.setName("dyshi");
        user.setAge(20);

        return user.getName()+"  "+user.getAge();
    }
    @RequestMapping(value = "/EnumSingletonTest",method = RequestMethod.GET)
    public String EnumSingletonTest(){
      return   EnumSingleton.instance.toString();
    }

    @RequestMapping(value = "/DoublechecklockingTest",method = RequestMethod.GET)
    public String DoublechecklockingTest(){
        return   Doublechecklocking.getInstance().toString();
    }

    @RequestMapping(value = "/BuilderTest",method = RequestMethod.GET)
    public String BuilderTest(){
        Student stu = new Student.Builder("icecode", 22, 178, 1)
                .SchoolName("BUPT").Profession("Computer Science and Technology").GradeNo(20091012).build();
       return  stu.toString();
    }


}



