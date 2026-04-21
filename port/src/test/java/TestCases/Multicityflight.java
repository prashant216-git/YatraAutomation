package TestCases;

import PageObjects.HomePAge;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class Multicityflight extends BaseTest{
    List<String> Testdataa = new ArrayList<>();


    @Test
            public void Multicityflight() throws InterruptedException {
        Testdataa.add("Mumbai");
        Testdataa.add("New Delhi");
        Testdataa.add("indore");
        Testdataa.add("kolkata");
        Testdataa.add("Chennai");
        Testdataa.add("Lucknow");
        HomePAge pg = new HomePAge(driver);
pg.closelogin();
pg.openmulticity();
        pg.multicity(3,Testdataa);

    }}
