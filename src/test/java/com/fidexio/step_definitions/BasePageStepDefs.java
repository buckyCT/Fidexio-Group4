package com.fidexio.step_definitions;

import com.fidexio.pages.DashboardPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class BasePageStepDefs {

    List<String> actualMoreMenus = new ArrayList<>();

    //user see 22 modules(when more button is clicked other modules will also be ween
    @Then("the user should see following options")
    public void theUserShouldSeeFollowingOptions(List<String> moduleNames) {

        BrowserUtils.waitForVisibility(new DashboardPage().topBarMenus.get(0), 10);

        List<String> topModulesText = BrowserUtils.getElementsText(new DashboardPage().topBarMenus);

        if (new DashboardPage().moreTab.isDisplayed()) {
            new DashboardPage().moreTab.click();
            List<String> moreModulesText = BrowserUtils.getElementsText(new DashboardPage().moreLists);
            topModulesText.addAll(moreModulesText);
        }

        for (String moduleName : moduleNames) {
            Assert.assertTrue(topModulesText.contains(moduleName));
        }
    }

    @When("the user clicks {string} tab")
    public void theUserClicksTab(String tabMenu) {

        BrowserUtils.waitFor(3);
        new DashboardPage().moreTab.click();
        BrowserUtils.waitFor(3);
        new DashboardPage().fleetTab.click();
        BrowserUtils.waitFor(3);

    }
}





