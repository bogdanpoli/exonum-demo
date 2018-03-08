package selenium.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import selenium.Pages;

public class MonitorPage extends Pages{

    public MonitorPage(WebDriver driver) {
        super(driver);
    }

    public static final String FIRST_MENU_TEXT = "Monitor ongoing elections";
    public static final String SECOND_MENU_TEXT = "View finished elections` results";

    @FindBy(xpath = "//tr[1]/td[@class='ng-binding']")
    WebElement firstMonitorMenu;

    @FindBy(xpath = "//tr[2]/td[@class='ng-binding']")
    WebElement secondMonitorMenu;

    public void verifyMonitorMenu() {
        Assert.assertEquals(firstMonitorMenu.getText(), MonitorPage.FIRST_MENU_TEXT);
        Assert.assertEquals(secondMonitorMenu.getText(), MonitorPage.SECOND_MENU_TEXT);
    }

}
