package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.NoSuchElementException;

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

    public void clickModule(String module){
        List<String> topModulesText = BrowserUtils.getElementsText(topModules);

        if(topModulesText.contains(module)){
            topModules.get(topModulesText.indexOf(module)).click();
        }
        else{
            moreBtn.click();
            List<String> moreModulesText = BrowserUtils.getElementsText(moreModules);
            if(moreModulesText.contains(module)){
                moreModules.get(moreModulesText.indexOf(module)).click();
            }
            else{
                throw new NoSuchElementException();
            }
        }
    }

    //button on username on the homepage
    @FindBy(css = "span.oe_topbar_name")
    public WebElement usernameBtn;

    //logout button on the main page
    @FindBy(linkText = "Log out")
    public WebElement logoutBtn;

    //top menus(22)
    @FindBy(xpath = "//ul[@class='nav navbar-nav navbar-left oe_application_menu_placeholder']/li/a/span")
    public List<WebElement> topBarMenus;

    //Fleet tab menu
    @FindBy(xpath = "//span[contains(text(),'Fleet')]")
    public WebElement fleetTab;

    //More tab menu
    @FindBy(xpath = "//li[@id='menu_more_container']/a")
    public WebElement moreTab;

    @FindBy(css = "#menu_more>li")
    public List <WebElement> moreLists;

    public void navigateToModule() {

        WebElement moreTab = Driver.get().findElement(By.xpath("//li[@id='menu_more_container']/a"));

        moreTab.click();

        List<WebElement> fourModules = Driver.get().findElements(By.xpath("(//ul[@class='oe_secondary_submenu nav nav-pills nav-stacked'])[34]/li/a/span"));

        for (WebElement eachModules : fourModules) {

            String eachModuleText = eachModules.getText();

            System.out.println(eachModuleText);
        }

    }

}
