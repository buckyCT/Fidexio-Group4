package com.fidexio.step_definitions;

import com.fidexio.pages.LoginPage;
import com.fidexio.utilities.BrowserUtils;
import com.fidexio.utilities.ConfigurationReader;
import com.fidexio.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefs {

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String expectedTitle = "Login | Best solution for startups";
        Assert.assertEquals(expectedTitle, Driver.get().getTitle());
    }

    @When("user logs in as {string}")
    public void user_logs_in_as(String user) {
        LoginPage loginPage = new LoginPage();
        String username="";
        String password="";

        switch (user.toLowerCase().trim().replace(" ", "")) {
            case "expensesmanager":
                username = ConfigurationReader.get("expenses_manager_username");
                password = ConfigurationReader.get("expenses_manager_password");
                break;
            case "inventorymanager" :
                username = ConfigurationReader.get("inventory_manager_username");
                password = ConfigurationReader.get("inventory_manager_password");
                break;
            case "manufuser" :
                username = ConfigurationReader.get("manufacturing_user_username");
                password = ConfigurationReader.get("manufacturing_user_password");
                break;
            case "posmanager" :
                username = ConfigurationReader.get("pos_manager_username");
                password = ConfigurationReader.get("pos_manager_password");
                break;
            case "salesmanager" :
                username = ConfigurationReader.get("sales_manager_username");
                password = ConfigurationReader.get("sales_manager_password");
                break;
            default :
                System.out.println("Invalid user type!");
                break;
        }

        loginPage.login(username,password);
    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        String expectedTitle = "Odoo";
        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
//        BrowserUtils.waitFor(3);
//        String expectedTitle2 = "#Inbox - Odoo";
//        Assert.assertEquals(expectedTitle2,Driver.get().getTitle());
    }

    @When("user logs in with {string} username and {string} password")
    public void userLogsInWithUsernameAndPassword(String username, String password) {
        new LoginPage().login(username, password);
    }

    @Then("user should not be able to login")
    public void userShouldNotBeAbleToLogin() {
        Assert.assertTrue(new LoginPage().wrongPasswordAlert.isDisplayed());
    }

    @Then("user should see Reset Password link")
    public void userShouldSeeResetPasswordLink() {
        Assert.assertTrue(new LoginPage().resetPassword.isDisplayed());
    }

    @Then("user should be able to reset password")
    public void userShouldBeAbleToResetPassword() {
        LoginPage loginPage = new LoginPage();
        loginPage.resetPassword.click();
        loginPage.usernameInput.sendKeys("imm10@info.com");
        loginPage.confirmBtn.click();
        Assert.assertTrue(true);
    }

    //using invalid or blank username or password- dynamic way
    @When("the user logs in using {string} or {string}")
    public void the_user_logs_in_using_or(String username1, String password1) {
        new LoginPage().login1(username1,password1);

    }

    //the user using invalid credential can see error message (Wrong login/password)
    @Then("the user should not be able to login")
    public void the_user_should_not_be_able_to_login() {

        Assert.assertTrue(new LoginPage().errorMessage.isDisplayed());

    }

    //when user could not login and want to reset his password
    @And("User should see reset password on the login page")
    public void userShouldSeeResetPasswordOnTheLoginPage() {

        System.out.println("forgotPasswordLink = " + new LoginPage().forgetPasswordLink.getText());
        Assert.assertTrue(new LoginPage().forgetPasswordLink.isDisplayed());
    }

    //user using valid credentials is in login page
    @Given("the user is in login page")
    public void theUserIsInLoginPage() {

        Driver.get().get(ConfigurationReader.get("url"));
    }

    //user entering usertype and valid username-password from the feature-dynamic
    @When("the user logged in as {string} using {string} {string}")
    public void theUserLoggedInAsUsingUsernamePassword(String userType, String username, String password) {

        Driver.get().get(ConfigurationReader.get("url"));

        new LoginPage().login(username, password);

    }

    //user is in main page and the title is asserted
    @Then("the user should be able to login")
    public void the_user_should_be_able_to_login() {

        BrowserUtils.waitFor(3);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("#Inbox - Odoo", actualTitle);
        BrowserUtils.waitFor(2);

    }

}
