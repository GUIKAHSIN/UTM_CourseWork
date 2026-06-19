// Offline.java
public class Offline implements Booking {
    public static final double PAYMENT_RATE = 0.5;
    private double payment;

    public void bookHotel(Hotel hotel, Customer customer) {
        setPayment(hotel);
    }

    public void setPayment(Hotel hotel) {
        this.payment = hotel.getPrice() * hotel.getDurationDays() * PAYMENT_RATE;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment() {
        // for interface compliance
    }
}