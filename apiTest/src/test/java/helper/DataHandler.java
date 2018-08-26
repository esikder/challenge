package helper;

import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*This class contains method for manipulating data. For different tests data needs to be created as prerequisite also data
needs to be deleted afterwards.This class provides that facility.*/
public class DataHandler {

    public List<String> addBulkListItem(HashMap<String,Integer> input){
        List<String> ids= new ArrayList<>();
        int i=0;
        for(Map.Entry<String,Integer> entry : input.entrySet()){
            Map body = new HashMap();
            body.put("name",entry.getKey() );
            body.put("done", entry.getValue());

            ApiCalls apiCalls   = new ApiCalls();
            Response response =  apiCalls.postAddItemToList( body);
            response.then().statusCode(200);
            ids.add(i,response.body().jsonPath().get("_id"));
            i++;
        }
        return ids;
    }

    public void deleteAllListItem(){
        ApiCalls apiCalls   = new ApiCalls();
        Response response = apiCalls.getAllItemFromList();
        List<String> ids= response.body().jsonPath().get("_id");

        for (String id: ids) {
            apiCalls.deleteItemFromList(id);

        }


    }

}
