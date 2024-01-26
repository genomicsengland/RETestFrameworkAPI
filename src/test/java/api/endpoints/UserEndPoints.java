package api.endpoints;

import api.payload.UserModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Created to perform CRUD operations in the USER api
public class UserEndPoints {

    public static Response createUser(UserModel payload)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.post_basePath)
                                            .contentType(ContentType.JSON)
                                            .accept(ContentType.JSON)
                                            .body(payload)
                                        .when()
                                            .post();
        return response;
    }
    public static Response readUser(String userName)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.get_basePath)
                                            .pathParam("username",userName)
                                            .accept(ContentType.JSON)
                                        .when()
                                            .get();
        return response;
    }
    public static Response updateUser(String UserName,UserModel payload)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.update_basePath)
                                            .pathParam("username",UserName)
                                            .contentType(ContentType.JSON)
                                            .accept(ContentType.JSON)
                                            .body(payload)
                                        .when()
                                            .put();
        return response;
    }
    public static Response deleteUser(String userName)
    {
        Response response = RestAssured.given()
                                            .baseUri(Routes.base_uri)
                                            .basePath(Routes.delete_basePath)
                                            .pathParam("username",userName)
                                            .accept(ContentType.JSON)
                                        .when()
                                            .delete();
        return response;
    }


}
