package Tests;

//import PageLocators.LoginPageLocators;
import io.cucumber.java.After;
import io.cucumber.java.Before;
//import io.cucumber.messages.types.Scenario;
//import cucumber.api.Scenario;
import io.cucumber.java.Scenario;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

//import org.openqa.selenium.devtools.v118.network.Network;
//import org.openqa.selenium.devtools.v118.network.model.Response;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
public class Hooks {
	public static ChromeDriver driver ;
    //LoginPageLocators loginLoc = new LoginPageLocators();

public static Scenario scenario;


    @Before
    public void setup(Scenario scenario)
    {
        Hooks.scenario=scenario;
        driver = new ChromeDriver();
        driver.navigate().to("http://192.168.50.107:31000/auth/Dev/login");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //loginLoc.UsrName(driver).sendKeys("admin");
        //loginLoc.PssWrd(driver).sendKeys("111");
       // loginLoc.LoginButton(driver).click();
        Hooks.driver.manage().timeouts().implicitlyWait(9, TimeUnit.SECONDS);


    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(2000);
     //   driver.quit();
    }
}
