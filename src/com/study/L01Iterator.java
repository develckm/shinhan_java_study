package com.study;

import java.util.ArrayList;
import java.util.List;

public class L01Iterator {
    public static void main(String[] args) {
        WindowHandler w=new WindowHandler();
        List list=new ArrayList(); //  {10,20 ,30, 10.3 }
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(100.3);
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        //list.hasNext() 가 true 이면 list.next() 로 값을 가져와서 i가 참조
        for (Object i : list){
            System.out.println(i);
        }
        for (Object i : list){
            System.out.println(i);
        }

        Object []arr={10,20,30,10.3};
        for( Object i: arr){
            System.out.println(i);
        }


    }
}
