package practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

public class SwipeDemo  extends AppBasePrac{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
		
		AndroidDriver<AndroidElement>driver= capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Date Widgets']").click();
		driver.findElementByAndroidUIAutomator("text(\"2. Inline\")").click();
		/*
		 driver.findElementByXpath("//tagName[@Attribute='value']").click
		below case we are using regular expression(*) instead tagName
		*/
		driver.findElementByXPath("//*[@content-desc='9']").click();
		
		/*Steps for swipe
		 1.long press on element 1 or 2 secs move to another element and you release 
		 */
	
		TouchAction t = new TouchAction(driver);
		WebElement source =driver.findElementByXPath("//*[@content-desc='15']");
		WebElement target =driver.findElementByXPath("//*[@content-desc='45']");
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2)))
		.moveTo((element(target))).release().perform();
		

}
}