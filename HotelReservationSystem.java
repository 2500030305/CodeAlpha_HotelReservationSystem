import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isBooked;

    Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isBooked = false;
    }
}

public class HotelReservationSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> rooms = new ArrayList<>();

        rooms.add(new Room(1, "Standard"));
        rooms.add(new Room(2, "Deluxe"));
        rooms.add(new Room(3, "Suite"));

        int choice;

        do {
            System.out.println("\n===== HOTEL MENU =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\nAvailable Rooms:");

                    for (Room r : rooms) {
                        String status = r.isBooked ? "Booked" : "Available";

                        System.out.println(
                                "Room " + r.roomNumber +
                                " | " + r.category +
                                " | " + status);
                    }
                    break;

                case 2:
                    System.out.print("Enter room number to book: ");
                    int roomNo = sc.nextInt();

                    boolean found = false;

                    for (Room r : rooms) {
                        if (r.roomNumber == roomNo) {
                            found = true;

                            if (!r.isBooked) {
                                r.isBooked = true;

                                System.out.println("Payment Successful!");
                                System.out.println("Room Booked Successfully.");
                            } else {
                                System.out.println("Room already booked.");
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Room not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter room number to cancel booking: ");
                    int cancelNo = sc.nextInt();

                    boolean cancelFound = false;

                    for (Room r : rooms) {
                        if (r.roomNumber == cancelNo) {
                            cancelFound = true;

                            if (r.isBooked) {
                                r.isBooked = false;
                                System.out.println("Booking Cancelled.");
                            } else {
                                System.out.println("Room is not booked.");
                            }
                        }
                    }

                    if (!cancelFound) {
                        System.out.println("Room not found.");
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}