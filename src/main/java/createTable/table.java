package createTable;

public class table {
    public String createtable(String tablename){
        String sql="";
        sql="create table "+tablename+" (key int, value string)";
        return sql;
    }
}
