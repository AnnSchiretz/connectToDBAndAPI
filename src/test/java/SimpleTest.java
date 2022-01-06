import connectDB.ConnectToDB;
import model.ArtistModel;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

public class SimpleTest {

    @Test
    public static void getData() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        ConnectToDB connection = new ConnectToDB();
        List<ArtistModel> ala = connection.getArtists("new_schema.Artists");
        ala.stream().forEach(System.out::println);
    }


}
