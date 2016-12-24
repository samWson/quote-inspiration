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

	// Split into individual Strings delimited by "\n".
	String[] lines = text.split("\n");

	for (String line: lines) {
	    System.out.println(line);
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
