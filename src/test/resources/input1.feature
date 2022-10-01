Feature: The bill is calculated for input 1

  Scenario: Input 1
    Given 1 book at 12.49, 1 music CD at 14.99, 1 chocolate bar at 0.85
    When the bill is calculated for input 1
    Then 1 book: 12.49 1 music CD: 16.49 1 chocolate bar: 0.85 Sales Taxes: 1.50 Total: 29.83
