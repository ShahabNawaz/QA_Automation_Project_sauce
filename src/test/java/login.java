import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class login{
   WebDriver driver;
   String Url="https://www.saucedemo.com/";

   @BeforeMethod
   public void setUp(){
       System.setProperty("WebDriver", "C:\\Users\\Shahab\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
       driver=new ChromeDriver();
       driver.manage().window().maximize();
    }
    @Test
    public void testLogin(){
       System.out.println("Loading URL");
       driver.get(Url);
        WebElement username=driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");

        WebElement password=driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginbutton=driver.findElement(By.id("login-button"));
        loginbutton.click();
        String expectedUrl="https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Login failed");

    }
    @AfterClass
    public void tearDown(){
       driver.quit();
    }
}
