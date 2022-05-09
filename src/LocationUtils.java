import java.util.ArrayList;
import java.util.List;

public class LocationUtils {
    /**
     * Returns the nearest list location by latitude and longitude
     *
     * @param locations list dto location
     * @param current dto location
     * @param radius the value for filtering distance in KM
     * @return the nearest list location dto
     */
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
                    ) * 60 * 1.1515 * 1.609344; // multiply by 1.609344 is logic to get value in KM. just remove it if you want value in miles
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

    /**
     * Returns the nearest list location by latitude and longitude using Haversine Formula
     *
     * @param locations list dto location
     * @param current dto location
     * @param radius the value for filtering distance in KM
     * @return the nearest list location dto
     */
    public static List<Location> nearestLocationHaversine(List<Location> locations, Location current, int radius) {
        final int R = 6371; // Radious of the earth (KM)
        var latitude = current.getLat();
        var longitude = current.getLng();
        List<Location> nearestLoc = new ArrayList<>();
        if (!locations.isEmpty()) {
            for (var loc :
                    locations) {
                double distance = 0;
                try {
                    Double latDistance = toRad(loc.getLat() - latitude);
                    Double lonDistance = toRad(loc.getLng() - longitude);
                    Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                            Math.cos(toRad(latitude)) * Math.cos(toRad(loc.getLat())) *
                                    Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
                    Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
                    distance = R * c;
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

    private static Double toRad(Double value) {
        return value * Math.PI / 180;
    }
}
