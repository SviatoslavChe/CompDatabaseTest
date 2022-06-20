import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver =driver;
    }

    private By addComputerButton = By.xpath("//*[@id=\"add\"]");
    private By filterButton = By.xpath("//*[@id=\"searchsubmit\"]");
    private By searchField = By.xpath("//*[@id=\"searchbox\"]");
    private By resultOfAdding = By.xpath("//*[@id=\"main\"]/div[1]");

    public AddingNewPcPage addNewPC (){
        driver.findElement(addComputerButton).click();
        return new AddingNewPcPage(driver);
    }
    public String doneText (){
        return driver.findElement(resultOfAdding).getText();
    }
}
