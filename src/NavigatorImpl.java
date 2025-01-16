import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NavigatorImpl implements Navigator {
    private LinkedList<Route> linkedList;

    public NavigatorImpl() {
        this.linkedList = new LinkedList<>();
    }


    @Override
    public void addRoute(Route route) {
        linkedList.add(route);
    }

    @Override
    public void removeRoute(String routeId) {
        if (linkedList.getHead() == null) {
            return;
        }
        for (Route route : linkedList) {
            if (route.getId().equals(routeId)) {
                linkedList.remove(route);
                return;
            }
        }
    }


    @Override
    public boolean contains(Route route) {
        return linkedList.contains(route);
    }

    @Override
    public int size() {
        return linkedList.getSize();
    }

    @Override
    public Route getRoute(String routeId) {
        if (linkedList == null || linkedList.getHead() == null)
            return null;

        for (Route route : linkedList) {
            if (routeId.equals(route.getId())) {
                return route;
            }
        }
        return null;
    }


    @Override
    public void chooseRoute(String routeId) {
        if (linkedList == null || linkedList.getHead() == null)
            return;

        for (Route route : linkedList) {
            if (routeId.equals(route.getId())) {
                route.setPopularity(route.getPopularity() + 1);
                return;
            }
        }

    }

    public void display() {
        linkedList.display();
    }




    @Override
    public Iterable<Route> searchRoutes(String startPoint, String endPoint) {
        LinkedList<Route> resultList = new LinkedList<>();
        for (Route route : resultList) {
            if (route.getLocationPoints().getById(0).equals(startPoint) &&
                    route.getLocationPoints().getById(route.getLocationPoints().getSize() - 1).equals(endPoint)) {
                resultList.add(route);
            }
        }
        Comparator<Route> routeComparator = new Comparator<Route>() {
            @Override
            public int compare(Route r1, Route r2) {
                if (r1.isFavorite() && !r2.isFavorite()) return -1;
                if (!r1.isFavorite() && r2.isFavorite()) return 1;
                int distanceComparison = Double.compare(r1.getDistance(), r2.getDistance());
                if (distanceComparison != 0) return distanceComparison;
                return Integer.compare(r2.getPopularity(), r1.getPopularity());
            }
        };


        resultList.sort(routeComparator);
        return resultList;
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        LinkedList<Route> resultList = new LinkedList<>();

        for (Route route : resultList) {
            if (route.isFavorite() &&
                    route.getLocationPoints().contains(destinationPoint) && !route.getLocationPoints().getById(0).equals(destinationPoint)) {
                resultList.add(route);
            }
        }
        Comparator<Route> routeComparator = new Comparator<Route>() {
            @Override
            public int compare(Route r1, Route r2) {
                if (r1.isFavorite() && !r2.isFavorite()) return -1;
                if (!r1.isFavorite() && r2.isFavorite()) return 1;
                int popularityComparsion = Integer.compare(r2.getPopularity(), r1.getPopularity());
                int distanceComparison = Double.compare(r1.getDistance(), r2.getDistance());
                if (distanceComparison != 0) return distanceComparison;
                else if (popularityComparsion != 0) return popularityComparsion;
                else return (Integer.compare(r2.getLocationPoints().getSize(), r1.getLocationPoints().getSize()));
            }

            ;


        };
        LinkedList<Route> top5RoutesList = new LinkedList<>();

        for (int i = 0; i < Math.min(3, resultList.getSize()); i++) {
            top5RoutesList.add((resultList.getById(i)));
        }
        top5RoutesList.sort(routeComparator);
        return top5RoutesList;
    }

    @Override
    public Iterable<Route> getTop3Routes() {
        LinkedList<Route> resultList = new LinkedList<>();

        for (Route route : linkedList) {
            resultList.add(route);
        }

        Comparator<Route> routeComparator = new Comparator<Route>() {
            @Override
            public int compare(Route r1, Route r2) {
                int distanceComparison = Double.compare(r1.getDistance(), r2.getDistance());
                if (distanceComparison != 0) return distanceComparison;
                else return Integer.compare(r2.getPopularity(), r1.getPopularity());
            }
        };


        LinkedList<Route> top3RoutesLinkedList = new LinkedList<>();
        for (int i = 0; i < Math.min(5, resultList.getSize()); i++) {
            top3RoutesLinkedList.add(resultList.getById(i));
        }
        top3RoutesLinkedList.sort(routeComparator);
        return top3RoutesLinkedList;
    }
}
