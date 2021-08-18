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

}
