@wip
Feature: Navigation Menu

  Background:
    Given the user is in login page
    When the user logged in as "Point of Sales" using "posmanager10@info.com" "posmanager"

  Scenario:Menu Options POS Manager
    Then the user should see following options
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


