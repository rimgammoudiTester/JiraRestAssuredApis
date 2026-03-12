package Utlis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

public class UtlisClass {
    public static final Logger logger = LogManager.getLogger(UtlisClass.class);
    public static final String BASE_URL_PROPERTY = "baseUrl";
    public static final String GROUP_BASE_URL_PROPERTY = "communPath";
    public static final String USERS_GROUPS="usersGroups";
    public static final String FILE_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\src\\main\\resources\\environment.properties";
    public static final String LOCAL_PATH="C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\local.properties";
    public static final String TOKEN_PROPERTY="TokenForJira";
    public static final String EMAIL_PROPERTY="userMail";
    public static final String JQL_PROPERTY = "jql";
    public static final String COMMUN_PATH_PROPERTY="communPath";
    public static final String Suggestion_PROPERTY="suggestion";


    public static final String AUTO_COMPLETE_DATA_PROPERTY = "autoCompleteData";
    public static final String JQL_FILE = "C:\\Users\\Rim Gammoudi\\Desktop\\TestApiAutomation\\jiraApiAutomation\\src\\main\\java\\models\\jql\\referenceData.json";




    public static final HashMap<String,Object>map=new HashMap<>();
    static{
        map.put("Accept","application/json");
    }




}
