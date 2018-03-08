package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class ElectionsCandidatesPage extends Pages {

    public ElectionsCandidatesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@class='app-list']//tr[1]")
    WebElement firstCandidate;

    @FindBy(xpath = "//table[@class='app-list']//tr[1]//div[contains(@class,'active')]")
    WebElement selectedFirstCandidate;

    @FindBy(css = "[ng-click*='chooseCandidate']")
    WebElement voteForCandidate;

    @FindBy(css = "[ng-click*='submitCandidate']")
    WebElement modalSubmitButton;

    @FindBy(css = "[data-dismiss='modal']")
    WebElement modalCancelButton;

    public void candidateIsSelectedAndSubmitted() {
        waitAndClickElement(firstCandidate);
        selectedFirstCandidate.isDisplayed();
        waitAndClickElement(voteForCandidate);
        waitAndClickElement(modalSubmitButton);
    }

    public void candidateIsSelectedAndCanceled() {
        waitAndClickElement(firstCandidate);
        selectedFirstCandidate.isDisplayed();
        waitAndClickElement(voteForCandidate);
        waitAndClickElement(modalCancelButton);
        //TODO assert modal window disappear
    }
}
