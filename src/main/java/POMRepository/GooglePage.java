package POMRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GooglePage {
    public void GoodlePage(WebDriver driver) {

    }

    @FindBy(name = "q")
    WebElement googleSearchBox;

    @FindBy(xpath = "(//input[@value=\"Google Search\"])[2]")
    WebElement googleSearchButton;

}
