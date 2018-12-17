package SQLOperation;
/*
查看商品
 */
public class viewGoods {
    String tablename="goods";
    /*
    所有书
     */
    public String getAllBoods(){
        String sql="select * from "+tablename;
        return sql;
    }
    /*
    总数量
     */
    public String getCount(){
        String sql="select count(1) from "+tablename;
        return sql;
    }
    /*
    某一类的书籍
     */
    public String getTypeBoods(String type){
        String sql="select * from "+tablename +" where type "+" = "+type;
        return sql;
    }

}
