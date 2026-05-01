package libraryseatreservationswing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	public static int login(String username, String password, String role) {
        int userId = -1;
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT user_id FROM users WHERE username=? AND password=? AND role=?"
            );
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, role);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                userId = rs.getInt("user_id");
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userId;
    }

}
