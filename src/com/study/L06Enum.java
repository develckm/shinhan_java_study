package com.study;

class AirPlan{
    public void fly(){
        System.out.println("일반 비행 합니다.");
    }
    final public void land(){
        System.out.println("이륙");
    }
    final public void takeOff(){
        System.out.println("착륙");
    }
}
class SupersonicAirplan extends AirPlan{
//    final public void takeOff(){
//        System.out.println("음속착륙");
//    }

    // 상수로 flyMode 를 약속
    //interface 추상화를 목적으로 만든다. 때문에 필드를 정의할 수 없다.
    //interface에 정의한 전역변수는 모두 public static final 이 자동 완성된다.
//    interface PlanMode{
//      int NORMAL=1;
//      int SUPERSONIC=2;
//    }
    //public static final int NORMAL=1;
    //public static final int SUPERSONIC=2;
    //db enum 타입을 값을 파싱해준다.
    enum PlanMode{
        NORMAL,SUPERSONIC
    }
    private PlanMode flyMode=PlanMode.NORMAL;

    public void setFlyMode(PlanMode mode){
        this.flyMode=mode;
    }
    @Override
    public void fly() {
        if(flyMode==PlanMode.SUPERSONIC){
            System.out.println("초음속으로 비행");
        }else{
            super.fly();
        }
    }
}

public class L06Enum {
    public static void main(String[] args) {
        SupersonicAirplan a=new SupersonicAirplan();
        Object o=1; //o 참조하는 타입은 int,Integer 1->new Integer(1)


        String s=(String)o;
//        a.fly();
//        a.setFlyMode(2);
//        a.fly();
//        a.setFlyMode(SupersonicAirplan.PlanMode.NOMAL);
//        a.fly();
//        a.setFlyMode(3); //컴파일 오류가 발생하지 않는다.
//        a.fly();
        //상수를 수로 사용하면 매개변수의 값 제한이 없기 때문에 문제가 발생할 수 있다.
        a.setFlyMode(SupersonicAirplan.PlanMode.SUPERSONIC);
        a.fly();
    }
}
