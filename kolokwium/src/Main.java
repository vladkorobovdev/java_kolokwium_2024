import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, City> cities = City.parseFile("./strefy.csv");
        AnalogClock clock = new AnalogClock(cities.get("Warszawa"));
        clock.setTime(23, 15, 30);

        clock.toSvg("./clock.svg");
    }
}