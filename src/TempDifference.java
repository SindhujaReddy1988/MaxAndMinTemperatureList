import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TempDifference {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		try
		{
		driver.get("http://www.weather.com");
		driver.findElement(By.xpath("//*[@id='APP']/div/div[6]/div[3]/div/ul/li[4]/a/span")).click();
		for(int i=1;i<10;i++)
		{
		WebElement highTemp = driver.findElement(By.xpath(".//*[@id='twc-scrollabe']/table/tbody/tr["+i+"]/td[4]/div/span[1]"));
		WebElement lowTemp = driver.findElement(By.xpath(".//*[@id='twc-scrollabe']/table/tbody/tr["+i+"]/td[4]/div/span[3]"));
		WebElement Day = driver.findElement(By.xpath(".//*[@id='twc-scrollabe']/table/tbody/tr["+i+"]/td[2]"));
		String highT = highTemp.getText();
		String lowT= lowTemp.getText();
		//System.out.println(highT);
		int hlen=highT.length();
		int llen=lowT.length();
		if(hlen ==3 && llen == 3)
		{
		String h2 =highT.substring(0,2);
		int htemp = Integer.parseInt(h2);
		String l2 =lowT.substring(0,2);
		int ltemp = Integer.parseInt(l2);
		int tempDiff = htemp-ltemp;
		if(tempDiff<20)
		{
			System.out.println("Testcase Passed:"+Day.getText());
		}
		else
		{
			System.out.println("Testcase Failed:"+Day.getText());
		}
		
		
		}
		
		}
		} catch(Exception E)
		{
			System.out.println(E.getMessage());	
		} finally
		{
			if(driver !=null )
			{
				driver.quit();
			}
		}
	
	    
	    
	    

	}

}
