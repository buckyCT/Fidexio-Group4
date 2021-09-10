package com.fidexio.step_definitions;

import com.fidexio.pages.DashboardPage;
import com.fidexio.pages.DiscussPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

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

    @When("the user clicks username button and logout on homepage")
    public void theUserClicksUsernameButtonAndLogoutOnHomepage() {
        BrowserUtils.waitFor(2);
        new DashboardPage().usernameBtn.click();
        BrowserUtils.waitFor(1);
        new DashboardPage().logoutBtn.click();
        BrowserUtils.waitFor(3);

    }

    @Then("the user should stop using application")
    public void theUserShouldStopUsingApplication() {

        String actualTitle = Driver.get().getCurrentUrl();
        Assert.assertEquals("https://qa.fidexio.com/web/session/logout", actualTitle);

    }
}
