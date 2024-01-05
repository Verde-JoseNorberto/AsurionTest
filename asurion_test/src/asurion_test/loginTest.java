package asurion_test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest {

    public static void main(String[] args) throws InterruptedException {
	// TODO Auto-generated method stub
    	
    	// Accessing Directory for chromedriver. Modify Path to expected directory.
        System.setProperty("webdriver.chrome.driver", "C:\\xampp\\htdocs\\AsurionTest\\asurion_test\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        
        // Access Login page
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        // Scenario 1: Log in using standard user
        login(driver, "standard_user", "secret_sauce");
        
        // Logout user
        logout(driver);

        // Scenario 2: Log in using locked out user
        login(driver, "locked_out_user", "secret_sauce");
        Thread.sleep(2000);
        
        // Execute program
        driver.quit();
    }

    private static void login(WebDriver driver, String username, String password) throws InterruptedException {    	
        // Enter username and password
    	Thread.sleep(2000);
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);

        // Click the login button
        Thread.sleep(2000);
        driver.findElement(By.id("login-button")).click();
    }
    
    private static void logout(WebDriver driver) throws InterruptedException {
        // Click on the menu button
    	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[1]/div/button")).click();

        // Click on the logout button
	Thread.sleep(2000);
	driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[1]/div/div[2]/div[1]/nav/a[3]")).click();
    }
}
