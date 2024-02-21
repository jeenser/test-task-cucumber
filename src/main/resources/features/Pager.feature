Feature: Testing a pager

  #  Test different scenarios on the pager ( validating that it returns the expected amount )

  Scenario: Testing get all products request with pagination
    When User sends request
    Then Correct amount of data is returned

    #  Validate that the pager parameters work accurately

  Scenario: Testing get all products request params
    Given Pagination with 0 offset and 10 limit
    When User sends request with params
    Then Correct amount of data is returned according to params

      #  Validate all products have the price larger than 0

  Scenario: Testing GET request with pagination
    Given Price of all products should be higher than 0
    When User sends request
    Then All products have correct price