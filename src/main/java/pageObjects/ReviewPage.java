package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class ReviewPage {

    private By fourStar = By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[local-name()='svg'][4]");
    private By fourStar_light_up = By.xpath("//review-star[@class='rvs-svg']//div[@class='rating-box-wrapper']//*[local-name()='svg'][4]/*[name()='g'][1]/*[name()='path' and @fill='none']");
    private By profile_top = By.xpath("//div[@class='brgm-button brgm-user brgm-list-box']");
    private By profile_sub = By.xpath("//a[normalize-space()='Profile']");


    public ReviewPage mouseOverOnFourStar(){
        PageActionUtils.scrollToView(fourStar);
        PageActionUtils.moveToElement(fourStar);
        return this;
    }

    public boolean checkStarLitUp(){
        return PageActionUtils.isElementDisplayed(fourStar_light_up);
    }

    public ReviewSubmitPage clickOnFourStar(){
        PageActionUtils.click(fourStar);
        return new ReviewSubmitPage();
    }

    public ProfilePage navigateToProfilePage(){
        PageActionUtils.scrollToTopByKey();
        PageActionUtils.moveToElement(profile_top);
        PageActionUtils.click(profile_sub);
        return new ProfilePage();
    }


}
