
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HelloRedirectLoop {

    public static void main(String[] args) throws Exception {

        // open server on a port 8080
        ServerSocket server = new ServerSocket(8080);

        while (true) {
            // listen for requests
            Socket socket = server.accept();

            // read request
            Scanner reader = new Scanner(socket.getInputStream());

            if (reader.nextLine().contains("/quit")) {
                break;
            }

            // reply
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println("HTTP/1.1 302 Found");
            writer.println("Location: http://localhost:8080");
            writer.println();

            // close up everything
            writer.close();
            reader.close();
            socket.close();

        }

        server.close();

    }
}
