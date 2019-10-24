import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PHPDemoUser {
	 public String baseUrl = "https://www.phptravels.net";
	    String driverPath = "E:\\Selenium\\Chromedriver.exe";
	    public WebDriver driver;
	    
	
  @Test
  public void login() {
	  System.setProperty("webdriver.chrome.driver", driverPath);
      driver = new ChromeDriver();
      driver.get(baseUrl);
      driver.manage().window().maximize();  
      int size = driver.findElements(By.tagName("iframe")).size();
      System.out.println(size);
      driver.switchTo().frame("ym-native-frame");
      
      try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      
      driver.findElement(By.xpath("//*[@id=\"li_myaccount\"]/a")).click();
      driver.findElement(By.xpath("//*[@id=\"li_myaccount\"]/ul/li[1]/a")).click();
      String expectedtitle = "Login";
      String actualtitle = driver.getTitle();
      Assert.assertEquals(actualtitle, expectedtitle);
  }
}
