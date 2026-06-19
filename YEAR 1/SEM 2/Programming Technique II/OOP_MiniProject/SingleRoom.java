// SingleRoom.java
public class SingleRoom extends Hotel {
    public SingleRoom(int room, double price) {
        super(room, price);
    }

    @Override
    public String infoDisplay() {
        return "Single Room | RM" + price + " | Available: " + room;
    }
}
