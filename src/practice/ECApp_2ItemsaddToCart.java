package practice;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
//need to import manually below imports hence appium doc jar it didn't included officially
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class ECApp_2ItemsaddToCart extends AppBasePrac {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

		Thread.sleep(3000);
		driver.findElementByXPath("//*[@text='Enter name here']").sendKeys("welocme");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Male']")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).size();
		System.out.println("=================================");
		System.out.println("items count is:" + count);
		/*
		 * here u can use for loop OR click add to cart of index twice bcz once u added
		 * to cart it will change to added to cart and size zero
		 * driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")
		 * ).get(0).click();
		 * driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")
		 * ).get(0).click();
		 */
		for (int i = 0; i < count; i++) {
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(2000);
		
		int productcount =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).size();
		double sumofItems =0;
		for(int j=0; j<productcount;j++) {
			String amountval =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(j).getText();
			sumofItems =sumofItems+AmountConverstion(amountval);
		}
 System.out.println("==> this val is the sum of items:"+sumofItems);
	String totalval=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1);
	double fianlval =Double.parseDouble(totalval);
	System.out.println("this is the total purchase amount:"+fianlval);
	/*
	 * validation
	 * Assert.assertEquals(fianlval,sumofItems);
	 */
	
	//gestures in app >folloed by webview 
	driver.findElement(By.className("android.widget.CheckBox")).click();//select checkbox
		TouchAction t = new TouchAction(driver);
	WebElement Longp= driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
	t.longPress(longPressOptions().withElement(element(Longp)).withDuration(ofSeconds(2))).release().perform();
	driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
	//switching to hybrid app from native mobile app
	Thread.sleep(6000);
	Set<String>	contexts=driver.getContextHandles();
	System.out.println("====context names are===");
	for(String contextNames :contexts ) {
		System.out.println(contextNames);
	}
		
	driver.context("WEBVIEW_com.androidsample.generalstore");
	Thread.sleep(1000);
	driver.findElement(By.name("q")).sendKeys("hello");
	}
	
	

	

// utility method for 
	public static double AmountConverstion(String value) {
		value = value.substring(1);
		double amount = Double.parseDouble(value);
		return amount;

	}
}
