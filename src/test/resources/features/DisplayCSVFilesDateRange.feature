Feature: Display CSV files loaded for a Given date range

  Scenario:  Positive Flow - CSV files selection
    Given I enter a date range
    When I press List CSV file button
    Then All CSV Files loaded during the selected period should be displayed

  Scenario:  Negative Flow - CSV files selection for wrong range
    Given I enter a date range (where no CSV files loaded)
    When I press List CSV file button
    Then “No CSV files loaded for the selected range” to be displayed

  Scenario:  Positive Flow - Product selection
    Given I enter a date range
    When I press List Products button
    Then All Products loaded during the selected period should be displayed

  Scenario:  Negative Flow - Product selection where no products exits
    Given I enter a date range
    When I press List Products button
    Then  “No Products loaded for the selected range” to be displayed