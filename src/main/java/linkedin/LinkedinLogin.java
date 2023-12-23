package linkedin;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class LinkedinLogin {
	public static WebDriver driver;
	//public static SoftAssert softassert=new SoftAssert();
	
	@Test
	public void launchBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--incognito");
        options.addArguments("--remote-allow-origins=*");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation","disable-infobars"));


		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/home");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
		
	}
	
	@Test(dataProvider = "getData",dataProviderClass =LinkedinData.class)
	public void loginPage(String username, String password) throws InterruptedException {
		
		String expectedResult="LinkedIn: Log In or Sign Up";
		String actualResult= driver.getTitle();
		System.out.println(driver.getTitle());
		if(expectedResult.equals(actualResult)) {
			System.out.println("Title Of This Page : ");
		}else {
			System.out.println("Title Not This Page");
			
		}
		
		driver.findElement(By.xpath("//input[@id='session_key']")).sendKeys(username);
		driver.findElement(By.id("session_password")).sendKeys(password);
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		
		//String title=driver.getTitle();
		
		//softassert.assertTrue(true, "Title Of This Page : "+ driver.getTitle());
		
	
		
		Thread.sleep(3000);
		
		//Click on Job Option
		driver.findElement(By.xpath("//span[@title='Jobs']")).click();
		
		//Click on Search Option
		driver.findElement(By.xpath("//input[@class='search-global-typeahead__input']")).sendKeys("QA Tester Fresher");
//		driver.findElement(By.xpath("//button[text()='Search']")).click();
//		
//		Thread.sleep(3000);
//		
//		//driver.findElement(By.xpath("//input[@class='search-global-typeahead__input']")).sendKeys(Keys.ENTER);
//
//		driver.findElements(By.xpath("//li[contains(@class,'jobs-search-results')]"));
		
		driver.findElement(By.xpath("(//span[text()='Show all'])[1]")).click();
		Thread.sleep(2000);

		
		//get list
		ArrayList<WebElement> elements = (ArrayList<WebElement>) driver.findElements(By.xpath("//li[contains(@class,'jobs-search-results')]//a"));
		
		for(WebElement element: elements) {
			System.out.println(element.getText());
		}
		
		elements.get(1).click();
		
		
		
	}

}
