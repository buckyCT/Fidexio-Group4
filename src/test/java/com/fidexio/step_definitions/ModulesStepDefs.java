package com.fidexio.step_definitions;

import com.fidexio.pages.DiscussPage;
import com.fidexio.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ModulesStepDefs {

    @Then("user should see all modules below")
    public void userShouldSeeAll(List<String> moduleNames) {
        DiscussPage discussPage = new DiscussPage();
        BrowserUtils.waitForVisibility(discussPage.topModules.get(0),10);

        List<String> topModulesText = BrowserUtils.getElementsText(discussPage.topModules);

        if(discussPage.moreBtn.isDisplayed()){
            discussPage.moreBtn.click();
            List<String> moreModulesText = BrowserUtils.getElementsText(discussPage.moreModules);
            topModulesText.addAll(moreModulesText);
        }

        for (String moduleName : moduleNames) {
            Assert.assertTrue(topModulesText.contains(moduleName));
        }
    }

}
