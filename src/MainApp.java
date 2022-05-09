import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        var currentLoc = new Location(null, -7.0127027864546045, 110.47836890208306, "current");
//        basic(currentLoc, 20);
        haversine(currentLoc, 20);
    }

    static List<Location> getListLocation() {
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(2l, -8.197373474144884, 112.72459889849165, "Indomaret Majang Tengah"));
        locations.add(new Location(3l, -8.188233534699545, 112.70423235436036, "Masjid At-Tulus"));
        locations.add(new Location(5l, -7.98240293031187, 112.62966928360427, "Masjid Agung Jami' Kota Malang"));
        locations.add(new Location(6l, -7.001476, 110.432831, "Semarang"));
        return locations;
    }

    static void basic(Location currentLoc, int radius) {
        System.out.println("Current Location " + currentLoc.getLat() + ", " + currentLoc.getLng());
        var locations = getListLocation();
        PrintUtils.listLocation(locations, "LOCATION LIST");
        var nearestLocation = LocationUtils.nearestLocation(locations, currentLoc, radius);
        System.out.println("");
        PrintUtils.listLocation(nearestLocation, "NEAREST LOCATION LIST");
    }

    static void haversine(Location currentLoc, int radius) {
        System.out.println("Current Location " + currentLoc.getLat() + ", " + currentLoc.getLng());
        var locations = getListLocation();
        PrintUtils.listLocation(locations, "LOCATION LIST");
        var nearestLocation = LocationUtils.nearestLocationHaversine(locations, currentLoc, radius);
        System.out.println("");
        PrintUtils.listLocation(nearestLocation, "NEAREST LOCATION LIST");
    }
}
