/*
Quotes.
A program that produces a random quote on demand.
*/

package quotes;

import java.util.List;
import java.util.ArrayList;

/**
   Selects a quote at random from a list of quotes, and prints it to the
   console. 
*/
public class Main {

    /**
       The start of the program. Selects a quote from a list, prints
       it to the console, then exits.
    */
    public static void main(String[] args) {

	Quote q1 = new Quote("Programming is the art of making a computer do what you want it to", "CPP, Programming concepts 1");

	Quote q2 = new Quote("What would you do if someone was firing rockets at your house?", "Myself", "2015");

	// Stores all the Quote objects.
	List<Quote> quotes = new ArrayList<>();

	quotes.add(q1);
	quotes.add(q2);
	System.out.println("Printing quote...");
    }
	
       
}
