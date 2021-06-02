package MobileAppiumFramework;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import AppiumFramework.HybridCapability;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class HybridappTesting extends HybridCapability {
	AndroidDriver<AndroidElement> driver;

	@BeforeTest
	public void setup() throws InterruptedException, IOException {
		Runtime.getRuntime().exec("adb kill-server");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("adb start-server");
		Thread.sleep(5000);
	}

	@Test
	public void testcase1() throws InterruptedException, IOException {
		// service.start();
		Thread.sleep(8000);
		service = startsserver();
		driver = capabilities(deviceName, chromedriverexecutable, apppackage, appactivity);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(9000);
		System.out.println("Hybrid");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@text='Dismiss']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Dismiss']")).click();
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();

		driver.findElement(By.xpath("//*[@content-desc='Sign up with email']")).click();

		driver.findElementByAccessibilityId("First name").sendKeys("shrav1");
		driver.findElementByAccessibilityId("Last name").sendKeys("shrav1");
		driver.findElement(By.xpath("//*[@content-desc='Birthday']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		// driver.findElementByAccessibilityId("Email
		// address").sendKeys("shrav21@gmail.com");
		String email = "shrav1" + RandomStringUtils.randomAlphanumeric(3) + "@gmail.com";
		driver.findElementByAccessibilityId("Email address").sendKeys(email);
		driver.findElementByAccessibilityId("Password").sendKeys("shrav@1234");
		driver.findElement(By.xpath("//*[@text='CREATE']")).click();
		System.out.println("User Login Created");
		Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Sign out']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		System.out.println("User Signed Out");
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Dismiss']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@text='Sign in']")).click();

		driver.findElement(By.xpath("//*[@text='Sign in']")).click();
		driver.findElementByAccessibilityId("Enter an e-mail address or username").sendKeys(email);
		driver.findElementByAccessibilityId("Password").sendKeys("shrav@1234");
		driver.findElement(By.xpath("//*[@content-desc='Sign in']")).click();
		System.out.println("User Signed in");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Language & region\"));").click();
		Thread.sleep(1000);
		System.out.println("Visited Language & region page");
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"OFF\"));")
				.click();
		Thread.sleep(1000);
		System.out.println("Enabled sound settings");
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Licenses\"));")
				.click();
		Thread.sleep(1000);
		System.out.println("Visited licenses page");
		driver.navigate().back();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Privacy policy\"));").click();
		Thread.sleep(1000);
		driver.findElement(By.id("android:id/button_once")).click();
		System.out.println("Visited Privacy policy page");
		Thread.sleep(9000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		// driver.navigate().back();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"About the team\"));").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Ankita\"));")
				.click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		System.out.println("Visited About the team page");
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		Thread.sleep(1000);

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"My courses\").instance(0))");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"My courses\"));").click();
		driver.findElement(By.xpath("//*[@text='Get started']")).click();

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Other\"));")
				.click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Personal finance\").instance(0))");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Personal finance\"));").click();
		driver.findElement(By.xpath("//*[@text='Done']")).click();
		System.out.println("Personal finance course added");

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"My courses\").instance(0))");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Personal finance\"));");// .click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Personal finance\").instance(0))")
				.click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Housing\").instance(0))")
				.click();
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Titles and deeds in real estate\").instance(0))")
				.click();
		Thread.sleep(8000);
		System.out.println("View \"Titles and deeds in real estate\" vedio class");
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\"Making an offer on a home\").instance(0))")
				.click();
		Thread.sleep(9000);
		System.out.println("Switch and view \"Making an offer on a home\" vedio class");
		WebElement screen = driver.findElement(By.className("android.view.View"));
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(screen))).perform();
		driver.navigate().back();
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Back']")).click();
		driver.findElement(By.xpath("//*[@content-desc='Settings']")).click();
		driver.findElement(By.xpath("//*[@text='Sign out']")).click();
		driver.findElement(By.id("android:id/button1")).click();
		System.out.println("User Signed Out");
		service.stop();
	}
}