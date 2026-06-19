// Customer.java
public class Customer {
    private String name;
    private String phone;
    private String ic;
    private Hotel hotel;
    private String bookingId;
    private Booking bookingMethod;

    public Customer(String name, String phone, String ic) {
        this.name = name;
        this.phone = phone;
        this.ic = ic;
    }

    public void placeBooking(Hotel hotel, Booking bookingMethod, String bookingId) {
        this.hotel = hotel;
        this.bookingMethod = bookingMethod;
        this.bookingId = bookingId;
        bookingMethod.bookHotel(hotel, this);
    }

    public String getBookingId() {
        return bookingId;
    }

    public String getReceipt() {
        return "\n--- Booking Receipt ---" +
                "\nName: " + name +
                "\nIC: " + ic +
                "\nPhone: " + phone +
                "\nHotel: " + hotel.getHotelName() +
                "\nRoom: " + hotel.getClass().getSimpleName() +
                "\nPrice: RM" + hotel.getPrice() +
                "\nDuration: " + hotel.formatDuration() + "day(s)" + 
                "\nBooking ID: " + bookingId +
                "\nPayment: RM" + bookingMethod.getPayment();
    }
}