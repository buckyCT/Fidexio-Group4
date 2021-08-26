package com.fidexio.step_definitions;

import com.fidexio.pages.FleetPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

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
}
