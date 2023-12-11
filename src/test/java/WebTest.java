import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebTest {
    private WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void google()
    {
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Automation");
        driver.findElement(By.name("btnK")).submit();
        String title = driver.getTitle();
        Assert.assertEquals("avg", title);
    }

    @AfterTest
    public void tearDown()
    {
        driver.quit();
    }

}
