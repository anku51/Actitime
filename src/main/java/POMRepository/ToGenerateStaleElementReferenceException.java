package POMRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToGenerateStaleElementReferenceException {

    public static void main(String[] args) {
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	driver.get("https://www.google.com/");
	WebElement googleSearchBox = driver.findElement(By.name("q"));
	googleSearchBox.sendKeys("selenium");
	// driver.findElement(By.name("q")).sendKeys("selenium");
	driver.navigate().refresh();
	// driver.findElement(By.name("q")).sendKeys("automation");
	googleSearchBox.sendKeys("automation");
    }

}
