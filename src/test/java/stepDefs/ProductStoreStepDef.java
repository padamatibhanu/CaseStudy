package stepDefs;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.TestBase;
import commonUtils.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class ProductStoreStepDef extends TestBase {
	LoginPage loginPage;
	HomePage homePage;

	@Before
	public void setUp() {
		loginPage = new LoginPage();
		homePage = new HomePage();
	}

	@Given("User is on login page")
	public void user_is_on_login_page() {
		initialize();
		loginPage.clickOnLogin();
	}

	@When("User enter username and password")
	public void user_enter_username_and_password() {
		loginPage.enterUserName();
		loginPage.enterPassword();
		loginPage.clickLoginButton();
	}

	@Then("User must be on home page")
	public void user_must_be_on_home_page() {
		// boolean isUserLoggedIn = homePage.checkUserName();
		// Assert.assertTrue(isUserLoggedIn);
	}

	@Given("User is on Home Page")
	public void user_is_on_home_page() {
		// boolean isUserLoggedIn = homePage.checkUserName();
		// Assert.assertTrue(isUserLoggedIn);
	}

	@When("User adds the product {string}")
	public void user_adds_the_product(String itemName) {
		homePage.addToCart(itemName);
	}

	@Then("Item must be added to cart")
	public void item_must_be_added_to_cart() {
		homePage.goToCart();
		homePage.checkitems();
	}

	@Given("User is on Cart")
	public void user_is_on_cart() {
		homePage.goToCart();
	}

	String delItem;

	@When("cart contains unwanted items delete them")
	public void cart_contains_unwanted_items_delete_them(DataTable deleteData) {
		List<Map<String, String>> data = deleteData.asMaps();
		delItem = data.get(0).get("deleteItems");
		System.out.println("Delete element "+delItem);
		homePage.deleteitem(delItem);
	}

	@Then("item must not be in cart")
	public void item_must_not_be_in_cart() {
		boolean status = homePage.checkDeletedElement(delItem);
		Assert.assertTrue(status);
	}
	
//	@After	
//	public void tearDown(Scenario scenario) {
//	    if (scenario.isFailed()) {
//	            final byte[] screenshot = ((TakesScreenshot) driver)
//	                        .getScreenshotAs(OutputType.BYTES);
//	            scenario.embed(screenshot, "image/png"); 
//	    }
//	    driver.close();
//	}
}
