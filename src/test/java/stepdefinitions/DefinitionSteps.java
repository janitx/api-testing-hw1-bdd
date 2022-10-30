package stepdefinitions;

import clients.ProductClient;
import factories.ProductFactory;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import models.Message;
import models.Product;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.Assertions.assertThat;

public class DefinitionSteps {
    Product product;
    Message actualResult;

    @Before
    public void testSetUp() {
        product = ProductFactory.create(ProductFactory.Product.PRODUCT_FULL);

    }

    @Given("User create Sweatband")
    public void createSweatband() {
        actualResult = ProductClient.create(product);
    }

    @Then("User checks response {string}")
    public void userChecksResponse(String expectedResult) {
        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo(expectedResult);
    }


    @Given("User update Sweatband")
    public void updateSweatband() {
        actualResult = ProductClient.update(product);
    }

    @Then("User checks response update call {string}")
    public void userChecksUpdateResponse(String expectedResult) {
        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo(expectedResult);
    }


    @Given("User get Sweatband")
    public void getSweatband() {
        product.setId(1010);
        product = ProductClient.get(product.getId());
    }

    @Then("^User checks response id (-?\\d+)$")
    public void userChecksGetResponse(int id) {
        assertThat(product.getId()).as("Wrong id").isEqualTo(id);
        //System.out.println("This is "+id);
    }

    @Given("User delete Sweatband")
    public void deleteSweatband() {
        actualResult = ProductClient.delete(product);
    }

    @Then("User checks response delete call {string}")
    public void userChecksDeleteResponse(String expectedResult) {
        assertThat(actualResult.getMessage()).as("Message field contains wrong text")
                .isEqualTo(expectedResult);
    }

    @Given("^User get Multivitamins id (-?\\d+)$")
    public void getMultivitaminsSweatband(int id) {
        product = ProductClient.get(id);
    }

    @Then("User checks response get Multivitamins id")
    public void userChecksGetMultivitaminsResponse() {
        Product expectedProduct = ProductFactory.create(ProductFactory.Product.PRODUCT_MULTIVITAMINS);
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(product.getId()).as("Wrong id").isEqualTo(expectedProduct.getId());
        softAssertions.assertThat(product.getName()).as("Wrong name").isEqualTo(expectedProduct.getName());
        softAssertions.assertThat(product.getDescription()).as("Wrong description").isEqualTo(expectedProduct.getDescription());
        softAssertions.assertThat(product.getPrice()).as("Wrong price").isEqualTo(expectedProduct.getPrice());
        softAssertions.assertThat(product.getCategoryId()).as("Wrong category").isEqualTo(expectedProduct.getCategoryId());
        softAssertions.assertThat(product.getCategoryName()).as("Wrong category").isEqualTo(expectedProduct.getCategoryName());
        softAssertions.assertAll();
    }

}
