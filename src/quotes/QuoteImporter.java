package quotes;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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

	/* Add an empty String at the end of lines, so the last group
	   of Quote elements get added to quoteElements in the for
	   each loop below.*/
	List<String> listOfLines = new ArrayList<>(Arrays.asList(lines));
	listOfLines.add("");

	// For Lists made up of the lines that will make Quote objects.
	List<ArrayList<String>> quoteElements = new ArrayList<>();

	/* This list will hold the individual lines of the Quote
	   objects, and will be added to an index of quoteElements
	   everytime a blank line is found.
	*/
	List<String> singleQuote = new ArrayList<>();
	
	for (String line: listOfLines) {

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
	    final String quoteText = subList.get(0);

	    // The 2nd element is the quote author.
	    final String quoteAuthor = subList.get(1);

	    // The 3rd element is the quote date.
	    final String quoteDate = subList.get(2);
	    
	    if (quoteDate.equals("")) {
		/* If the 3rd element is an empty string (""), the
		   quote does not have a date. Use the 2 argument
		   constructor. 
		*/	    
		quotes.add(new Quote(quoteText, quoteAuthor));
	    } else {
		quotes.add(new Quote(quoteText, quoteAuthor, quoteDate));
	    }
	}
		
	return quotes;
    }

    /**
       Writes all the quote fields to the same external text file that
    the Quote objects are created from. The file is overwritten.
    @param quoteList the List of Quote objects to be exported
    @param file the file to export to
    */
    public void exportQuotes(List<Quote> quoteList, String file) {

	// Change the Quote objects into a char[] for export.
	char[] text = (createExportString(quoteList)).toCharArray();

	try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {

	    // Write each character to the export file.
	    for(char ch: text) {

		writer.write((int) ch);
	    }
	    
	} catch (IOException ioe) {
	    System.err.printf("Error writing to export file: %s%n", ioe);
	}
    }

    /** Creates a single String from a List of Quote objects, made up
    of the Quote fields.
    @param quoteList the List of Quote objects
    @return the String made from Quote objects
    */
    private String createExportString(List<Quote> quoteList) {

	// Commented help text that goes at the top of the String.
	final String HELP_TEXT = new StringBuilder()
	    .append("# Lines starting with a '#' character are ignored.\n")
	    .append("# This file contains quotes that can be imported into the quotes program.\n")
	    .append("# All the Quote objects can be exported back into this file to save all new\n")
	    .append("# Quote objects created by the program.\n")
	    .append("# Each Quote object is made up of the Quote text, the author, and the quote\n")
	    .append("# date, each on a separate line. Different quotes are separated by one\n")
	    .append("# blank line. The date line is optional. e.g.\n")
	    .append("# This is the first quote text\n")
	    .append("# This is the author\n")
	    .append("# This is the date\n")
	    .append("#\n")
	    .append("# This is the second quote text\n")
	    .append("# This is the author\n")
	    .append("# This is the date\n")
	    .append("#\n")
	    .append("# And so on.\n")
	    .toString();

	// Start the export String with the help text.
	StringBuilder exportString = new StringBuilder(HELP_TEXT);

	// Append the Strings of each Quote field to the export String.
	for (Quote quote: quoteList) {

	    exportString.append(quote.getText())
		.append("\n")
		.append(quote.getAuthor())
		.append("\n");

	    if (quote.getDate() != null) {
		exportString.append(quote.getDate())
		    .append("\n");
	    }

	    // Append a single blank line to separate the Quotes.
	    exportString.append("\n");
	}

	return exportString.toString();
    }
}
