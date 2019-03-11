import com.anongrp.hyperlite.Connection;
import com.anongrp.hyperlite.listeners.OnConnectListener;

public class Main {
    public static void main(String[] args) {
        Connection connection = Connection.getInstance();
        connection.connectAsync("localhost", 8989, "test.db",new OnConnectListener() {
            @Override
            public void onConnect() {
                System.out.println("Connected");
            }

            @Override
            public void onFailed() {
                System.out.println("Server is Down");
            }
        });
    }
}
