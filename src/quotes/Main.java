/*
Quotes.
A program that produces a random quote on demand.
*/

package quotes;

import java.util.List;
import java.util.ArrayList;
import java.util.Random;

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

	// Select an index at random and print the Quote at the index.
	System.out.println(quotes.get(new Random().nextInt(quotes.size())));

    }
}
