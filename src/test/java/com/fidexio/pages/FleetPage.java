package com.fidexio.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FleetPage extends BasePage{

    @FindBy(xpath = "//div[@class='oe_secondary_menu'][@data-menu-parent='134']/ul/li")
    public List<WebElement> menusOnLeft;

}
