import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class AddingTest {

    private WebDriver driver;

    @BeforeMethod (description = "Browser opening")
    public void setUpChrome() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://computer-database.gatling.io/computers");

    }

    @AfterMethod (description = "Browser closing")
    public void tearDown(){
        driver.quit();
    }

    @Test (description = "Creating new computer with all correct data")
    public void addingTest(){
        HomePage homePage = new HomePage(driver);
        AddingNewPcPage addingNewPcPage = new AddingNewPcPage(driver);
        homePage.addNewPC();
        addingNewPcPage.fillingAllFields("Che","1996-12-15","2022-04-15");
        String result = homePage.doneText();
        Assert.assertEquals("Done ! Computer Che has been created", result);
    }

    @Test (description = "Creating new computer with only name")
    public void addOnlyName(){
        HomePage homePage = new HomePage(driver);
        AddingNewPcPage addingNewPcPage = new AddingNewPcPage(driver);
        homePage.addNewPC();
        addingNewPcPage.fillingOnlyName("ololo");
        String result = homePage.doneText();
        Assert.assertEquals("Done ! Computer ololo has been created", result);
    }
}
