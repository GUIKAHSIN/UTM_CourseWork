// The Offline class implements the Booking interface
public class Offline implements Booking {
    public static final double PAYMENT_RATE = 0.5;
    private double payment;
    private double originalPrice;

    public void bookHotel(Hotel hotel, Customer customer) {
        setPayment(hotel);
    }

    public void setPayment(Hotel hotel) {
        this.payment = hotel.getPrice() * PAYMENT_RATE * hotel.getDuration();
    }

    public double getPayment() { //accessor method
        return payment;
    }
    public double originalPrice(Hotel hotel){
        this.originalPrice = hotel.getPrice() * hotel.getDuration();
        return originalPrice;
    }

    public String depositOrFull(){
        return " (With Deposit 50%)";
    }
}