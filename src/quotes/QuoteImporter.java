package quotes;

import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
   QuoteImporter.java
   This class provides the functionality for importing Quote objects into
   the program.
*/
public class QuoteImporter {

    private File file;

    /**
       A QuoteImporter object is used for importing Quote objects from
       a text file.
       @param filePath the file path to import Quotes from
    */
    public QuoteImporter(String filePath) {
	this.file = new File(filePath);
    }

    /**
       Imports Quote objects from a text file.
       @return the List of Quote objects
    */
    public List<Quote> importQuotes() {
	
	// Temp StringBuffer for making this method.
	StringBuffer importedText = new StringBuffer();
	
	try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

	    // For reading each line from the text file.
	    String line;
	    
	    while ((line = reader.readLine()) != null) {

		// Ignore lines starting with '#' i.e. commented
		// lines.
		if (line.startsWith("#")) {
		    continue;
		}

		importedText.append(line).append("\n");

	    }

	} catch (IOException ioe) {
	    System.err.printf("Error importing from file: %s%n", ioe.toString());
	}

	// Make the Quote objects from the Strings.
	List<Quote> quotes = makeQuotes(importedText.toString());
	
	// Returning a List that has had nothing done to it. Still
	// building this method.
	return quotes;
    }

    /**
       Creates Quote objects from the parsed lines of a String object.
       @param text a String object to be parsed 
       @return the list of Quote objects
    */
    private List<Quote> makeQuotes(String text) {

	// For returning the new Quote objects.
	List<Quote> quotes = new ArrayList<>();

	// Split into individual Strings delimited by "\n".
	String[] lines = text.split("\n");

	// For Lists made up of the lines that will make Quote objects.
	List<ArrayList<String>> quoteElements = new ArrayList<>();

	/* This list will hold the individual lines of the Quote
	   objects, and will be added to an index of quoteElements
	   everytime a blank line is found.
	*/
	List<String> singleQuote = new ArrayList<>();
	
	for (String line: lines) {

	    singleQuote.add(line);

	    /* If a blank line is added, that is the end of the
	       Quote. Add it to the quoteElements List.
	    */
	    if (line.equals("")) {

		quoteElements.add(new ArrayList<String>(singleQuote));

		// Clear the List, making it ready for a new series of
		// Quote elements.
		singleQuote.clear();
	    }
	}

	/* Make the Quote objects from the individual Lists in
	   quoteElements. A subList may have up to 4 elements. We are
	   only interested in using 3. The 3rd or 4th elements may be
	   empty Strings, in which case they are discarded.
	*/
	for (ArrayList<String> subList: quoteElements) {

	    // The 1st element is the quote text.
	    final String subList[0];

	    // The 2nd element is the quote author.
	    final String subList[1];

	    // The 3rd element is the quote date.
	    final String subList[2];
	    
	    /* If the 3rd element is an empty string (""), the quote
	       does not have a date. Use the 2 argument constructor.
	    */
	    if ()
	}
		

	return new ArrayList<Quote>();
    }
    /*
    /**
       Removes any lines from a string object that start with a '#'
       character, and returns the remaining String.
    
    private String stripComments(String text) {

	char[] commentedText = text;

	for ()

     
    }
    */
}
