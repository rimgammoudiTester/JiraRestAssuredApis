
package Bases.Api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;

public class GenericApiCalls {

    //setUp headers of a request

    public static RequestSpecification setRequest(String baseUrl, HashMap<String, Object> headers, String email, String token) {
        RequestSpecification req = RestAssured.given().baseUri(baseUrl).auth().preemptive().basic(email, token).headers(headers).when().contentType(ContentType.JSON);
        return req;
    }

    //Method for recuperate  list of Objects
    public static Response recuperateAllObject(String baseUrl, HashMap<String, Object> map, String getEndpoint, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //passing query

    public static Response recuperateAllObjectByQuery(String baseUrl, HashMap<String, Object> map, String getEndpoint, String email, String token, HashMap<String, Object> queryToSend) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token);
        res = req.queryParams(queryToSend).get(getEndpoint);
        res.then().log().all();
        return res;
    }


    //Method for recuperate an object by pathParameter (By id)
    public static Response recuperateAnObjectById(String baseUrl, HashMap<String, Object> map, String getEndpoint, int id, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).pathParam("id", id);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for recuperate an object by QueryParameter (By id)
    public static Response recuperateObjectByParamterKey(String baseUrl, HashMap<String, Object> map, String getEndpoint, HashMap<String, Object> parameters, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).queryParams(parameters);
        res = req.get(getEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    public static Response createAnObject(String baseUrl, HashMap<String, Object> map, String postEndpoint, Object payloadToSent, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).body(payloadToSent);
        res = req.post(postEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    public static Response modifyAnObject(String baseUrl, HashMap<String, Object> map, String putEndpoint, HashMap<String, Object> payloadToSent, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).body(payloadToSent);
        res = req.put(putEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for creating Objects
    public static Response patchCallApi(String baseUrl, HashMap<String, Object> map, String patchEndpoint, HashMap<String, Object> payloadToSent, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).body(payloadToSent);
        res = req.patch(patchEndpoint);
        res.then().log().all();
        return res;
    }

    //Method for Deleting Objects
    public static Response deleteAnObject(String baseUrl, HashMap<String, Object> map, String deleteEndpoint, int id, String email, String token) {
        Response res;
        RequestSpecification req = setRequest(baseUrl, map, email, token).pathParam("id", id);
        res = req.delete(deleteEndpoint);
        res.then().log().all();
        return res;
    }


}



