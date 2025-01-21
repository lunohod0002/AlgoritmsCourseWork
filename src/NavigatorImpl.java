
public class NavigatorImpl implements Navigator {
    private LinkedList<Route> linkedList;

    public NavigatorImpl() {
        this.linkedList = new LinkedList<>();
    }


    @Override
    public void addRoute(Route route) {
        if (getRoute(route.getId())!=null){
            throw new IllegalArgumentException("Id %s is already exists".formatted(route.getId()));
        }
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
        Route route = getRoute(routeId);
        if (route != null) {
            route.setPopularity(route.getPopularity() + 1);
        }
    }

    public void display() {
        linkedList.display();
    }


    @Override
    public Iterable<Route> searchRoutes(String startPoint, String destinationPoint) {
        LinkedList<Route> result = new LinkedList<>();


        for (Route route : linkedList) {
            LinkedList<String> locationPoints = route.getLocationPoints();

            if (locationPoints.get(0).equals(startPoint) && locationPoints.get(locationPoints.getSize() - 1).equals(destinationPoint)) {
                result.add(route);


            }
        }
        if (result.getSize() > 1) {
            firstSort(result);
        }

        return result;
    }

    private void firstSort(LinkedList<Route> result) {
        for (int i = 0; i < result.getSize(); i++) {
            for (int j = 0; j < result.getSize() - i - 1; j++) {
                Route route1 = result.get(j);
                Route route2 = result.get(j + 1);
                if (route1.isFavorite() != route2.isFavorite()) {
                    if (!route1.isFavorite()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    }
                } else {
                    if (route1.getLocationPoints().getSize() > route2.getLocationPoints().getSize()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    } else if (route1.getLocationPoints().getSize() == route2.getLocationPoints().getSize()) {
                        if (route1.getPopularity() < route2.getPopularity()) {
                            result.set(j, route2);
                            result.set(j + 1, route1);
                        }

                    }
                }
            }
        }
    }

    @Override
    public Iterable<Route> getFavoriteRoutes(String destinationPoint) {
        LinkedList<Route> result = new LinkedList<>();

        for (Route route : linkedList) {
            // System.out.println(route.toString());
            // System.out.println(route.getLocationPoints().contains(destinationPoint));
            if (route.isFavorite() && route.getLocationPoints().contains(destinationPoint)) {
                if (!route.getLocationPoints().getHead().getData().equals(destinationPoint)) {
                    result.add(route);
                    // System.out.println(route.toString());
                }
            }
        }

        if (result.getSize() > 1) {
            bubbleSortForFavoriteRoutes(result);
        }

        return result;
    }


    private void bubbleSortForFavoriteRoutes(LinkedList<Route> result) {
        for (int i = 0; i < result.getSize() - 1; i++) {
            for (int j = 0; j < result.getSize() - 1 - i; j++) {
                Route route1 = result.get(j);
                Route route2 = result.get(j + 1);
                if (route1.isFavorite() != route2.isFavorite()) {
                    if (!route1.isFavorite()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    }
                }
                else if (route1.getDistance() > route2.getDistance()) {
                    result.set(j, route2);
                    result.set(j + 1, route1);
                } else if (route1.getDistance() == route2.getDistance() && route1.getPopularity() < route2.getPopularity()) {
                    result.set(j, route2);
                    result.set(j + 1, route1);
                }

            }
        }
    }

    @Override
    public Iterable<Route> getTop3Routes() {

        if (linkedList == null || linkedList.getSize() == 0) {
            return new LinkedList<>();
        }

        LinkedList<Route> result = linkedList;

        for (int i = 0; i < result.getSize() - 1; i++) {
            for (int j = 0; j < result.getSize() - 1 - i; j++) {
                Route route1 = result.get(j);
                Route route2 = result.get(j + 1);
                if (route1.isFavorite() != route2.isFavorite()) {
                    if (!route1.isFavorite()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    }
                } else
                if (route1.getPopularity() < route2.getPopularity()) {
                    result.set(j, route2);
                    result.set(j + 1, route1);
                }
                else if (route1.getPopularity() == route2.getPopularity()) {
                    if (route1.getDistance() > route2.getDistance()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    }
                    else if (route1.getDistance() == route2.getDistance() &&
                            route1.getLocationPoints().getSize() > route2.getLocationPoints().getSize()) {
                        result.set(j, route2);
                        result.set(j + 1, route1);
                    }
                }
            }
        }

        LinkedList<Route> top5Routes = new LinkedList<>();
        for (int i = 0; i < Math.min(5, result.getSize()); i++) {
            top5Routes.add(result.get(i));
        }

        return top5Routes;
    }
}




