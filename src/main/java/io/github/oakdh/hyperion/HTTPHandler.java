package io.github.oakdh.hyperion;

import java.net.Socket;

import org.json.JSONObject;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HTTPHandler {

    private static Socket conn;

    public static boolean init()
    {
        try
        {
            conn = new Socket("localhost", 1025);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static boolean cleanup()
    {
        try
        {
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    public static JSONObject sendMessage(String path)
    {
        try
        {
            String message = String.format("GET /%s 1.1\n\n", path);

            InputStream inputStream = conn.getInputStream();
            BufferedReader isReader = new BufferedReader(new InputStreamReader(inputStream));

            OutputStream outStream = conn.getOutputStream();
            PrintWriter outWriter = new PrintWriter(outStream, true);

            outWriter.print(message);
            outWriter.flush();

            String response = "";
            String line = null;
            boolean emptyLinePassed = false;
            int contentLengthLeft = -1;
            while ((line = isReader.readLine()) != null)
            {
                if (line.startsWith("Content-Length: ") && !emptyLinePassed)
                {
                    contentLengthLeft = Integer.parseInt(line.substring("Content-Length: ".length()));
                }
                
                if (emptyLinePassed)
                {
                    response += line + "\n";
                    contentLengthLeft -= line.length();
                }

                if (line.trim().isEmpty() && !emptyLinePassed)
                {
                    emptyLinePassed = true;
                }

                if (emptyLinePassed && contentLengthLeft == 0) break;
            }
        
            return new JSONObject(response);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return new JSONObject();
        }
    }
}
