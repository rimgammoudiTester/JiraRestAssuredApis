package ConfigReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /**
     * @Author Rim Gammoudi
     * Role : QA test Engineer
     */

    static Properties prop;
    //Method useful To read the File of environment.properties
    public static  String readEnvironmentFile(String FilePath,String propertyToReturn) throws FileNotFoundException {
        try {
            FileInputStream File = new FileInputStream(FilePath);
            prop = new Properties();
            prop.load(File);
          return  prop.getProperty(propertyToReturn);
        } catch (IOException e) {
            System.out.println("File Not Found would you verify please !!");
            throw new RuntimeException("faild to load File", e);
        }
    }
}
