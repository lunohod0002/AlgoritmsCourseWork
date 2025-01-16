import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        NavigatorImpl navigator = new NavigatorImpl();
        Route route1 = new Route("1", 100, new LinkedList<>(Arrays.asList("Москва", "Воронеж")));
        Route route2 =new Route("2", 900, new LinkedList<>(Arrays.asList("Санкт-Петерсбург", "Москва")));
        Route route3 =new Route("3", 1200, new LinkedList<>(Arrays.asList("Москва", "Ростов")));
        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.removeRoute(route1.getId());
        System.out.println(navigator.contains(route1));
        navigator.display();
        navigator.chooseRoute("2");
        navigator.chooseRoute("2");
        navigator.display();


    }
}