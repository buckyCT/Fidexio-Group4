@FIDE-187
Feature: Login

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