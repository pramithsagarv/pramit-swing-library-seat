package libraryseatreservationswing;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyReservationsFrame extends JFrame {
	public MyReservationsFrame(int userId) {
        setTitle("My Reservations");
        setSize(500, 300);

        String[] cols = {"ID", "Seat", "Date", "Slot"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(
                "SELECT r.reservation_id, s.seat_number, r.reservation_date, r.time_slot " +
                "FROM reservations r JOIN seats s ON r.seat_id=s.seat_id WHERE r.user_id=?"
            );
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getDate(3),
                    rs.getString(4)
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JTable table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }


}
