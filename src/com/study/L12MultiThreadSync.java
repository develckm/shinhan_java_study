package com.study;

public class L12MultiThreadSync {
    public static int count=0;//thead가 호출될때마다 1씩 증가
    public static synchronized void count(){
        count++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(()->{
            for(int i=0; i<10000; i++){
                count();
            }
        });
        Thread t2=new Thread(()->{
            for(int i=0; i<10000; i++){
                count();
            }
        });
        t.start();
        t2.start();
        t.join();
        t2.join();
        System.out.println(count);
    }
}
