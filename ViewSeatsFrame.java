package libraryseatreservationswing;

import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ViewSeatsFrame extends JFrame {
	JTable table;

    public ViewSeatsFrame() {
        setTitle("Seats");
        setSize(500, 300);

        String[] cols = {"ID", "Seat Number", "Status"};
        DefaultTableModel model = new DefaultTableModel(cols, 0);

        try {
            Connection con = DBConnection.getConnection();
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM seats");

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("seat_id"),
                    rs.getString("seat_number"),
                    rs.getString("status")
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        table = new JTable(model);
        add(new JScrollPane(table));

        setVisible(true);
    }

}
