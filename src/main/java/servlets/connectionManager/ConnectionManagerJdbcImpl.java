package servlets.connectionManager;



import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManagerJdbcImpl implements ConnectionManager{
    private static ConnectionManager connectionManager;
//    private static final Logger LOGGER = Logger.getLogger(ConnectionManagerJdbcImpl.class);

    private ConnectionManagerJdbcImpl(){
    }

    public static ConnectionManager getInstance(){
        if(connectionManager == null){
            connectionManager = new ConnectionManagerJdbcImpl();
//            LOGGER.info("this good");
        }
        return connectionManager;
    }

    @Override
    public Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/test",
                    "postgres",
                    "root");
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
