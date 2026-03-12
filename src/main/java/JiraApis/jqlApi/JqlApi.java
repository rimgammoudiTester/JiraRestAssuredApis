package JiraApis.jqlApi;
import io.restassured.response.Response;
import java.util.HashMap;

import static Bases.Api.GenericApiCalls.*;

public class JqlApi {


    /**@Author Rim Gammoudi ***
     * Qa Automation Engineer
     */

    //Method useful for create a group
    public static Response createAJql(String baseUrl, HashMap<String, Object> map, String postEndpoint, Object payloadToSent, String email, String token)
    {
        Response res;

        return res=createAnObject(baseUrl,map,postEndpoint,payloadToSent,email,token);
    }

    //Method useful for extracting a Group

  //  public static Response recuperateAllObject(String baseUrl, HashMap<String, Object> map, String getEndpoint, String email, String token) {

        public static Response getJql(String baseUrl,HashMap<String, Object> map,String getEndpoint, String email, String token)
    {
        Response res;
        return res=recuperateAllObject(baseUrl, map, getEndpoint, email, token);

    }


      public static Response getJqlWithQuery(String baseUrl,HashMap<String, Object> map,String getEndpoint,HashMap<String,Object>queryToSend, String email, String token)
     {
         Response res;
         return res=recuperateAllObjectByQuery(baseUrl,map,getEndpoint,email,token,queryToSend);


     }


}
