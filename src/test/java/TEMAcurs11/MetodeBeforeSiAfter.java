package TEMAcurs11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import static org.testng.Assert.assertEquals;

public class MetodeBeforeSiAfter {

    WebDriver driver;


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/CursSelenim/src/test/Driver/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://keybooks.ro");
    }


    @Test
    public void LoginMetoda() throws InterruptedException {
      WebElement login = driver.findElement(By.xpath("//li[@class=\"menu_user_login\"]"));
      login.click();

      WebElement loginField= driver.findElement(By.xpath("//header[@class=\"top_panel_wrap top_panel_style_4 scheme_original menu_show\"]//input[@id=\"log\"]"));
      loginField.sendKeys("TestUser");

      WebElement password = driver.findElement(By.xpath("//header[@class=\"top_panel_wrap top_panel_style_4 scheme_original menu_show\"]//input[@id=\"password\"]"));
      password.sendKeys("12345@67890");

      WebElement element= driver.findElement(By.xpath("//header[@class=\"top_panel_wrap top_panel_style_4 scheme_original menu_show\"]//input[@value=\"Login\"]"));
      element.click();

      Thread.sleep(3000);
      WebElement textUser = driver.findElement(By.xpath("//div[@class=\"rs_error_message_content\"]"));
      String text = textUser.getText();
     assertEquals(text, "Slider with alias sliderhome1 not found.");


    }


    @AfterClass
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }


}
