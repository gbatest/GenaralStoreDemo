package practice;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class Test1 extends AppBasePrac{

	public static void main(String[] args) throws MalformedURLException {

		AndroidDriver<AndroidElement>driver=capabilities() ;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//xpath with text
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		//Id
		driver.findElementById("android:id/checkbox").click();
		//xpath with index when there is duplicate elements with no text 
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		//class Name
	    driver.findElementByClassName("android.widget.EditText").sendKeys("hello");
	    
       //multiple elements with same class name> to get unique one from that use get index
	    driver.findElementsByClassName("android.widget.Button").get(1).click();
	    //or
		//driver.findElementByXPath("(//android.widget.Button)[2]").click();
		

	}

}
