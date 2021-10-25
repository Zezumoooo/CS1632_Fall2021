import org.junit.After;
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
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class D3Test {
	private WebDriver driver;
	  private Map<String, Object> vars;
	  JavascriptExecutor js;
	  @Before
	  public void setup() {
		  driver=new ChromeDriver();
		  js=(JavascriptExecutor) driver;
		  vars=new HashMap<String, Object>();
	  }
	  @After
	  public void tearDown() {
		  driver.quit();
	  }
	  @Test
	  public void FUNLINKS(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  
	  }
	  @Test
	  public void FUNLISTING(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.get("https://cs1632.appspot.com/rent-a-cat,");
		  driver.get("https://cs1632.appspot.com/feed-a-cat");
		  driver.get("https://cs1632.appspot.com/greet-a-cat");
		  driver.get("https://cs1632.appspot.com/reset");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  {}
		  assertThat(driver.findElement(By.linkText("Catalog")).getAttribute("/"), is("https://cs1632.appspot.com/"));
		  {}
		  assertThat(driver.findElement(By.linkText("Rent-A-Cat")).getAttribute("/rent-a-cat"), is("https://cs1632.appspot.com/"));
		  {}
		  assertThat(driver.findElement(By.linkText("Feed-A-Cat")).getAttribute("/feed-a-cat"), is("https://cs1632.appspot.com/"));
		  
		  {}
		  assertThat(driver.findElement(By.linkText("Greet-A-Cat")).getAttribute("/greet-a-cat"), is("https://cs1632.appspot.com/"));
		  assertThat(driver.findElement(By.linkText("Reset")).getAttribute("/reset"), is("https://cs1632.appspot.com/"));
	  }
	  @Test
	  public void FUNCATALOG(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  {
		  List<WebElement>elements=driver.findElements(By.xpath("/images/cat1.jpg"));
		  assert(elements.size() > 0);
		  }
		  {
		  List<WebElement>elements=driver.findElements(By.xpath("/images/cat2.jpg"));
		  assert(elements.size() > 0);
		  }
		  {
		  List<WebElement>elements=driver.findElements(By.xpath("/images/cat3.jpg"));
		  assert(elements.size() > 0);
		  }
	  }
	  @Test
	  public void FUNRENTACAT(){
		  driver.get("https://cs1632.appspot.com/rent-a-cat");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  
		  assertThat(driver.findElement(By.cssSelector(".col-xs-2 text-left > .rentSubmit()")).getText(),is("Rent"));
		  //
		  assertThat(driver.findElement(By.cssSelector(".col-xs-2 text-left > .returnSubmit()")).getText(),is("Return"));
	  }
	  @Test
	  public void FUNRENT(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  driver.findElement(By.id("Rent")).click();
		  driver.findElement(By.id("Rent")).sendKeys("1");
		  driver.findElement(By.id("Rent")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Success!"));
		  driver.findElement(By.id("Rent")).click();
		  driver.findElement(By.id("Rent")).sendKeys("1");
		  driver.findElement(By.id("Rent")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Failure!"));
		  // 2 3 
	  }
	  @Test
	  public void FUNRETURN(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  driver.findElement(By.id("Return")).click();
		  driver.findElement(By.id("Return")).sendKeys("1");
		  driver.findElement(By.id("Return")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Success!"));
		  driver.findElement(By.id("Return")).click();
		  driver.findElement(By.id("Return")).sendKeys("1");
		  driver.findElement(By.id("Return")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Failure!"));
		  // 2 3 
	  }
	  @Test
	  public void FUNFEEDACAT(){
		  driver.get("https://cs1632.appspot.com/feed-a-cat");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  assertThat(driver.findElement(By.cssSelector(".col-xs-2 text-left > .feedSubmit()")).getText(),is("Feed"));
	  }
	  @Test
	  public void FUNFEED(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  driver.findElement(By.id("Feed")).click();
		  driver.findElement(By.id("Feed")).sendKeys("1");
		  driver.findElement(By.id("Feed")).sendKeys(Keys.ENTER);
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Cat fight!"));
		  assertThat(driver.findElement(By.cssSelector(".col-xs-3 text-left")).getText(),is("Nom, nom, nom."));
		  // 1 2 3 
	  }
	  @Test
	  public void FUNGREETACAT(){
		  driver.get("https://cs1632.appspot.com/greet-a-cat");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  assertThat(driver.findElement(By.cssSelector("h4")).getText(), is("Meow!Meow!Meow!"));
	  }
	  @Test
	  public void FUNGREETACATWITHNAME(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  
	  }
	  @Test
	  public void FUNRESET(){
		  driver.get("https://cs1632.appspot.com/reset");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
		  assertThat(driver.findElement(By.cssSelector("/reset")).getText(),is("Reset"));
	  }
	  @Test
	  public void DEFECT1FUNRENT(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
	  }
	  @Test
	  public void DEFECT2FUNRENT(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
	  }
	  @Test
	  public void DEFECT3FUNFEEDACAT(){
		  driver.get("https://cs1632.appspot.com/");
		  driver.manage().window().setSize(new Dimension(1920, 1080));
	  }
}
