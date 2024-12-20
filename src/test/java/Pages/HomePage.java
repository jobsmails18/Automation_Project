package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id='wzrk-cancel']")
    private WebElement POP_UP_CANCEL;

    @FindBy(xpath="//div[@class='ds-flex ds-flex-row ds-items-center']/div[6]/i")
    private WebElement SEARCH_ICON;

    @FindBy(xpath="//input[@placeholder='Search Players, Teams or Series']")
    private WebElement ENTER_TEXT;

	@FindBy(xpath="//*[contains(text(), 'You searched for')]")
    private WebElement SEARCH_RESULT;
	
	
    public void searchIcon() throws InterruptedException {
        Thread.sleep(2000);
        SEARCH_ICON.click();
    }

    public void searchField(String input) throws InterruptedException {
        Thread.sleep(2000);
        ENTER_TEXT.sendKeys(input);
    }

    public void enter() throws InterruptedException {
        Thread.sleep(2000);
        ENTER_TEXT.sendKeys(Keys.ENTER);
    }

	
	public String getSearchResult() throws InterruptedException {
        Thread.sleep(2000);
        String result = SEARCH_RESULT.getText();
        return result;
    }


    public void clickByJavaSE() throws InterruptedException {
        System.out.println("In clickByJavaSE method");
        Thread.sleep(2000);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", POP_UP_CANCEL);
    }

}
