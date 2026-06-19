public class Customer {
    private String name;
    private String phone;
    private String ic;
    private Hotel hotel; // composition - has-a strong relationship, cannot exist independently
    private String bookingId;
    private Booking bookingMethod; // composition

    public Customer(String name, String phone, String ic, Hotel hotel) {
        this.name = name;
        this.phone = phone;
        this.ic = ic;
        this.hotel = hotel;
    }

    public void placeBooking(Hotel hotel, Booking bookingMethod) {
        this.hotel = hotel;
        this.bookingMethod = bookingMethod;
        bookingMethod.bookHotel(hotel, this);
        setBookingId();
    }   

    public void setBookingId() {
        this.bookingId = hotel.generateBookingId();
    }

    public String getBookingId() {
        return bookingId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getReceipt() {
        // Check if the booking method is an instance of Offline 
        // If true, label it as "Deposit", otherwise label it as "Total Payment"
        String paymentLabel = (bookingMethod instanceof Offline) ? "Deposit" : "Total Payment";
        String originalPriceSection = (bookingMethod instanceof Offline) ? "\nOriginal Price: RM" + bookingMethod.originalPrice(hotel) : "";

        return "\n======== Booking Receipt ========" +
                "\nHotel: " + hotel.getHotelName() +
                "\nName: " + name +
                "\nIC: " + ic +
                "\nPhone: " + phone +
                "\n======== Room Details ========" +
                "\nRoom: " + hotel.getClass().getSimpleName() + // return hotel name
                "\nPrice (Per Day): RM" + hotel.getPrice() +
                "\nDuration: " + hotel.getDuration() + " days" +
                "\nBooking ID: " + getBookingId() +
                "\nCheck In: " + hotel.getCheckInDate() +
                "\nCheck Out: " + hotel.getCheckOutDate() +
                "\nPayment Method: " + bookingMethod.getClass().getSimpleName() + bookingMethod.depositOrFull() +
                originalPriceSection +
                // "\nOriginal Price: RM" + bookingMethod.originalPrice(hotel) +
                "\n" + paymentLabel + ": RM" + bookingMethod.getPayment();
            }
}