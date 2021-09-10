package com.fidexio.pages;

import com.fidexio.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id = "login")
    public WebElement usernameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    //loginpage username checkbox
    @FindBy(id = "login")
    public WebElement userName;

    //loginpage password checkbox
    @FindBy(id = "password")
    public WebElement password;

    //loginpage errror message while using invalid credentials
    @FindBy(css = "p.alert.alert-danger")
    public WebElement errorMessage;

    //loginpage reset password link
    @FindBy(linkText = "Reset Password")
    public WebElement forgetPasswordLink;

    @FindBy(xpath = "//button[@type='submit'][text()='Log in']")
    public WebElement loginBtn;

    @FindBy(xpath = "//p[contains(text(),'Wrong login/password')]")
    public WebElement wrongPasswordAlert;

    @FindBy(linkText = "Reset Password")
    public WebElement resetPassword;

    @FindBy(xpath = "//button[text()='Confirm']")
    public WebElement confirmBtn;

    public void login(String username, String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

    // method for invalid or blank username or password
    public void login1(String username1, String password1) {
        userName.sendKeys(username1);
        password.sendKeys(password1);
        loginBtn.click();
    }

}
