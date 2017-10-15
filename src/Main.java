import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Core core = new Core(new BufferedReader(new FileReader("input.txt")));
        System.out.printf(core.getEqualsStateResources());
    }
}
