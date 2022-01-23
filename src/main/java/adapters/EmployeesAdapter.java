package adapters;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.EmployeesModel;
import model.JobUser;
import org.apache.http.protocol.HTTP;

import static io.restassured.RestAssured.given;

public class EmployeesAdapter extends Adapter {


    public JobUser post(String path, EmployeesModel employee) {
        Response response =
                given()
                        .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                        .body(gson.toJson(employee))
                        .log().body()
                        .when()
                        .post(path)
                        .then()
                        .statusCode(201)
                        .contentType(ContentType.JSON).extract().response();
        return gson.fromJson(response.asString().trim(), JobUser.class);
    }


}
