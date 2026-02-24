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
    Properties prop;
    //Method useful To read the File of environment.properties
    public void ReadEnvironmentFile(String FilePath) throws FileNotFoundException {
        try {
            FileInputStream File = new FileInputStream(FilePath);
            prop = new Properties();
            prop.load(File);
        } catch (IOException e) {
            System.out.println("File Not Found would you verify please !!");
            throw new RuntimeException("faild to load File", e);
        }
    }
    //Method useful To read a property from the file environment.properties
    public String ReadApropertyFromEnvironmentFile(String propertyToReturn,String FilePath) throws FileNotFoundException {
        ReadEnvironmentFile(FilePath);
        return prop.getProperty(propertyToReturn);
    }
}
