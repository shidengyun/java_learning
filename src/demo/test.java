package demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class test {

	public static void main(String[] args){
		
		//��������
		List<Integer> list = new ArrayList<Integer>();
		Date dateBegin=new Date();
		Random random=new Random();
		//�����
		Integer item=random.nextInt(100000);
		
		//�������
		for(int i=0;i<1000;i++) {
			while(true) {
				
				if(!list.contains(item)) {
					list.add(item);	
					break;
				}else {
					 item=random.nextInt(100000);
				}
			}
		}
		Date dateEnd=new Date();

		//����
		Collections.sort(list);
		
		//����ʱ��
		System.out.println("���к�����: "+ (dateEnd.getTime()- dateBegin.getTime()));
		
		//����ֵ
		System.out.println(list.toString());
	}

}
