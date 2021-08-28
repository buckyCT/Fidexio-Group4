package com.fidexio.step_definitions;

import com.fidexio.pages.FleetPage;
import com.fidexio.pages.VehicleCostsPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class FleetStepDefs {

    @And("user navigates to {string} module")
    public void userNavigatesToModule(String module) {
        BrowserUtils.waitForVisibility(new FleetPage().topModules.get(0),10);
        new FleetPage().clickModule(module);
    }

    @Then("on the left side user should see all options below")
    public void userShouldSeeAllOptionsBelow(List<String> menuNames) {
        List<String> actualMenuTexts = BrowserUtils.getElementsText(new FleetPage().menusOnLeft);
        for (String expectedName : menuNames) {
            Assert.assertTrue(actualMenuTexts.contains(expectedName));
        }
    }

    @When("user navigates to {string} in Fleet page")
    public void userNavigatesToInFleetPage(String name) {
        FleetPage fleetPage = new FleetPage();
        BrowserUtils.waitForVisibility(fleetPage.menusOnLeft.get(0),10);
        List<String> textList = BrowserUtils.getElementsText(fleetPage.menusOnLeft);
        fleetPage.menusOnLeft.get(textList.indexOf(name)).click();
    }

    @And("user clicks the create button")
    public void userClicksTheCreateButton() {
        BrowserUtils.waitFor(15);
        BrowserUtils.waitForVisibility(new FleetPage().createBtn,15);
        new FleetPage().createBtn.click();
    }

    @And("user enters {string} and selects first option in vehicle dropdown")
    public void userEntersAndSelectsFirstOptionInVehicleDropdown(String input) {
        BrowserUtils.waitFor(1);
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        BrowserUtils.waitForVisibility(vehicleCostsPage.vehicleDropdown,10);
        vehicleCostsPage.vehicleDropdown.click();
        vehicleCostsPage.vehicleDropdown.sendKeys(input);
        BrowserUtils.waitFor(1);
        vehicleCostsPage.vehicleDropdown.sendKeys(Keys.ENTER);
//        BrowserUtils.waitFor(1);
//        List<String> dropdownTexts = BrowserUtils.getElementsText(vehicleCostsPage.getDropdownOptions());
//        vehicleCostsPage.getDropdownOptions().get(dropdownTexts.indexOf(input)).click();
//        vehicleCostsPage.getDropdownOptions().get(0).click();
    }

    @And("user selects {string} option in type dropdown")
    public void userSelectsOptionInTypeDropdown(String input) {
        BrowserUtils.waitFor(1);
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        vehicleCostsPage.typeDropdown.click();
        BrowserUtils.waitFor(1);
//        List<String> dropdownTexts = BrowserUtils.getElementsText(vehicleCostsPage.dropdownOptions);
        List<String> dropdownTexts = BrowserUtils.getElementsText(vehicleCostsPage.getDropdownOptions());
        vehicleCostsPage.getDropdownOptions().get(dropdownTexts.indexOf(input)).click();
    }

    @And("user enters {string} as total price")
    public void userEntersAsTotalPrice(String amount) {
        BrowserUtils.waitFor(1);
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        vehicleCostsPage.priceBox.clear();
        vehicleCostsPage.priceBox.sendKeys(amount);
    }

    @When("user clicks save button")
    public void userClicksSaveButton() {
        BrowserUtils.waitFor(1);
        new FleetPage().saveBtn.click();
        BrowserUtils.waitFor(5);
    }

    @Then("user should have created new cost successfully {string} {string} {string}")
    public void userShouldHaveCreatedNewCostSuccessfully(String model, String type, String price) {
        BrowserUtils.waitFor(1);
        VehicleCostsPage vehicleCostsPage = new VehicleCostsPage();
        Assert.assertTrue(vehicleCostsPage.editBtn.isDisplayed());
        Assert.assertTrue(vehicleCostsPage.createBtn.isDisplayed());

        Assert.assertEquals(model,vehicleCostsPage.vehicleAfterSave.getText());
        Assert.assertEquals(type,vehicleCostsPage.typeAfterSave.getText());
        Assert.assertEquals(price,vehicleCostsPage.priceBox.getText());
    }

    @And("user clicks edit button")
    public void userClicksEditButton() {
        new VehicleCostsPage().editBtn.click();
    }
}
