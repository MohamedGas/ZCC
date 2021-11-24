import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {
    String url = " https://zcc9468.zendesk.com/api/v2/tickets.json " +
            "mig7690@utulsa.edu:Ugaas123@@";

    @Test
    void getTicketByIDTest() throws ParseException {

        Credential credential = new Credential("zcc9468", "mig7690@utulsa.edu", "Ugaas123@@");
        Tickets tickets = new Tickets(credential);
        String expected = tickets.getTicketByID(204);

        Response actual = (Response) given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .auth().basic("mig7690@utulsa.edu", "Ugaas123@@")
                .when()
                .get("https://zcc9468.zendesk.com/api/v2/tickets/204.json ")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .body();
        Assert.assertEquals(actual, expected);


    }

    @Test
    void getTicketTest() throws ParseException {
        Credential credential = new Credential("zcc9468", "mig7690@utulsa.edu", "Ugaas123@@");
        Tickets tickets = new Tickets(credential);
        String expected = tickets.getTickets();

        Response actual = (Response) given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .auth()
                .basic("mig7690@utulsa.edu", "Ugaas123@@")
                .when()
                .get("https://zcc9468.zendesk.com/api/v2/tickets.json ")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .body();
        Assert.assertEquals(actual.getStatusCode(), 200);

        Assert.assertEquals(actual.body().asString(), expected);


    }

}
