package views.mainViews;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainViewElements {

    public final Color RED = Color.fromString("#FF0000");
    public final Color GREEN = Color.fromString("#008000");
    public final Color BLUE = Color.fromString("#0000FF");

    public WebElement getAnswBtn() {

        return DriverManager.driver.androidDriver.findElement(By.id("button2"));
    }

    public WebElement getTextViewActive() {

        return DriverManager.driver.androidDriver.findElement(By.id("textViewActive"));
    }

    public WebElement getTextViewStatic() {

        return DriverManager.driver.androidDriver.findElement(By.id("textViewStatic"));
    }

    public WebElement getBurgerBtn() {

        return DriverManager.driver.androidDriver
                .findElement(By.xpath("//android.widget.ImageView[@content-desc=\"More options\"]"));
    }

    public WebElement getRedColor() {

        DriverManager.driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Red']")));
        return DriverManager.driver.androidDriver.findElement(By.xpath("//*[@text='Red']"));
    }

    public WebElement getGreenColor() {

        DriverManager.driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Green']")));
        return DriverManager.driver.androidDriver.findElement(By.xpath("//*[@text='Green']"));
    }

    public WebElement getBlueColor() {

        DriverManager.driver.wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@text='Blue']")));
        return DriverManager.driver.androidDriver.findElement(By.xpath("//*[@text='Blue']"));
    }

}
