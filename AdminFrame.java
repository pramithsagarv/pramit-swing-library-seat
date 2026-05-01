package libraryseatreservationswing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AdminFrame extends JFrame {
	JTextField seatField;

    public AdminFrame() {
        setTitle("Admin Panel");
        setSize(400, 300);
        setLayout(new FlowLayout());

        seatField = new JTextField(10);
        JButton addBtn = new JButton("Add Seat");
        JButton viewBtn = new JButton("View Seats");
        JButton deleteBtn = new JButton("Delete Seat");

        add(seatField);
        add(addBtn);
        add(viewBtn);
        add(deleteBtn);

        addBtn.addActionListener(e -> {
            SeatDAO.addSeat(seatField.getText());
            JOptionPane.showMessageDialog(this, "Seat Added");
        });

        viewBtn.addActionListener(e -> new ViewSeatsFrame());

        deleteBtn.addActionListener(e -> {
            int id = Integer.parseInt(seatField.getText());
            SeatDAO.deleteSeat(id);
            JOptionPane.showMessageDialog(this, "Seat Deleted");
        });

        setVisible(true);
    }

}
