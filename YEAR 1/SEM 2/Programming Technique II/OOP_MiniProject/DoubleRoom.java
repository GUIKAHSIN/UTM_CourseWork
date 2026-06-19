// DoubleRoom.java
public class DoubleRoom extends Hotel {
    public DoubleRoom(int room, double price) {
        super(room, price);
    }

    @Override
    public String infoDisplay() {
        return "Double Room | RM" + price + " | Available: " + room;
    }
}
