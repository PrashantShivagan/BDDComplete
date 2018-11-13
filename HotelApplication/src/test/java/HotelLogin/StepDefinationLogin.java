package HotelLogin;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageBean.HotelBookingPageFactory;
import pageBean.HotelLoginPageFactory;

public class StepDefinationLogin {
	
	private WebDriver driver;
	private HotelLoginPageFactory objhlpg;
	
	@Given("^user is on login page$")
	public void user_is_on_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objhlpg = new HotelLoginPageFactory(driver);	
		driver.get("file:///D:/hotelBooking/login.html");
		
		}

	@Then("^check the heading of the page$")
	public void check_the_heading_of_the_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String strheading =  driver.findElement(By.xpath(".//*[@id='mainCnt']/div/div[1]/h1")).getText();
		if(strheading.contentEquals("Hotel Booking Application"))
			System.out.println("Heading matched");
		else
			System.out.println("Heading Not Matched");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user enters valid username, valid password$")
	public void user_enters_valid_username_valid_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objhlpg.setPfuname("capgemini");
		objhlpg.setPfpwd("capg1234");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.close();
		
		
	}

	@Then("^navigate to hotelBooking$")
	public void navigate_to_hotelBooking() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.navigate().to("file:///D:/hotelBooking/hotelbooking.html");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user does not enter either username or password$")
	public void user_does_not_enter_either_username_or_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objhlpg.setPfuname("");
		Thread.sleep(1000);
		
	}

	@When("^click the login Button$")
	public void click_the_login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objhlpg.setPflogin();
		Thread.sleep(1000);
	}

	@Then("^display appropriate message$")
	public void display_appropriate_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String strheading = driver.findElement(By.xpath(".//*[@id='userErrMsg']")).getText();
		assertEquals(strheading, "* Please enter userName.");
		driver.close();
	}

	@When("^user enters incorrect username or password$")
	public void user_enters_incorrect_username_or_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		objhlpg.setPfuname("cg");
		objhlpg.setPfpwd("capg1234");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		objhlpg.setPflogin();
	}

	@Then("^display login failed message$")
	public void display_login_failed_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("********" + alertMessage);
				
	}


}
