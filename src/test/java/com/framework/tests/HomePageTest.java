package com.framework.tests;

import com.framework.base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.ProfilePage;
import pageObjects.ReviewPage;
import pageObjects.ReviewSubmitPage;

public class HomePageTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    ReviewPage reviewPage = new ReviewPage();
    ReviewSubmitPage reviewSubmitPage = new ReviewSubmitPage();
    ProfilePage profilePage = new ProfilePage();


    @Test
    public void TC_01_This_is_Test(){
    /*
        Do the login and navigate to review Page
     */
    reviewPage = loginPage.doLogin(prop.getProperty("username"),prop.getProperty("password"))
            .navigateToReviewPage(prop.getProperty("review_url"));
    /*
    Verify Star got lit up after hover over on Star
     */
    Assert.assertTrue(reviewPage.mouseOverOnFourStar().checkStarLitUp());

    /*
    Clicking on 4th star
     */
    reviewSubmitPage = reviewPage.clickOnFourStar();
    /*
    Selecting Insurance type and submitting review, After this Navigating Profile Page
     */
    reviewSubmitPage.selectHealthInsurance();
    /*
    Verifying Awesome Text Post submission review
     */
    Assert.assertTrue(reviewSubmitPage.isAwesomeTextDispayed());

    /*
    Navigating to Review Page
     */
    reviewPage = reviewSubmitPage.navigateToReviewPage();
    /*
    Navigating to Profile Page
     */
    reviewPage.navigateToProfilePage();
    Assert.assertEquals(profilePage.getCompanyName(),"Test Insurance Company");


    }
}
