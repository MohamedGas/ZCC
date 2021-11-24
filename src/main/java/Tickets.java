import org.json.simple.parser.ParseException;

public class Tickets {

    API api;
    String path;
    Credential credential;

    public Tickets(Credential userCredential) {
        this.credential = userCredential;
    }


    public String getTickets() throws ParseException {

        api = new API(credential);
        path = "tickets.json";
        StringBuffer responseContent = api.connectionAPI(path);
        return responseContent.toString();
    }

    public String getTicketByID(int id) throws ParseException {
        api = new API(credential);
        path = "tickets/" + id + ".json";
        api.connectionAPI(path);
        StringBuffer responseContent = api.connectionAPI(path);
        return responseContent.toString();

    }


}
