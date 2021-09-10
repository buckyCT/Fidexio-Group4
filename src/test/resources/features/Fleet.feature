Feature: Fleet Page

  Background:
    Given user logs in as "pos manager"
    And user navigates to "Fleet" module

  Scenario: Verify that POS manager can see menu on the left side
    Then on the left side user should see all options below
      | Vehicles               |
      | Vehicles Odometer      |
      | Vehicle Costs          |
      | Vehicles Contracts     |
      | Vehicles Fuel Logs     |
      | Vehicles Services Logs |

