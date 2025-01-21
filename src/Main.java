import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        NavigatorImpl navigator = new NavigatorImpl();

        Route route2 = new Route("2", 1500, true, 4, new LinkedList<>(Arrays.asList("Тверь", "Санкт-Петерсбург")));
        Route route3 = new Route("3", 3000, false, 10, new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург")));
        Route route4 = new Route("4", 2000, true, 2, new LinkedList<>(Arrays.asList("Москва", "Тверь", "Санкт-Петерсбург")));
        Route route5 = new Route("5", 3500, true, 0, new LinkedList<>(Arrays.asList("Москва", "Казань", "Владимир", "Великий Новгород", "Санкт-Петерсбург")));
        Route route6 = new Route("6", 1200, false, 7, new LinkedList<>(Arrays.asList("Москва", "Казань", "Вологда", "Санкт-Петерсбург")));
        Route route7 = new Route("7", 700, true, 8, new LinkedList<>(Arrays.asList("Москва", "Тула", "Санкт-Петерсбург")));
        Route route8 = new Route("8", 1000, true, 9, new LinkedList<>(Arrays.asList("Москва", "Волоколамск", "Санкт-Петерсбург")));
        Route route9 = new Route("9", 1000, true, 3, new LinkedList<>(Arrays.asList("Москва", "Воронеж", "Тверь", "Санкт-Петерсбург")));
        Route route10 = new Route("19", 2400, true, 6, new LinkedList<>(Arrays.asList("Казань", "Нижний Новгород")));

        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);
        navigator.addRoute(route6);
        navigator.addRoute(route7);
        navigator.addRoute(route8);
        navigator.addRoute(route9);
        navigator.addRoute(route10);*/

        String startPoint = "Москва";
        String destinationPoint = "Санкт-Петерсбург";

        System.out.println("Маршруты до первой сортировки");
        navigator.display();

        LinkedList<Route> resultSearchList = (LinkedList<Route>) navigator.searchRoutes(startPoint, destinationPoint);
        System.out.println("После первой сортировки");
        for (Route route : resultSearchList) {
            System.out.println(route.toString());
        }

        Route route1 = new Route("1", 3000, true, 4, new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург", "Сызрань", "Вологда")));

        Route route2 = new Route("2", 1500, true, 4, new LinkedList<>(Arrays.asList("Санкт-Петерсбург", "Тверь")));
        Route route3 = new Route("3", 3000, false, 10, new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург")));
        Route route4 = new Route("4", 2000, true, 2, new LinkedList<>(Arrays.asList("Москва", "Тверь", "Санкт-Петерсбург")));
        Route route5 = new Route("5", 3500, true, 0, new LinkedList<>(Arrays.asList("Владимир", "Москва", "Казань", "Великий Новгород")));
        Route route6 = new Route("6", 1200, false, 7, new LinkedList<>(Arrays.asList("Москва", "Казань", "Вологда", "Санкт-Петерсбург")));
        Route route7 = new Route("7", 700, false, 8, new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург", "Архангельск")));
        Route route8 = new Route("8", 1000, true, 9, new LinkedList<>(Arrays.asList("Москва", "Волоколамск", "Санкт-Петерсбург")));
        Route route9 = new Route("9", 2000, true, 3, new LinkedList<>(Arrays.asList("Москва", "Воронеж", "Санкт-Петерсбург", "Тверь")));
        Route route10 = new Route("10", 2400, true, 6, new LinkedList<>(Arrays.asList("Санкт-Петерсбург", "Нижний Новгород")));
        Route route11 = new Route("11", 3000, true, 8, new LinkedList<>(Arrays.asList("Казань", "Санкт-Петерсбург")));
        Route route12 = new Route("12", 2000, true, 12, new LinkedList<>(Arrays.asList("Москва", "Владимир", "Санкт-Петерсбург", "Тверь")));
        Route route13 = new Route("13", 1400, true, 2, new LinkedList<>(Arrays.asList("Москва", "Владимир", "Воронеж", "Тверь")));

        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);
        navigator.addRoute(route6);
        navigator.addRoute(route7);
        navigator.addRoute(route8);
        navigator.addRoute(route9);
        navigator.addRoute(route10);
        navigator.addRoute(route11);
        navigator.addRoute(route12);
        navigator.addRoute(route13);


        System.out.println("Маршруты до второй сортировки");
        navigator.display();

        //  navigator.display();
        String destinationPoint = "Санкт-Петерсбург";

        LinkedList<Route> getFavoriteRoutesResult = (LinkedList<Route>) navigator.getFavoriteRoutes(destinationPoint);
        System.out.println("Маршруты после второй сортировки содержащие не начальную точку - Санкт-Петерсбург");
        for (Route route : getFavoriteRoutesResult) {
            System.out.println(route.toString());
        }





/*        navigator.removeRoute(route4.getId());
        System.out.println("Вывод связного списка после удаления 4-го маршрута");
        navigator.display();

        navigator.chooseRoute("2");
        navigator.chooseRoute("2");
        navigator.chooseRoute("2");
        navigator.chooseRoute("2");
        navigator.chooseRoute("1");
        navigator.chooseRoute("3");

        navigator.chooseRoute("1");*/

/*
        Route route1 = new Route("1", 3000, true, 4, new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург", "Сызрань","Вологда")));
        Route route2 =new Route("2", 4500, true,10, new LinkedList<>(Arrays.asList("Санкт-Петерсбург", "Тверь")));
        Route route3 =new Route("3", 4500, false,10,new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург")));
        Route route4 =new Route("4", 4500,true, 10, new LinkedList<>(Arrays.asList("Москва", "Тверь","Санкт-Петерсбург")));
        Route route5 =new Route("5", 3500,true, 0 ,new LinkedList<>(Arrays.asList("Владимир", "Москва", "Казань","Великий Новгород")));
        Route route6 =new Route("6", 1200,false, 7, new LinkedList<>(Arrays.asList("Москва", "Казань", "Вологда","Санкт-Петерсбург")));
        Route route7 =new Route("7", 700,false, 8,new LinkedList<>(Arrays.asList("Москва", "Санкт-Петерсбург","Архангельск")));
        Route route8 =new Route("8", 4500,false, 9,new LinkedList<>(Arrays.asList("Москва", "Волоколамск","Санкт-Петерсбург")));
        Route route9 =new Route("9", 2000,true, 3,new LinkedList<>(Arrays.asList("Москва","Воронеж","Санкт-Петерсбург","Тверь")));
        Route route10 =new Route("10", 2400, true,12, new LinkedList<>(Arrays.asList("Санкт-Петерсбург", "Нижний Новгород")));
        Route route11 =new Route("11", 3000, true,8, new LinkedList<>(Arrays.asList("Казань", "Санкт-Петерсбург")));
        Route route12 =new Route("12", 3500,true, 12,new LinkedList<>(Arrays.asList("Москва","Владимир","Санкт-Петерсбург","Тверь")));

        Route route13 =new Route("13", 1400,false, 9,new LinkedList<>(Arrays.asList("Москва","Владимир","Воронеж","Тверь")));

        navigator.addRoute(route1);
        navigator.addRoute(route2);
        navigator.addRoute(route3);
        navigator.addRoute(route4);
        navigator.addRoute(route5);
        navigator.addRoute(route6);
        navigator.addRoute(route7);
        navigator.addRoute(route8);
        navigator.addRoute(route9);
        navigator.addRoute(route10);
        navigator.addRoute(route11);
        navigator.addRoute(route12);
        navigator.addRoute(route13);


        System.out.println("Маршруты до третьей сортировки");
        navigator.display();

        //  navigator.display();
        String destinationPoint="Санкт-Петерсбург";

        LinkedList<Route> getTop5RoutesResult= (LinkedList<Route>) navigator.getTop3Routes();
        System.out.println("Маршруты после третьей сортировки");
        for (Route route : getTop5RoutesResult){
            System.out.println(route.toString());
        }
*/


    }
}