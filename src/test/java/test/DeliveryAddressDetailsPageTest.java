package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;

public class DeliveryAddressDetailsPageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;
    AccountPage accountPage;
    AddressPage addressPage;
    DeliveryAddressDetailsPage deliveryAddressDetailsPage;
    GlobalMethods globalMethods;

    /** konstruktor **/
    public DeliveryAddressDetailsPageTest(){
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
        deliveryAddressDetailsPage = new DeliveryAddressDetailsPage();
        globalMethods = new GlobalMethods();

        loginPage = homePage.goToLoginPage();
        accountPage = loginPage.login(testdata.getProperty("userLogin"), testdata.getProperty("userPassword"));
        addressPage = accountPage.goToAddresses();
        deliveryAddressDetailsPage = addressPage.goToAddDeliveryAddress();
    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    /** TESTY **/
    @Test(priority = 0)
    public void addDeliveryAddress(){
        addressPage = deliveryAddressDetailsPage.fillForm("Jan", "Testowy2", "Polska", "S\u0142oneczna", "00-001", "Warszawa");

        Assert.assertEquals(addressPage.getInfoDeliveryAddress(), "Jan Testowy2\n" + "S\u0142oneczna\n" + "00-001 Warszawa");
        globalMethods.takeScreenshot(this.getClass().getSimpleName(), 1);
    }
}
