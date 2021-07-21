
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class HelloServer {

    public static void main(String[] args) throws Exception {

        // open server on port 8080
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // waiting for request
            Socket socket = server.accept();

            // reading request
            Scanner reader = new Scanner(socket.getInputStream());

            if (reader.nextLine().contains("/quit")) {
                break;
            }

            // reply
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("HTTP/1.1 200 OK");
            writer.println();
            Files.lines(Paths.get("osa01-Osa01_02.HelloServer/index.html")).forEach(writer::println);

            // close up
            writer.close();
            reader.close();
            socket.close();

        }

        server.close();

    }
}
