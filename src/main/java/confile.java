import SQLOperation.OrderSearch;
import SQLOperation.viewGoods;

import java.sql.*;
import java.util.Scanner;

public class confile {
    private static String driverName="org.apache.hadoop.hive.jdbc.HiverDriver";
    public static void main(String[] args) throws SQLException{
       try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection con= DriverManager.getConnection("jdbc:hive://localhost:10002/default","","");
        Statement stmt=con.createStatement();

        System.out.println("连接成功！");

        viewGoods goods=new viewGoods();
        OrderSearch orderSearch=new OrderSearch();

        Scanner sc=new Scanner(System.in);

        System.out.println("登录方式：1.买家；2.卖家");
        int i=sc.nextInt();
        String pe;
        if(i==1)pe="买家";
        else pe="卖家";
        System.out.println("您以"+pe+"登录！输入用户名：");
        System.out.println("输入用户名：");
        String username=sc.next();
        System.out.println("输入密码：");
        String password=sc.next();

        //判断是否登录成功
        System.out.println("登录成功");

        if(i==1) {
            System.out.println("请选择您的服务：1.浏览书籍 2.查看订单 3.退出");
            int operation = sc.nextInt();
            if (operation == 1) {
                //显示所有书籍数据
                ResultSet books=stmt.executeQuery(goods.getAllBoods());
                while (books.next()){
                    System.out.println(books.getArray(1));
                }
            }
            else if(operation==2){
                //查看订单
               // orderSearch.order(1);
                ResultSet order=stmt.executeQuery(orderSearch.order(1));

            }
            else{
                System.out.println("成功退出");
                return;
            }
        }



        else if(i==2){
            System.out.println("请选择您的服务：1.查看所有商品 2.添加商品 3.删除商品 4.修改商品库存 5.查看所有员工 6.退出");
            int operation=sc.nextInt();
            if(operation==1){

            }
            else if(operation==2){

            }
            else if(operation==3){

            }
            else if(operation==4){

            }
            else if(operation==5){

            }
            else if(operation==6){

            }

        }

        //ResultSet resultSet=stmt.executeQuery(books.getAllBoods());




    }

}
