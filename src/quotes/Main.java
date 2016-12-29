/*
Quotes.
A program that produces a random quote on demand.
*/

package quotes;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

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

      	// File for importing/exporting Quotes.
	final String quotesFile = "/home/samuel/Programming/quote-inspiration/quote-file.txt";
	
	// Import the Quotes from a file.
	QuoteImporter importer = new QuoteImporter(quotesFile);
	List<Quote> quotes = importer.importQuotes();

	if (args.length == 0) {
	    // If there are no command line arguments, print a random
	    // quote and exit the program.
	    System.out.println(quotes.get(new Random().nextInt(quotes.size())));
	    System.exit(0);
	}

	// For reading console input.
	Scanner input = new Scanner(System.in);
	String text;
	String author;
	String date;

	if (args[0].equals("add")) {
	    // Add a new Quote, get the Quote details.
	    System.out.println("Enter the quote text: ");
	    text = input.nextLine();
	    System.out.println("Enter the author: ");
	    author = input.nextLine();
	    System.out.println("Enter the date (optional): ");
	    date = input.nextLine();

	    if (date.equals("") || date == null) {
		// If date is an empty or null String, use the 2 argument constructor.
		quotes.add(new Quote(text, author));
	    } else {
		quotes.add(new Quote(text, author, date));
	    }
	}		
    }
}
