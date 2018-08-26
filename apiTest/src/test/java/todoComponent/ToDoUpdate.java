package todoComponent;

import helper.ApiCalls;
import helper.DataHandler;
import helper.Utility;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ToDoUpdate {
    DataHandler data =  new DataHandler();

    @Before
    public void setup() {
        Utility c =  new Utility();
        c.init();
    }
    @Test @Ignore("api implementarion is wrong")
    public void testUpdateNameOfListItem() {

        String name = "updateTest";
        Map<String,Integer> value = new HashMap();
        value.put(name,1);
        List<String> id = data.addBulkListItem((HashMap<String, Integer>) value);

        String updatedName = "updateTest_Updated";

        Map body = new HashMap();
        body.put("_id", id.get(0));
        body.put("done", false);
        body.put("__v", 0);
        body.put("editing",false);
        body.put("name",updatedName);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postUpdateItemInList( body,id.get(0));
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(updatedName))
                .body("done", Matchers.is(false))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.is(id.get(0)));

    }
    @Test @Ignore("api implementarion is wrong")
    public void testUpdateEmptyNameOfItemInListAndCompleteItem() {

        String name = "updateTest";
        Map<String,Integer> value = new HashMap();
        value.put(name,1);
        List<String> id = data.addBulkListItem((HashMap<String, Integer>) value);

        String updatedName = "";
        Boolean done = true;

        Map body = new HashMap();
        body.put("_id", id.get(0));
        body.put("done", done);
        body.put("__v", 0);
        body.put("editing",false);
        body.put("name",updatedName);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postUpdateItemInList( body,id.get(0));
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(updatedName))
                .body("done", Matchers.is(done))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.is(id.get(0)));

    }

    @Test @Ignore("api implementarion is wrong")
    public void testCompleteItemInList() {

        String name= "updateTest";
        Map<String,Integer> value = new HashMap();
        value.put("updateTest",1);
        List<String> id = data.addBulkListItem((HashMap<String, Integer>) value);

        Boolean done =true;
        Map body = new HashMap();
        body.put("_id", id.get(0));
        body.put("done", done);
        body.put("__v", 0);
        body.put("editing",false);
        body.put("name",name);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postUpdateItemInList( body,id.get(0));
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(name))
                .body("done", Matchers.is(done))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.is(id.get(0)));

    }
    @Test @Ignore("api implementarion is wrong")
    public void testNotCompleteItemInList() {

        String name= "updateTest";
        Map<String,Integer> value = new HashMap();
        value.put("updateTest",1);
        List<String> id = data.addBulkListItem((HashMap<String, Integer>) value);

        Map body = new HashMap();
        body.put("_id", id.get(0));
        body.put("done", false);
        body.put("__v", 0);
        body.put("editing",false);
        body.put("name",name);

        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.postUpdateItemInList( body,id.get(0));
        response.then().assertThat()
                .statusCode(200)
                .body("name",Matchers.is(name))
                .body("done", Matchers.is(false))
                .body("__v", Matchers.is(0))
                .body("_id",Matchers.is(id.get(0)));

    }

    @After
    public void cleanup() {
        Utility util =  new Utility();
        util.cleanup();
    }

}
