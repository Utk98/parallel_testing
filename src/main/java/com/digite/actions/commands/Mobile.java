package com.digite.actions.commands;

import com.annotation.PageFragment;
import com.digite.actions.drivercapabilities.WebDriverFactory;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.time.Duration.ofMillis;


@PageFragment
public class Mobile extends Common{
    public Mobile(WebDriverFactory webDriverFactory) {
        super(webDriverFactory);
    }

    public void touch(int startX,int startY,int endX,int endY){
        new TouchAction(a_driver)
                .press(PointOption.point(startX, startY))
                .waitAction(waitOptions(ofMillis(100)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public void scroll(By locator,String scrollDirection) throws Exception {
        int startX = a_driver.manage().window().getSize().getWidth() / 2; // Middle of the screen (horizontal center)
        int startY = a_driver.manage().window().getSize().getHeight() / 2; // Middle of the screen (vertical center)
        int endX=0,endY=0;
        switch(scrollDirection.toLowerCase()) {
            case "left":  endX = startX+200;
            break;
            case "right": endX = startX - 200;
                break;
            case "up":  endY = startY+200;
                break;
            case "down": endY = startY-200;
                break;
        }
        int count=0;
        while (!isElementVisible(locator)&&count<25) {
            touch(startX,startY,endX,endY);
            count++;
        }
        touch(startX,startY,endX,endY);
    }

    public void dragDropCards(By sourceLocation, By targetLocation) throws Exception {
        TouchAction touchAction = new TouchAction(a_driver);
        int startX = a_driver.manage().window().getSize().getWidth() / 2;
        int startY = a_driver.manage().window().getSize().getHeight() / 2;
        int endX=startX+1500;
        int endY=startY;
        touchAction.longPress(ElementOption.element(a_driver.findElement(sourceLocation)))
                .perform();
        while(!isElementVisible(targetLocation)){
            touchAction.moveTo((PointOption.point(endX, endY))).perform();
        }
        touchAction.moveTo((PointOption.point(endX, endY))).perform();
        touchAction.moveTo(ElementOption.element(a_driver.findElement(targetLocation)))
                .release()
                .perform();
    }
    public void dragDrop(By sourceLocation, By targetLocation) throws Exception {
        int count = 0;
        TouchAction touchAction = new TouchAction(a_driver);
        int startX = a_driver.manage().window().getSize().getWidth() / 2;
        int startY = a_driver.manage().window().getSize().getHeight() / 2;
        int endX=startX+2000;
        int endY=startY;
        touchAction.longPress(ElementOption.element(a_driver.findElement(sourceLocation)))
                .perform();

        while(!isElementVisible(targetLocation)){
            touchAction.moveTo((PointOption.point(endX, endY))).perform();
        }
        boolean isFullyVisible= false;
        int previousX = 0;
        while (!isFullyVisible){

            Point elementLocation = a_driver.findElement(targetLocation).getLocation();
            Dimension elementSize = a_driver.findElement(targetLocation).getSize();
            //till the time he gets same co-ordinates we will just scroll
            if(previousX==elementLocation.getX()){
                break;
            }else{
                isFullyVisible = (
                        elementLocation.getX() >= 0 &&
                                elementLocation.getX() + elementSize.getWidth() > (startX*2)
                );
                previousX = elementLocation.getX();
                touchAction.moveTo((PointOption.point(endX, endY))).perform();
            }
        }
        touchAction.moveTo(ElementOption.element(a_driver.findElement(targetLocation)))
                .release()
                .perform();
    }
}


