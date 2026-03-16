import java.util.HashMap;
import java.util.Map;

class Room {
    int beds;
    int size;
    double price;

    public Room(int beds, int size, double price) {
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + beds);
        System.out.println("Size: " + size + " sq ft");
        System.out.println("Price per night: " + price);
    }
}

class RoomInventory {

    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        roomAvailability.put("Single", 3);
        roomAvailability.put("Double", 2);
        roomAvailability.put("Suite", 1);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }
}

class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        if (availability.get("Single") > 0) {
            System.out.println("\nSingle Room Available:");
            singleRoom.displayRoomDetails();
        } else {
            System.out.println("Single Room Not Available");
        }

        if (availability.get("Double") > 0) {
            System.out.println("\nDouble Room Available:");
            doubleRoom.displayRoomDetails();
        } else {
            System.out.println("Double Room Not Available");
        }

        if (availability.get("Suite") > 0) {
            System.out.println("\nSuite Room Available:");
            suiteRoom.displayRoomDetails();
        } else {
            System.out.println("Suite Room Not Available");
        }
    }
}

public class BookMyStayApp {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        Room singleRoom = new Room(1, 200, 1500);
        Room doubleRoom = new Room(2, 350, 2500);
        Room suiteRoom = new Room(3, 500, 5000);

        RoomSearchService searchService = new RoomSearchService();

        System.out.println("Searching Available Rooms...");

        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}