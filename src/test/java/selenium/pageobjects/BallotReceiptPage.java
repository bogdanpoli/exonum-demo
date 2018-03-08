package selenium.pageobjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class BallotReceiptPage extends Pages {

    public BallotReceiptPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "[ng-click*='electionWizardReset']")
    WebElement discardButton;

    @FindBy(css = "[ng-click*='decryptModal']")
    WebElement decryptButton;

    @FindBy(css = "[ng-click*='submitDecrypt']")
    WebElement modalSubmitDecryptButton;

    @FindBy(xpath = "//div[@id='decryptModal']//*[@data-dismiss='modal']")
    WebElement modalCancelDecryptButton;

    @FindBy(css = "[ng-click*='signModal']")
    WebElement signButton;

    @FindBy(xpath = "//div[contains(@class,'code-box')][1]")
    WebElement ballotMemo;

    @FindBy(xpath = "//div[contains(@class,'code-box')][2]")
    WebElement ballotHash;

    @FindBy(css = ".keyboard-button-digit")
    WebElement pinNumber;

    @FindBy(css = "[ng-click*='submitSign']")
    WebElement modalSignBallot;

    @FindBy(xpath = "//div[@id='signModal']//*[@data-dismiss='modal']")
    WebElement modalCancelBallot;

    @FindBy(css = ".buttons-wrapper>.button")
    WebElement saveMemoHashButton;

    @FindBy(css = "[ng-click*='saveMemoHash']")
    WebElement modalSaveButton;

    public void discardVote() {
        waitAndMoveToElement(discardButton);
        waitAndClickElement(discardButton);
    }

    public void decryptVote() {
        waitAndMoveToElement(decryptButton);
        waitAndClickElement(decryptButton);
        waitAndClickElement(modalSubmitDecryptButton);
        waitForElementIsInvisible(modalSubmitDecryptButton);
    }

    public void cancelDecryptVote() {
        waitAndMoveToElement(decryptButton);
        waitAndClickElement(decryptButton);
        waitAndClickElement(modalCancelDecryptButton);
    }

    public void signVote() {
        waitAndMoveToElement(signButton);
        waitAndClickElement(signButton);
    }

    public void enterPin() {
        waitAndClickElement(pinNumber);
        waitAndClickElement(pinNumber);
        waitAndClickElement(pinNumber);
        waitAndClickElement(pinNumber);
        waitAndClickElement(modalSignBallot);
        waitForElementIsInvisible(modalSignBallot);
    }

    public void saveMemoAndHash() {
        waitAndClickElement(saveMemoHashButton);
        waitAndClickElement(modalSaveButton);
    }
}
