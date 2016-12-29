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

    public Quote(String text, String author) {
	this.text = text;
	this.author = author;
    }

    public Quote(String text, String author, String date) {
	this(text, author);
	this.date = date;
    }

    @Override
    public String toString() {
	return new StringBuilder().append(text)
	    .append("\n")
	    .append(author)
	    .append("\n")
	    .append(date)
	    .append("\n")
	    .toString();
    }

    /**
       Returns the value of the Quotes text.
       @return the Quote text
    */
    public String getText() {
	return this.text;
    }

    /**
       Returns the value of the Quotes author.
       @return the Quote author
    */
    public String getAuthor() {
	return this.author;
    }

    /**
       Returns the value of the Quotes date.
       @return the Quote date
    */
    public String getDate() {
	return this.date;
    }
}
