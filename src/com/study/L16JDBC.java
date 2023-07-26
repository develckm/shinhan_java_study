package com.study;
//import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class L16JDBC {
    public static void main(String[] args) {
        String user="boardServerDev";
        String password="mysql123";
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/webAppBoard";
        //DriverManager 는 mysql 드라이버를 동적로딩으로 객체로 생성 및 사용
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        //DB 통신 조회하고 close 하는 방식으로 사용하지 않는다.
        //jdbc 로 db를 접속하는 행위가 자원을 많이 소모한다.
        //보통 DB 는 connection Pool 기술을 지원하고 사용하는 편
        try {
            Class.forName(driver);
            conn= DriverManager.getConnection(url,user,password);
            String sql="SELECT * FROM BOARD_LIKES WHERE b_id=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,10);
            rs=pstmt.executeQuery();
            System.out.println("bl_id\t|\tb_id\t|\tu_id\t|\tstatus");
            while (rs.next()){//next table 튜플을 탐색
                int blId=rs.getInt("bl_id");
                int bId=rs.getInt("b_id");
                String uId=rs.getString("u_id");
                String status=rs.getString("status");
                System.out.println(blId+"\t|\t"+bId+"\t|\t"+uId+"\t|\t"+status);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
