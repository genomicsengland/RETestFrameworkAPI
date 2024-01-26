package api.test;

import api.endpoints.UserEndPoints;
import api.payload.UserModel;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    Faker faker;
    UserModel userPayload;
    public Logger logger;
    @BeforeClass
    public void setup()
    {
        faker = new Faker();
        userPayload = new UserModel();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        //Logs

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority = 1)
    public void testPostUser()
    {
        logger.info("*********Creating User*************");
        Response response = UserEndPoints.createUser(this.userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("****************User is created************");
    }
    @Test(priority=2)
    public void testGetUserByName()
    {
        logger.info("*********Reading User info *************");
        Response response = UserEndPoints.readUser(this.userPayload.getUsername());
       response.then().log().all();
       Assert.assertEquals(response.getStatusCode(),200);
        logger.info("*********User info Displayed*************");
    }
    @Test(priority = 3)
    public void testUpdateuserByName()
    {
        //Update data using payload
        logger.info("*********Updating User*************");
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);

        //Checking data after updation

        Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getUsername());
        responseAfterUpdate.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("*********User info updated*************");
    }
    @Test(priority = 4)
    public void testDeleteUserByName()
    {
        logger.info("*********Deleting User*************");
        Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("*********User Deleted*************");
    }

}
