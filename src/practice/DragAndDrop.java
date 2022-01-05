package practice;

import static java.time.Duration.ofSeconds;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class DragAndDrop extends AppBasePrac {

	public static void main(String[] args  ) throws MalformedURLException {
		// TODO Auto-generated method stub

		AndroidDriver<AndroidElement>driver= capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MILLISECONDS);
		driver.findElementByXPath("//android.widget.TextView[@text='Views']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='Drag and Drop']").click();
		
		TouchAction t = new TouchAction(driver);
		
	WebElement source =	driver.findElementsByClassName("android.view.View").get(0);
	WebElement destination =driver.findElementsByClassName("android.view.View").get(1);
	
	//lonpress source and moveTo destination and release: Testcase
	/*we use longpress when we are performing single action with action class
	//we use longPressOptions when we are performing multiple  actions with action class
     ex: t.longPress(longPressOptions().withElement(element(pname)).withDuration(ofSeconds(2))).release().perform();

	*/
	//sinle action
	t.longPress(element(source)).moveTo(element(destination)).release().perform();
		
		
		
	}

}
