package org.example;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.setProperty("webdriver.gecko.driver","src/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //chod na ais
        driver.get("https://ais2.ukf.sk/ais/start.do");
        //vloz udaje
        driver.findElement(By.id("login")).sendKeys("");
        driver.findElement(By.id("heslo")).sendKeys("");
        driver.findElement(By.id("login-form-submit-btn")).click();
        //pocka kym sa nacitaju elementy
        Thread.sleep(2000);
        driver.switchTo().frame(0);
        //klikni na play tlacidlo
        driver.findElement(By.cssSelector(".ytp-large-play-button")).click();
        //kvoli delayu musime dať 8000
        Thread.sleep(8000);
        driver.findElement(By.cssSelector(".video-stream")).click();
        driver.switchTo().defaultContent();
        //odhlas sa
        driver.findElement(By.cssSelector(".ms-2")).click();
        driver.findElement(By.cssSelector(".app-dropdown-menu > .app-dropdown-item > .action")).click();
        //vypni prehliadac
        driver.quit();
    }
}