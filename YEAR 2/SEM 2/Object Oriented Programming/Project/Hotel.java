import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Hotel { // abstract class & inheritance
    protected final String hotelName = "RoyalRest Hotel";
    protected int room;
    protected double price;
    protected String bookingId;
    protected Duration duration;
    protected LocalDateTime checkIn;
    protected LocalDateTime checkOut;

    private static int bookingCounter = 1;


    public Hotel(int room, double price) {
        this.room = room;
        this.price = price;
    }

    // Add method to generate sequential booking ID
    public static String generateSequentialBookingId() {
        String id = String.format("%02d", bookingCounter);
        bookingCounter++;
        return id;
    }       
    
    public String getHotelName() {
        return hotelName;
    }

    public int getRoom() {
        return room;
    }

    public double getPrice() {
        return price;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
        if (checkIn != null && checkOut != null) {
            this.duration = Duration.between(checkIn, checkOut);
        }
    }

    public String formatDuration() {
        if (duration == null) {
            return "Not Set";
        }
        return duration.toDays() + " day(s)";
    }

    public int getDuration() { // convert duration into int
        long days = duration.toDays();
        int daysAsInt = (int) days;
        return daysAsInt;
    }

    public String getCheckInDate() {
        return (checkIn != null) ? checkIn.toLocalDate().toString() : "Not Set";
    }

    public String getCheckOutDate() {
        return (checkOut != null) ? checkOut.toLocalDate().toString() : "Not Set";
    }

    public abstract String infoDisplay();
    public abstract String generateBookingId();
}
