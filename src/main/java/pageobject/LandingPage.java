package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import reuseable.AbstractClass;

public class LandingPage extends AbstractClass {
    WebDriver driver ;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver ;
        PageFactory.initElements(driver , this);

    }
    public void goTOLandingPage(){
        driver.get("http://example.com/");
    }
    public  void logData(String data){
        System.out.println(data);
    }
}
