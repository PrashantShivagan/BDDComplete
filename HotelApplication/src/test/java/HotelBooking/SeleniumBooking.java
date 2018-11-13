package HotelBooking;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class SeleniumBooking {
	public static void main(String args[]) throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///D:/hotelBooking/hotelbooking.html");
		
		String title=driver.getTitle();
		System.out.println("The Page title is: "+ title);
		
		
		driver.findElement(By.name("txtFN")).sendKeys("");
		
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("txtFN")).sendKeys("Prashant");
		
		
		driver.findElement(By.name("txtLN")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageLast = driver.switchTo().alert().getText();
		System.out.println(alertMessageLast);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("txtLN")).sendKeys("Shivagan");
		
		
		driver.findElement(By.name("Email")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageEmail = driver.switchTo().alert().getText();
		System.out.println(alertMessageEmail);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("Email")).sendKeys("prashantshivagan@gmail.com");
		
		driver.findElement(By.name("Email")).sendKeys("a.com");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageEmail1 = driver.switchTo().alert().getText();
		System.out.println(alertMessageEmail1);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Email")).sendKeys("prashantshivagan@gmail.com");
		
		
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("123654789");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessagePhone = driver.switchTo().alert().getText();
		System.out.println(alertMessagePhone);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).clear();
		driver.findElement(By.cssSelector("input[pattern='[789][0-9]{9}']")).sendKeys("8692837660");
		
		
		Select dropc = new Select(driver.findElement(By.name("city")));
		dropc.selectByVisibleText("Select City");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageCity = driver.switchTo().alert().getText();
		System.out.println(alertMessageCity);
		driver.switchTo().alert().accept();
		
		dropc.selectByVisibleText("Pune");
		
		Select drops = new Select(driver.findElement(By.name("state")));
		drops.selectByVisibleText("Select State");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageState = driver.switchTo().alert().getText();
		System.out.println(alertMessageState);
		driver.switchTo().alert().accept();
		
		drops.selectByVisibleText("Maharashtra");
		
		
		Select dropp = new Select(driver.findElement(By.name("persons")));
		dropp.selectByVisibleText("1");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessagePerson = driver.switchTo().alert().getText();
		System.out.println(alertMessagePerson);
		driver.switchTo().alert().accept();
		
		dropp.deselectByVisibleText("3");
		
		
		
		
		driver.findElement(By.id("txtCardholderName")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageCard = driver.switchTo().alert().getText();
		System.out.println(alertMessageCard);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("txtCardholderName")).sendKeys("Prashant");
		
		
		driver.findElement(By.name("debit")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessagedebit = driver.switchTo().alert().getText();
		System.out.println(alertMessagedebit);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("debit")).sendKeys("1001-6031-7896-1896");
		
		driver.findElement(By.name("cvv")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessagecvv = driver.switchTo().alert().getText();
		System.out.println(alertMessagecvv);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("cvv")).sendKeys("456");
		
		driver.findElement(By.name("month")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessagemnt = driver.switchTo().alert().getText();
		System.out.println(alertMessagemnt);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("month")).sendKeys("January");
		
		driver.findElement(By.name("year")).sendKeys("");
		driver.findElement(By.id("btnPayment")).click();
		Thread.sleep(3000);
		String alertMessageyer = driver.switchTo().alert().getText();
		System.out.println(alertMessageyer);
		driver.switchTo().alert().accept();
		
		driver.findElement(By.name("year")).sendKeys("2028");
		
		driver.navigate().to("file:///D:/hotelBooking/success.html");
	}
	
}
