package libraryseatreservationswing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class SeatDAO {
	public static void addSeat(String seatNumber) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO seats(seat_number,status) VALUES(?,?)"
            );
            ps.setString(1, seatNumber);
            ps.setString(2, "AVAILABLE");
            ps.executeUpdate();
            System.out.println("Seat added successfully!");
            con.close();
        } catch (Exception e) {
            System.out.println("Seat already exists!");
        }
    }

    public static void viewSeats() {
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM seats");

            System.out.println("\nSeat ID | Seat Number | Status");
            while (rs.next()) {
                System.out.println(
                    rs.getInt("seat_id") + " | " +
                    rs.getString("seat_number") + " | " +
                    rs.getString("status")
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteSeat(int seatId) {
        try {
            Connection con = DBConnection.getConnection();

            // Step 1: Delete reservations for this seat
            PreparedStatement ps1 = con.prepareStatement(
                "DELETE FROM reservations WHERE seat_id=?"
            );
            ps1.setInt(1, seatId);
            ps1.executeUpdate();

            // Step 2: Delete the seat
            PreparedStatement ps2 = con.prepareStatement(
                "DELETE FROM seats WHERE seat_id=?"
            );
            ps2.setInt(1, seatId);
            int rows = ps2.executeUpdate();

            if (rows > 0) {
                System.out.println("Seat removed successfully!");
            } else {
                System.out.println("Seat not found!");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
