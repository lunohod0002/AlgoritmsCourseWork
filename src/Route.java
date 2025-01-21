
import java.util.Objects;

public class Route {
    private String id;
    private double distance;
    private int popularity;
    private boolean isFavorite;
    private LinkedList<String> locationPoints;

    public Route(String id, double distance, boolean isFavorite, int popularity, LinkedList<String> locationPoints) {
        this.id = id;
        this.distance = distance;
        this.popularity = popularity;
        this.isFavorite = isFavorite;
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
        StringBuilder sb = new StringBuilder();
        sb.append("Route{" +
                "id='" + id + '\'' +
                ", distance=" + distance +
                ", popularity=" + popularity +
                ", isFavorite=" + isFavorite +
                ", locationPoints=");
        if (locationPoints != null && !(locationPoints.getSize() == 0)) {
            for (String location : locationPoints) {
                sb.append(" -> ").append(location);
            }
        }
        String result=sb.toString().replaceFirst(" -> "," ");
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Route route = (Route) obj;

        if (!id.equals(route.id)) return false;

        if (Double.compare(distance, route.distance) != 0) return false;

        if (popularity != route.popularity) return false;

        if (isFavorite != route.isFavorite) return false;
        if (locationPoints == null && route.locationPoints != null || locationPoints != null && route.locationPoints == null)
            return false;

        if (locationPoints != null && !locationPoints.equals(route.locationPoints))
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = 53;
        result = 47 * result + (id == null ? 0 : id.hashCode());
        long distanceBits = (long) distance;
        result = 47 * result + (int) (distanceBits ^ (distanceBits >>> 32));
        result = 47 * result + popularity;
        result = 47 * result + (isFavorite ? 1 : 0);
        result = 47 * result + (locationPoints == null ? 0 : locationPoints.hashCode());
        return result;
    }
}


