package sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {

    private Socket client_socket;

    public Client(String hostname, int port) throws IOException {
        this.client_socket = new Socket(hostname, port);
    }

    public void sendMessage(String message) throws IOException {
        OutputStream outputStream = this.client_socket.getOutputStream();
        DataOutputStream out = new DataOutputStream(outputStream);
        out.writeUTF(message);
    }
}
