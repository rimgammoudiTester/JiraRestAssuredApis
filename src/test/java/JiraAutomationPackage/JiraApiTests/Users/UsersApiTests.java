package JiraAutomationPackage.JiraApiTests.Users;
import JiraAutomationPackage.Bases.Asserts.GenericAssertsCalls;
import JiraAutomationPackage.JiraApis.UsersApi.UsersApi;
import JiraAutomationPackage.Pojos.UserPOJO;
import Utlis.UtlisClass;
import io.qameta.allure.Description;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsersApiTests extends UsersApi {
    GenericAssertsCalls asserts;
    private Response res;
    UtlisClass utlisClass;
    UserPOJO userClass;
    final String  ERROR_MESSAGE="[You are not authenticated. Authentication required to perform this operation.]";
    private final String PRODCUTS_Missing="Vous devez indiquer les produits auxquels l'utilisateur peut accéder.";
    private final String PRODUCT_ERROR_MESSAGE="Impossible de créer un utilisateur : nom de produit Jira non valide fourni dans la demande.";
    private final String EMAIL_FORMAT_ERROR="Vous devez indiquer une adresse électronique valide.";
    private final String USER_EXIST_ERROR="Un utilisateur portant ce nom existe déjà.";
    private final String MISSING_EMAIL_MESSAGE="Vous devez indiquer une adresse électronique.";
    String[]products={"jira-software"};
    //<String>products =List.of("jira-software");
    private static final Logger logger = LogManager.getLogger(UsersApiTests.class);


    @BeforeMethod()
    public void intialize()
    {
        asserts=new GenericAssertsCalls();
        userClass=new UserPOJO();
        UtlisClass utlisClass1=new UtlisClass();


    }

    //Method usefull for verifying the api is accesible only by authentification
    @Test()
    public void verifyTheResponseShouldReturn404WithoutAuthentifcation()
    {
        res=recuperateTheListOfUsersx();
        logger.info("The response is :",res);
    }


    //Verify the message returned By the api is correct
    @Test()
    public void verifyTheResponseShouldReturnTheCorrectErrorMessage()
    {
        res=recuperateTheListOfUsersxp(1);
        logger.info("The response is :",res);
    }

    //Add a user Api
    @Test()
    @Description("Test To verify That the api status is 400 when the products is empty and we give the email")
    public void verifyThatTheCreateUserTurn400WithEmailAndEmptyProducts()
    {
        userClass.setEmailAddress("testjjjooa@atlassian.com");
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(400,res);
        logger.info("The response status is 400");
    }


    @Test()
    @Description("Test To verify That The api return The right error message with empty products and the given email")
    public void verifyThatTheApiReturnTheCorrectErrorMessageWithAnEmailAndEmptyProducts()
    {
        userClass.setEmailAddress("testjjjooa@atlassian.com");
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        logger.info(res);
        asserts.assertParameterEqualToExpectedValue( PRODCUTS_Missing,res,"errorMessages[0]");

    }



    //Method useful
    @Test()
    @Description("Verify That the api return 400 while given an email and product incorrect")
    public void verifyTheApiReturn400WhenTheEmailFormatIsCorrectAndTheProductsNotCorrect()
    {
        userClass.setEmailAddress("testjjjooa@atlassian.com");
        products=new String[]{"jira-softwareb"};
        userClass.setProduct(products);
        logger.info("the product is :",userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(400,res);
    }


    @Test()
    @Description("Verify that the product given in the request is wrong")
    public void verifyTheApiReturnTheErrorMessageWhenTheEmailFormatIsCorrectAndTheProductsNotCorrect()
    {
        userClass.setEmailAddress("testjjjooa@atlassian.com");
        products=new String[]{"jira-softwareb"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertParameterEqualToExpectedValue(PRODUCT_ERROR_MESSAGE,res,"errorMessages[0]");
    }

    @Test()
    @Description("Verify that The api should return 400 when the email is not correct")
    public void verifyTheApiReturn400WhenTheEmailFormatIsIncorrect()
    {
        userClass.setEmailAddress("testjjjo.com");
        products=new String[]{"jira-softwareb"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(400,res);
    }

    @Test()
    @Description("Verify that The api should return 400 when the email is not correct")
    public void verifyTheApiReturnTheCorrectErrorWhenTheEmailFormatIsIncorrect()
    {
        userClass.setEmailAddress("testjjjo.com");
        products=new String[]{"jira-softwareb"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertParameterEqualToExpectedValue(EMAIL_FORMAT_ERROR,res,"errors.email");
    }

    @Test()
    @Description("Verify that The api should return 400 when the email is already exist")
    public void verifyTheApiReturn400WhenTheEmailExist()
    {
        userClass.setEmailAddress("test@atlassian.com");
        products=new String[]{"jira-software"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(400,res);
        //asserts.assertParameterEqualToExpectedValue(EMAIL_FORMAT_ERROR,res,"errors.email");

    }

    @Test()
    @Description("Verify that The api return error message when the email is already exist")
    public void verifyTheApiReturnTheCorrectErrorMessageWhenTheEmailExist()
    {
        userClass.setEmailAddress("test@atlassian.com");
        products=new String[]{"jira-software"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertParameterEqualToExpectedValue(USER_EXIST_ERROR,res,"errorMessages[0]");

    }

    @Test()
    @Description("Verify that The api return 400 when the email adress is empty")
    public void verifyTheApiReturn400WhenTheEmailIsEmpty()
    {
        userClass.setEmailAddress("");
        products=new String[]{"jira-software"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(400,res);

    }


    @Test()
    @Description("Verify that The api return The correct error message when the email adress is empty")
    public void verifyTheApiReturnTheCorrectErrorMessageWhenTheEmailIsEmpty()
    {
        userClass.setEmailAddress("");
        products=new String[]{"jira-software"};
        userClass.setProduct(products);
        logger.info("the product is :", userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertParameterEqualToExpectedValue(MISSING_EMAIL_MESSAGE,res,"errors.email");

    }

    //Method useful
    @Test()
    @Description()
    public void verifyTheApiReturn400WhenTheEmailFormatIncorrectAndTheProducts()
    {
        logger.info("hi");
        userClass.setEmailAddress("testjjjooa@atlassian.com");
        userClass.setProduct(products);
        logger.info("the product is :",userClass.getProduct());
        logger.info(userClass.getEmailAdress());
        res=createUser(userClass);
        asserts.assertResponseStatus(201,res);
    }
}