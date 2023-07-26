package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.*;

@FunctionalInterface //람다식으로 사용될 인터페이스를 명시(검사)
interface LambdaTest{
    void sum(int a,int b); //무조건 1개의 추상메서드가 있어야 람다식을 사용가능
    //void sum();
}

public class L13Lambda {
    public static void main(String[] args) {
        Function<Integer,Long> f=(a)->{return (long)a;};
        f=new Function<Integer, Long>() {
            @Override
            public Long apply(Integer a) {
                return (long)a;
            }
        };
        List<String> list= Arrays.asList("안녕","신한","신입사원");
        for (int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
        Consumer<String> c=(s)->{
            System.out.println(s);
        };
        //컴파일러가 추측할 수 있는 정도로 줄인다. -> 메서드 참조
        c=System.out::println;
        list.forEach(c);

        //const arr={"aa","bb","cc"};


        //배열의 삽입 삭제에 대해 아는 만큼 서술(Array,List,Linked)
        //내부 반복문의 장점에 대해 서술(콜백함수,배열탐색,Iterator)

        //내부 반복문 => Iterator 에 의해서 내부의 아이템들을 순회할때 마다
        //          정의해 놓은 콜백함수를 실행하는 것

        //외부 반복문 => for 나 while로 내부에 구현한 코드를 반복실행



        //Thread
        Runnable r=()->{};
        Supplier<Integer> supplier=()->10;
        //**제네릭 자료형만 지정가능 (기본형 x)
        //기본형을 매개변수나 리턴타입으로 사용하는 람다식 타입을 제공
        IntSupplier intSupplier=()->20;

        BinaryOperator<Integer> sum=(i,i2)->i+i2;
        UnaryOperator<Integer> unaryOperator =(i)->i*i;
        IntPredicate predicate=(i)->i>0;
        BiPredicate biPredicate=(o,o2)->o.equals(o2);
        biPredicate= Objects::equals;




        LambdaTest l=(a,b)->{};




        LambdaTest l2=new LambdaTest() {
            @Override
            public void sum(int a, int b) {

            }
        };
    }
}
