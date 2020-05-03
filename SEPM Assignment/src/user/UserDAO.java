package user;

import java.sql.*;

public class UserDAO {
	
    public static boolean userExists(String username) 
    {
        String sql = "select * from users where username= ?";
        Connection con = DBManager.connection();
        try 
        {
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, username);
            ResultSet rs = st.executeQuery();
            if(rs.next()) 
            {
                return true;
            }
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        
        return false;
    }

    public static  User login(String username, String password) 
    {
        if (userExists(username)) 
        {
            String sql = "select * from users where username= ?";
            Connection con = DBManager.connection();
            try 
            {
                PreparedStatement st = con.prepareCall(sql);
                st.setString(1, username);
                ResultSet rs = st.executeQuery();
                
                if(rs.next()) 
                {
                   if (password.equals(rs.getString("password")))
                   {
                       User u = new User();
                       u.setFirstName(rs.getString("firstname"));
                       u.setLastName(rs.getString("lastname"));
                       u.setUsername(rs.getString("username"));
                       u.setRole(rs.getString("role"));
                       return u;
                   }
                   
                   else 
                   {
                       System.out.println("Incorrect password");
                   }
                }
            } 
            
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
        
        else 
        {
            System.out.println("Unregistered username. Please register first.");
        }
        
        return null;
    }

    public static  void register(User u) 
    {
        String sql = "insert into users (firstname, lastname, username, role, password) values(?,?,?,?,?)";
        Connection con = DBManager.connection();
        try 
        {
            PreparedStatement st = con.prepareCall(sql);
            st.setString(1, u.getFirstName());
            st.setString(2, u.getLastName());
            st.setString(3, u.getUsername());
            st.setString(4, u.getRole());
            st.setString(5, u.getPassword());
            st.executeUpdate();
        } 
        
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}
