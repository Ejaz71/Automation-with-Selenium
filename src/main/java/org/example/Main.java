package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.log.Log;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //System.setProperty("webdriver.chrome.driver", "D:\\webdrivers\\Chrome_Webdriver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        //fireforx launch
//        WebDriver driverff = new FirefoxDriver();
//        driverff.get("https://google.com");
//        System.out.println(driverff.getTitle());
//        driverff.quit();
//
//        //chrome
//        driver.get("https://rahulshettyacademy.com/");
//        // check title
//        String title = driver.getTitle();
//        System.out.println(title);
//        //check URL
//        System.out.println(driver.getCurrentUrl());
//        driver.close();
//
//        int n = 1;
//
//        //edge
//        WebDriver driverEdge = new EdgeDriver();
//        try {
//            driverEdge.get("https://google.com");
//            System.out.println("This is edge title: " + driverEdge.getTitle());
//        } finally {
//            driverEdge.close();
//        }

        Login loginObj = new Login();
//        loginObj.customerLoginWithIncorrectPass();
//        loginObj.resetPassword();
//        loginObj.customerLoginWithCorrectPass();
        loginObj.logoutTest();

    }
}