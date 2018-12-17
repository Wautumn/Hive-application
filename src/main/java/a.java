


import java.sql.Connection;
import java.sql.DriverManager;


public class a {
    private static Connection getConnection() {
        Connection con = null; // 创建用于连接数据库的Connection对象
        try {
            Class.forName("org.apache.hive.jdbc.HiveDriver");// 加载hive2数据驱动

            con = DriverManager.getConnection(
                    "jdbc:hive2://192.168.174.131:10000/default", "root", null);// 创建数据连接

        } catch (Exception e) {
            System.out.println("hive数据库连接失败" + e.getMessage());
        }
        return con; // 返回所建立的数据库连接
    }
}
