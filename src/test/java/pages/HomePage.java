package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.TestBase;

public class HomePage extends TestBase{
	@FindBy(id="nameofuser")
	WebElement nameOfuser;
	
	@FindBy(xpath="//div[@class='col-lg-9']/div/div/div/div/h4/a")
	List<WebElement> items;
	
	@FindBy(xpath="//a[contains(text(),'Add to cart')]")
	WebElement addCart;
	
	@FindBy(xpath="//body/nav[1]/div[1]/div[1]/ul[1]/li[1]/a[1]")
	WebElement homeLink;
	
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(xpath="//tbody/tr/td[2]")
	List<WebElement> cartItems;
	
	@FindBy(xpath="//tbody/tr/td[4]")
	List<WebElement> delete;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkUserName() {
		System.out.println("***User Name**"+ nameOfuser.getText());
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(nameOfuser));		
		return nameOfuser.isDisplayed();
		//return nameOfuser.getText().contains("Bhanu");
	}
	
	public void addToCart(String itemName) {
		for(WebElement item : items) {
			if(item.getText().equalsIgnoreCase(itemName)) {
				JavascriptExecutor js= (JavascriptExecutor) driver; 
				js.executeScript("arguments[0].click();",item);
				addCart.click();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
				wait.until(ExpectedConditions.alertIsPresent());
				driver.switchTo().alert().accept();
				homeLink.click();
			}
		}
	}
	
	public void goToCart()
	{
		System.out.println("Inside go to Cart");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.elementToBeClickable(cart)).click();
	}
	
	public boolean checkitems() {
		System.out.println("Inside go to Cart");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));	
		wait.until(ExpectedConditions.visibilityOfAllElements(cartItems));
		if(cartItems.size()>0)
			return true;
		return false;
	}
	
	public void deleteitem(String delItem) {
		System.out.println("Inside delete item");
		int index=0;
		for(int i=0;i<cartItems.size();i++) {
			if(cartItems.get(i).getText().equalsIgnoreCase(delItem))
			{
				index=i;
				break;
			}
		}
		for(int j=0;j<delete.size();j++) {
			if(j==index) {
				delete.get(j).click();
				break;
			}
		}
	}
	
	public boolean checkDeletedElement(String delItem) {
		System.out.println("Inside check deleted element");
		if(cartItems.contains(delItem)) {
			return false;
		}
		else {	
			return true;
		}
	}
}
