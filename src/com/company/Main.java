package com.company;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Main{
    public static void main(String[] args){
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
        System.out.println("运行毫秒数: "+ (dateEnd.getTime()- dateBegin.getTime()));
        //运行值
        System.out.println(list.toString());
    }
}




