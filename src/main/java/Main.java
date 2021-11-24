
import org.json.simple.parser.ParseException;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws ParseException {


        System.out.println("+-------------------------------------------+");
        Scanner input = new Scanner(System.in);

        System.out.print("Please Enter Your SubDomain: ");
        String subDomain = input.next();
        System.out.println();
        System.out.print("Please Enter you email: ");
        String email = input.next();
        System.out.println();
        System.out.print("please enter your password: ");
        String password = input.next();
        System.out.println();

        Credential credential = new Credential(subDomain, email, password);


        String message = " WELCOME TO TICKET VIEWER  \n type 'm' to see menu or  'q'  to quit";
        System.out.println(message);
        System.out.println("+-------------------------------------------+");
        String userInput = input.next();

        while (!userInput.equals("q")) {

            menuMessage();
            userInput = input.next();
            if (userInput.equals("1")) {
                Tickets tickets = new Tickets(credential);
                JsonParser.parse(tickets.getTickets());


            } else {
                System.out.println("Please Enter Id you want to search ");
                int id = input.nextInt();
                Tickets tickets = new Tickets(credential);
                JsonParser.parseByID(tickets.getTicketByID(id));

            }

        }

    }

    public static void menuMessage() {

        String message = " Menu Options \n \t 1- Press 1 to get list of tickets. \n \t 2: Press 2 to search a ticket\n \t 3- Press 'q' to Exit";
        System.out.println(message);
    }


}




