package JiraAutomationPackage.JiraApis.GroupsApi;
import ConfigReader.ConfigurationReader;
import JiraAutomationPackage.Bases.Api.GenericApiCalls;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class GroupsApis extends GenericApiCalls {



    /**@Author Rim Gammoudi ***
     * Qa Automation Engineer
     */
    ConfigurationReader configProperties;
    private static final String BASE_URL_PROPERTY = "baseUrl";
    private static final String GROUP_BASE_URL_PROPERTY = "communPath";
    private static final String USERS_GROUPS="usersGroups";
    private static final String FILE_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\src\\main\\resources\\environment.properties";
    private static final String LOCAL_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\local.properties";
    private static final String TOKEN_PROPERTY="TokenForJira";
    private static final String EMAIL_PROPERTY="userMail";

    private String baseUrl;
    String GroupEndpoint;
    private String token;
    private  String email;
    @Test()
    public void readProperties() throws FileNotFoundException {
        configProperties=new ConfigurationReader();
        baseUrl=configProperties.ReadApropertyFromEnvironmentFile(BASE_URL_PROPERTY,FILE_PATH);
        GroupEndpoint=configProperties.ReadApropertyFromEnvironmentFile(GROUP_BASE_URL_PROPERTY,FILE_PATH);
        GroupEndpoint=GroupEndpoint+configProperties.ReadApropertyFromEnvironmentFile(USERS_GROUPS,FILE_PATH);
        token=configProperties.ReadApropertyFromEnvironmentFile(TOKEN_PROPERTY,LOCAL_PATH);
        email=configProperties.ReadApropertyFromEnvironmentFile(EMAIL_PROPERTY,LOCAL_PATH);

    }
    //Method useful for recuperate the List of users
    public HashMap<String,Object> setUpHeaders()
    {
        HashMap<String,Object>headersOfRequest=new HashMap<>();
        headersOfRequest.put("Content-Type","application/json");
        return headersOfRequest;
    }
    //Method useful for create a group
    public void createAGroup()
    {

    }

    //Method useful for extracting a Group
    public void extractAGroup()
    {


    }

}
