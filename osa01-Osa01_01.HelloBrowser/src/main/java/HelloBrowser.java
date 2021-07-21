
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class HelloBrowser {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("================");
        System.out.println("THE INTERNETS!");
        System.out.println("================");
        System.out.print("Where to? ");

        String whereTo = input.nextLine();
        int port = 80;

        // create a connection to the server
        Socket socket = new Socket(whereTo, port);

        // send message to the server
PrintWriter writer = new PrintWriter(socket.getOutputStream());
        writer.println("GET / HTTP/1.1");
        writer.println("Host: " + whereTo);
        writer.println();
        writer.flush();

        System.out.println("==========");
        System.out.println("RESPONSE");
        System.out.println("==========");

        // read an answer from the server
        Scanner reader = new Scanner(socket.getInputStream());
        while (reader.hasNext()) {
            System.out.println(reader.nextLine());
        }

        socket.close();
        input.close();
    }
}
