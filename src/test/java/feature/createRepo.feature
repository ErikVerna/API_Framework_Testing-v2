Feature: Validate Create Repository & Delete Repository


  Scenario Outline: Verify Create Repo API
    Given Starting Test Case "Verify Create Repo API"
    Given Create Repo Payload name "<name>" and description "<description>"
    When User calls Create API "/user/repos" Post API Call
    Then API Call got successful with status code 201
    And Verify Repository "name" is "<name>"
    And Verify the Repository "description" is "<description>"
    And Ending Test Case

    Examples:
      | name       | description                     |
      | Test-Repo1 | This is Data Driven Test Repo 1 |
      | Test-Repo2 | This is Data Driven Test Repo 2 |
      | Test-Repo3 | This is Data Driven Test Repo 3 |

  Scenario Outline: Verify Delete Repo API
    Given Starting Test Case "Verify Delete Repo API"
    Given Create Repo Payload name "<name>" and description "<description>"
    When User calls Delete API "/repos/ErikAPIdummy/" Delete API Call
    Then API Call got successful with status code 204
    And Ending Test Case

    Examples:
      | name       | description                     |
      | Test-Repo1 | This is Data Driven Test Repo 1 |
      | Test-Repo2 | This is Data Driven Test Repo 2 |
      | Test-Repo3 | This is Data Driven Test Repo 3 |
