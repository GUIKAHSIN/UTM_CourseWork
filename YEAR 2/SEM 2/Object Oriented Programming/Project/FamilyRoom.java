public class FamilyRoom extends Hotel {
    private static int availableRooms = 5;

    public FamilyRoom() {
        super(availableRooms, 200);
    }

    public static boolean isAvailable() {
        return availableRooms > 0;
    }

    public static void reduceAvailability() {
        if (availableRooms > 0) {
            availableRooms--;
        }
    }

    // Add this method to each room class
    public static void increaseAvailability() {
        availableRooms++;
    }

    public static int getAvailability() {
        return availableRooms;
    }

    @Override
    public String infoDisplay() {
        return "Family Room | RM" + price + "/day | Available: " + availableRooms;
    }

    @Override
    public String generateBookingId() {
        return "FR" + Hotel.generateSequentialBookingId();

        // Random random = new Random();
        // int number = random.nextInt(900000) + 100000; // 6-digit number
        // return "FR" + number;
    }
}
