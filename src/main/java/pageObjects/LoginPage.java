package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;


public class LoginPage {

    private By email_Field = By.id("email");
    private By password_Field = By.id("password");
    private By login_Btn = By.xpath("//span[text()='Login']");


    public HomePage doLogin(String userName, String password){
        PageActionUtils.typeIntoTextBox(email_Field,userName);
        PageActionUtils.typeIntoTextBox(password_Field,password);
        PageActionUtils.click(login_Btn);
        PageActionUtils.waitToLoad(4000);
        return new HomePage();
    }



}
