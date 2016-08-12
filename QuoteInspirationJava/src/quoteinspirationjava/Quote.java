/* Copyright 2016 Samuel Wilson
 *
 * This file is a part of Quote Inspiration.
 *
 * Quote Inspiration is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Quote Inspiration is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package quoteinspirationjava;

/**
 *
 * @author sam
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
       return this.text + "\n" + this.author + "\n" + this.date + "\n";
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Quote programming = new Quote("Programming is the art of making a computer do what you want it to.", "CPP Programming Concepts 1", "2015");
        Quote variables = new Quote("Variables created to store fixed values are called contants and it is convention to name constants with all uppercase characters.", "Mike McGrath, Java in easy steps, fifth edition", "2015");
        
        System.out.println(programming);
        System.out.println(variables);
    }
    
}
