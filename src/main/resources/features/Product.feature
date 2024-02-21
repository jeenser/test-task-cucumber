Feature: Testing product

  #  Validate the creation of product

  Scenario: Testing creation of product
    Given correct Product data consisting of title "New Product" , price 10, description "A description", category 1. images
      |https://placeimg.com/640/480/any|
      |https://placeimg.com/720/480/any|
    When User sends request to create Product
    Then Success response of Product creation is received
    And Product is shown in list of Products

    #  Negative test the product creation

  Scenario: Testing invalid creation of product
    Given incorrect Product data
    When User sends request to create Product
    Then Failed response of Product creation is received
    And Product is not shown in list of Products

    #  Filter the products within 2 random prices and validate the returned products fall between the given prices

  Scenario: Testing price range
    Given Upper limit of price
    Given Lower limit of price
    When User sends request with price limits
    Then Products in response are not exceeding price range