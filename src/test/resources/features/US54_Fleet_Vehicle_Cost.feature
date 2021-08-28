@FIDE-252
Feature: US54

  Background:
    Given user logs in as "pos manager"

  @US54-AC01 @FIDE-247
  Scenario: Verify that POS manager can see top bar menus
    Then user should see all modules below
      | Discuss       |
      | Calendar      |
      | Notes         |
      | Contacts      |
      | CRM           |
      | Sales         |
      | Website       |
      | Point of Sale |
      | Purchases     |
      | Inventory     |
      | Manufacturing |
      | Repairs       |
      | Project       |
      | Events        |
      | Surveys       |
      | Employees     |
      | Attendances   |
      | Leaves        |
      | Expenses      |
      | Maintenance   |
      | Fleet         |
      | Dashboards    |

  @US54-AC02 @FIDE-250
  Scenario: Verify that POS manager can see menu on the left side
    And user navigates to "Fleet" module
    Then on the left side user should see all options below
      | Vehicles               |
      | Vehicles Odometer      |
      | Vehicle Costs          |
      | Vehicles Contracts     |
      | Vehicles Fuel Logs     |
      | Vehicles Services Logs |

  @US54-AC03 @US54-AC04 @FIDE-251
  Scenario Outline: Verify that POSmanager can create a new cost
    Given user navigates to "Fleet" module
    And user navigates to "Vehicle Costs" in Fleet page
    And user clicks the create button
    And user enters "<price>" as total price
    And user selects "<type>" option in type dropdown
    And user enters "<model>" and selects first option in vehicle dropdown
    When user clicks save button
    Then user should have created new cost successfully "<model>" "<type>" "<price>"
    And user clicks edit button
    And user enters "<new price>" as total price
    When user clicks save button
    Then user should have created new cost successfully "<model>" "<type>" "<new price>"
    Examples:
      | model             | type       | price  | new price |
      | Audi/A1/1-AUD-001 | Snow tires | 650.00 | 680.00    |