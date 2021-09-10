#you should change the number of records before-fleetstepsdefs
#  you should change number of records in fleetpages lines 74
@wip
Feature: Vehicles Menu

  Background:
    Given the user is in login page
    When the user logged in as "Point of Sales" using "posmanager10@info.com" "posmanager"
    And the user clicks "Fleet" tab


  Scenario: Vehicles Menu Options
    Then the user should see following menu
      | Vehicles               |
      | Vehicles Odometer      |
      | Vehicle Costs          |
      | Vehicles Contracts     |
      | Vehicles Fuel Logs     |
      | Vehicles Services Logs |

  Scenario: Create a new Service Log
    Given the user clicks Vehicles Services Logs button
    When the user clicks Create button and enters the details and adds note
    Then the user should see the the creation time as a note

  Scenario: The number of log records
    When the user clicks Vehicles Services Logs button
    And the user gets the number of records before the new record
    When the user clicks Create button and enters the details and adds note
    Then the user should see the the creation time as a note
    And the user gets the number of records after the new record
    Then the user should see the number of records increases one

  Scenario: Edit Log and add 3 Random Services
    When the user clicks Vehicles Services Logs button
    And the user edit log record
    Then the user should see three random services added








