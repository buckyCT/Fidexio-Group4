package com.fidexio.step_definitions;

import com.fidexio.pages.DiscussPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;

import java.util.List;

public class ModulesStepDefs {

    @Then("user should see all {string}")
    public void userShouldSeeAll(String moduleName) {
        DiscussPage discussPage = new DiscussPage();
        List<String> modulesNames = BrowserUtils.getElementsText(discussPage.topModules);
    }

}
