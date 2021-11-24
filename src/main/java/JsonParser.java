import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonParser {
    static String header = "  ID \t\tSubject\t\t\t\t\tDate Created\t\ttype ";

    public static String parse(String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(body);
        JSONArray tickets = (JSONArray) json.get("tickets");
        // counts
        Object count = json.get("count");
        System.out.println("You Have " + count +" Tickets\n");



        for (int i = 0; i < tickets.size(); i++) {
            JSONObject ticket = (JSONObject) tickets.get(i);
            Object id = ticket.get("id");
            Object created_at = ticket.get("created_at");
            Object type = ticket.get("type");
            Object subject = ticket.get("subject");
            System.out.println("" + id + " \t " + subject + "\t\t" + created_at + " \t " + type + "");


        }


        return null;
    }

    public static String parseByID(String body) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(body);
        JSONObject ticket = (JSONObject) json.get("ticket");

        System.out.println(header);
        Object id = ticket.get("id");
        Object created_at = ticket.get("created_at");

        Object type = ticket.get("type");
        Object subject = ticket.get("subject");

        System.out.println("" + id + " \t " + subject + "\t\t" + created_at + " \t " + type + "");


        return null;
    }

}
