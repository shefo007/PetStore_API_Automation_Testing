package api.test;

import api.endpoints.User_EndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class DDTests {

    Faker faker;

    @Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
    public void testPostUsers(String userID, String userName, String fName, String lName, String email, String password, String phone) {

        User user = new User();

        user.setId(Integer.parseInt(userID));
        user.setUsername(userName);
        user.setFirstName(fName);
        user.setLastName(lName);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        Response response = User_EndPoints.createUser(user);

        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Test(priority = 2,dataProvider = "UserNames", dataProviderClass = DataProviders.class)
    public void testDeleteUserByName(String userName) {

        Response response = User_EndPoints.deleteUser(userName);

        Assert.assertEquals(response.getStatusCode(), 200);
    }
}
