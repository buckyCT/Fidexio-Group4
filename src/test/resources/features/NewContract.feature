Feature: Create a new Contract Functionality
  Background:
    Given user logs in as "pos manager"

  Scenario: Verify that POSmanager can create new contract
   When user should navigate to "Fleet" Page
    Then the title contains "#Inbox - Odoo"
    And user clicks create button
    Then the title contains "New - Odoo"
    And user enters vehicle Model as "Audi/A1"
    And  user enters License Plate as "WA PAE 324"




