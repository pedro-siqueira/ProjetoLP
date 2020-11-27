import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class ClientCount {
    public static int getLast() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("LastClient.txt"));
        return Integer.parseInt(br.readLine());
    }

    public static void incrementa() throws IOException {
        int lastId = getLast();
        FileWriter fw = new FileWriter("LastClient.txt");
        fw.write(String.valueOf(lastId + 1));
        fw.close();
    }
}