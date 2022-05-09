import java.util.ArrayList;
import java.util.List;

public class LocationUtils {
    public static List<Location> nearestLocation(List<Location> locations, Location current, int radius) {
        var latitude = current.getLat();
        var longitude = current.getLng();
        List<Location> nearestLoc = new ArrayList<>();
        if (!locations.isEmpty()) {
            for (var loc :
                    locations) {
                double distance = 0;
                try {
                    distance = (
                            (
                                    Math.acos(
                                            Math.sin((latitude * Math.PI / 180))
                                                    * Math.sin((loc.getLat() * Math.PI / 180)) + Math.cos((latitude * Math.PI / 180))
                                                    * Math.cos((loc.getLat() * Math.PI / 180)) * Math.cos((longitude - loc.getLng()) * Math.PI / 180)
                                    )
                            ) * 180 / Math.PI
                    ) * 60 * 1.1515 * 1.609344;
                } catch (Exception e) {
                    System.out.println("error when counting distance location");
                }
                System.out.println("distance between current location to " + loc.getName() + " = " + distance + " KM ≈ " + (Math.round(distance * 100.0) / 100.0) + " KM");
                if (distance <= radius) {
                    nearestLoc.add(loc);
                }
            }
        }

        return nearestLoc;
    }
}
