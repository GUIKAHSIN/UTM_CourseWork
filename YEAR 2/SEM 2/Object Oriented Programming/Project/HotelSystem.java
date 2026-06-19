import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HotelSystem {
    private static ArrayList<Customer> customers = new ArrayList<>(); // association & arraylist -> Customer links to a Hotel

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeCustomer(String bookingId) {
        if (customers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings to cancel.");
            return;
        }

        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getBookingId().equalsIgnoreCase(bookingId.trim())) {  // Check for case-insensitive match and trim whitespace
                // Add the room back to available count
                Hotel hotel = customer.getHotel();
                addRoomBack(hotel);
                
                // Remove the customer from the list
                customers.remove(i);
                JOptionPane.showMessageDialog(null, "Booking " + bookingId + " has been cancelled successfully!\nRoom has been added back to available rooms.");
                return;
            }
        }
        // If no matching booking ID is found, show this message
        JOptionPane.showMessageDialog(null, "Booking ID not found!");
    }
    
    public static void addRoomBack(Hotel hotel) {
        if (hotel instanceof SingleRoom) {
            SingleRoom.increaseAvailability();
        } else if (hotel instanceof DoubleRoom) {
            DoubleRoom.increaseAvailability();
        } else if (hotel instanceof FamilyRoom) {
            FamilyRoom.increaseAvailability();
        } else if (hotel instanceof ExecutiveRoom) {
            ExecutiveRoom.increaseAvailability();
        }
    }
    
    public static Customer findCustomerById(String bookingId) {
        for (Customer c : customers) {
            if (c.getBookingId().equals(bookingId)) {
                return c;
            }
        }
        return null;
    }

    public static void displayAllBookings() {
        if (customers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No bookings available.");
            return;
        }

        StringBuilder sb = new StringBuilder(); // Create a StringBuilder to hold all customer receipts
        for (Customer c : customers) {
            sb.append(c.getReceipt()).append("\n--------------------------\n"); // Add separator for clarity
        }
        // Create a scrollable text area
        JTextArea textArea = new JTextArea(sb.toString()); //JTextArea:a component that displays multiline text.
        textArea.setEditable(false); // Prevent user from editing the text
        textArea.setFont(new java.awt.Font("Monospaced", java.awt.Font.PLAIN, 12)); // Set a monospaced font for better readability and looks liked printed format
        
        // Wrap the text area in a scroll pane to allow scrolling if the content is long
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(500, 400));
        
        JOptionPane.showMessageDialog(null, scrollPane, "All Bookings", JOptionPane.INFORMATION_MESSAGE);    
    }

        public static ArrayList<Customer> getCustomers() {
            return customers;
    }
}
