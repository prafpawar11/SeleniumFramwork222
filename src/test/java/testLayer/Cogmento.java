package testLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Cogmento {
	static WebDriver driver;

	@BeforeTest
	public void openaUrl() {
		driver = new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test
	public void loginFunctionality() {
		driver.findElement(By.name("email")).sendKeys("prafulp1010@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Pr@ful0812");
		driver.findElement(By.xpath("//div[text()='Login']")).click();
	}

	@Test(priority = 1)
	public void validateContactPage() {
		driver.findElement(By.xpath("//a[@href='/contacts']")).click();

		String actualURl = driver.getCurrentUrl();

		Assert.assertTrue(actualURl.contains("contact"));

	}

	@Test(priority = 2)
	public void validateCreatePageOnContactPage() {
		driver.findElement(By.xpath("//a[@href='/contacts/new']")).click();

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
