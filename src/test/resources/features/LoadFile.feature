Feature: Load selected CSV files

  Scenario: Positive Flow – Successful loading of selected CSV files
    Given I select CSV files to upload with all mandatory fields available
    When I press upload button
    Then All files selected to be uploaded
    And should display the list of files uploaded

  Scenario: Negative Flow – Some Mandatory fields missing
    Given I select CSV files to upload (with few mandatory fields with NULL)
    When I press upload button
    Then Files should not be uploaded
    And display error message as ‘File contains few roles with missing mandatory fields’

  Scenario: Negative Flow - no read access to csv files
    Given I select CSV files to upload (with no read permission)
    When I press upload button
    Then Files should not be uploaded
    And display error message as ‘No read permission for the selected files’