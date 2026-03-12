package JiraAutomationPackage.JiraApiTests.jql;
import Pojos.jqlPojo.ReferenceData;
import io.restassured.response.Response;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;

import static Bases.Asserts.GenericAssertsCalls.assertResponseStatus;
import static ConfigReader.ConfigurationReader.readEnvironmentFile;
import static JiraApis.jqlApi.JqlApi.*;
import static Utlis.SerilaizingDeserializingClass.deserialize;
import static Utlis.SerilaizingDeserializingClass.deserliaze;
import static Utlis.UtlisClass.*;
import static Utlis.apiResponsesStatus.statusCodeNumbers.StatusCode.*;


@Slf4j
public class jqlApiTestCases {
    String baseUrl;
    String jqlEndpoint;
    String email;
    String token;
    @BeforeClass
    public void intializeBaseUrl() throws FileNotFoundException {
       baseUrl= readEnvironmentFile(FILE_PATH,BASE_URL_PROPERTY);
       jqlEndpoint=readEnvironmentFile(FILE_PATH,COMMUN_PATH_PROPERTY)+readEnvironmentFile(FILE_PATH,JQL_PROPERTY)+readEnvironmentFile(FILE_PATH,AUTO_COMPLETE_DATA_PROPERTY);
        email=readEnvironmentFile(LOCAL_PATH,EMAIL_PROPERTY);
        token=readEnvironmentFile(LOCAL_PATH,TOKEN_PROPERTY);
    }


    @DataProvider
    public Object[][] getTheWrongCredentianls()
    {
       return new Object[][]{
               {email+"wrongValue",token},
               {email,token+"wrongValue"},
               {"",""}




       };


    }
    // Verify that the api return all the avatars Objects
    @Test(description="test for extracting the list of Jirajql")
    public void getFieldReferenceDataGet() {
     Response res;
       res= getJql(baseUrl,map,jqlEndpoint,email,token);
        assertResponseStatus(succesCode,res);
        log.info("The jql api is successfully returning :"+res.getStatusCode());


    }

    // Verify that the api return all the avatars Objects
    @Test(dataProvider ="getTheWrongCredentianls")
    public void getFieldReferenceDataGetWithWrongCredentinals(String email,String password) {
       Response res;
        res= getJql(baseUrl,map,jqlEndpoint,email,password);
        log.info(res.body().asString());
       assertResponseStatus(unothorized,res);
        System.out.println("hello :"+res.getStatusCode());

       }


    // Verify that the api Load Avatar
    @Test(description ="verifying the creation of referenceData jql" )
    public void getFieldReferenceDataPost() {
       Response res;
       res= createAJql(baseUrl,map,jqlEndpoint,deserliaze(JQL_FILE,ReferenceData.class),email,token);
        assertResponseStatus(succesCode,res);
        log.info("The status code is :"+res.getStatusCode());
    }

    // Delete avatar
    @SneakyThrows
    @Test()
    public void getFieldAutoCompleteSuggestions() {
      Response res;
       res= getJqlWithQuery(baseUrl,map,jqlEndpoint+readEnvironmentFile(FILE_PATH,Suggestion_PROPERTY),deserialize(JQL_FILE),email,token);
       assertResponseStatus(succesCode,res);
        log.info("The status code is :"+res.getStatusCode());

    }


    /// extract The avatar Image By type
    @Test()
    public void parseJqlQuery() {

    }


    // Extract the avatar image by Id
    @Test()
    public void getUsersFromGroup() {

    }

    // Extract the avatar image by owner
    @Test()
    public void convertUserIdentifiersToAccountIdsInJqlQueries() {

    }


// Négative scenraios

    // Veify that delete dashboard return badRequest with the wrong data
    @Test()
    public void sanitizeJqlQueries() {


    }

}
