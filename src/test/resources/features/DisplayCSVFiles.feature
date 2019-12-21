Feature: Display CSV files for a Given directory
'''
As a Supplier I want see all upload files and products for a Given range of dates so that I get my product CatLog status
'''
  Scenario: Positive Flow – Given path has CSV files
    When I enter the path for CSV files
    Then I should able to see all the CSV files in the path

  Scenario: Negative Flow - No CSV files in the path
    When I enter the path for CSV files which doesn’t contain any CSV files
    Then I should get a message that the entered path has no CSV files

  Scenario: Negative Flow - Path/Folder wrong
    When I enter wrong path
    Then I should get a message that the entered path is wrong