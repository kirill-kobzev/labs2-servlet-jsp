package servlets.dao;



import servlets.connectionManager.ConnectionManager;
import servlets.connectionManager.ConnectionManagerJdbcImpl;
import servlets.pojo.City;
import servlets.pojo.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private static ConnectionManager connectionManager = ConnectionManagerJdbcImpl.getInstance();

    @Override
    public List<Student> getAllStudents() {
        List<Student> result = new ArrayList<>();
        Connection connection = connectionManager.getConnection();
        try (PreparedStatement statement = connection.prepareStatement(
                "SELECT * from students LEFT JOIN city on students.city = city.city_id");
        ) {

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    result.add(new Student(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("family_name"),
                            resultSet.getInt("age"),
                            resultSet.getString("contact"),
                            new City(resultSet.getInt("city_id"),
                                    resultSet.getString("city_name"),
                                    resultSet.getInt("citizens"))));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

}