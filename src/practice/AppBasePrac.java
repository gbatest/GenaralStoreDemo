package practice;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppBasePrac {

	public static AndroidDriver<AndroidElement> capabilities() throws MalformedURLException {

		// public static void main(String[] args) throws MalformedURLException {
		// 1.we need to Provide which app to automate it contains .apk extension
		// 2.which device you want to automate
		// 3.need port number 4723
//4.to setup all the above three we need Desired capabiliries 
		/*
		 * Desired Capabilities: is a class used to declare a set of basic requirements
		 * such as combinations of browsers, operating systems, browser versions, etc.
		 * to perform automated cross browser testing of a web application.
		 */
//5.need to declare Andriod driver
//6.UI Automater(old one)> uiautomator2(new framework) used to develop Andriod apps
		/*
		 * Appium UiAutomator2 Driver is a test automation framework for Android
		 * devices. Appium UiAutomator2 Driver automates native, hybrid and mobile web
		 * apps, tested on emulators and real devices. Appium UiAutomator2 Driver is
		 * part of the Appium mobile test automation tool.
		 */
		File appDirectory = new File("src");// file location in proj
		File app = new File(appDirectory, "General-Store.apk"); //ApiDemos-debug.apk
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "GangaNexus");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());// get the path of file at runtime
		//from adroid 6 if we didn't use UiAutomator2 app will fail it is mandatory
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,30);//wait for 14seconds
		// pass all the capabilities to Android driver class

		// portnumber sending as a String to URL class(URL class will take string as a parameter)
		// note: make sure to give local IP address along with portnumber
		// http://127.0.0.1:4723/wd/hub(http://ipadress:portnumber/webdriver(listing to
		// hub in server language)/hub
		AndroidDriver<AndroidElement> driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}