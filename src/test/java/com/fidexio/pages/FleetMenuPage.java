package com.fidexio.pages;

import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FleetMenuPage {

    public FleetMenuPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath = "(//ul[@class='oe_secondary_submenu nav nav-pills nav-stacked'])[34]/li[6]/a")
    public WebElement VSLModule;

    @FindBy(xpath = "//div[@class='o_list_buttons']/button[@accesskey='c']")
    public WebElement VSLcreateBttn;

    @FindBy(xpath = "//div[@class='oe_secondary_menu'][@data-menu-parent='134']/ul/li")
    public List<WebElement> menusOnLeft;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[1]")
    public WebElement vehicleBttn;

    @FindBy(xpath = "(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[1]/li")
    public List<WebElement> vehiclesOptions;


    @FindBy(xpath= "(//input[@class='o_input ui-autocomplete-input'])[2]")
    public WebElement serviceTypeBttn;

    @FindBy(xpath = "(//ul[2][@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[1]/li")
    public List<WebElement> serviceTypeOptions;

    @FindBy(xpath="(//input[@class='o_field_float o_field_number o_field_widget o_input'])[1]")
    public WebElement totalPriceBox;

    @FindBy(css="input.o_datepicker_input.o_input")
    public WebElement dateDropdown;

    @FindBy(xpath="(//div[@class='o_input_dropdown'])[3]")
    public WebElement purchaserDropdown;

    @FindBy(xpath="(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[3]/li")
    public List<WebElement> purchaserOptions;

    @FindBy(xpath="//div[@class='o_field_widget o_field_many2one']")
    public WebElement vendorDropdown;

    @FindBy(xpath="(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[4]/li")
    public List<WebElement> vendorOptions;

    @FindBy(xpath="//input[@name='inv_ref']")
    public WebElement invoiceRefBox;

    @FindBy(xpath="//textarea[@name='notes']")
    public WebElement notesBox;

    @FindBy(xpath="//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public WebElement saveBttnForLog;

    @FindBy(xpath = "//div[@class='o_cp_pager']/div/span/span[2]")
    public WebElement numberOfRecords;

    //    you should change number before test all scenarious
    @FindBy (xpath = "//table/tbody/tr")
    public List <WebElement> lastLogRecord;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_form_button_edit']")
    public WebElement editBttn;

    @FindBy(xpath = "//td[@class='o_field_x2many_list_row_add']/a")
    public WebElement addServicesBttn;

    @FindBy(xpath = "(//input[@class='o_input ui-autocomplete-input'])[5]")
    public WebElement newServicesDropdown;

    @FindBy (xpath = "(//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content'])[5]/li")
    public List<WebElement> newServicesOptions;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped o_editable_list']/tbody/tr[1]/td[1]")
    public WebElement firstNewService;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped o_editable_list']/tbody/tr[2]/td[1]")
    public WebElement secondNewService;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped o_editable_list']/tbody/tr[3]/td[1]")
    public WebElement thirdNewService;

}
