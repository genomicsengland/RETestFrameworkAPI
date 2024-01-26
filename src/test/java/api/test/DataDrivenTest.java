package api.test;

import api.endpoints.UserEndPoints;
import api.payload.UserModel;
import api.utilities.DataProviders;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUser(String userID, String UserName, String FirstName, String LastName, String Email,String Password, String Phone)
    {
        Faker faker = new Faker();

        UserModel userPayLoad = new UserModel();
        userPayLoad.setId(faker.idNumber().hashCode());
        userPayLoad.setUsername(UserName);
        userPayLoad.setFirstName(FirstName);
        userPayLoad.setLastName(LastName);
        userPayLoad.setEmail(Email);
        userPayLoad.setPassword(Password);
        userPayLoad.setPhone(Phone);

        Response response = UserEndPoints.createUser(userPayLoad);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
    }

    @Test(priority = 2,dataProvider = "UserNames" , dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName)
    {
        Response response = UserEndPoints.deleteUser(userName);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
    }
}
