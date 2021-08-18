@FIDE-185 #185 is execution and 184 is test set
Feature: Login

  Background:
    Given the user is on the login page

  @FIDE-181 @FIDE-184
  Scenario Outline: Login with valid credentials -> <user>
    When user logs in as "<user>"
    Then user should be able to login

    Examples:
      | user              |
      | expenses manager  |
      | inventory manager |
      | manuf user        |
      | pos manager       |
      | sales manager     |

  @FIDE-182 @FIDE-184
  Scenario: Login with invalid credentials
    When user logs in with "someusername" username and "somepassword" password
    Then user should not be able to login

  @FIDE-182 @FIDE-184
  Scenario: Login with invalid password
    When user logs in with "imm10@info.com" username and "somepassword" password
    Then user should not be able to login

  @FIDE-182 @FIDE-184
  Scenario: Login with invalid username
    When user logs in with "someusername" username and "inventorymanager" password
    Then user should not be able to login

  @FIDE-183 @FIDE-184
  Scenario: Reset password link
    And user should see Reset Password link
    Then user should be able to reset password