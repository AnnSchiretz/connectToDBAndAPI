import adapters.EmployeesAdapter;
import connectDB.ConnectToDB;
import model.EmployeesModel;
import model.JobUser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class ConnectToDBAndSendRequestsToApiTest {

    public EmployeesModel anyEmployee = null;

    @BeforeTest
    public static ConnectToDB connectToDB() {
        return new ConnectToDB();
    }

    @Test
    public void getDataFromDB() throws SQLException {
        List<EmployeesModel> artistsList = connectToDB().getEmployees("new_schema.Employ");
        artistsList.forEach(System.out::println);
        anyEmployee = artistsList.get(artistsList.size() - 3);
        System.out.println(anyEmployee.toString());
        System.out.println(System.getProperty("java.ext.dirs"));
    }

    @Test
    public void setNewUserFromDBToApi() throws SQLException {
        List<EmployeesModel> artistsList = connectToDB().getEmployees("new_schema.Employ");
        anyEmployee = artistsList.get(artistsList.size() - 3);
        JobUser result = new EmployeesAdapter().post("https://reqres.in/api/users/2", anyEmployee);

        assertThat(anyEmployee.getName(), equalTo(result.getName()));
    }

}
