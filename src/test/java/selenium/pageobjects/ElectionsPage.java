package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class ElectionsPage extends Pages {

    public ElectionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[text()='US Presidential Election']")
    private WebElement usElection;

    @FindBy(xpath = "//td[text()='Estonian Presidential Election']")
    private WebElement estonianElection;

    @FindBy(css = "[ui-sref=candidates]")
    WebElement electionsVoteButton;

    public void selectUsElection() {
        waitAndClickElement(usElection);
        waitAndClickElement(electionsVoteButton);
        waitForElementIsInvisible(electionsVoteButton);
    }
}
