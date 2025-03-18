package creational;

import java.util.*;

class DatabaseConnection {
    private static int counter = 1;
    private int id;

    public DatabaseConnection() {
        this.id = counter++;
    }

    public void connect() {
        System.out.println("Using Connection: " + id);
    }
}

class ConnectionPool {
    private final List<DatabaseConnection> availableConnections = new ArrayList<>();
    private final List<DatabaseConnection> usedConnections = new ArrayList<>();
    private final int MAX_CONNECTIONS = 3;

    public DatabaseConnection getConnection() {
        if (availableConnections.isEmpty() && usedConnections.size() < MAX_CONNECTIONS) {
            availableConnections.add(new DatabaseConnection());
        }
        if (!availableConnections.isEmpty()) {
            DatabaseConnection connection = availableConnections.remove(0);
            usedConnections.add(connection);
            return connection;
        }
        throw new RuntimeException("No available connections!");
    }

    public void releaseConnection(DatabaseConnection connection) {
        usedConnections.remove(connection);
        availableConnections.add(connection);
    }
}

public class ObjectPoolFactory {
    public static void main(String[] args) {
        ConnectionPool pool = new ConnectionPool();

        DatabaseConnection conn1 = pool.getConnection();
        conn1.connect();

        DatabaseConnection conn2 = pool.getConnection();
        conn2.connect();

        pool.releaseConnection(conn1);

        DatabaseConnection conn3 = pool.getConnection();
        conn3.connect();
    }
}
