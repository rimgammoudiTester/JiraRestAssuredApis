package JiraAutomationPackage.JiraApis.UsersApi;

import ConfigReader.ConfigurationReader;
import JiraAutomationPackage.Bases.Api.GenericApiCalls;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.FileNotFoundException;
import java.util.HashMap;

import static Bases.Api.GenericApiCalls.*;
import static ConfigReader.ConfigurationReader.ReadEnvironmentFile;

public class UsersApi {
    /**@Author Rim Gammoudi ***
     * Qa Automation Engineer
     */
    private static final String BASE_URL_PROPERTY = "baseUrl";
    private static final String USERS_BASE_URL_PROPERTY = "userCommunPath";
  /*  private static final String FILE_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\src\\main\\resources\\environment.properties";
    private static final String LOCAL_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\local.properties";*/
  private static final String FILE_PATH = "src/test/resources/environment.properties";

    // For local.properties (which is in your project root)
    private static final String LOCAL_PATH = "local.properties";
    private static final String TOKEN_PROPERTY="TokenForJira";
    private static final String EMAIL_PROPERTY="userMail";

    private String baseUrl;
    String UserEndpoint;
    private String token;
    private  String email;
    @BeforeClass()
    public void readProperties() throws FileNotFoundException {
    baseUrl=ReadEnvironmentFile(FILE_PATH,BASE_URL_PROPERTY);
    UserEndpoint=ReadEnvironmentFile(FILE_PATH,USERS_BASE_URL_PROPERTY);
    token=ReadEnvironmentFile(LOCAL_PATH,TOKEN_PROPERTY);
    email=ReadEnvironmentFile(LOCAL_PATH,EMAIL_PROPERTY);

    }
    //Method useful for recuperate the List of users


    public HashMap<String,Object> setUpHeaders()
    {
        HashMap<String,Object>headersOfRequest=new HashMap<>();
        headersOfRequest.put("Content-Type","application/json");
        return headersOfRequest;
    }
    public Response recuperateTheListOfUsersx()
    {
        Response res;
        HashMap<String,Object>map=setUpHeaders();
        System.out.println(email);
        System.out.println(token);
        System.out.println("hello the url is "+baseUrl);
        System.out.println("hello the userEndpoint" +UserEndpoint);
     return res= recuperateAllObject(baseUrl,map,UserEndpoint,email,token);
    }

    public Response recuperateTheListOfUsersxp(int id)
    {
        Response res;
        HashMap<String,Object>map=setUpHeaders();
        HashMap<String,Object>map2=new HashMap<>();
        map2.put("accountId",id);
        return res= recuperateAllObjectByQuery(baseUrl,map,UserEndpoint,email,token,map2);
    }

    //Method useful for creating a user
    public Response createUser(Object UserPayload)
    {
        Response res;
        HashMap<String,Object>headersToSend;
        headersToSend=setUpHeaders();
       return res=createAnObject(baseUrl,headersToSend,UserEndpoint,UserPayload,email,token);

    }





}
