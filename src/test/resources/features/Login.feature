@FIDE-185 #185 is execution and 184 is test set
@FIDE-203
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

  @FIDE-196 @FIDE-198
  Scenario Outline: US03-AC01-TC01-User login with valid credentials
    Given the user is in login page
    When the user logged in as "<userType>" using "<username>" "<password>"
    Then the user should be able to login

    Examples:

      | userType           | username                   | password         |
      | Sales Manager      | salesmanager15@info.com    | salesmanager     |
      | Point of Sales     | posmanager10@info.com      | posmanager       |
      | Inventory Manager  | imm10@info.com             | inventorymanager |
      | Expenses Manager   | expensesmanager10@info.com | expensesmanager  |
      | Manufacturing User | manuf_user10@info.com      | manufuser        |

  @FIDE-197 @FIDE-198
  Scenario: US03-AC01-TC02-User login with invalid credentials
    Given the user is on the login page
    When the user logs in using "username" or "user123"
    Then the user should not be able to login
    And User should see reset password on the login page