Feature: Testing a pager

  #  Test different scenarios on the pager ( validating that it returns the expected amount )

  Scenario: Testing GET request with pagination
    When User sends request
    Then Correct amount of data is returned

    #  Validate that the pager parameters work accurately

  Scenario: Testing GET request params
    Given Pagination with 0 offset and 10 limit
    When User sends request with params
    Then Correct amount of data is returned according to params