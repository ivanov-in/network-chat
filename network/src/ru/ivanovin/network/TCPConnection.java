package ru.ivanovin.network;

import java.io.*;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class TCPConnection {
    private final Socket socket;
    private final Thread rxThread;
    private final TCPConnectionListener eventListener;
    private final BufferedReader input;
    private final BufferedWriter output;

    public TCPConnection (TCPConnectionListener eventListener,Socket socket) throws IOException {
        this.eventListener = eventListener;
        this.socket = socket;
        input = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));
        rxThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String msg = input.readLine();
                } catch (IOException e) {

                } finally {

                }
            }
        });
        rxThread.start();
    }
}
