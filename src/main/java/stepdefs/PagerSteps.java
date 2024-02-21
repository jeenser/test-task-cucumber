package stepdefs;

import dtos.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Client;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PagerSteps {

    private List<Product> products = Collections.emptyList();
    private int offset;
    private int limit;

    @When("User sends request")
    public void userSendsRequest() {
        this.products = Client.getAllProducts();
    }

    @Then("Correct amount of data is returned")
    public void correctAmountOfDataIsReturned() {
        assertThat(products).isNotEmpty();
    }

    @Given("Pagination with {int} offset and {int} limit")
    public void paginationWithOffsetAndLimit(int offset, int limit) {
        this.offset = offset;
        this.limit = limit;
    }

    @When("User sends request with params")
    public void userSendsRequestWithParams() {
        this.products = Client.getProductsWithOffsetAndLimit(this.offset, this.limit);
    }

    @Then("Correct amount of data is returned according to params")
    public void correctAmountOfDataIsReturnedAccordingToParams() {
        assertThat(products).size().isEqualTo(this.limit);
    }
}
