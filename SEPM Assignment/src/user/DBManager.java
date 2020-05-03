package user;

import java.sql.*;

public class DBManager {
    private  static  String password = "",
                            username = "root",
                             dbname = "simplejavaproject",
                                url="jdbc:mysql://localhost/"+dbname+"" +
                                    "?useUnicode=true&useJDBCCompliantTimezoneShift=true" +
                                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";


    public static Connection connection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
           con  = DriverManager.getConnection(url, username, password);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }




}
