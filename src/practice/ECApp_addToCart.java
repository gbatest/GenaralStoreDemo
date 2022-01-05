package practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class ECApp_addToCart extends AppBasePrac{

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);

	Thread.sleep(3000);
	driver.findElementByXPath("//*[@text='Enter name here']").sendKeys("hello");
	driver.hideKeyboard();
	driver.findElement(By.xpath("//*[@text='Female']")).click();
	driver.findElement(By.id("android:id/text1")).click();
	driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"));");
	//or//	  //   driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textMatches(\"" + containedText + "\").instance(0))"));  
	driver.findElement(By.xpath("//*[@text='India']")).click();
	driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
	
	/*go to parent scroll list then look for child item
     TC3:
	shop the items in the app by scrolling to specific product add to cart
	*/
	driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()"
            + ".resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView("
            + "new UiSelector().text(\"Jordan Lift Off\"));"));
	int count= driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	System.out.println("=================================");
	System.out.println("items count is:"+count);
	for(int i=0;i<count;i++) {
	String ProductName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
	if(ProductName.equalsIgnoreCase("Jordan Lift Off"))	
	{
		driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
		System.out.println("Productname is:"+ProductName);
		break;
	}
	}
driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
Thread.sleep(3000);
//TScenario 4:validating the orders in checkout page.
String PName_Checkoutpage = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
System.out.println("PName_Checkoutpage is:"+PName_Checkoutpage);
/*
 * validation
 * Assert.assertEquals(ProductName(expected),PName_Checkoutpage(actual));
 */
	}

}
