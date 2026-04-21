//package TestCases;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import org.openqa.selenium.By;
//
//import java.net.URL;
//
//
//
//        public class mob {
//
//            public static void main(String[] args) {
//
//                AndroidDriver driver = null;
//
//                try {
//                    // 🔹 Setup UiAutomator2 Options
//                    UiAutomator2Options options = new UiAutomator2Options();
//
//                    options.setDeviceName("Android Device");
//                    options.setPlatformName("Android");
//                    options.setAutomationName("UiAutomator2"); // 🔥 ADD THIS
//
//                    options.setAppPackage("com.etoro.openbook");
//                    options.setAppActivity("com.etoro.openbook.activities.MainActivity");
//
//                    options.setNoReset(true); // keeps app data (no reinstall)
//
//                    // 🔹 Start Driver
//                    driver = new AndroidDriver(
//                            new URL("http://127.0.0.1:4723"),
//                            options
//                    );
//
//                    // 🔹 Wait for app to open
//                    Thread.sleep(8000);
//
//                    // 🔹 Sample action (update locator based on actual app)
////                    driver.findElement(By.xpath("//android.widget.TextView")).click();
//
//                    System.out.println("App launched and action performed");
//
//                } catch (Exception e) {
//                    e.printStackTrace();
////                } finally {
////                    if (driver != null) {
////                        driver.quit();
////                    }
//                }
//            }
//        }
//
