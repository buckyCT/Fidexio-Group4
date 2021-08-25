Feature: Top Menu Bars

  Background:
    Given user logs in as "pos manager"

  Scenario Outline: Verify that POS manager can see top bar menus
    Then user should see all "<modules>"

    Examples:
      | modules       |
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