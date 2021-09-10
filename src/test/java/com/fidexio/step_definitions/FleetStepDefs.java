package com.fidexio.step_definitions;

import com.fidexio.pages.FleetMenuPage;
import com.fidexio.pages.FleetPage;
import com.fidexio.pages.VehicleCostsPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.util.List;

public class FleetStepDefs {

    FleetMenuPage fleetMenuPage = new FleetMenuPage();

    int numberOfRecordsBefore;
    int numberOfRecordsAfter;

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

    @Then("the user should see following menu")
    public void theUserShouldSeeFollowingMenu(List<String> expectedMenu) {

        BrowserUtils.waitFor(3);
        List<String> actualMenuTexts = BrowserUtils.getElementsText(new FleetMenuPage().menusOnLeft);
        System.out.println("actualMenuTexts.size() = " + actualMenuTexts.size());

        for (String expectedName : expectedMenu) {
            Assert.assertTrue(actualMenuTexts.contains(expectedName));
            System.out.println("expectedName = " + expectedName);
        }
    }

    @Given("the user clicks Vehicles Services Logs button")
    public void theUserClicksVehiclesServicesLogsButton() {

        fleetMenuPage.VSLModule.click();

        BrowserUtils.waitFor(3);
    }

    @And("the user gets the number of records before the new record")
    public void theUserGetsTheNumberOfRecordsBeforeTheNewRecord() {

        BrowserUtils.waitFor(1);

        numberOfRecordsBefore = Integer.parseInt(fleetMenuPage.numberOfRecords.getText());
        System.out.println("numberOfRecordsBefore = " + numberOfRecordsAfter);
        System.out.println("numberOfRecordsBefore = " + numberOfRecordsBefore);

    }


    @When("the user clicks Create button and enters the details and adds note")
    public void theUserClicksCreateButtonAndEntersTheDetailsAndAddsNote() {


        fleetMenuPage.VSLcreateBttn.click();

        BrowserUtils.waitFor(3);

        fleetMenuPage.vehicleBttn.click();

        BrowserUtils.waitFor(5);

        fleetMenuPage.vehiclesOptions.get(5).click();

        BrowserUtils.waitFor(1);

        fleetMenuPage.serviceTypeBttn.click();

        fleetMenuPage.serviceTypeOptions.get(3).click();

        fleetMenuPage.totalPriceBox.clear();

        fleetMenuPage.totalPriceBox.sendKeys("250.00", Keys.TAB);

        fleetMenuPage.dateDropdown.click();

        fleetMenuPage.dateDropdown.sendKeys("08/26/2021", Keys.TAB);

        BrowserUtils.waitFor(2);

        String date = fleetMenuPage.dateDropdown.getAttribute("value");

        fleetMenuPage.purchaserDropdown.click();

        fleetMenuPage.purchaserOptions.get(1).click();

        fleetMenuPage.vendorDropdown.click();

        fleetMenuPage.vendorOptions.get(0).click();

        fleetMenuPage.invoiceRefBox.sendKeys("220");

        fleetMenuPage.notesBox.sendKeys(date);

        BrowserUtils.waitFor(2);
    }

    @Then("the user should see the the creation time as a note")
    public void theUserShouldSeeTheTheCreationTimeAsANote() {

        String date = fleetMenuPage.dateDropdown.getAttribute("value");

        System.out.println("date = " + date);

        Assert.assertTrue(fleetMenuPage.notesBox.getAttribute("value").contains(date));

        fleetMenuPage.saveBttnForLog.click();

    }

    @And("the user gets the number of records after the new record")
    public void theUserGetsTheNumberOfRecordsAfterTheNewRecord() {

        BrowserUtils.waitFor(2);

        numberOfRecordsAfter = Integer.parseInt(fleetMenuPage.numberOfRecords.getText());

        System.out.println("numberOfRecordsAfter = " + numberOfRecordsAfter);

    }

    @Then("the user should see the number of records increases one")
    public void theUserShouldSeeTheNumberOfRecordsIncreasesOne() {

        BrowserUtils.waitFor(2);

        Assert.assertEquals(numberOfRecordsAfter,(numberOfRecordsBefore+1));

    }

    @And("the user edit log record")
    public void theUserEditLogRecord() {

        fleetMenuPage.VSLModule.click();

        BrowserUtils.waitFor(3);

        fleetMenuPage.lastLogRecord.get(fleetMenuPage.lastLogRecord.size()-1).click();

        BrowserUtils.waitFor(1);

        fleetMenuPage.editBttn.click();

        fleetMenuPage.addServicesBttn.click();

        fleetMenuPage.newServicesDropdown.click();

        BrowserUtils.waitFor(3);

        fleetMenuPage.newServicesOptions.get(0).click();

        fleetMenuPage.addServicesBttn.click();

        BrowserUtils.waitFor(2);

        fleetMenuPage.newServicesDropdown.click();

        fleetMenuPage.newServicesOptions.get(1).click();

        BrowserUtils.waitFor(2);

        fleetMenuPage.addServicesBttn.click();

        fleetMenuPage.newServicesDropdown.click();

        fleetMenuPage.newServicesOptions.get(2).click();

        fleetMenuPage.addServicesBttn.click();

    }

    @Then("the user should see three random services added")
    public void theUserShouldSeeThreeRandomServicesAdded() {

        Assert.assertTrue(fleetMenuPage.firstNewService.isDisplayed());
        Assert.assertTrue(fleetMenuPage.secondNewService.isDisplayed());
        Assert.assertTrue(fleetMenuPage.thirdNewService.isDisplayed());
    }

}
