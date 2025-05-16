import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AnalogClock extends Clock {
    public AnalogClock(City city) {
        super(city);
    }

    public void toSvg(String pathToFile) {
        File file = new File(pathToFile);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write("<svg width=\"200\" height=\"200\" viewBox=\"-100 -100 200 200\" xmlns=\"http://www.w3.org/2000/svg\">\n" +
                    " <circle cx=\"0\" cy=\"0\" r=\"90\" fill=\"none\" stroke=\"black\" stroke-width=\"2\" />\n" +
                    "<g text-anchor=\"middle\">\n" +
                    "  <text x=\"0\" y=\"-80\" dy=\"6\">12</text>\n" +
                    "  <text x=\"80\" y=\"0\" dy=\"4\">3</text>\n" +
                    "  <text x=\"0\" y=\"80\" dy=\"6\">6</text>\n" +
                    "  <text x=\"-80\" y=\"0\" dy=\"4\">9</text>\n" +
                    " </g>\n" +
                    "</svg>");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.err.println("Cannot access: " + file.getName());
        }
    }
}