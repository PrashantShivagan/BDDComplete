package HotelBooking;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.lexer.Th;
import pageBean.HotelBookingPageFactory;

public class StepDefinationBooking {
	
	private WebDriver driver;
	private HotelBookingPageFactory book;
	
	
	
	
	
	@Given("^User is on booking page$")
	public void user_is_on_booking_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		book = new HotelBookingPageFactory(driver);
		driver.get("file:///D:/hotelBooking/hotelbooking.html");
	}

	@Then("^check the heading of page$")
	public void check_the_heading_of_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String strheading =  driver.findElement(By.xpath("html/body/div/h2")).getText();
		if(strheading.contentEquals("Hotel Booking Form"))
			System.out.println("Heading matched");
		else
			System.out.println("Heading Not Matched");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.close();
	}
	
	

	@When("^User does not enter firstname , lastname$")
	public void user_does_not_enter_firstname_lastname() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//driver.close();
		book.setPbooking();
	}

	@Then("^prompt user to fill in details$")
	public void prompt_user_to_fill_in_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();

		
	}

	@When("^User does not enter email in correct format$")
	public void user_does_not_enter_email_in_correct_format() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail(" ");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		
		
		
	}

	@Then("^prompt user to write input correctly$")
	public void prompt_user_to_write_input_correctly() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}

	@When("^User does not enter mobile number$")
	public void user_does_not_enter_mobile_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant"); Thread.sleep(1000);
		book.setPln("Shivagan"); Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com"); Thread.sleep(1000);
		book.setPphone(" "); Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^prompt user to enter mobile number$")
	public void prompt_user_to_enter_mobile_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
		
	}

	@When("^User enters  incorrect mobile no format and clicks the button$")
	public void user_enters_incorrect_mobile_no_format_and_clicks_the_button(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    //throw new PendingException();
		book.setPfn("Prashant"); Thread.sleep(1000);
		book.setPln("Shivagan"); Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com"); Thread.sleep(1000);
		
		List<String> list = arg1.asList(String.class);;
		
		for(int i=0; i<list.size(); i++) {
			book.getPphone().clear();
			book.setPphone(list.get(i)); Thread.sleep(1000);
			book.setPbooking();
		
			
			if(Pattern.matches("^[789][0-9]{9}$", list.get(i))) {
				System.out.println("*****Matched"+ list.get(i)+"****");
			}else {
				String alertMessage = driver.switchTo().alert().getText();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();
				System.out.println("" + alertMessage);
				System.out.println("****Not Matched" + list.get(i)+"*****");
			}
		}
		book.setPbooking();
	}

	@Then("^display alert msg$")
	public void display_alert_msg() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	
				
	}

	@When("^User does not select number of people$")
	public void user_does_not_select_number_of_people() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		
	}

	@Then("^prompt user to select the number of people$")
	public void prompt_user_to_select_the_number_of_people() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User does not address$")
	public void user_does_not_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^prompt user to fill in the address$")
	public void prompt_user_to_fill_in_the_address() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@When("^User does not select city$")
	public void user_does_not_select_city() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Select City");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		
	}

	@Then("^prompt user to select city$")
	public void prompt_user_to_select_city() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}

	@When("^User does not select state$")
	public void user_does_not_select_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Select State");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^prompt user to select state$")
	public void prompt_user_to_select_state() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}
	
	@When("^User does not select gender$")
	public void user_does_not_select_gender() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^prompt user to select gender$")
	public void prompt_user_to_select_gender() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}
	
	

	@When("^User does not enter card holder name$")
	public void user_does_not_enter_card_holder_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPhobbies("drawing");Thread.sleep(1000);
		book.setPchn(" ");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^prompt user to fill in card holder name$")
	public void prompt_user_to_fill_in_card_holder_name() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}

	@When("^User does not enter debit card number$")
	public void user_does_not_enter_debit_card_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit(" ");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		
		
	}

	@Then("^prompt user to enter debit card number$")
	public void prompt_user_to_enter_debit_card_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}
	
	
	@When("^User does not enter cvv number$")
	public void user_does_not_enter_cvv_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit("1020-7896-6325-6325");Thread.sleep(1000);
		book.setPcvv(" "); Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^prompt user to enter cvv number$")
	public void prompt_user_to_enter_cvv_number() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}

	@When("^User does not enter card expiration month$")
	public void user_does_not_enter_card_expiration_month() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit("1020-7896-6325-6325");Thread.sleep(1000);
		book.setPcvv("444"); Thread.sleep(1000);
		book.setPmonth(" ");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		
		
	}

	@Then("^prompt user to enter card expiration month$")
	public void prompt_user_to_enter_card_expiration_month() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
	}

	@When("^User does not enter card expiration year$")
	public void user_does_not_enter_card_expiration_year() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit("1020-7896-6325-6325");Thread.sleep(1000);
		book.setPcvv("444"); Thread.sleep(1000);
		book.setPmonth("January");Thread.sleep(1000);
		book.setPyear("");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		
	}

	@Then("^prompt user to enter card expiration year$")
	public void prompt_user_to_enter_card_expiration_year() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String alertMessage = driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		System.out.println("" + alertMessage);
		driver.close();
		
	}

	@When("^User clicks on confirm booking button$")
	public void user_clicks_on_confirm_booking_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit("1020-7896-6325-6325");Thread.sleep(1000);
		book.setPcvv("444"); Thread.sleep(1000);
		book.setPmonth("January");Thread.sleep(1000);
		book.setPyear("2020");Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
		Thread.sleep(1000);
	}

	@Then("^navigate to booking successful$")
	public void navigate_to_booking_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		//driver.navigate().to("file:///D:/hotelBooking/success.html");
		driver.findElement(By.partialLinkText("Click Here")).click();Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.close();
	}

	@When("^user enters (\\d+)$")
	public void user_enters(int arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		book.setPfn("Prashant");Thread.sleep(1000);
		book.setPln("Shivagan");Thread.sleep(1000);
		book.setPemail("prashantshivagan@gmail.com");Thread.sleep(1000);
		book.setPphone("8692837660");Thread.sleep(1000);
		book.setPcity("Pune");Thread.sleep(1000);
		book.setPstate("Maharashtra");Thread.sleep(1000);
		book.setPgender("male");Thread.sleep(1000);
		book.setPhobbies("music");Thread.sleep(1000);
		book.setPchn("Prashant");Thread.sleep(1000);
		book.setPdebit("1020-7896-6325-6325");Thread.sleep(1000);
		book.setPcvv("444"); Thread.sleep(1000);
		book.setPmonth("January");Thread.sleep(1000);
		book.setPyear("2020");Thread.sleep(1000);
		book.setPperson(String.valueOf(arg1)); Thread.sleep(1000);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		book.setPbooking();
	}

	@Then("^for (\\d+) allocate (\\d+)$")
	public void for_allocate(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		System.out.println("******** Rooms:" + arg2);
		if(arg1 <=3) {
			assertEquals(1, arg2);
		}
		else if(arg1<=6) {
			assertEquals(2, arg2);
		}
		else if(arg1<=9) {
			assertEquals(3, arg2);
		}
	}


}
