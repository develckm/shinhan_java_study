package com.study;

import java.util.Date;
import java.util.Objects;

class Mouse{
    String rightBtn="기본 오른쪽 버튼";
    String leftBtn="기본 왼쪽 버튼";
    int x;
    int y;
    //오버로딩 : 객체지향에서 다형성 함수나 생성자의 이름이 같은데 매개변수의 수나 타입이 달라서 다르게 호출
    public Mouse(){}//default 생성자
    public Mouse(String rightBtn, String leftBtn){
        this.rightBtn=rightBtn;
        this.leftBtn=leftBtn;
        //생성자 : new 연산자로 객체를 생성할때 호출 (최초)
        //객체를 생성할 때 필드를 초기화 한다.
        //js constructor(문법적 설탕), 함수의 매개변수(함수==타입)
        //파이썬 __init__()
    }
    public void moveLeft(){
        --this.x;
    }
    public void moveLeft(int x){
        this.x-=x;
    }
    //필드,멤버(객체의 입장),속성(class 입장),전역변수

    //부모의 함수를 재정의 : 오버라이딩 (다형성:이름은 1개인데 역할이 많은 것)
    //자식과 부모가 같은 함수를 가질 수 있다.
    @Override
    public String toString() {
        System.out.println(super.toString());
        return "{" +
                "\"rightBtn\":\"" + rightBtn + '\"' +
                ",\"leftBtn\":" + leftBtn + '\"' +
                ",\"x\":" + x +
                ",\"y\":" + y +
                '}';
    }
    //byte b=(byte)128;


    //m.equals(m2)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || this.getClass() != o.getClass()) return false;
        //NullPointException, ClassCastException
        Mouse mouse = (Mouse) o; //Cast 형변환
        return rightBtn.equals(mouse.rightBtn) && leftBtn.equals(mouse.leftBtn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rightBtn, leftBtn);
    }
}


public class L02Class {
    public static void main(String[] args) {
        //class : 객체(현실세계의 무언가)를 추상화 한것 (설계도)
        //객체 : 필드들과 함수로 이루어져있더라??

        //객체지향 문법에서 class -> 자료형 데이터의 타입


        //데이터 : 컴퓨터에서 사용하는 자원 (기본형,자료형)
        //자료형 데이터 : 원시적이지 않은 것은 모두 자료형, 참조하는 데이터가 존재하는
        //원시적 : 기본형은 원시적이다 (그 데이터를 찾으면 그 데이터만 존재)

        Mouse m=new Mouse();//객체 설명서 :  Object.toString()
        System.out.println(m);
        Mouse m2=new Mouse();
        System.out.println(m2);
        //자료형 타입을 사용할때 두 자료가 같은지 비교하고 싶은 때 Object.equals(Oject param);
        //두 객체의 필드값들이 같은지 비교했을 때 같으면 true 를 반환(구현 권장)
        System.out.println(m==m2); //기본형이 같은 값인지 비교할 때만 사용
        System.out.println(m.equals(m2));

        Mouse m3=new Mouse("다이아몬드 버튼","골드 버튼");
        System.out.println(m.equals(m3));

        //패키지
        //1.배포시 중복을 막기 위해
        //2.유사한 목적의 class 집합
        //3.class 이름을 유일하게
        Date now=new Date(); //현재 날짜 시간
        java.sql.Date dbNow=new java.sql.Date(now.getTime());
    }
}
