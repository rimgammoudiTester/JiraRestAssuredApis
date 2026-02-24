package JiraAutomationPackage.Pojos;

import com.fasterxml.jackson.annotation.JsonProperty;
import groovy.transform.stc.FirstParam;

import java.util.List;

public class UserPOJO {
    @JsonProperty("emailAddress")
     private String emailAddress;
    @JsonProperty("products")
     private String[] products;
   /* public UserPOJO(String emailAddress,String[] products) {
        this.emailAddress=emailAddress;
        this.products=products;
    }*/
    public String getEmailAdress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAdress)
    {
        this.emailAddress=emailAdress;
    }

    public void setProduct(String[] products)
    {
        this.products=products;
    }
    public String[] getProduct()
    {
        //String productByIndex;
        return  products;
    }



}
