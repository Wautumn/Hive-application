package SQLOperation;

public class UserRelated {

    String tablename="users";
    /*
    买书
     */
    public String buybooks(int id){
        String sql="";
        return sql;
    }

    /*
    登陆
     */
    public String login(String username){
        String sql="select password from "+tablename +" where name "+" = "+username;
        return sql;
    }

    /*
    查用户ID
     */
    public String findid(String username){
        String sql="select id from "+tablename +" where name "+" = "+username;
        return sql;
    }




}
