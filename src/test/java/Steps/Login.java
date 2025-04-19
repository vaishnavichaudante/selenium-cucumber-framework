package Steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

   WebDriver driver = Hook.driver;

    @Given("I open the login page")
    public void i_open_the_login_page() {

        driver.get("https://testffc.nimapinfotech.com/");
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_username_and_password(String username, String password) {
        driver.findElement(By.id("email")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("I click the login button")
    public void i_click_the_login_button() {

        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
    }

    @Then("I should be redirected to the dashboard")
    public void i_should_be_redirected_to_the_dashboard() {
        boolean isDashboardVisible = driver.getCurrentUrl().contains("dashboard");
        assert isDashboardVisible;
        //driver.quit();
    }
}

