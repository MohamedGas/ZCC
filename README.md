# ZCC
# Overview
this is a ticket viewer app from zendesk API. This can use everyone.
## Requirements
<h4> in order to access the API you are required</h4>
<ul><li>Zendesk SubDomain <br></li>
<li>email <br></li>
<li>Password  <br></li>

<h1> Features </h1>
<ul>
<li>
List of Tickets </lI>
<li>Search a Ticket By ID</li>

</ul>
<h1> Quick Start </h1>
<p>Run the main method in Main.class then you are required to put</p>
<p>your subdomain , email , password. After that you are at the menu and have Three</p>
<p>Options. List of Tickets, Search a ticker , quit.</p>
 

# Library
````
Json-simple 1.1.1.jar
````

# Testing 

In the unit testing also you are required to put your subdomain , email , password.
## Here is some unit testing code 
````

    String url = " https://{subDomain}.zendesk.com/api/v2/tickets.json " +
            "{email}:{Password}";

    @Test
    void getTicketByIDTest() throws ParseException {

        Credential credential = new Credential("{subdomain}", "{email}", "{password}");
        Tickets tickets = new Tickets(credential);
        String expected = tickets.getTicketByID(put ticket number here );

        Response actual = (Response) given()
                .headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
                .auth()
                .basic("{email}", "{password}")
                .when()
                .get("https://{subdomain}.zendesk.com/api/v2/tickets/{put ticket Number here}.json ")
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response()
                .body();
        Assert.assertEquals(actual.body().asString(), expected);

      

