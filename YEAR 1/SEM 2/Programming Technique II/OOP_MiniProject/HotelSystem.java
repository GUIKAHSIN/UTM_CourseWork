// HotelSystem.java
import java.util.*;

public class HotelSystem {
    private static ArrayList<Customer> customers = new ArrayList<>();

    public static void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public static void removeCustomer(String bookingId) {
        customers.removeIf(c -> c.getBookingId().equals(bookingId));
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
        for (Customer c : customers) {
            System.out.println(c.getReceipt());
        }
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }
}