package sockets;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket server_socket;

    public Server(int port) throws IOException {
        this.server_socket = new ServerSocket(port);
    }

    public String recvMessage() throws IOException {
        Socket client_socket = this.server_socket.accept();
        DataInputStream in = new DataInputStream(client_socket.getInputStream());
        String message = in.readUTF();
        return message;
    }
}
