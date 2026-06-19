import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class HotelBookingSystem {
    public static void main(String[] args) {
        ImageIcon hotelIcon = new ImageIcon("hotel.png");
        while (true) {
            String[] options = { "Book Room", "Cancel Booking", "View All Bookings", "Exit" };
            int choice = JOptionPane.showOptionDialog(null, "Welcome to RoyalRest Hotel Booking System", "Main Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, hotelIcon, options, options[0]);

            if (choice == 0) {
                bookRoom();
            } else if (choice == 1) {
                cancelBooking();
            } else if (choice == 2) {
                HotelSystem.displayAllBookings();
            } else {
                break;
            }
        }
    }

    public static void bookRoom() {
        Hotel[] allRooms = { new SingleRoom(), new DoubleRoom(), new FamilyRoom(), new ExecutiveRoom() };
        StringBuilder sb = new StringBuilder("Room Types:\n");
        int i = 1;
        for (Hotel room : allRooms) {
            sb.append(i++).append(": ").append(room.infoDisplay()).append("\n");
        }

        String[] roomTypes = { "Single Room", "Double Room", "Family Room", "Executive Room", "Return" };
        int roomChoice = JOptionPane.showOptionDialog(null, sb.toString(), "Room Selection",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, roomTypes, roomTypes[0]);

        Hotel selectedHotel = null;

        switch (roomChoice) {
            case 0:
                if (!SingleRoom.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "No Single Rooms available!");
                    return;
                }
                selectedHotel = new SingleRoom();
                SingleRoom.reduceAvailability();
                break;
            case 1:
                if (!DoubleRoom.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "No Double Rooms available!");
                    return;
                }
                selectedHotel = new DoubleRoom();
                DoubleRoom.reduceAvailability();
                break;
            case 2:
                if (!FamilyRoom.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "No Family Rooms available!");
                    return;
                }
                selectedHotel = new FamilyRoom();
                FamilyRoom.reduceAvailability();
                break;
            case 3:
                if (!ExecutiveRoom.isAvailable()) {
                    JOptionPane.showMessageDialog(null, "No Executive Rooms available!");
                    return;
                }
                selectedHotel = new ExecutiveRoom();
                ExecutiveRoom.reduceAvailability();
                break;
            default:
                return;
        }

        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate checkInDate = null;
            LocalDate checkOutDate = null;
    
            // Check-in date validation with loop
            while (checkInDate == null) {
                String checkInStr = JOptionPane.showInputDialog("Enter check-in date (YYYY-MM-DD):");
                if (checkInStr == null) { // User clicked Cancel
                    restoreRoomAvailability(selectedHotel);
                    return;
                }
                if (checkInStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Check-in date cannot be empty! Please try again.");
                    continue;
                }
                
                try {
                    checkInDate = LocalDate.parse(checkInStr, formatter);
                    if (checkInDate.isBefore(LocalDate.now())) {
                        JOptionPane.showMessageDialog(null, "Check-In date cannot be in the past! Please enter a valid date.");
                        checkInDate = null; // Reset to retry
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid date format! Please use YYYY-MM-DD format.");
                }
            }
    
            // Check-out date validation with loop
            while (checkOutDate == null) {
                String checkOutStr = JOptionPane.showInputDialog("Enter check-out date (YYYY-MM-DD):");
                if (checkOutStr == null) { // User clicked Cancel
                    restoreRoomAvailability(selectedHotel);
                    return;
                }
                if (checkOutStr.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Check-out date cannot be empty! Please try again.");
                    continue;
                }
                
                try {
                    checkOutDate = LocalDate.parse(checkOutStr, formatter);
                    
                    if (checkOutDate.isBefore(LocalDate.now())) {
                        JOptionPane.showMessageDialog(null, "Check-Out date cannot be in the past! Please enter a valid date.");
                        checkOutDate = null;
                        continue;
                    }
                    
                    if (checkInDate.equals(checkOutDate)) {
                        JOptionPane.showMessageDialog(null, "Check-In and Check-Out dates cannot be the same! Please enter a different date.");
                        checkOutDate = null;
                        continue;
                    }
                    
                    if (checkOutDate.isBefore(checkInDate)) {
                        JOptionPane.showMessageDialog(null, "Check-Out date cannot be before Check-In date! Please enter a valid date.");
                        checkOutDate = null;
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid date format! Please use YYYY-MM-DD format.");
                }
            }
    
            // Set check-in & check-out
            selectedHotel.setCheckIn(checkInDate.atStartOfDay());
            selectedHotel.setCheckOut(checkOutDate.atStartOfDay());
    
            // Name validation with loop
            String name = null;
            while (name == null) {
                try {
                    String nameInput = JOptionPane.showInputDialog("Enter your name:");
                    if (nameInput == null) { // User clicked Cancel
                        restoreRoomAvailability(selectedHotel);
                        return;
                    }
                    
                    // Check if empty
                    if (nameInput.trim().isEmpty()) {
                        throw new IllegalArgumentException("Name cannot be empty!");
                    }
                    
                    // Check if name contains only letters and spaces
                    if (!nameInput.trim().matches("[a-zA-Z\\s]+")) {
                        throw new IllegalArgumentException("Name can only contain letters and spaces!");
                    }
                    
                    // Check if name is too short
                    if (nameInput.trim().length() < 3) {
                        throw new IllegalArgumentException("Name must be at least 3 characters long!");
                    }
                    
                    name = nameInput.trim();
                    
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage() + " Please enter your name again.");
                }
            }
    
            // IC validation with exception handling
            String ic = null;
            while (ic == null) {
                try {
                    String icInput = JOptionPane.showInputDialog("Enter your IC/Identity Number:");
                    if (icInput == null) { // User clicked Cancel
                        restoreRoomAvailability(selectedHotel);
                        return;
                    }
                    
                    // Check if empty
                    if (icInput.trim().isEmpty()) {
                        throw new IllegalArgumentException("IC/Identity Number cannot be empty!");
                    }
                    
                    // Check if IC contains only numbers
                    if (!icInput.trim().matches("[0-9]+")) {
                        throw new IllegalArgumentException("IC/Identity Number can only contain numbers!");
                    }
                    
                    // Check if IC has exactly 12 characters
                    if (icInput.trim().length() != 12) {
                        throw new IllegalArgumentException("IC/Identity Number must be exactly 12 digits!");
                    }
                    
                    ic = icInput.trim();
                    
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage() + " Please enter your IC again.");
                }
            }
    
            // Phone validation with loop
            String phone = null;
            while (phone == null) {
                try{
                String phoneInput = JOptionPane.showInputDialog("Enter your phone number:");
                if (phoneInput == null) { // User clicked Cancel
                    restoreRoomAvailability(selectedHotel);
                    return;
                }
                // Check if empty
                    if (phoneInput.trim().isEmpty()) {
                        throw new IllegalArgumentException("Phone number cannot be empty!");
                    }
                    
                    // Check if phone number contains only numbers
                    if (!phoneInput.trim().matches("[0-9]+")) {
                        throw new IllegalArgumentException("Phone number can only contain numbers!");
                    }

                    // Add length validation for Malaysian phone numbers
                    if (phoneInput.trim().length() < 10) {
                        throw new IllegalArgumentException("Phone number must be at least 10 digits!");
                    }
                    
                    if (phoneInput.trim().length() > 11) {
                        throw new IllegalArgumentException("Phone number cannot be more than 11 digits!");
                    }

                    phone = phoneInput.trim();

                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage() + " Please enter your phone number again.");
                }
            }
    
            // Payment method selection
            String[] payments = { "Online (Full Payment)", "Offline (50% Deposit)" };
            int payChoice = JOptionPane.showOptionDialog(null, "Select Payment Method:", "Payment",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, payments, payments[0]);
    
            if (payChoice == -1) { // User clicked X or Cancel
                JOptionPane.showMessageDialog(null, "Payment method must be selected!");
                restoreRoomAvailability(selectedHotel);
                return;
            }
    
            Customer customer = new Customer(name, ic, phone, selectedHotel);
            Booking method = (payChoice == 0) ? new Online() : new Offline();
            customer.placeBooking(selectedHotel, method);
            HotelSystem.addCustomer(customer);
            JOptionPane.showMessageDialog(null, customer.getReceipt());
    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "An unexpected error occurred! Please try again.");
            restoreRoomAvailability(selectedHotel);
        }
    }

    private static void restoreRoomAvailability(Hotel selectedHotel) {
        if (selectedHotel instanceof SingleRoom) {
            SingleRoom.increaseAvailability();
        } else if (selectedHotel instanceof DoubleRoom) {
            DoubleRoom.increaseAvailability();
        } else if (selectedHotel instanceof FamilyRoom) {
            FamilyRoom.increaseAvailability();
        } else if (selectedHotel instanceof ExecutiveRoom) {
            ExecutiveRoom.increaseAvailability();
        }
    }

    public static void cancelBooking() {
        String bookingId = JOptionPane.showInputDialog("Enter Booking ID to cancel:");
        if (bookingId != null && !bookingId.trim().isEmpty()) {
            HotelSystem.removeCustomer(bookingId.trim());
        } else {
            JOptionPane.showMessageDialog(null, "Booking ID cannot be empty!");
        }
    }
}