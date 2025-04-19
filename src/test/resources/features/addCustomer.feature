Feature: AddCustomer

  Scenario Outline: Add customer with valid details
    Given User is on Customer page
    When User enters customer name "<name>" and contact "<contact>"
    Then Customer "<name>" should be added successfully

    Examples:
      | name       | contact     |
      | Test User  | 9999999999  |
