package test;

import base.TestBase;
import helpers.GlobalMethods;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductListPageTest extends TestBase {
    HomePage homePage;
    ProductListPage productListPage;
    GlobalMethods globalMethods;


    ArrayList<String> correctProductListSortByPriceFromLowest = new ArrayList<>(Arrays.asList
            ("PI\u0141KA NO\u017bNA KIPSTA F100", "KOSZULKA NEWCASTLE FC UNITED", "KOSZULKA WEST HAM UNITED", "PI\u0141KA NO\u017BNA ADIDAS REPLIKA LIGA MISTRZ\u00D3W",
            "PI\u0141KA NO\u017bNA ADIDAS EURO 2020", "KOSZULKA TOTTENHAM HOTSPUR F.C.", "KOSZULKA ARSENAL LONDON", "KOSZULKA CHELSEA LONDON",
            "KOSZULKA MANCHESTER UNITED", "KOSZULKA MANCHESTER FC CITY", "KOSZULKA LIVERPOOL FC", "KOSZULKA LEICESTER FC CITY"));

    /** konstruktor **/
    public ProductListPageTest(){
        super();
    }


    //Przed każdym uruchomieniem przeglądarki wraz z zadeklarowanymi własnościami
    @BeforeMethod
    public void setUp(){
        initialization();
        homePage = new HomePage();
        productListPage = new ProductListPage();
        globalMethods = new GlobalMethods();

        productListPage = homePage.goToProductPage();

    }

    // Po każdym teście zamknięcie przeglądarki
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    /** TESTY **/
    @Test(priority = 0)
    public void verifyProductNumber(){
        Assert.assertEquals(productListPage.getProductNumber(), Integer.parseInt(testdata.getProperty("correctProductNumber")));
        globalMethods.takeScreenshot(this.getClass().getSimpleName(), 1);
    }

    @Test(priority = 1)
    public void verifySortProducts(){
        Assert.assertEquals(productListPage.getProductsNameAfterOrderByPrice(),correctProductListSortByPriceFromLowest);
        globalMethods.takeScreenshot(this.getClass().getSimpleName(), 2);
    }
}
