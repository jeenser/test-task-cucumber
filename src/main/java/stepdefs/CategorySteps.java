package stepdefs;

import dtos.Category;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CategoryClientService;

import static org.assertj.core.api.Assertions.assertThat;

public class CategorySteps {

    private Category category;
    private Category newCreatedCategory;

    @Given("Category data name {string}, image {string}")
    public void categoryDataNameImage(String name, String image) {
        this.category = Category.builder()
                .name(name)
                .image(image)
                .build();
    }

    @When("User sends request to create Category")
    public void userSendsRequestToCreateCategory() {
        this.newCreatedCategory = CategoryClientService.postCreateCategory(this.category);
    }

    @Then("New category is created")
    public void newCategoryIsCreated() {
        assertThat(CategoryClientService.getAllCategories().stream().anyMatch(c-> c.equals(newCreatedCategory))).isTrue();
    }
}
