package com.fidexio.step_definitions;

import com.fidexio.pages.DiscussPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.When;

public class LogoutStepDefs {

    @When("user logout")
    public void userLogout() {
        BrowserUtils.waitFor(3);
        DiscussPage discussPage = new DiscussPage();
        discussPage.userMenu.click();
        discussPage.logOutBtn.click();
        BrowserUtils.waitFor(1);
        Driver.get().navigate().refresh();
    }

}
