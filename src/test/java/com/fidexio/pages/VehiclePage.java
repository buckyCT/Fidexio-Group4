package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehiclePage<list> extends BasePage{
    public VehiclePage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/button[1]")
    public WebElement createBtn;

    @FindBy(xpath = "//*[@id=\"o_field_input_544\"]")
    public  WebElement modelOptions;
    @FindBy(name = "license_plate")
    public WebElement LicensePlate;


}
