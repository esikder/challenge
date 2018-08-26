package helper;

import io.restassured.RestAssured;
/*This class contains the functions for @Before and @After method. Wanted to keep it common across tests and for
changing anything will not need to modify in multiple places.*/
public class Utility {

    public void init()  {

        RestAssured.basePath = ConfigHandler.getConfigValue(("basePath"));
        RestAssured.baseURI = ConfigHandler.getConfigValue(("baseURI"));
        RestAssured.port = Integer.parseInt( ConfigHandler.getConfigValue(("port")));

    }

    public void cleanup() {
        DataHandler dataHandler = new DataHandler();
        dataHandler.deleteAllListItem();
    }
}
