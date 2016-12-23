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
       @param the file path to import Quotes from
    */
    public QuoteImporter(String filePath) {
	this.file = new File(filePath);
    }

    /**
       Imports Quote objects from a text file.
       @return the List of Quote objects
    */
    public List<Quote> importQuotes() {
	
	// For storing and returning the Quote objects.
	List<Quote> quotes = new ArrayList<>();


	// Temp StringBuffer for making this method.
	StringBuffer importedText = new StringBuffer();
	
	try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

	    // For reading each line from the text file.
	    String line;
	    
	    while ((line = reader.readLine()) != null) {
		importedText.append(line).append("\n");
	    }
	} catch (IOException ioe) {
	    System.err.printf("Error importing from file: %s%n", ioe.toString());
	}

	// Printing out the imported text.
	System.out.println(importedText.toString());

	// Returning a List that has had nothing done to it. Still
	// building this method.
	return quotes;
    }
}
