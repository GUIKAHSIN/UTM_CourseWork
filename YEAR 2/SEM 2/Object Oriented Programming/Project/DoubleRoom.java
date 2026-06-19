public class DoubleRoom extends Hotel {
    private static int availableRooms = 10;

    public DoubleRoom() {
        super(availableRooms, 150);
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
        return "Double Room | RM" + price + "/day | Available: " + availableRooms;
    }

    @Override
    public String generateBookingId() {
        return "DR" + Hotel.generateSequentialBookingId();

        // Random random = new Random();
        // int number = random.nextInt(900000) + 100000; // 6-digit number
        // return "DR" + number;
    }
}
