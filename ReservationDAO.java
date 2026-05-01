package libraryseatreservationswing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ReservationDAO {
	public static void reserveSeat(int userId, int seatId, String date, String slot) {
        try {
            Connection con = DBConnection.getConnection();

            PreparedStatement check = con.prepareStatement(
                "SELECT * FROM seats WHERE seat_id=? AND status='AVAILABLE'"
            );
            check.setInt(1, seatId);
            ResultSet rs = check.executeQuery();

            if (!rs.next()) {
                System.out.println("Seat not available!");
                return;
            }

            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO reservations(user_id,seat_id,reservation_date,time_slot) VALUES(?,?,?,?)"
            );
            ps.setInt(1, userId);
            ps.setInt(2, seatId);
            ps.setDate(3, Date.valueOf(date));
            ps.setString(4, slot);
            ps.executeUpdate();

            PreparedStatement updateSeat = con.prepareStatement(
                "UPDATE seats SET status='BOOKED' WHERE seat_id=?"
            );
            updateSeat.setInt(1, seatId);
            updateSeat.executeUpdate();

            System.out.println("Seat reserved successfully!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewMyReservations(int userId) {
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT r.reservation_id, s.seat_number, r.reservation_date, r.time_slot " +
                "FROM reservations r JOIN seats s ON r.seat_id=s.seat_id WHERE r.user_id=?"
            );
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            System.out.println("\nID | Seat | Date | Slot");
            while (rs.next()) {
                System.out.println(
                    rs.getInt(1) + " | " +
                    rs.getString(2) + " | " +
                    rs.getDate(3) + " | " +
                    rs.getString(4)
                );
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void cancelReservation(int reservationId) {
        try {
            Connection con = DBConnection.getConnection();

            // Get seat id first
            PreparedStatement ps1 = con.prepareStatement(
                "SELECT seat_id FROM reservations WHERE reservation_id=?"
            );
            ps1.setInt(1, reservationId);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Reservation not found!");
                return;
            }

            int seatId = rs.getInt("seat_id");

            // Delete reservation
            PreparedStatement ps2 = con.prepareStatement(
                "DELETE FROM reservations WHERE reservation_id=?"
            );
            ps2.setInt(1, reservationId);
            ps2.executeUpdate();

            // Free the seat
            PreparedStatement ps3 = con.prepareStatement(
                "UPDATE seats SET status='AVAILABLE' WHERE seat_id=?"
            );
            ps3.setInt(1, seatId);
            ps3.executeUpdate();

            System.out.println("Reservation cancelled successfully!");
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
