// ExecutiveRoom.java
public class ExecutiveRoom extends Hotel {
    public ExecutiveRoom(int room, double price) {
        super(room, price);
    }

    @Override
    public String infoDisplay() {
        return "Executive Room | RM" + price + " | Available: " + room;
    }
}
