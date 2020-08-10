package main.tasks;

import main.util.Config;
import main.util.Reference;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class Tasks {
    static WebDriver driver;

    public static void startSpammer(String username, String password) {
        System.setProperty("webdriver.chrome.driver", Reference.CHROME_DRIVER);
        driver = new ChromeDriver();
        driver.get("http://twitter.com/login");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement usernameele = driver.findElement(By.name("session[username_or_email]"));
        WebElement passwordele = driver.findElement(By.name("session[password]"));
        usernameele.sendKeys(username);
        passwordele.sendKeys(password);
        passwordele.submit();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                GenerateSentence.parseWords();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            String text = GenerateSentence.makeSentence(GenerateSentence.list);
            if (text.length() < 200) {
                WebElement tweetbox = driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div/div/div[2]/div[1]/div/div/div/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div/div/div/div"));
                tweetbox.sendKeys(text + " " + Config.tags);
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tweetbox.sendKeys(Keys.CONTROL, Keys.ENTER);
                try {
                    Thread.sleep(Config.interval * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Tweet przekroczyl limit znakow.");
            }
        }
    }
}
