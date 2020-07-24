package main.tasks;

import main.util.Config;
import main.util.Reference;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Tasks {
    static WebDriver driver;

    public static void launchAndLogin() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", Reference.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.get("http://twitter.com/login");
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.name("session[username_or_email]"));
        WebElement password = driver.findElement(By.name("session[password]"));
        username.sendKeys(Config.username);
        password.sendKeys(Config.password);
        password.submit();
        Thread.sleep(5000);
    }

    public static void startTweeting(String text) throws InterruptedException {
            if (text.length() < 200) {
                WebElement tweetbox = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div"));
                tweetbox.sendKeys(text + " " + Config.tags);
                Thread.sleep(4000);
                tweetbox.sendKeys(Keys.CONTROL, Keys.ENTER);
                Thread.sleep(Config.interval * 1000);
            } else {
                System.out.println("Tweet przekroczyl limit znakow.");
            }
    }

}
