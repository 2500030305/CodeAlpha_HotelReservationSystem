import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Room {
    int roomNumber;
    String category;
    boolean booked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.booked = false;
    }
}

public class HotelReservationSystem extends JFrame implements ActionListener {

    JTextArea area;
    JTextField roomField;

    JButton viewButton, bookButton, cancelButton;

    ArrayList<Room> rooms = new ArrayList<>();

    HotelReservationSystem() {

        setTitle("Hotel Reservation System");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Deluxe"));
        rooms.add(new Room(103, "Suite"));

        JLabel label = new JLabel("Enter Room Number:");
        roomField = new JTextField(10);

        viewButton = new JButton("View Rooms");
        bookButton = new JButton("Book Room");
        cancelButton = new JButton("Cancel Booking");

        area = new JTextArea(20, 45);
        area.setEditable(false);

        add(label);
        add(roomField);
        add(viewButton);
        add(bookButton);
        add(cancelButton);
        add(new JScrollPane(area));

        viewButton.addActionListener(this);
        bookButton.addActionListener(this);
        cancelButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == viewButton) {

            area.setText("===== ROOM DETAILS =====\n\n");

            for (Room r : rooms) {

                String status = r.booked ? "Booked" : "Available";

                area.append(
                        "Room: " + r.roomNumber +
                        " | " + r.category +
                        " | " + status + "\n");
            }
        }

        if (e.getSource() == bookButton) {

            int roomNo = Integer.parseInt(roomField.getText());

            for (Room r : rooms) {

                if (r.roomNumber == roomNo) {

                    if (!r.booked) {

                        r.booked = true;

                        area.append(
                                "\nRoom " + roomNo +
                                " booked successfully.\n");

                    } else {

                        area.append("\nRoom already booked.\n");
                    }
                }
            }
        }

        if (e.getSource() == cancelButton) {

            int roomNo = Integer.parseInt(roomField.getText());

            for (Room r : rooms) {

                if (r.roomNumber == roomNo) {

                    if (r.booked) {

                        r.booked = false;

                        area.append(
                                "\nBooking cancelled for room "
                                + roomNo + "\n");

                    } else {

                        area.append("\nRoom is not booked.\n");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new HotelReservationSystem();
    }
}
