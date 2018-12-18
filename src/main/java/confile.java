import SQLOperation.OrderSearch;
import SQLOperation.GoodsRelated;
import SQLOperation.UserRelated;

import java.sql.*;
import java.util.Scanner;

public class confile {
    private static String driverName="org.apache.hadoop.hive.jdbc.HiverDriver";
    public static void main(String[] args) throws SQLException{
        Connection con= getConnection();
        System.out.println("终于连接成功了！");

        Statement stmt=con.createStatement();


        GoodsRelated goods=new GoodsRelated();
        OrderSearch orderSearch=new OrderSearch();
        UserRelated user = new UserRelated();

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
        ResultSet pass = stmt.executeQuery(user.login(username));
        if(password.equals(pass)){
            System.out.println("登录成功");
        }
        else{
            System.out.println("登录失败");
        }

        //该用户ID
        String account = stmt.executeQuery(user.findid(username)).toString();
        int id = Integer.parseInt(account);

        if(i==1) {
            System.out.println("请选择您的服务：1.浏览书籍 2.查看订单 3.购买书籍 4.退出");
            int operation = sc.nextInt();
            if (operation == 1) {
                //显示所有书籍数据
                ResultSet books=stmt.executeQuery(goods.getAllBoods());
                while (books.next()){
                    //System.out.println(books.getArray(1));
                }
            }
            else if(operation==2){
                //查看订单
               // orderSearch.order(1);
                ResultSet order=stmt.executeQuery(orderSearch.order(id));
                while(order.next()){

                    int orderid = order.getInt(1);
                    //int userid = order.getInt(2);
                    int bookid = order.getInt(3);
                    String bookname = stmt.executeQuery(goods.getname(bookid)).toString();
                    String bookprice = stmt.executeQuery(goods.getprice(bookid)).toString();
                    int state = order.getInt(4);
                    System.out.println(orderid+" "+bookname+" "+bookprice+" "+state +"\n");

                }

            }
            else{
                System.out.println("成功退出");
                return;
            }
        }



        else if(i==2){
            System.out.println("请选择您的服务：1.查看所有商品 2.添加商品 3.删除商品 4.修改商品库存 5.退出");
            int operation=sc.nextInt();
            if(operation==1){
                ResultSet resultSet=stmt.executeQuery(goods.getAllBoods());
            }
            else if(operation==2){
                System.out.println("请输入书籍名称");
                String name=sc.next();
                System.out.println("请输入书籍价格");
                int price=sc.nextInt();
                System.out.println("请输入书籍库存");
                int count=sc.nextInt();
                String sql=goods.addBooks(name,price,count);
                System.out.println("运行"+sql);
                stmt.execute(goods.addBooks(name,price,count));
                System.out.println("添加成功");
            }
            else if(operation==3){
                ResultSet resultSet=stmt.executeQuery(goods.getAllBoods());
                while (resultSet.next()){

                }
                System.out.println("请输入商品编号");
                int num=sc.nextInt();
                stmt.executeQuery(goods.deleteBooks(num));
                String sql=goods.deleteBooks(num);
                System.out.println("运行"+sql);
                stmt.execute(sql);
                System.out.println("删除成功");
            }
            else if(operation==4){
                ResultSet resultSet=stmt.executeQuery(goods.getAllBoods());
                while (resultSet.next()){

                }
                System.out.println("请输入商品编号");
                int num=sc.nextInt();
                System.out.println("请输入现有库存");
                int count=sc.nextInt();
                String sql=goods.deleteBooks(num);
                System.out.println("运行"+sql);
                stmt.execute(goods.updateCount(num,count));
                System.out.println("修改成功");

            }
            else if(operation==5){

            }


        }

        //ResultSet resultSet=stmt.executeQuery(books.getAllBoods());




    }

    private static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");// 加载hive2数据驱动

            con = DriverManager.getConnection(
                    "jdbc:hive2://192.168.174.131:10000/default", "root", null);// 创建数据连接

        } catch (Exception e) {
            System.out.println("hive数据库连接失败" + e.getMessage());
        }
        return con;
    }

}
