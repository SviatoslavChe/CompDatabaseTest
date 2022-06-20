import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddingNewPcPage {

    private WebDriver driver;

    public AddingNewPcPage (WebDriver driver) {
        this.driver=driver;
    }

    private By nameField = By.xpath("//*[@id=\"name\"]");
    private By introduceDateField = By.xpath("//*[@id=\"introduced\"]");
    private By discontinuedDateField = By.xpath("//*[@id=\"discontinued\"]");
    private By companyList = By.xpath("//*[@id=\"company\"]");
    private By company = By.xpath("//*[@id=\"company\"]/option[16]");
    private By createButton = By.xpath("//*[@id=\"main\"]/form/div/input");
    private By cancelButton = By.xpath("//*[@id=\"main\"]/form/div/a");


    public HomePage fillingAllFields (String name, String introducingDate, String discontinueDate){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(introduceDateField).sendKeys(introducingDate);
        driver.findElement(discontinuedDateField).sendKeys(discontinueDate);
        driver.findElement(companyList).click();
        driver.findElement(company).click();
        driver.findElement(createButton).click();
        return new HomePage(driver);
    }

    public HomePage fillingOnlyName (String name){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(createButton).click();
        return new HomePage(driver);
    }
}
