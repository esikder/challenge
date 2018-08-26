package todoComponent;

import helper.ApiCalls;
import helper.DataHandler;
import helper.Utility;
import io.restassured.response.Response;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ToDoDelete {
    DataHandler data =  new DataHandler();

    @Before
    public void setup() {
        Utility c =  new Utility();
        c.init();
    }
    @Test
    public void testDeleteAValidItemFromListShouldReturn200() {

        Map<String,Integer> value = new HashMap();
        value.put("testItem",1);
         List<String> id =  data.addBulkListItem((HashMap<String, Integer>) value);

        ApiCalls apiCalls = new ApiCalls();
        Response response = apiCalls.deleteItemFromList(id.get(0));
        response.then().assertThat()
                .statusCode(200);
    }


    @After
    public void cleanup() {
        Utility util =  new Utility();
        util.cleanup();
    }
}
