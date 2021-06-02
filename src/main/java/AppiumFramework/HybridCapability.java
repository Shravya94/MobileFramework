
package AppiumFramework;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class HybridCapability {

	protected static String deviceName;
	protected static String chromedriverexecutable;
	protected static String apppackage;
	protected static String appactivity;
	public AppiumDriverLocalService service;

	public static void StartEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir") + "\\src\\main\\java\\emulator.bat");
		Thread.sleep(8000);
	}

	//
	public AppiumDriverLocalService startsserver() {
		boolean flag = checkifserverisRunning(4723);
		if (!flag) {

			service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
					.usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
					.withAppiumJS(new File(
							"C:\\Users\\ShravyaRai\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
					.withIPAddress("127.0.0.1").usingPort(4723));
			service.start();
		}
		return service;
	}

	public static boolean checkifserverisRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serversocket;
		try {
			serversocket = new ServerSocket(port);
			serversocket.close();
		} catch (IOException e) {
			isServerRunning = true;
		} finally {
			serversocket = null;
		}
		return isServerRunning;
	}

	public static AndroidDriver<AndroidElement> capabilities(String deviceName, String chromedriverexecutable,
			String apppackage, String appactivity) throws IOException, InterruptedException {
		FileReader fis = new FileReader(System.getProperty("user.dir") + "\\src\\main\\java\\global.properties");
		Properties pro = new Properties();
		pro.load(fis);
		deviceName = pro.getProperty("deviceName");
		chromedriverexecutable = pro.getProperty("chromedriverexecutable");
		apppackage = pro.getProperty("apppackage");
		appactivity = pro.getProperty("appactivity");
		if (deviceName.contains("Shravya9")) {
			StartEmulator();
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, apppackage);
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appactivity);
		cap.setCapability(MobileCapabilityType.NO_RESET, false);
		cap.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, chromedriverexecutable);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
				new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
}