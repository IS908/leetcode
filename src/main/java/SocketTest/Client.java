package SocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by kevin on 16-8-11.
 */
public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 2000);
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)){
            pw.println("Hello");
            String s = null;
            while (true) {
                s = br.readLine();
                if (s!=null) {
                    break;
                }
            }
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
