package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//li[@class='o_user_menu']/a/span")
    public WebElement userMenu;

    @FindBy(linkText = "Log out")
    public WebElement logOutBtn;

}
