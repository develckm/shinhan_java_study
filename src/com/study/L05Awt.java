package com.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;

class WindowHandler implements WindowListener{
    //WindowHandler.e 정적멤버,클래스멤버 (메소드 영역, 정적 메모리)
    //WindowHandler 가 객체든 객체가 아니든 e는 jvm이 처음 시작한때 data로 생성됨
    //static 으로 선언된 함수에서 바로 사용 (main)
    //목적
    //1.메모리 절약 (객체(new->힙(GC)) 즉 인스턴스를 매번 만들필요가 없다.)
    //  싱글톤 패턴으로 구현 : 공유하려는 객체를 안전하게 공유하려고
    //2.다른 객체들 간의 공유 및 수정 (정적멤버의 단점)
    //3.다른 객체들 간의 공유 (정보) -> 상수

    private static Connection e=null; //필드(해당 객체의 멤버)가 아니다!
    public static Connection getInstance() throws SQLException {
        System.out.println(Math.PI);


        if(!(e!=null && !e.isClosed()) ){
            e= DriverManager.getConnection("");
        }
        return e;
    }


    public int a;
    int b;//default
    protected int c;
    private int d; //은닉
    //PlainOldJavaObject BEAN DataTransferObject VariableObject
    //DTO : db와 서버가 통신도중 주고 받는 데이터를 파싱할 때
    //*DTO -> 라이브러리 JACKSON or 프레임워크가 JPA(Entity) 사용
    //*프록시 객체 : 대리자 A class -> A_proxy A+구현
    //VO : 프로그램에서 객체정보를 다룰때 유효성검사 or 비교연산등을 하기 위해
    public int getD() {
        return d;
    }
    public void setD(int d) {
        this.d = d;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WindowHandler that = (WindowHandler) o;
        return a == that.a && b == that.b && c == that.c && d == that.d;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, d);
    }

    @Override
    public void windowOpened(WindowEvent e) {}//열리면
    //x버튼을 누르면
    @Override
    public void windowClosing(WindowEvent e) {
        //e: 이벤트정보 (마우스의 위치,마우스의 어떤버튼으로 눌렀는지, 어떤 윈도우를 눌렀는지)
        Window w=e.getWindow();
        w.dispose();
    }
    //윈도우가 종료되면
    @Override
    public void windowClosed(WindowEvent e) {
        System.exit(0);
    }
    //최소화버튼으로 아이콘이 되면
    @Override
    public void windowIconified(WindowEvent e) {}
    //아이콘에 창으로 변하면
    @Override
    public void windowDeiconified(WindowEvent e) {}
    //마우스로 윈도우를 누르고 움직이면
    @Override
    public void windowActivated(WindowEvent e) {}
    //마우스를 놓으면
    @Override
    public void windowDeactivated(WindowEvent e) {}
}
public class L05Awt {
    public static void main(String[] args) {
        //기본형은 필드가 존재하나요??
        //원시데이터 타입이기 때문에 필드가 존재하지 않습니다.
        //-> 그 값 자체인 것을 의미
        JFrame jf=new JFrame("??");
        jf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//windowListner 종료만 정의

        Frame f=new Frame("안녕");
        f.setBounds(0,0,200,200);
        f.addWindowListener(new WindowHandler());
        Button b=new Button("btn");
        f.add(b,BorderLayout.NORTH);
        Label l=new Label("라벨");
        f.add(l);
        b.addActionListener((e)->{
            //l=null;
            l.setText("hello");
        });


        //frame(window) 의 상단 버튼을 누를때(이벤트)
        //어떻게 동작할 건지 재정의
        f.setVisible(true);
    }
}
