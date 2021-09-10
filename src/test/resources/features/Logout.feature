@FIDE-187
@FIDE-231
Feature: Logout

  @FIDE-186
  Scenario Outline:
    Given the user is on the login page
    And user logs in as "<user>"
    When user logout
    Then the user is on the login page

    Examples:
      | user              |
      | expenses manager  |
      | inventory manager |
      | manuf user        |
      | pos manager       |
      | sales manager     |


  @FIDE-199
  Scenario Outline: US04-AC01-TC01- User logout
    Given the user logged in as "<userType>" using "<username>" "<password>"
    When the user clicks username button and logout on homepage
    Then the user should stop using application

    Examples:

      | userType           | username                   | password         |
      | Sales Manager      | salesmanager15@info.com    | salesmanager     |
      | Point of Sales     | posmanager10@info.com      | posmanager       |
      | Inventory Manager  | imm10@info.com             | inventorymanager |
      | Expenses Manager   | expensesmanager10@info.com | expensesmanager  |
      | Manufacturing User | manuf_user10@info.com      | manufuser        |