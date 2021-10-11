package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.annotations.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;

public class LoginPageTest extends TestBase {
    /** deklaracja obiektów **/
    HomePage homePage;
    AccountPage accountPage;
    LoginPage loginPage;
    GlobalMethods globalMethods;

    /** konstruktor **/
    public LoginPageTest(){
        super ();
    }

    //Przed każdym uruchomieniem przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        globalMethods = new GlobalMethods();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    /** TESTY **/
    @Test(priority = 0)
    public void verifyPageTitle(){
        Assert.assertTrue(loginPage.getPageTitle().equals(testdata.getProperty("correctAccountPageTitle")));
        globalMethods.takeScreenshot(this.getClass().getSimpleName(), 1);
    }
}
