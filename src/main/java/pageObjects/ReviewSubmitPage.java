package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class ReviewSubmitPage {


    private By select_DropDown = By.xpath("//span[normalize-space()='Select...']");
    private By health_Insurance = By.xpath("//li[normalize-space()='Health Insurance']");
    private By review_TextBox = By.xpath("//textarea[@placeholder='Write your review...']");
    private By submit_Button = By.xpath("//div[text()='Submit']");
    private By awesome_text = By.xpath("//h2[normalize-space()='Awesome!']");
    private By continue_Btn = By.cssSelector("div[class='btn rvc-continue-btn']");


    public ReviewSubmitPage selectHealthInsurance(){
        PageActionUtils.click(select_DropDown);
        PageActionUtils.click(health_Insurance);
        PageActionUtils.typeIntoTextBox(review_TextBox, getReview());
        PageActionUtils.click(submit_Button);
        return this;
    }

    public boolean isAwesomeTextDispayed(){
        return PageActionUtils.isElementDisplayed(awesome_text);
    }

    public ReviewPage navigateToReviewPage(){
        PageActionUtils.click(continue_Btn);
        return new ReviewPage();
    }



    public String getReview(){
       StringBuilder text = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            text.append("This Is a Test.. ");
        }
        return String.valueOf(text);
    }

}
