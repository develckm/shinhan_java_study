package com.study;

public class L14StreamApi {
    public static void main(String[] args) {
        //Stream : Input Output 에서의 데이터 입출력의 흐름
        //StreamApi : 내부반복문으로 만들어진 새로운 자료구조(list 와 유사)와 내부반복문의 종류
        //Java 가 대부부의 자료를 (Array,Collection ...)을 Stream 으 변경되도록 지원
        //-> java 에서 사용되는 모든 자료를 동일한 형식(StreamAPI)로 처리되고 유지 보수되기를 기대
        // 기존의 for while 등로 생성한 반복문이 유지 보수에 분리해서 StreamAPI로 대체 대기를 기대
        // 단점 !
        // 외부 반복문은 한번의 반복문에 조건으로 여러처리를 할 수 있는데
        // streamAPI 는 반복문을 여러번 실행한다. -> 속도가 느리다.
        // (*StreamAPI Lazy 연산 으로 반복문을 여러번 실행하는 것을 줄이려고 노력중이다.)
    }
}
