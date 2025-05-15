import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class City {
    private String capital;
    private String timeZone;
    private String latitude;
    private String longitude;

    private static City parseLine(String line) {
        City city = new City();

        List<String> cityData = Arrays.stream(line.split(",")).toList();
        city.capital = cityData.get(0);
        city.timeZone = cityData.get(1);
        city.latitude = cityData.get(2);
        city.longitude = cityData.get(3);

        return city;
    }

    public static Map<String, City> parseFile(String pathToFile) {
        Map<String, City> map = new HashMap<>();
        List<City> cities = new ArrayList<>();
        File file = new File(pathToFile);
        StringBuilder result = new StringBuilder();
        try {
            FileReader reader = new FileReader(file);
            int next;
            while (reader.read() != '\n') {}
            while ((next = reader.read()) != -1) {
                result.append((char) next);
                if ((char) next == '\n') {
                    City city = parseLine(result.toString());
                    cities.add(city);
                    result.delete(0, result.length());
                }
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Cannot access: " + file.getName());
        }

        for (City city : cities) {
            map.put(city.capital, city);
        }

        return map;
    }
}
