package linkedin;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class login {

	public static WebDriver driver;

	@BeforeTest
	public void LaunchBrowser() throws InterruptedException {

		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();

		driver.get("https://mail.google.com/mail/u/0/#inbox");
		

		//Thread.sleep(5000);

		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test // (dataProvider = "getData", dataProviderClass = loginData.class)
	public void LoginPage() throws InterruptedException {

		// claseloginPopup
		driver.findElement(By.xpath("//span[@class='_30XB9F']")).click();

		WebElement target = driver.findElement(By.xpath("//div[@class='H6-NpN _3N4_BX']"));

		//

		Actions action = new Actions(driver);
		action.moveToElement(target).perform();
//		
		Thread.sleep(2000);

		WebElement target2 = driver.findElement(By.xpath("(//li[@class='AT0fUR'])[1]"));

		action.doubleClick(target2).perform();
		
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath("//a[@class='_2KpZ6l _2HKlqd _3NgS1a']")).click();

//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click", signIn);
//		
		//driver.findElement(By.xpath("//a[@title='My Profile']")).click();
		// driver.findElement(By.xpath("input[@class='_2IX_2-
		// VJZDxU']")).sendKeys(Username);

		// driver.findElement(By.id("nav-link-accountList-nav-line-1")).click();
		// driver.findElement(By.id("ap_email")).sendKeys(Username);
		// driver.findElement(By.id("continue")).click();
		// driver.findElement(By.id("ap_password")).sendKeys(Password);
		// driver.findElement(By.id("signInSubmit")).click();

	}

//	@Test
//	public void SearchProduct() {
//		
//		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("mobile cover redmi note 8");
//		driver.findElement(By.id("nav-search-submit-button")).click();
//	}

}
