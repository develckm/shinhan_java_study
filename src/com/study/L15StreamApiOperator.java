package com.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class L15StreamApiOperator {
    public static void main(String[] args) {
        Stream stream=Stream.of("1","2","3");
        String [] arr={"1","2","3"};
        stream= Arrays.stream(arr);
        List list=new ArrayList();
        list.add("1");
        list.add("2");
        list.add("삼");
        list.add("3");
        list.add("3");
        list.add("2");
        list.add("1");
        list.add("오");
        list.add("4");

        stream=list.stream();
        //** 대부분의 통신은 그데이터를 문자열로
        //문자열로 받은 데이터는 정수로 취급되어야하고 최종적으로 모두를 더한 결과를 반환
        //중간 연산자와 최종연산자
        //중간연산자 : stream 자료를 반환해서 chaining으로 stream 연산을 더 진행가능
        //최종연산자 : stream 이 아닌 것은 반환하거나 아무것도 반환하지 않아서 chaining이 불가능

        //filter(Predicate) : 중간 연산자 해당 요소를 검사해서 true 인것만 stream 으로 반환
        //distinct() : 중복 자료를 삭제 (equlas()가 구현되어 있으면 자료형도 삭제)
        //map(Function) : 스트림의 존재하는 data를 다른 자료형으로 변환
        //mapToX(Function) : 스트림의 존재하는 data를 자료형일때 기본형으로 변환
        //reduce(BinaryOperator(i1,i2)->i1+i2)
        //sum(),max(),min() : 스트림의 값이 기본형일때 (기본형 스트림) 최종연산 진행
            //sum(),
            int sum=stream
                .filter((i)->{
                    return i.toString().chars().allMatch((c)->Character.isDigit(c));
                })
                    .mapToInt((i)->Integer.parseInt(i.toString()))
                    .distinct()
                    .sum();
        System.out.println(sum);

    }
}
