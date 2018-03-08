package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;
import selenium.pageobjects.EmailSteps;


public class SignedBallotPage extends Pages {

    EmailSteps emailSteps = new EmailSteps();

    public SignedBallotPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[ng-model='inputs.email']")
    WebElement email;

    @FindBy(css = "[ng-click*='sendEmailAndGo']")
    WebElement submitBallotButton;

    @FindBy(css = "[ng-click*='electionWizardReset']")
    WebElement discardBallotButton;

    public void submitBallot() {
        waitAndClickElement(submitBallotButton);
    }

    public void provideEmailAddress() {
        waitForElement(email);
        String emailAddressValue = emailSteps.getMailAddress();
        email.sendKeys(emailAddressValue);
        System.out.print(emailAddressValue);
    }

    public void provideEmailAddress2() {
        waitForElement(email);
        String emailAddressValue = emailSteps.getMailAddress();
        email.sendKeys(emailAddressValue);
        System.out.print(emailAddressValue);
    }

    public void discardBallot() {
        waitAndClickElement(discardBallotButton);
    }
}
