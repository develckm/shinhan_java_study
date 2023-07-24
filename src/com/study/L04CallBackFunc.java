package com.study;

import java.text.SimpleDateFormat;
import java.util.Date;

class DateApp implements Runnable{
    @Override
    public void run() {//콜백함수
        while (true){
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Date now=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
            System.out.println(sdf.format(now));
        }
    }
}
public class L04CallBackFunc {
    //Thread 를 생성할 때 사용할 콜백함수 정의

    public static void main(String[] args) throws InterruptedException {
        //Thread , awt (GUI)
        //자바 스레드 : 일의 단위(일꾼)
        //자바 : 1개의 일(main thread)을 제공
        //자바 순자적 언어 : 순서대로 코드가 실행됨
        //자바는 멀티 스레드 생성을 지원

        int a=10;
        int b=a+10;
        int c=b*b;
        //콘솔에 1초에 한번씩 시간을 출력하는 시계를 만든다.
        //10초에 한번씩 날짜를 동시에 출력하는 달력을 만든다.
        boolean start=true;
        //스레드 생성법 : 스레드로 생성할 코드를 콜백함수로
        // 구현한 Runable 타입을 Thread 생성자의 매개변수로 사용하고
        // start()를 실행하면 스레드가 생성됨
        //Thread t=new Thread(new DateApp());
        //람다식! 함수를 매개변수로 사용하는 척 해줄께!(문법적 설탕)
        Thread t=new Thread(() ->{
                while (start){
                    try {
                        Thread.sleep(10000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Date now=new Date();
                    SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
                    System.out.println(sdf.format(now));
                }
            });
        t.start();


        while (start){
            Thread.sleep(1000);//1초
            Date now=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
            System.out.println(sdf.format(now));
        }
//        while (start){
//            Thread.sleep(10000);
//            Date now=new Date();
//            SimpleDateFormat sdf=new SimpleDateFormat("yyyy년MM월dd일");
//            System.out.println(sdf.format(now));
//        }
        //System.out.println(c);//2



    }
}
