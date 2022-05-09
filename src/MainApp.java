import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        var currentLoc = new Location(null, -8.182164603741485, 112.69347938852638, "current");
        var radius = 20; // KM
        System.out.println("Current Location " + currentLoc.getLat() + ", " + currentLoc.getLng());
        List<Location> locations = new ArrayList<>();
        locations.add(new Location(1l, -8.168696592527512, 112.69020880137741, "SMK Negeri 1 Turen"));
        locations.add(new Location(2l, -8.197373474144884, 112.72459889849165, "Indomaret Majang Tengah"));
        locations.add(new Location(3l, -8.188233534699545, 112.70423235436036, "Masjid At-Tulus"));
        locations.add(new Location(4l, -8.147807804657392, 112.69656292838319, "SMP Negeri 2 Turen"));
        locations.add(new Location(5l, -7.98240293031187, 112.62966928360427, "Masjid Agung Jami' Kota Malang"));
        PrintUtils.listLocation(locations, "LOCATION LIST");
        var nearestLocation = LocationUtils.nearestLocation(locations, currentLoc, radius);
        System.out.println("");
        PrintUtils.listLocation(nearestLocation, "NEAREST LOCATION LIST");
    }
}
