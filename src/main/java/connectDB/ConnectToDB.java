package connectDB;

import model.EmployeesModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ConnectToDB {

    private Connection connect = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    private void connect() {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/new_schema?user=root&useUnicode=true" +
                                                          "&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
        } catch (SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("VendorError: " + e.getErrorCode());
//            e.printStackTrace();
        }
    }

    public List<EmployeesModel> getEmployees(String tableName) throws SQLException {
        connect();
        preparedStatement = connect.prepareStatement(String.format("select * from %s", tableName));
        resultSet = preparedStatement
                .executeQuery();
        return getGroupList(resultSet);
    }

    public List<EmployeesModel> getGroupList(ResultSet resultSet) throws SQLException {
        List<EmployeesModel> groups = new ArrayList<>();
        while (resultSet.next()) {
            groups.add(new EmployeesModel(
                    resultSet.getString("Name"),
                    resultSet.getString("Job")));
            groups.iterator();
        }
        return groups;
    }

}
