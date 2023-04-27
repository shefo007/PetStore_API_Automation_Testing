package api.test;

import api.endpoints.User_EndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static api.endpoints.User_EndPoints2.*;

// This userTests2 test class is for using routes for properties file
public class UserTests2 {

    Faker faker;
    User userPayload;

    public Logger logger;

    @BeforeClass
    public void setUp() {

        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password(5, 10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        // Logs
        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority = 1)
    public void testPostUser() {
        logger.info("********** Creating User **********");

        Response response = createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("********** User is created Successfully **********");

    }

    @Test(priority = 2)
    public void testGetUserByName() {
        logger.info("********** Reading User Info **********");

        Response response = readUser(userPayload.getUsername());
        response.then().log().body();

        Assert.assertEquals(response.statusCode(), 200);

        logger.info("********** User Info is displayed Successfully **********");
    }

    @Test(priority = 3)
    public void testUpdateUserByName() {
        logger.info("********** Updating User **********");

        // We will update some data
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = User_EndPoints.updateUser(userPayload.getUsername(), userPayload);

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("********** User is Updated Successfully **********");

        // Checking data after update
        Response responseAfterUpdate = readUser(userPayload.getUsername());
        responseAfterUpdate.then().log().body();
        Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);

    }

    @Test(priority = 4)
    public void testDeleteUserByName() {
        logger.info("********** Deleting User **********");

        Response response = deleteUser(userPayload.getUsername());

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("********** User is Deleted Successfully **********");
    }
}
