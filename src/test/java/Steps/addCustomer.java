package Steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class addCustomer {

    WebDriver driver;
    WebDriverWait wait;

    @Given("User is on Customer page")
    public void user_is_on_customer_page() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://testffc.nimapinfotech.com/");


        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailElement.sendKeys("admin@admin.com");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
        passwordField.sendKeys("Admin@123");

        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Login')]")));
        loginButton.click();


        WebElement mastersMenu = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Masters']")));
        mastersMenu.click();

        WebElement customerLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Customer']")));
        customerLink.click();

        WebElement addCustomerButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Add Customer')]")));
        addCustomerButton.click();
    }

    @When("User enters customer name {string} and contact {string}")
    public void user_enters_customer_name_and_contact(String name, String contact) {
        WebElement nameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("name")));
        nameField.sendKeys(name);

        WebElement phoneField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("phone")));
        phoneField.sendKeys(contact);
    }

    @Then("Customer {string} should be added successfully")
    public void customer_should_be_added_successfully(String expectedName) {
        WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Submit')]")));
        submitButton.click();

        WebElement toast = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Toastify__toast-body")));
        String toastMsg = toast.getText();
        assertTrue("Expected message not shown!", toastMsg.contains("Customer Added Successfully"));

        driver.quit();
    }
}