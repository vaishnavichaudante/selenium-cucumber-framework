package Steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PunchIn {

    WebDriver driver = Hook.driver;

    @When("User clicks Punch In button")
    public void user_clicks_punch_in_button() {
        driver.findElement(By.id("punch_in")).click();
    }

    @Then("Toast message {string} should be displayed")
    public void toast_message_should_be_displayed(String expected) {
        String actual = driver.findElement(By.className("toast-message")).getText();
        Assert.assertEquals(actual, expected);
    }

}
