package TestCases;

import org.testng.annotations.Test;

import PageObjects.HomePAge;

public class Cheapflight_test extends BaseTest{
@Test
void flightset() throws InterruptedException {
	HomePAge pg=new HomePAge(driver);
pg.closelogin();
	pg.setSrc("mumbai");
	pg.setDest("New Delhi");
	pg.opencalendar();
	pg.calender("November");
	pg.clickPrice();
	pg.clicksearch();
}
}
