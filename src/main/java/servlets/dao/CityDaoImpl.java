package servlets.dao;



import servlets.connectionManager.ConnectionManager;
import servlets.connectionManager.ConnectionManagerJdbcImpl;
import servlets.pojo.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CityDaoImpl implements CityDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();
    public City getCitById(Integer id) {
        Connection connection = connectionManager.getConnection();
        City city = null;
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from city WHERE city_id = ?");
        ) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    city = new City(resultSet.getInt("city_id"),
                            resultSet.getString("city_name"),
                            resultSet.getInt("citizens"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return city;
    }
}
