Feature: Testing category

  #  Validate the creation of a category.

  Scenario: Testing creation of Category
    Given Category data
    When User sends request to create Category
    Then New category is created