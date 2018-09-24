package org.andestech.learning.rfb18.at;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
import static org.testng.Assert.assertEquals;


public class AppTest
{

    private WebDriver driver = null, driverFF = null;
    private WebDriverWait wait1;


    @BeforeClass
    public void init(){

        System.setProperty("webdriver.chrome.driver",
                "E:\\drivers\\selenium\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver",
                "E:\\drivers\\selenium\\geckodriver.exe");

       // System.setProperty("webdriver.firefox.marionette", "false");

        ChromeOptions opt = new ChromeOptions();
      //  opt.setExperimentalOption("useAutomationExtension",false);
        opt.addArguments("start-maximized");
       // opt.setHeadless(true);

        //....
        try {
            driver = new ChromeDriver(opt);
           // driverFF = new FirefoxDriver();
        }

        catch (org.openqa.selenium.WebDriverException ex)
        {
            if(driver != null) driver.quit();
          //  if(driverFF != null) driverFF.quit();
            throw ex;
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait1 = new WebDriverWait(driver, 10);

       // driverFF.get("http://gmail.com");

        System.out.println("++ webdriver created ok");
    }

    @Test()
    public void testLink1()
    {
        driver.navigate().to("http://google.com");
        //wait1.until(ExpectedConditions.alertIsPresent());
        //driver.switchTo().alert().accept();
        wait1.until(ExpectedConditions.titleIs("Google"));

        System.out.println(driver.getTitle() );
        assertEquals("Google", driver.getTitle());
    }

    @Test
    @Ignore
    public void testLink1FF()
    {
        driverFF.navigate().to("http://google.com");
        System.out.println(driverFF.getTitle() );
       // assertEquals("Google", driverFF);
    }

    @Test
    public void testLink2()
    {
        driver.navigate().to("http://microsoft.com");
        System.out.println(driver.getTitle() );
      //  assertEquals("Google", driver.getTitle());
    }

    @AfterClass
    public void tearDown(){
        System.out.println("-- after");
        if(driver != null) {driver.quit();
            System.out.println("-- webdriver chrome quit ok..");}
//        if(driverFF != null) {driverFF.quit();
//            System.out.println("-- driver quit firefox");}


    }

}
