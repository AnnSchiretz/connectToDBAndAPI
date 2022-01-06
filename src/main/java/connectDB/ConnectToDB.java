package connectDB;

import model.ArtistModel;

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

    private void connect() throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException {
        try {
            connect = DriverManager.getConnection("jdbc:mysql://localhost/",
                                                  "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ArtistModel> getArtists(String tableName) throws SQLException, ClassNotFoundException,
            InstantiationException, IllegalAccessException {
        connect();
        preparedStatement = connect.prepareStatement(String.format("select * from %s", tableName));
        resultSet = preparedStatement
                .executeQuery();
        return getGroupList(resultSet);
    }

    public List<ArtistModel> getGroupList(ResultSet resultSet) throws SQLException {
        List<ArtistModel> groups = new ArrayList<>();
        while (resultSet.next()) {
            groups.add(new ArtistModel(
                    resultSet.getInt("ArtistId"),
                    resultSet.getString("Name")));
            groups.iterator();
        }
        return groups;
    }

}
