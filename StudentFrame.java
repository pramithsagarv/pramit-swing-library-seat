package libraryseatreservationswing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class StudentFrame extends JFrame {
	int userId;

    public StudentFrame(int userId) {
        this.userId = userId;

        setTitle("Student Panel");
        setSize(400, 300);
        setLayout(new FlowLayout());

        JButton viewSeats = new JButton("View Seats");
        JButton reserve = new JButton("Reserve");
        JButton myRes = new JButton("My Reservations");

        add(viewSeats);
        add(reserve);
        add(myRes);

        viewSeats.addActionListener(e -> new ViewSeatsFrame());

        reserve.addActionListener(e -> new ReserveFrame(userId));

        myRes.addActionListener(e -> new MyReservationsFrame(userId));

        setVisible(true);
    }

}
