package com.study;

public class L10StringBuilder {
    public static void main(String[] args) {
        String s="안녕";
        s=new String("안녕");//권장x-> 메모리를 아끼위해
        char [] arr={'안','녕'};
        s=new String(arr);//문자 배열을 문자열 타입으로 변경
        //문자열 -> byte [] 암호화
        String s2="abcd123";
        byte[] arr2=s2.getBytes();
        for(byte b : arr2){
            System.out.println(b);
        }
        s2="가나다"; //utf-8 에서 한글은 3byte
        arr2=s2.getBytes();
        for(byte b: arr2){
            System.out.println(b);
        }
        //+연산이 많은 문자열은 String 사용하면 안된다!!??
        // "a" + "b" +"c"+"d"
        // "a"+"b"=> "ab"
        // "ab"+"c"=> "abc"
        // "abc"+"d" => "abcd"
        // 7개의 문자열 객체가 생성됨 => 메모리낭비+느림

        //StringBuilder 를 사용하는 이유
        //sb 객체 생성 (버퍼:임시저장공간)
        //"a" 문자가 만들어지고 sb "a      "
        //"b" 문자가 만들어지고 sb "ab     "
        //"c" 문자가 만들어지고 sb "abc    "
        //"d" 문자가 만들어지고 sb "abd    "
        String test="";
        long time1=System.nanoTime();
        for(int i=0; i<100000; i++){
            test+=i;
        }
        long time2=System.nanoTime();
        System.out.println(time2-time1);

        StringBuilder sb2=new StringBuilder();
        time1=System.nanoTime();
        for(int i=0; i<100000; i++){
            sb2.append(i);
        }
        time2=System.nanoTime();
        System.out.println(time2-time1);




        StringBuilder sb=new StringBuilder();
        sb.append("a");
        sb.append("b");
        sb.append("c");
        sb.append("d");
        System.out.println(sb.toString());


    }
}
