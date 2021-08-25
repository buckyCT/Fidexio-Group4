package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "//li[@class='o_user_menu']/a/span")
    public WebElement userMenu;

    @FindBy(linkText = "Log out")
    public WebElement logOutBtn;

    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']/li/a/span")
    public List<WebElement> topModules;

    @FindBy(xpath = "//li[@id='menu_more_container']/a")
    public WebElement moreBtn;

    @FindBy(xpath = "//li[@id='menu_more_container']/ul/li/a/span")
    public List<WebElement> moreModules;

}
