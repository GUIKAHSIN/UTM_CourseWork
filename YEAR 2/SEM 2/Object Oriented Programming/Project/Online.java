public class Online implements Booking {
    public static final double PAYMENT_RATE = 1.0;
    private double payment;
    private double originalPrice;

    public void bookHotel(Hotel hotel, Customer customer) {
        setPayment(hotel);
    }

    public void setPayment(Hotel hotel) {
        this.payment = hotel.getPrice() * PAYMENT_RATE * hotel.getDuration();
    }

    public double getPayment() {
        return payment;
    }
    public double originalPrice(Hotel hotel){
        this.originalPrice = hotel.getPrice() * hotel.getDuration();
        return originalPrice;
    }
    public String depositOrFull(){
        return " (Full Payment)";
    }
}