package com.fidexio.step_definitions;

import com.fidexio.pages.DiscussPage;
import com.fidexio.pages.VehiclePage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.BrokenBarrierException;

public class NewContractStepDefs {
    DiscussPage discussPage=new DiscussPage();
    VehiclePage vehiclePage=new VehiclePage();

    @When("user should navigate to {string} Page")
    public void userShouldNavigateToPage(String str) {

        BrowserUtils.waitFor(5);
        discussPage.clickModule(str);
    }

    @Then("the title contains {string}")
    public void theTitleContains(String expectedTitle) {
        BrowserUtils.waitForVisibility(discussPage.topModules.get(0),10);
        String actualTitle= Driver.get().getTitle();
        System.out.println("actualTitle = " + actualTitle);
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @And("user clicks create button")
    public void userClicksCreateButton() {

        BrowserUtils.waitFor(5);
        vehiclePage.createBtn.click();
        BrowserUtils.waitFor(5);
    }

    @And("user enters vehicle Model as {string}")
    public void userEntersVehicleModelAs(String model) {
        Select ModelOptions= new Select(vehiclePage.modelOptions);
        ModelOptions.selectByVisibleText(model);
        BrowserUtils.waitFor(3);

    }

    @And("user enters License Plate as {string}")
    public void userEntersLicensePlateAs(String LicensePlate) {
        BrowserUtils.waitFor(2);
        vehiclePage.LicensePlate.sendKeys(LicensePlate);
        BrowserUtils.waitFor(2);
    }
}
