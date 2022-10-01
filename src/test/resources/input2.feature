Feature: The bill is calculated for input 2

  Scenario: Input 2
    Given 1 imported box of chocolates at 10.00 1 imported bottle of perfume at 47.50
    When the bill is calculated
    Then imported box of chocolates: 10.50 1 imported bottle of perfume: 54.65 Sales Taxes: 7.65 Total: 65.15

