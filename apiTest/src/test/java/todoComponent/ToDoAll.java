package todoComponent;

import helper.ApiCalls;
import helper.DataHandler;
import helper.Utility;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasItem;

public class ToDoAll {
    DataHandler data =  new DataHandler();

    @Before
    public void setup() {
        Utility c =  new Utility();
        c.init();
    }

    @Test
    public void testListPopulationReturns200WithValidName() {

        Map<String,Integer> value = new HashMap();
        value.put("111testing",1);
        value.put("122testing",1);
        data.addBulkListItem((HashMap<String, Integer>) value);

        ApiCalls apiCalls = new ApiCalls();
        Response response = apiCalls.getAllItemFromList();
        response.then().assertThat()
                .statusCode(200)
                .body("name",hasItem("111testing"))
                .body( "name" ,hasItem("122testing"));

    }
    @Test
    public void testEmptyListLoadReturns200() {

        ApiCalls apiCalls = new ApiCalls();
        Response response = apiCalls.getAllItemFromList();
        response.then().assertThat()
                .statusCode(200);

    }
    @After
    public void cleanup() {
        Utility util =  new Utility();
        util.cleanup();
    }

}
