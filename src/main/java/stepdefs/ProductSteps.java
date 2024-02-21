package stepdefs;

import dtos.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class ProductSteps {

    private Product product;

    @Given("correct Product data consisting of title {string} , price {int}, description {string}, category {int}. images")
    public void correctProductDataConsistingOfTitlePriceDescriptionCategoryImages(String title,
                                                                                  int price,
                                                                                  String description,
                                                                                  int category,
                                                                                  List<String> images) {
        this.product = Product.builder()
                .title(title)
                .price(price)
                .description(description)
                .images(images)
                .build();
    }

    @When("User sends request to create Product")
    public void userSendsRequestToCreateProduct() {
    }

    @Then("Success response of Product creation is received")
    public void successResponseOfProductCreationIsReceived() {
    }

    @And("Product is shown in list of Products")
    public void productIsShownInListOfProducts() {
    }

    @Given("incorrect Product data")
    public void incorrectProductData() {
    }

    @Then("Failed response of Product creation is received")
    public void failedResponseOfProductCreationIsReceived() {
    }

    @And("Product is not shown in list of Products")
    public void productIsNotShownInListOfProducts() {
    }

    @Given("Upper limit of price")
    public void upperLimitOfPrice() {
    }

    @Given("Lower limit of price")
    public void lowerLimitOfPrice() {
    }

    @When("User sends request with price limits")
    public void userSendsRequestWithPriceLimits() {
    }

    @Then("Products in response are not exceeding price range")
    public void productsInResponseAreNotExceedingPriceRange() {
    }
}
