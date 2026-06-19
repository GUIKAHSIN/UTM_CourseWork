import javax.swing.*;
import java.util.*;
import java.time.LocalDateTime;

public class HotelBookingSystem {
    public static void main(String[] args) {
        ArrayList<Hotel> rooms = new ArrayList<>();
        rooms.add(new SingleRoom(5, 100));
        rooms.add(new DoubleRoom(5, 150));
        rooms.add(new FamilyRoom(3, 200));
        rooms.add(new ExecutiveRoom(2, 300));

        while (true) {
            String[] options = {"Book Room", "Cancel Booking", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Welcome to RoyalRest Hotel!", "Hotel System",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                StringBuilder sb = new StringBuilder("Room Types:\n");
                int i = 1;
                for (Hotel room : rooms) {
                    sb.append(i++).append(": ").append(room.infoDisplay()).append("\n");
                }

                String roomChoiceStr = JOptionPane.showInputDialog(sb.toString() + "\nEnter room number to book:");
                int roomChoice = Integer.parseInt(roomChoiceStr) - 1;
                Hotel selectedRoom = rooms.get(roomChoice);

                if (selectedRoom.getRoom() == 0) {
                    JOptionPane.showMessageDialog(null, "Room not available.");
                    continue;
                }

                String checkInStr = JOptionPane.showInputDialog("Enter check-in date and time (yyyy-MM-ddTHH:mm):");
                String checkOutStr = JOptionPane.showInputDialog("Enter check-out date and time (yyyy-MM-ddTHH:mm):");

                try {
                    LocalDateTime checkIn = LocalDateTime.parse(checkInStr);
                    LocalDateTime checkOut = LocalDateTime.parse(checkOutStr);
                    selectedRoom.setCheckIn(checkIn);
                    selectedRoom.setCheckOut(checkOut);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid date format.");
                    continue;
                }

                String name = JOptionPane.showInputDialog("Enter Name:");
                String ic = JOptionPane.showInputDialog("Enter Identity Number:");
                String phone = JOptionPane.showInputDialog("Enter Phone Number:");

                String[] payOptions = {"Online (Full)", "Offline (50% Deposit)"};
                int payChoice = JOptionPane.showOptionDialog(null, "Choose payment method:", "Payment",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, payOptions, payOptions[0]);

                Booking method = (payChoice == 0) ? new Online() : new Offline();

                Customer cust = new Customer(name, phone, ic);
                String bookingId = UUID.randomUUID().toString().substring(0, 6);
                cust.placeBooking(selectedRoom, method, bookingId);

                selectedRoom.room--; // Reduce availability
                HotelSystem.addCustomer(cust);

                JOptionPane.showMessageDialog(null, cust.getReceipt());

            } else if (choice == 1) {
                String bookingId = JOptionPane.showInputDialog("Enter Booking ID to cancel:");
                Customer toCancel = HotelSystem.findCustomerById(bookingId);
                if (toCancel != null) {
                    HotelSystem.removeCustomer(bookingId);
                    JOptionPane.showMessageDialog(null, "Booking cancelled for ID: " + bookingId);
                } else {
                    JOptionPane.showMessageDialog(null, "No booking found with that ID.");
                }

            } else {
                break;
            }
        }
    }
}
