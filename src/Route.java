
import java.util.Objects;

public class Route {
    private String id;
    private double distance;
    private int popularity;
    private boolean isFavorite;
    private LinkedList<String> locationPoints;

    public Route(String id, double distance, LinkedList<String> locationPoints) {
        this.id = id;
        this.distance = distance;
        this.popularity = 0;
        this.isFavorite = false;
        this.locationPoints = locationPoints;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getDistance() {
        return distance;
    }

    public int getPopularity() {
        return popularity;
    }

    public LinkedList<String> getLocationPoints() {
        return locationPoints;
    }

    public void setLocationPoints(LinkedList<String> locationPoints) {
        this.locationPoints = locationPoints;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getPopulatiry() {
        return popularity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id='" + id + '\'' +
                ", distance=" + distance +
                ", popularity=" + popularity +
                ", isFavorite=" + isFavorite +
                ", locationPoints=" + locationPoints +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return id == route.id && Double.compare(distance, route.distance) == 0 && popularity == route.popularity && isFavorite == route.isFavorite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, distance, popularity, isFavorite);
    }
}
