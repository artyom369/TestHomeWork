package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Helper {

    public Color getColor(WebElement element) throws Exception {

        File scrFile = element.getScreenshotAs(OutputType.FILE);

        BufferedImage image = ImageIO.read(scrFile);
        int clr = image.getRGB(0, 0);
        int red = (clr & 0x00ff0000) >> 16;
        int green = (clr & 0x0000ff00) >> 8;
        int blue = clr & 0x000000ff;

        return new Color(red, green, blue, 1);
    }
}
