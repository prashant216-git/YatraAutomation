package TestCases;

import PageObjects.HomePAge;
import PageObjects.Hotelspage;
import org.testng.annotations.Test;

public class Hotels extends BaseTest{
    @Test
    void hotelsearch() throws InterruptedException {
        Hotelspage hotelspage = new Hotelspage(driver);
        HomePAge hm = new HomePAge(driver);

hm.closelogin();
       hotelspage.clickHotels();
        hotelspage.setLocation("New Delhi");
        hotelspage.openCheckinPicker();
        hotelspage.cal("June","15");
        hotelspage.cal("June","20");
        hotelspage.clickSearch();
        hotelspage.clickPriceFilter();
        hotelspage.printnamewithprice();






    }




}