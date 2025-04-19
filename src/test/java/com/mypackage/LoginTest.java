package com.mypackage;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class LoginTest {

        @Test
        public void testLogin() {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-popup-blocking");  // Disable popups for the test
            WebDriver driver = new ChromeDriver(options);

            try {
                driver.get("https://testffc.nimapinfotech.com/");
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // Increase timeout


                System.out.println(driver.getPageSource());


                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));


                WebElement emailField = driver.findElement(By.id("email"));
                emailField.sendKeys("test@example.com");


                WebElement passwordField = driver.findElement(By.id("password"));
                passwordField.sendKeys("password123");

                WebElement loginButton = driver.findElement(By.id("loginButton"));
                loginButton.click();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                driver.quit();
            }
        }
    }

