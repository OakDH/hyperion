package io.github.oakdh.hyperion;
/*
    import javafx.application.Application;
    import javafx.scene.chart.PieChart.Data;
    import javafx.stage.Stage;
 */

import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class apphandler {

    public static void sendMessage() throws Exception {

        Socket sock = new Socket("localhost", 1025);
        String message1 = "GET /hello_world 1.1\n\n";

        OutputStream ostream = sock.getOutputStream();
        DataOutputStream dos = new DataOutputStream(ostream);
        dos.writeBytes(message1);
        dos.close();
        ostream.close();
        sock.close();
    }
}

/*
 * import java.net.Socket;
 * import java.io.OutputStream;
 * import java.io.DataOutputStream;
 * 
 * public class WishesClient
 * {
 * public static void main(String args[]) throws Exception
 * {
 * Socket sock = new Socket("127.0.0.1", 5000);
 * String message1 = "Accept Best Wishes, Serverji";
 * 
 * OutputStream ostream = sock.getOutputStream();
 * DataOutputStream dos = new DataOutputStream(ostream);
 * dos.writeBytes(message1);
 * dos.close();
 * ostream.close();
 * sock.close();
 * }
 * }
 */
