import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
public class RedditCatsTest {
		private WebDriver driver;
		  private Map<String, Object> vars;
		  JavascriptExecutor js;
	@Before
	public void name() {
		System.setProperty("webdriver.gecko.driver", "Firefox/geckodriver-win64.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		options.addArguments("--disable-notifications");
		RemoteWebDriver driver = new ChromeDriver(options);
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	
	
	//driver.manage().window().setSize(new Dimension(1200, 800));
	  @Test
	public void fUNTITLE() {
		  driver.get("https://www.reddit.com/r/cats/ ");
		  driver.manage().window().setSize(new Dimension(1200, 800));
		  assertThat(driver.findElement(By.cssSelector(".\\_2yYPPW47QxD4lFQTKpfpLQ")).getText(), is("Cats"));
	  }
	  @Test
	 public void fUNJOINBUTTONEXISTS() {
		  driver.get("https://www.reddit.com/r/cats/");
		  assertThat(driver.findElement(By.cssSelector(".\\_1Q_zPN5YtTLQVG72WhRuf3 > .\\_1LHxa-yaHJwrPK8kuyv_Y4")).getText(), is("Join"));
	  }
	  @Test
	 public void fUNSIGNUPLINK() {
		  driver.get("https://www.reddit.com/r/cats/");
		  driver.manage().window().setSize(new Dimension(1200, 800));
		  {
		      WebElement element = driver.findElement(By.xpath("//a[contains(text(),\'sign up\')]"));
		      String attribute = element.getAttribute("href");
		      vars.put("herf", attribute);
		    }
		  assertEquals(vars.get("herf").toString(), "https://www.reddit.com/register/?dest=https%3A%2F%2Fwww.reddit.com%2Fr%2Fcats%2F");
	  }
	  @Test
	 public void fUNRULES10ITEMS() {
		  driver.get("https://www.reddit.com/r/cats/");
		  driver.manage().window().setSize(new Dimension(1200, 800));
	  }
	  @Test
	  public void fUNSEARCHSMELLYCAT() {
		  driver.get("https://www.reddit.com/r/cats/");
		  driver.manage().window().setSize(new Dimension(1200, 800));
	  }
	  @Test
	  public void fUNRULE3() {
		  driver.get("https://www.reddit.com/r/cats/");
		  driver.manage().window().setSize(new Dimension(1200, 800));
	  }
}