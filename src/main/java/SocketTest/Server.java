package SocketTest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kevin on 16-8-11.
 */
public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(2000);
             Socket socket = server.accept();
             BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)){
            String s = br.readLine();
            pw.println(s);
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
