package Tendable.Tendable_Challenge;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Accessibility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.tendable.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		WebElement ourStory = driver.findElement(By.xpath("//a[text()='Our Story']"));
		if (ourStory.isDisplayed() && ourStory.isEnabled()) {
			ourStory.click();
			String url = driver.getCurrentUrl();
			Assert.assertEquals("https://www.tendable.com/our-story", url);
			WebElement requestDemo = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
			if(requestDemo.isDisplayed() && requestDemo.isEnabled())
			{
				requestDemo.click();
				String title = driver.getTitle();
				Assert.assertEquals("Tendable | Request a demo", title);
			}
		}

		WebElement ourSolution = driver.findElement(By.xpath("//a[text()='Our Solution']"));
		if (ourSolution.isDisplayed() && ourSolution.isEnabled()) {
			ourSolution.click();
			String url = driver.getCurrentUrl();
			Assert.assertEquals("https://www.tendable.com/our-solution", url);
			WebElement requestDemo = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
			if(requestDemo.isDisplayed() && requestDemo.isEnabled())
			{
				requestDemo.click();
				String title = driver.getTitle();
				Assert.assertEquals("Tendable | Request a demo", title);
			}
		}

		WebElement whyTendable = driver.findElement(By.xpath("//a[text()='Why Tendable?']"));
		if (whyTendable.isDisplayed() && whyTendable.isEnabled()) {
			whyTendable.click();
			String url = driver.getCurrentUrl();
			Assert.assertEquals("https://www.tendable.com/why-tendable", url);
			WebElement requestDemo = driver.findElement(By.xpath("//a[text()='Request A Demo']"));
			if(requestDemo.isDisplayed() && requestDemo.isEnabled())
			{
				requestDemo.click();
				String title = driver.getTitle();
				Assert.assertEquals("Tendable | Request a demo", title);
			}
			
		}
		
		//driver.navigate().to("https://www.tendable.com/contact-us");
		
		WebElement contactUs = driver.findElement(By.xpath("//a[text()='Contact Us']"));
		contactUs.click();
		
		WebElement form = driver.findElement(By.xpath("//div[normalize-space()='Marketing']/following::button[1]"));
		form.click();
		
		WebElement fullname = driver.findElement(By.xpath("//input[@id='form-input-fullName']"));
		Actions act = new Actions(driver);
		
		act.sendKeys(fullname,"Akshay G Mankar").
		keyDown(Keys.TAB).sendKeys("Tendable").
		keyDown(Keys.TAB).sendKeys("9687898545").
		keyDown(Keys.TAB).sendKeys("akshay@gmail.com").
		build().perform();
		
		WebElement jobRole = driver.findElement(By.xpath("//form[@id='contactMarketingPipedrive-163701']//select[@id='form-input-jobRole']"));
	
		Select sel = new Select(jobRole);
		
		sel.selectByVisibleText("Management");
		
		WebElement consent = driver.findElement(By.xpath("(//input[@id='form-input-consentAgreed-0'])[1]"));
		consent.click();
		
		WebElement submit = driver.findElement(By.xpath("//button[@data-loading-text='Loading...'][normalize-space()='Submit']"));
		submit.click();
		
		WebElement errorMessage = driver.findElement(By.xpath("//p[contains(text(),'Sorry, there was an error submitting the form. Ple')]"));
        if (errorMessage.isDisplayed()) {
            System.out.println("Test PASSED: Error message is displayed");
        } else {
            System.out.println("Test FAILED: Error message is not displayed");
        }

		
	}
}
