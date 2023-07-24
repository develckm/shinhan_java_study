package com.study;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

class WindowHandler implements WindowListener{
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
        Frame f=new Frame("안녕");
        f.setBounds(0,0,200,200);
        f.addWindowListener(new WindowHandler());
        Button b=new Button("btn");
        f.add(b,BorderLayout.NORTH);
        Label l=new Label("라벨");
        f.add(l);
        b.addActionListener((e)->{
            l.setText("??");
        });


        //frame(window) 의 상단 버튼을 누를때(이벤트)
        //어떻게 동작할 건지 재정의
        f.setVisible(true);
    }
}
