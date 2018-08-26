package todoComponent;

import helper.ApiCalls;
import helper.Utility;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class ToDoAdd {

    @Before
    public void setup() {
        Utility util =  new Utility();
        util.init();
    }

    @Test
    public void testAddItemToListValidItemNameShouldReturnIdStatus200(){
        String itemName = "testing";
        Integer done = 1;

        Map body = new HashMap();
        body.put("name", itemName);
        body.put("done", done);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postAddItemToList( body);
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(itemName))
                .body("done", Matchers.is(false))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.notNullValue());
    }

    @Test
    public void testAddItemToListWithSpecialKeyboarCharInName(){
        String itemName = "!@#$%^&*()_+|}{:?><~`";
        Integer done = 1;

        Map body = new HashMap();
        body.put("name", itemName);
        body.put("done", done);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postAddItemToList( body);
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(itemName))
                .body("done", Matchers.is(false))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.notNullValue());
    }

    @Test
    public void testAddItemToListWithNullNameNullDoneShouldReturn200(){

        Map body = new HashMap();
        body.put("name", null);
        body.put("done", null);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postAddItemToList( body);
        response.then().assertThat()
                .statusCode(200)
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.notNullValue());
    }
    @Test
    public void testAddItemToListWithoutItemName(){
        Integer done = 1;

        Map body = new HashMap();
        body.put("done", done);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postAddItemToList( body);
        response.then().assertThat()
                .statusCode(200)
                .body("done", Matchers.is(false))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.notNullValue());
    }

    @After
    public void cleanup() {
        Utility util =  new Utility();
        util.cleanup();
    }

}
