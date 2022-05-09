public class Location {
    private Long id;
    private double lat;
    private double lng;
    private String name;

    public Location() {
    }

    public Location(Long id, double lat, double lng, String name) {
        this.id = id;
        this.lat = lat;
        this.lng = lng;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
