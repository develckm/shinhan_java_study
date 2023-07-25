package com.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class OuterClass {
    class InnerClass {
        int a;
        int b;

    }
    int innerSum(){
        InnerClass innerClass =new InnerClass();
        return innerClass.a+ innerClass.b;
    }
}

//카드 맞추기 게임 JFrame (4btn)
class CardGame extends JFrame {
    JButton btn1; //앞면 -> 뒷면
    JButton exitBtn; //종료 버튼
    JLabel label; //시작 종료 표시
    private class BtnHandler implements ActionListener{
        //내부 클래스는 외부클래스의 필드를 접근할 수있다.
        JButton btn1;
        @Override
        public void actionPerformed(ActionEvent e) {
            //내부 클래스와 외부클래스의 이름이 같을때는 외부클래스.this.
            CardGame.this.btn1.setText("뒷면");
        }
    }
    public CardGame(String title) throws HeadlessException {
        super(title);
        this.setBounds(0,0,400,400);
        btn1=new JButton("앞면");
        btn1.addActionListener(new BtnHandler());
        exitBtn=new JButton("종료");
        label=new JLabel("시작");
        //익명 구현 객체 (익명클래스로 구현한 객체)
        //익명클래스는 컴파일러가 자동완성 해준다. (내부클래스로 1~)
        //가독성이 좋다. -> 재사용성 포기
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("종료");
            }
        });
        this.add(btn1,BorderLayout.NORTH);
        this.add(exitBtn,BorderLayout.SOUTH);
        this.add(label,BorderLayout.CENTER);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
public class L08InnerClass {
    //중첩 클래스
    public static void main(String[] args) {
        new CardGame("카드게임");

        OuterClass outerClass =new OuterClass();
        OuterClass.InnerClass innerClass = outerClass.new InnerClass();
        //중첩클래스는 독자적으로 객체가 될 수 없다.
        //new OuterCalss.InnerCalss();
        System.out.println(outerClass.innerSum());
    }
}
