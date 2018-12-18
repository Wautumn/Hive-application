package SQLOperation;

public class OrderSearch {

    String tablename="orders";
    /*
    查找某个人的订单
     */
    public String order(int userid){

        String sql="select * from "+tablename +" where userid "+" = "+userid;
        return sql;
    }


}
