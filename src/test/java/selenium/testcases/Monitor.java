package selenium.testcases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.HomePage;
import selenium.pageobjects.MonitorPage;
import selenium.pageobjects.StartPage;

public class Monitor extends SeleniumTestWrapper {

    StartPage startPage = PageFactory.initElements(getDriver(), StartPage.class);
    HomePage homePage = PageFactory.initElements(getDriver(), HomePage.class);
    MonitorPage monitorPage = PageFactory.initElements(getDriver(), MonitorPage.class);

    @Before
    public void setup() {
        startPage.open();
    }

    @Test
    public void checkElectionsMonitor() {
        homePage.pressMonitor();
        monitorPage.verifyMonitorMenu();
    }
}
