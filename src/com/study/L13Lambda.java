package com.study;

import java.util.function.Function;

@FunctionalInterface //람다식으로 사용될 인터페이스를 명시(검사)
interface LambdaTest{
    void sum(int a,int b); //무조건 1개의 추상메서드가 있어야 람다식을 사용가능
    //void sum();
}

public class L13Lambda {
    public static void main(String[] args) {
        Function f=(a)->a;
        Runnable r=()->{};



        LambdaTest l=(a,b)->{};




        LambdaTest l2=new LambdaTest() {
            @Override
            public void sum(int a, int b) {

            }
        };
    }
}
