import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, City> cities = City.parseFile("./strefy.csv");
        DigitalClock clock = new DigitalClock(DigitalClock.TimeType.FULL, cities.get("Warszawa"));
        clock.setTime(23, 15, 30);
        clock.setCity(cities.get("Warszawa"));
        System.out.println(clock);
    }
}