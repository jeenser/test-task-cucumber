Feature: Testing category

  #  Validate the creation of a category.

  Scenario: Testing creation of Category
    Given Category data name "New Category", image "https://placeimg.com/640/480/any"
    When User sends request to create Category
    Then New category is created