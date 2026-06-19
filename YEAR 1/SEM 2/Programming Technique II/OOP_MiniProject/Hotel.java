import java.time.Duration;
import java.time.LocalDateTime;

public abstract class Hotel {
    protected final String hotelName = "RoyalRest Hotel";
    protected int room;
    protected double price;
    protected Duration duration;
    protected LocalDateTime checkIn;
    protected LocalDateTime checkOut;

    public Hotel(int room, double price) {
        this.room = room;
        this.price = price;
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
        this.duration = Duration.between(checkIn, checkOut);
    }

    public long getDurationDays() {
        return duration.toDays();
    }

    public String formatDuration() {
        return duration.toDays() + " day(s)";
    }

    public abstract String infoDisplay();
}