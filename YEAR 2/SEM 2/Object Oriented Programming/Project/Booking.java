public interface Booking { // class interface & polymorphism
    public void bookHotel(Hotel hotel, Customer customer);
    public double getPayment();
    public void setPayment(Hotel hotel);
    public double originalPrice(Hotel hotel);
    public String depositOrFull();
}