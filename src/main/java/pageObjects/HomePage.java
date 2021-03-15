package pageObjects;

import org.openqa.selenium.By;
import utils.PageActionUtils;

public class HomePage {

    public ReviewPage navigateToReviewPage(String url){
        PageActionUtils.navigateToAnotherUrl(url);
        return new ReviewPage();
    }




}
