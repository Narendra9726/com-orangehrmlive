import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class OrangeHrmLive {
    static String browser = "Chrome"; // Change this to "chrome" or "edge" as needed
    static WebDriver driver;
    static String baseUrl = "https://opensource-demo.orangehrmlive.com/";


    public static void main(String[] args) {
        try {
            // 1. Setup Chrome browser.
            if (browser.equalsIgnoreCase("Chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equalsIgnoreCase("Firefox")) {
                driver = new FirefoxDriver();
            } else if (browser.equalsIgnoreCase("Edge")) {
                driver = new EdgeDriver();
            } else {
                System.out.println("Wrong browser name ");
            }

            // 2. Open URL.
            driver.get(baseUrl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // 3. Print the title of the page.
            System.out.println("Page Title: " + driver.getTitle());

            // 4. Print the current URL.
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // 5. Print the page source.
            System.out.println("Page Source: " + driver.getPageSource());


            //6. Click on ‘Forgot your password?’ link.
            WebElement forgotPasswordLink = driver.findElement(By.className("orangehrm-login-forgot-header"));
            forgotPasswordLink.click();

            // 7. Print the current URL.
            System.out.println("Current URL: " + driver.getCurrentUrl());

            // 8. Navigate back to the login page.
            driver.navigate().back();

            // 9. Refresh the page.
            driver.navigate().refresh();

            // 10. Enter the email to the email field.
            WebElement emailField = driver.findElement(By.name("username"));
            emailField.sendKeys("prime123@gmail.com");

            // 11. Enter the password to the password field.
            WebElement passwordField = driver.findElement(By.name("password"));
            passwordField.sendKeys("Prime123");

            // 12. Click on Login Button.
            WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
            loginButton.click();
        } finally {
            // 13. Close the browser.
            if (driver != null) {
                driver.quit();
            }
        }
    }
}



