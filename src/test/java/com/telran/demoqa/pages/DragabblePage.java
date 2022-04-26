package com.telran.demoqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;

public class DragabblePage extends PageBase{


    public DragabblePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (id = "dragBox")
    WebElement elementToDrag;

    public int getElementToDragPosition(){

        return  elementToDrag.getLocation().getX();

    }

    public boolean dragElementToGivenPosition(int x, int y) {

        int startPositionX = elementToDrag.getLocation().getX();
        int startPositionY = elementToDrag.getLocation().getY();

        Actions actions = new Actions(driver);
        actions.dragAndDropBy(elementToDrag, x, y).perform();

        int endPositionX = elementToDrag.getLocation().getX();
        int endPositionY = elementToDrag.getLocation().getY();

        if (startPositionX + x == endPositionX && startPositionY + y == endPositionY){
            return true;
        } else {
            return false;
        }
    }


}
