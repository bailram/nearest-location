import java.util.List;

public class PrintUtils {
    public static void listLocation(List<Location> locations, String header) {
        System.out.println(header);
        System.out.println("============================================================");
        if (!locations.isEmpty()) {
            for (var loc :
                    locations) {
                System.out.println(loc.getName() + " @ " + loc.getLat() + ", " + loc.getLng());
            }
        } else {
            System.out.println("Location not found");
        }
        System.out.println();
    }
}
