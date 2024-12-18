package KishoreProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
public class MiscellaneousAppiumActions extends BaseTest {
	
	@Test
	public void MIscelleneousActions() throws MalformedURLException, URISyntaxException
	{
		
		/*
		 * driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		 * driver.findElement(By.
		 * xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']"
		 * )).click();
		 */
		
		//instead of using above to statements to navigate to preference dependencies page, we can directly go to the preference dependencied page using appPackage and appActivity 
		
		Activity act = new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");//Activity constructor has two arguments, 1. package 2. Activity
		//we can get package and activity name in windows using the command : adb shell dumpsys window | find "mCurrentFocus"
		
		((JavascriptExecutor) driver).executeScript("mobile: startActivity", ImmutableMap.of("intent","io.appium.android.apis/io.appium.android.apis.preference.PreferenceDependencies"));
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape = new DeviceRotation(0, 0, 90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle,"WiFi settings");
		
		//Copy to clipboard and paste from clipboard
		driver.setClipboardText("Kishore WI-FI");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		String s = "{\"access_token\":";
	}

}
