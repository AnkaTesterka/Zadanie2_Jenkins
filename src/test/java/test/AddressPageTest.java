package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.AccountPage;
import pages.AddressPage;
import pages.HomePage;
import pages.LoginPage;

public class AddressPageTest extends TestBase {

    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    GlobalMethods globalMethods;

    /** konstruktor **/
    public AddressPageTest(){
        super();
    }

    //Przed każdym uruchomieniem przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        accountPage = new AccountPage();
        addressPage = new AddressPage();
        globalMethods = new GlobalMethods();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(user,password);
        addressPage = accountPage.goToAddresses();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    /** TESTY **/
    @Test(priority = 0)
    @Ignore
    public void verifyNoDeliveryAddress() {
        Assert.assertTrue(addressPage.getInfoDeliveryAddress().equalsIgnoreCase(testdata.getProperty("correctInfoAboutDeliveryAddress")));
        globalMethods.takeScreenshot(this.getClass().getSimpleName(), 1);
    }
}
