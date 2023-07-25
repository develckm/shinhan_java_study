package com.study;

import java.util.StringTokenizer;

public class L11StringTokenizer {
    public static void main(String[] args) {
        String s="최경민,홍길동,김길동,김자미";
        String [] arr=s.split(","); //regex
        for(String name:arr){
            System.out.println(name);
        }
        StringTokenizer st=new StringTokenizer(s,",");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }

    }
}
