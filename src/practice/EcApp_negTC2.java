package practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class EcApp_negTC2 extends AppBasePrac {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
	//or//	  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));  
	driver.findElement(By.xpath("//*[@text='India']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	String ToastMessage = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
	System.out.println("Nmae of toast message:"+ToastMessage);
	
	/* validation
	 * Assert.assertEquals("expected",ToastMessage);
	 * 
	 */

	}

}
