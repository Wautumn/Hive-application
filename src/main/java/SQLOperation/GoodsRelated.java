package SQLOperation;
/*
商品相关：查看商品，删除商品，添加商品
 */
public class GoodsRelated {
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

    /*
    删除
     */
    public String deleteBooks(int id){
        String sql="delete (?,?, ) from " +tablename;
        //
        return sql;
    }

    /*
    添加书
     */
    public String addBooks(){
        String sql="insert int "+tablename+" values(?,?,?)";
        //
        return sql;
    }

}