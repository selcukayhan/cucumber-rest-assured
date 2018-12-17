package objects;

import com.jayway.restassured.path.json.JsonPath;
import cucumber.api.java.gl.E;
import gherkin.deps.com.google.gson.JsonObject;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.*;

import static io.restassured.RestAssured.given;


public class JsonPlaceHolder {
    private Response response;
    private ValidatableResponse json;
    private RequestSpecification request;

    private String ENDPOINT_GET_POSTS_FROM_JSONPLACEHOLDER = "https://jsonplaceholder.typicode.com/posts";

    public void getPosts() {
        request = given();
        response = request.when().get(ENDPOINT_GET_POSTS_FROM_JSONPLACEHOLDER);
        //System.out.println("response: " + response.prettyPrint());
    }

    public void getUsersPost(String userId, int postsCount) {
        List<String> userIds = response.jsonPath().get("findAll { it.userId == " + userId + " }");

        Assert.assertEquals(postsCount, userIds.size());
    }

    public void postsIdsShouldBeUnique() {
        List<String> postIds = response.jsonPath().get("id");
        List<String> removedDuplicateIds = new ArrayList<>(new HashSet<>(postIds));

        Assert.assertEquals(postIds.size(), removedDuplicateIds.size());

        System.out.println("All post ids are unique");

    }
}





















