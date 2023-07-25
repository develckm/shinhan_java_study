package com.study;
abstract class A{
    int a=10;
    abstract public int sum();
}
//클래스에서 추상메서드를 작성할 수 없는 것을 구현을 강제하는 것이다.
//클래스는 객체가 되어야하기 때문에 {구현체}바디가 없는 것은 존재할 수 없다.

class Aable extends A{
    @Override
    public int sum() {
        return this.a;
    }
}

class B extends Aable{
    int b=20;
}
class C extends B{ //C의 조상들 C>B>A>Object
    int c=30;

    @Override
    public String toString() {
        return "C{" +
                "c=" + c +
                ", b=" + b +
                ", a=" + a +
                '}';
    }
}
public class L03Casting {
    class D{} //L03Casting$D : 내부클래스
    public static void main(String[] args) {
        Object o=new C(); //자료형 데이터는 부모의 타입의 변수로 참조될 수 있다.
        //자료형을 부모의 타입으로 참조하는 이유 : 변수가 많은 변수를 참조해서 편하게 코딩하려고!!
        System.out.println(o);
        System.out.println(o instanceof A);

        C c=(C)o;
        System.out.println(c.c);
        //A a=new A(); //추상클래스는 객체가 될 수 없다.
        //구현되지 않은 추상메서드를 구현해야하기 때문에
        A aable=new Aable();
        A a=new A(){
            @Override
            public int sum() {
                return 0;
            }
        };//{} => 바디 (구현체)
        //익명클래스(내부클래스로 숫자 이름을 갖는다. L03Casting$1)
        //추상클래스를 상속 구현하는 익명클래스를 만들고
        //그 클래스가 객체가 된다.



    }
}
