package utils;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClass {

    Framework f1 = new Framework();

    public WebDriver driver;

    @BeforeSuite
    public void bsConfig() {
	System.out.println("Database connection");

    }

    @BeforeTest
    public void btConfig() {
	System.out.println("Parallel Execution");

    }

    @BeforeClass
    public void bcConfig() throws IOException {
	driver = new ChromeDriver();
	String url = f1.property("url");
	driver.manage().window().maximize();
	System.out.println("Launch to the browser");
	driver.get(url);

    }

    @BeforeMethod
    public void bmConfig() throws IOException {
	String user = f1.property("username");
	String pswrd = f1.property("password");
	System.out.println("Login to Application");
	driver.findElement(By.id("username")).sendKeys(user);
	WebElement pwd = driver.findElement(By.name("pwd"));
	pwd.sendKeys(pswrd);
	pwd.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void amConfig() {
	System.out.println("Logout from Application");

    }

    @AfterClass
    public void acConfig() {
	driver.close();
	System.out.println("Close the browser");

    }

    @AfterTest
    public void atConfig() {
	System.out.println("Stop Parallel Execution");

    }

    @AfterSuite
    public void asConfig() {
	System.out.println("Close data base");

    }
}

/*
 * order of execution of Selenium annotation
 * 
 * @Beforesuite = It is an annotation of selenium in which we write the program
 * for database connection. It will always execute first.
 * 
 * @Beforetest = We use before test whenever we need to perform parallel
 * execution. It will execute after beforesuite annotation.
 * 
 * @Beforeclass = In this we write the code to launch the browser and navigates
 * the URL. It will execute after beforetest.
 * 
 * @Beforemethod = In this we write the code to login to the application. It
 * will execute after beforeclass.
 * 
 * @test
 * 
 * @Aftermethod = In this we write the code to logout from the application. It
 * will execute after @Test.
 * 
 * @Afterclass = In this we write the code to close the browser and it will
 * execute after aftermethod.
 * 
 * @Aftertest = It will used to stop the parallel execution and it will execute
 * after afterclass.
 * 
 * @Aftersuite = It will used to close the database and it will execute after
 * the aftertest.
 */

/*
 * why to close database..? To prevent data leakage, for garbagge collection,
 * for security reasons
 */
