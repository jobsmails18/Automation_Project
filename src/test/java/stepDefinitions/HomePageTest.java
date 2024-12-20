package stepDefinitions;

import Pages.HomePage;
import com.sun.swing.internal.plaf.synth.resources.synth_sv;
import io.cucumber.java.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePageTest
{
	private WebDriver driver;
	HomePage page = null;
	WebDriverWait explicitWait;
	
	@Before
	public void setUp()
	{
		System.out.println("setUp calling");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		page = new HomePage(driver);

	}
	
	@Given("I navigate to the Espncricinfo url {string}")
	public void I_navigate_to_the_Espncricinfo_url(String url) throws InterruptedException {
		Thread.sleep(2000);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@When("I enter {string} in search field")
	public void I_enter_in_search_field(String input) throws InterruptedException {
		System.out.println("I_enter_in_search_field method: "+input);
		//page.search(input);
		Thread.sleep(2000);
		try {
			page.clickByJavaSE();
			page.searchIcon();
			page.searchField(input);
			page.enter();
		} catch (Exception e) {
			System.out.println("**+1exc++" + e.getMessage());
		}
	}
	
	@Then("I should see the search result {string}")
	public void I_should_see_the_search_result(String searchResult) throws InterruptedException {
		Thread.sleep(2000);
		String result = page.getSearchResult();
		System.out.println(" Actual search Result is: "+result);
		System.out.println(" Expected search Result is: "+searchResult);
		Assert.assertEquals("You searched for æ"+searchResult+"Æ", result);
		Thread.sleep(2000);
	}

	@And("Url is {string}")
	public void Url_is(String urlToSearch) throws InterruptedException {
		String url = driver.getCurrentUrl();
		System.out.println(" Actual URL with search result is: "+url);
		System.out.println(" Expected URL with search result is: "+url);
		Assert.assertEquals(urlToSearch, url);
	}
	
	@After
	public void tearDown()
	{
		System.out.println("tearDown calling");
		driver.close();
	}
	
}