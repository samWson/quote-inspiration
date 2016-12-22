package quotes;

/**
  Quote.java
  This class defines Quote objects, which are made up of the quote
  text, the author or quoter, and the approximate date of the quote.
*/
public class Quote {

    private String text;
    private String author;
    private String date;

    public Quote(String text, String author, String date) {
	this.text = text;
	this.author = author;
	this.date = date;
    }

    @Override
    public String toString() {
	return text + ", " + author + ", " + date + ".";
    }
}
