package pageBean;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HotelBookingPageFactory {
	WebDriver driver;
	

	@FindBy(name="txtFN")
	@CacheLookup
	WebElement pfn;
	

	@FindBy(name="txtLN")
	@CacheLookup
	WebElement pln;
	

	@FindBy(name="Email")
	@CacheLookup
	WebElement pemail;
	
	@FindBy(name="Phone")
	@CacheLookup
	WebElement pphone;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement pcity;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement pstate;
	
	@FindBy(name="a")
	@CacheLookup
	WebElement pgender;
	
	@FindBy(name="hobbies")
	@CacheLookup
	WebElement phobbies;
	
	@FindBy(name="persons")
	@CacheLookup
	WebElement pperson;
	
	@FindBy(id="txtCardholderName")
	@CacheLookup
	WebElement pchn;
	
	@FindBy(name="debit")
	@CacheLookup
	WebElement pdebit;
	
	@FindBy(name="cvv")
	@CacheLookup
	WebElement pcvv;
	
	@FindBy(name="month")
	@CacheLookup
	WebElement pmonth;
	
	@FindBy(name="year")
	@CacheLookup
	WebElement pyear;
	
	@FindBy(className="btn")
	@CacheLookup
	WebElement pbooking;
	
	public HotelBookingPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getPfn() {
		return pfn;
	}

	public void setPfn(String first) {
		pfn.sendKeys(first);
	}

	public WebElement getPln() {
		return pln;
	}

	public void setPln(String last) {
		pln.sendKeys(last);
	}

	public WebElement getPemail() {
		return pemail;
	}

	public void setPemail(String email) {
		 pemail.sendKeys(email);
	}

	public WebElement getPcity() {
		return pcity;
	}

	public void setPcity(String city) {
		Select s= new Select(pcity);
		s.selectByVisibleText(city);
	}

	public WebElement getPstate() {
		return pstate;
	}

	public void setPstate(String state) {
		Select s = new Select(pstate);
		s.selectByVisibleText(state);
	}

	public WebElement getPchn() {
		return pchn;
	}

	public void setPchn(String Cardholder) {
		 pchn.sendKeys(Cardholder);
	}

	public WebElement getPdebit() {
		return pdebit;
	}

	public void setPdebit(String debit) {
		 pdebit.sendKeys(debit);
	}

	public WebElement getPcvv() {
		return pcvv;
	}

	public void setPcvv(String cvv) {
		pcvv.sendKeys(cvv);
	}

	public WebElement getPmonth() {
		return pmonth;
	}

	public void setPmonth(String month) {
		pmonth.sendKeys(month);
	}

	public WebElement getPyear() {
		return pyear;
	}

	public void setPyear(String year) {
		pyear.sendKeys(year);
	}

	public WebElement getPbooking() {
		return pbooking;
	}

	public void setPbooking() {
		pbooking.click();
	}

	public WebElement getPphone() {
		return pphone;
	}

	public void setPphone(String phone) {
		 pphone.sendKeys(phone);
	}

	public WebElement getPperson() {
		return pperson;
	}

	public void setPperson(String person) {
		 pperson.sendKeys(person);;
	}

	public WebElement getPgender() {
		return pgender;
	}

	public void setPgender(String gender) {
	//	List<WebElement> genli = driver.findElements(By.name("gender"));
		if(gender.equals("male")) {
			pgender.findElement(By.id("male")).click();
		}
		else
			pgender.findElement(By.id("female")).click();
		
	}

	public WebElement getPhobbies() {
		return phobbies;
	}

	public void setPhobbies(String hobbies) {
		if(hobbies.equals("music")) {
			phobbies.findElement(By.xpath("//*[@id='music']")).click();
		}
		else if(hobbies.equals("drawing"))
			phobbies.findElement(By.xpath("//*[@id='drawing']")).click();
		
	}

	
	
	
}
