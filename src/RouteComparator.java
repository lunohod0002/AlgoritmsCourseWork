import java.util.Comparator;
public class RouteComparator implements Comparator<Route> {

    @Override
    public int compare(Route o1, Route o2) {
        if (o1.isFavorite() && !o2.isFavorite()) return -1;
        if (!o1.isFavorite() && o2.isFavorite()) return 1;
        int distanceCompare=Double.compare(o1.getDistance(),o2.getDistance());
        if (distanceCompare!=0) return distanceCompare;
        else{
            return Integer.compare(o1.getPopularity(),o2.getPopularity());
        }
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
