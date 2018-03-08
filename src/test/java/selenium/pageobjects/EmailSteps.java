package selenium.pageobjects;

import com.jayway.restassured.RestAssured;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.notNullValue;

public class EmailSteps {

    public static final String DEFAULT_URI = "https://api.guerrillamail.com";

    @BeforeClass
    static void setup() {
        RestAssured.baseURI = DEFAULT_URI;
        RestAssured.basePath = "/ajax.php";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @AfterClass
    static void cleanup() {
        RestAssured.basePath = null;
    }

    public static String getMailAddress() {
        String emailAddress =
                given()
                        .param("f", "get_email_address")
                        .param("site", "elenb")
                        .when()
                        .get()
                        .then()
                        .assertThat()
                        .statusCode(200)
                        .body("sid_token", notNullValue())
                        .extract().path("email_addr");
        return emailAddress;
    }

    public void checkMail() {
        String sessionIdToken =
        given()
                .param("f", "get_email_address")
                .param("site", "elenb")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("sid_token", notNullValue())
                .extract().path("sid_token");

        given()
                .param("f", "check_email")
                .param("sid_token", sessionIdToken)
                .param("seq", "0")
                .when()
                .get()
                .then()
                .assertThat()
                .statusCode(200)
                .body("mail_from", hasItem("voting216app@gmail.com"))
                .body("mail_subject", hasItem("Voter, your ballot has been successfully posted on public bulletin board"));
    }

}