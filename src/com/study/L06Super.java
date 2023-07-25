package com.study;

public class L06Super {
    int a;
    int b;
    //public L06Super(){}
    public L06Super(int a, int b) {
        //생성자를 이용해서 필드를 초기화를 강제하는 이유
        //이 객체가 해당 필드 초기화 없이는 동작할 수 없다.
        this.a = a;
        this.b = b;
    }
    public int sum(){
        return a+b;
    }
}
//부모 클래스가 default 가 없다면 자식은 생성자 구현을 강제한다.(컴파일 오류)
//->부모의 생성자 규칙을 자식은 따라야한다->
// 부모 필드를 사용하기 위해서는 부모의 필드를 초기화 해야하기 때문
class Child extends L06Super{
    public Child(int a, int b) {
        super(a, b);
    }
    //@ -> 어노테이션 : 컴파일시 컴파일러가 (검사,자동완성)
    //검사 : Override,FunctionalInterface,@Nullable ....
    //자동완성 : WebServlet, Entitty,Id,Inject,AutoWired(DI),Getter

    @Override
    public int sum(){
        System.out.println(this.a+super.b);
        return super.sum();
    }
}


