package stepdefs;

import dtos.Product;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.hc.client5.http.HttpResponseException;
import utils.ProductClientService;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductSteps {

    private Product product;
    private Product newCreatedProduct;
    private boolean failedCreationRequest;

    private int upperPrice;
    private int lowerPrice;
    private List<Product> productsInPriceRange;

    @Given("Correct Product data consisting of title {string} , price {int}, description {string}, category {int}. images")
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
                .categoryId(1)
                .build();
    }

    @When("User sends request to create Product")
    public void userSendsRequestToCreateProduct() {

        try {
            this.newCreatedProduct = ProductClientService.postCreateProduct(this.product);
        }
        catch (HttpResponseException e) {
            this.failedCreationRequest = true;
        }

    }

    @Then("Success response of Product creation is received")
    public void successResponseOfProductCreationIsReceived() {

        assertThat(this.newCreatedProduct)
                .usingRecursiveComparison()
                .ignoringFields("categoryId", "category", "id", "creationAt", "updatedAt", "images")
                .isEqualTo(this.product);

    }

    @And("Product is shown in list of Products")
    public void productIsShownInListOfProducts() {
        assertThat(ProductClientService.getAllProducts().stream().anyMatch(p -> p.equals(this.newCreatedProduct))).isTrue();
    }

    @Given("incorrect Product data")
    public void incorrectProductData() {
        this.product = Product.builder()
                .title(null)
                .price(null)
                .description(null)
                .images(null)
                .categoryId(1)
                .build();
    }

    @Then("Failed response of Product creation is received")
    public void failedResponseOfProductCreationIsReceived() {
        assertThat(this.failedCreationRequest).isTrue();
    }

    @Given("Upper limit of price {int}")
    public void upperLimitOfPrice(int upperPrice) {
        this.upperPrice = upperPrice;
    }

    @Given("Lower limit of price {int}")
    public void lowerLimitOfPrice(int lowerPrice) {
        this.lowerPrice = lowerPrice;
    }

    @When("User sends request with price limits")
    public void userSendsRequestWithPriceLimits() {
        this.productsInPriceRange = ProductClientService.getProductsWithPriceLimits(this.lowerPrice, this.upperPrice);
    }

    @Then("Products in response are not exceeding price range")
    public void productsInResponseAreNotExceedingPriceRange() {
        assertThat(this.productsInPriceRange.stream()
                .filter(p -> p.getPrice()>upperPrice || p.getPrice()<lowerPrice).count())
                .isEqualTo(0);
    }
}
