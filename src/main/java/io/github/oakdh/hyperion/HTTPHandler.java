package io.github.oakdh.hyperion;

import java.net.Socket;
import java.io.OutputStream;
import java.io.DataOutputStream;

public class HTTPHandler {

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
