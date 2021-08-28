package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class VehicleCostsPage extends FleetPage {

    @FindBy(xpath = "//div[@name='vehicle_id']/div/input")
    public WebElement vehicleDropdown;

//    @FindBy(xpath = "//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li[@class='ui-menu-item']/a")
//    public List<WebElement> dropdownOptions;

    @FindBy(xpath = "//label[text()='Type']/../../td/div/div/input")
    public WebElement typeDropdown;

    public List<WebElement> getDropdownOptions(){
        return Driver.get().findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']/li[@class='ui-menu-item']/a"));
    }

    @FindBy(name = "amount")
    public WebElement priceBox;

    @FindBy(xpath = "//a[@class='o_form_uri o_field_widget']")
    public WebElement typeAfterSave;

    @FindBy(xpath = "//a[@class='o_form_uri o_field_widget o_required_modifier']")
    public WebElement vehicleAfterSave;

}
