package stepdefs;

import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import objects.JsonPlaceHolder;

public class JsonPlaceHolderSteps {

    JsonPlaceHolder jsonPlaceHolder = new JsonPlaceHolder();

    @When("^I get a list of blog posts using the API endpoint$")
    public void iGetAListOfBlogPostsUsingTheAPIEndpoint() {
        jsonPlaceHolder.getPosts();
    }

    @Then("^Then user (.*) should have (\\d+) posts$")
    public void i_should_login(String userId, int numpost) {
        jsonPlaceHolder.getUsersPostAndValidateCount(userId, numpost);
    }

    @Then("^each blog post should have a unique ID$")
    public void eachBlogPostShouldHaveAUniqueID() {
        jsonPlaceHolder.postsIdsShouldBeUnique();
    }
}


