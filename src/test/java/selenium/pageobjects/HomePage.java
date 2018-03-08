package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class HomePage extends Pages {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[ng-click*=electionWizardLink]")
    WebElement voteButton;

    @FindBy(css = "[ui-sref=monitor]")
    WebElement monitorButton;

    public void pressVote() {
        waitForPageLoad();
        isElementVisible(voteButton);
        waitAndClickElement(voteButton);
    }

    public void pressMonitor(){
        waitForPageLoad();
        waitAndClickElement(monitorButton);
    }

    public void homePageIsOpened(){
        waitForElement(monitorButton);
        waitForElement(voteButton);
    }
}
