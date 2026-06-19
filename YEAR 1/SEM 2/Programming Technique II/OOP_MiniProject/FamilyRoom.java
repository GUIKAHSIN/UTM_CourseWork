// FamilyRoom.java
public class FamilyRoom extends Hotel {
    public FamilyRoom(int room, double price) {
        super(room, price);
    }

    @Override
    public String infoDisplay() {
        return "Family Room | RM" + price + " | Available: " + room;
    }
}
