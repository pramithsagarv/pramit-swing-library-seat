package libraryseatreservationswing;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ReserveFrame extends JFrame {
	 public ReserveFrame(int userId) {
	        setTitle("Reserve Seat");
	        setSize(300, 250);
	        setLayout(new GridLayout(5, 2));

	        JTextField seatId = new JTextField();
	        JTextField date = new JTextField();
	        JTextField slot = new JTextField();

	        add(new JLabel("Seat ID:"));
	        add(seatId);
	        add(new JLabel("Date (YYYY-MM-DD):"));
	        add(date);
	        add(new JLabel("Slot:"));
	        add(slot);

	        JButton reserveBtn = new JButton("Reserve");
	        add(reserveBtn);

	        reserveBtn.addActionListener(e -> {
	            ReservationDAO.reserveSeat(
	                userId,
	                Integer.parseInt(seatId.getText()),
	                date.getText(),
	                slot.getText()
	            );
	            JOptionPane.showMessageDialog(this, "Reserved!");
	        });

	        setVisible(true);
	    }

}
