package practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class UiAutomaterTest extends AppBasePrac {

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement> driver = capabilities();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		//driver.findElementByAndroidUIAutomator("text(\"Animation\")").click();

//validate click-able feature for all the options + when you want to identify elements with property
//syntax :driver.findElementsByAndroidUIAutomator("new UiSelector().property(value)");

	//below method is Android method it is independent of appium 
	int countofClickables =	driver.findElementsByAndroidUIAutomator("new UiSelector().clickable(true)").size();
	
	System.out.println("countofClickables :"+countofClickables);

	}

}
