package com.anongrp.hyperlite;

import com.anongrp.hyperlite.listeners.OnConnectListener;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private static Connection ourInstance = null;

    private Socket socket;
    private DataInputStream input;
    private DataOutputStream output ;
    private String host;
    private Integer port;
    public String database;

    public Boolean isConnected = false;

    public Connection() { }

    public static Connection getInstance() {
        if (ourInstance == null) {
            ourInstance = new Connection();
            return ourInstance;
        }else {
            return ourInstance;
        }
    }

    public boolean connect(String host, Integer port, String database) {
        try {
            this.database = database;
            socket = new Socket(host, port);
            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());
            isConnected = true;
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    public void connectAsync(String host, Integer port,String database, OnConnectListener callback) {
        if (this.connect(host, port, database)) {
            callback.onConnect();
        }else {
            callback.onFailed();
        }
    }
}
