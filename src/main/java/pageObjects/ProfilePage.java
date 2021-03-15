package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class ProfilePage {

    private By insurance_Company = By.xpath("//a[normalize-space()='Test Insurance Company']");


    public String getCompanyName(){
        return PageActionUtils.getElementText(insurance_Company);
    }



}
