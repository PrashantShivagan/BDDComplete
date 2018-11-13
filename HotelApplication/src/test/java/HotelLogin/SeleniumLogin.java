package HotelLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLogin {
	public static void main(String args[]) throws Exception{
		WebDriver driver = new FirefoxDriver();
		
		driver.get("file:///D:/hotelBooking/login.html");
		String strheading = driver.findElement(By.xpath(".//*[@id='mainCnt']/div/div[1]/h1")).getText();
		if(strheading.contentEquals("Hotel Booking Application"))
		{
			System.out.println("Heading matched");
		}else {
			System.out.println("Heading Not Matched");
		}
	
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(300);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		driver.findElement(By.name("userName")).sendKeys("capgemini");
		Thread.sleep(300);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		//driver.findElement(By.name("userPwd")).sendKeys("capg1234");
		driver.findElement(By.name("userPwd")).sendKeys("blank");
		Thread.sleep(300);
		//driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.findElement(By.className("btn")).click();
		//driver.navigate().to("file:///D:/hotelBooking/hotelbooking.html");
		Thread.sleep(5000);
		//driver.switchTo().alert().getText();
		//driver.switchTo().alert().accept();
		//Thread.sleep(3000);
		//driver.close();
		String alertMessage = driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		driver.switchTo().alert().accept();
	}
	
	
}
