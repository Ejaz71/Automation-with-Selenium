package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Login {
    WebDriver driver = new ChromeDriver();


    String userNameLocator = "inputUsername"; //id
    String passWordLocator = "inputPassword"; //name
    String signInBtnLocator = "signInBtn"; //class
    String errorMessageLocator = "error"; //clss
    String rememberCheckboxLocator = ".checkbox-container #chkboxOne";
    String tncCheckboxLocator = ".checkbox-container #chkboxTwo";
    String loginSuccessLocator = ".login-container p";
    String logoutButtonLocator = "//button[@class='logout-btn']";
    //Forgot password fields
    String forgotPasswordLocator = "div.forgot-pwd-container a"; //css
    String nameFieldLocator = "//input[@placeholder = 'Name']"; //xpath
    String emailFieldLocator = "//input[@placeholder='Email']";
    String phoneNumberLocator = "//form/input[3]"; //xpath
    String resetLoginBtnLocator = "button.reset-pwd-btn"; //css
    String infoMsgLocator = "form > p.infoMsg"; //css
    String gotoLoginBtnLocator = ".go-to-login-btn";

    // value fields
    //login fields
    String loginUserName = "Rahul";
    String wrongPassword = "abc123";
    String correctPassword = "rahulshettyacademy";
    String loginConfirmationMessageExpected = "You are successfully logged in.";
    //forgot password form fields
    String testUserName = "Test User";
    String testUserEmail = "test.user@gmail.com";
    String testUserPhoneNumber = "+8801718550000";

    public void customerLoginWithIncorrectPass() {
        //timeout set to 5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice");
        driver.findElement(By.id(userNameLocator)).sendKeys(loginUserName);
        driver.findElement(By.name(passWordLocator)).sendKeys(wrongPassword);
        driver.findElement(By.className(signInBtnLocator)).click();


        String s = driver.findElement(By.className(errorMessageLocator)).getText();
        System.out.println(s);


        //driver.close();
    }

    public void resetPassword() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice");
        //driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.cssSelector(forgotPasswordLocator)).click();
        driver.findElement(By.xpath(nameFieldLocator)).sendKeys(testUserName);
        driver.findElement(By.xpath(emailFieldLocator)).sendKeys(testUserEmail);
        driver.findElement(By.xpath(phoneNumberLocator)).sendKeys(testUserPhoneNumber);
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector(resetLoginBtnLocator)).click();

        String infoMessage = driver.findElement(By.cssSelector(infoMsgLocator)).getText();
        System.out.println(infoMessage);

        driver.findElement(By.cssSelector(gotoLoginBtnLocator)).click();
        customerLoginWithCorrectPass();

    }

    public void customerLoginWithCorrectPass () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice");
        driver.findElement(By.id(userNameLocator)).sendKeys(loginUserName);
        driver.findElement(By.name(passWordLocator)).sendKeys(correctPassword);

        WebElement checkBoxOne = driver.findElement(By.cssSelector(rememberCheckboxLocator));
        if (!checkBoxOne.isSelected()) checkBoxOne.click();

        WebElement checkBoxTwo = driver.findElement(By.cssSelector(tncCheckboxLocator));
        if (!checkBoxTwo.isSelected()) checkBoxTwo.click();

        driver.findElement(By.className(signInBtnLocator)).click();
    }

    public void logoutTest () {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String loginConfirmationMessage = "";

        customerLoginWithCorrectPass();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        loginConfirmationMessage = driver.findElement(By.cssSelector(loginSuccessLocator)).getText();

        Assert.assertEquals(loginConfirmationMessage, loginConfirmationMessageExpected);

        driver.findElement(By.xpath(logoutButtonLocator)).click();

    }
}
