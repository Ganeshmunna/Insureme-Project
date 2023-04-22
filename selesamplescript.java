package seleniumsamplepack;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class selesamplescript {
	
		 
	public static void main(String[] args)
	{	
           System.out.println("swapnil selenium inruance website testing study "); 
	
        // TODO Auto-generated method stub 
           //windows
   		//System.setProperty("webdriver.chrome.driver","C:\\Users\\jadha\\Downloads\\chromedriver_win32\\chromedriver.exe");
           System.setProperty("webdriver.chrome.driver","/usr/bin/chromedriver"); //ubuntu


        ChromeOptions chromeOptions = new ChromeOptions();
   		WebDriver driver = new ChromeDriver(chromeOptions);
   		driver.get("http://65.2.149.114:8084//contact.html"); //where website is up
   		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
   		driver.findElement(By.id("inputName")).sendKeys("swapnil jadhav");
   		driver.findElement(By.id("inputNumber")).sendKeys("9975179519");
   		driver.findElement(By.id("inputMail")).sendKeys("swapnil919@gmail.com");
   		driver.findElement(By.id("inputMessage")).sendKeys("Hello Insurer");
   		driver.findElement(By.id("my-button")).click();
   		
   		String message = driver.findElement(By.id("response")).getText();
   		if(message.equals("Message Sent")) {
   			System.out.println("contact page tested Successfully");
   		} else 
   		{
   			System.out.println("contact page testing failed");
   		}
   		
           	
	System.out.println("selenuim contact page testing executed"); 
		
	}

 }
