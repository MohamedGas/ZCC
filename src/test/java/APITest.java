import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    // Put your subdomain and credential  here
    String subdomain = "";
    String email ="";
    String password = "";
    String url = " https://"+subdomain+".zendesk.com/api/v2/tickets.json " +
            email+":"+password;

    @Test
    void getTicketByIDTest() throws ParseException {

        Credential credential = new Credential(subdomain, email,password);
        Tickets tickets = new Tickets(credential);
        String expected = tickets.getTicketByID(204);

        Response actual = (Response) given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .auth()
                .basic(email,password)
                .when()
                .get("https://"+subdomain+".zendesk.com/api/v2/tickets/204.json ")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .body();
        Assert.assertEquals(actual.body().asString(), expected);


    }

    @Test
    void getTicketTest() throws ParseException {
        Credential credential = new Credential(subdomain,email,password);
        Tickets tickets = new Tickets(credential);
        String expected = tickets.getTickets();

        Response actual = (Response) given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .auth()
                .basic(email,password)
                .when()
                .get("https://"+subdomain+".zendesk.com/api/v2/tickets.json ")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .body();
        Assert.assertEquals(actual.getStatusCode(), 200);

        Assert.assertEquals(actual.body().asString(), expected);


    }

}
