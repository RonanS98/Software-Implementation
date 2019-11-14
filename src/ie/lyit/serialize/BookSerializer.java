package ie.lyit.serialize;

import java.util.*;
import ie.lyit.book.Book;
import java.io.*;

public class BookSerializer {
	private ArrayList<Book> books;
	
	private final String FILENAME = "books.ser";	
	
	// Default Constructor
	public BookSerializer(){
		// Construct bookList ArrayList
		books = new ArrayList<Book>();
	}	

	public void add(){
		// Create a Book object
		Book book = new Book();
		// Read its details
		book.read();	
		// And add it to the books ArrayList
		books.add(book);
	}

	public void list(){
		// for every Book object in books
        for(Book tmpBook:books)
			// display it
			System.out.println(tmpBook);
	}
	
	public Book view() {
		Scanner keyboard = new Scanner(System.in);
		
		// Read key field of book to be viewed from the user
		System.out.println("Enter library number of book: ");
		int bookToView = keyboard.nextInt();
		
		// Loop around every book object in the ArrayList
		for(Book tmpBook:books) {
			//If its key field equals the key field of the book to be viewed
			if(tmpBook.getLibraryNumber() == bookToView) {
			// Display the object
			System.out.println(tmpBook);
			// Return it
			return tmpBook;
			}
		}
		return null;
	}
	
	public void delete() {
		// Call the view() method to find, display and return the book to be deleted
		Book tempBook = view();
		// If the book to be deleted != null
		if(tempBook != null) {
			// Delete it from the Arraylist by calling the ArrayList remove() method
			books.remove(tempBook);
		}
	}
	
	public void edit() {
		// Call the view() method to find and disply the book to be edited
		Book tempBook = view();
		// If the book to be edited != null
		if(tempBook != null) {
			// Get its index
			int index = books.indexOf(tempBook);
			// Read in new book
			tempBook.read();
			// Reset the object in books
			books.set(index, tempBook);
		}
	}
	
	// This method will serialize the books ArrayList when called, 
	// i.e. it will write it to a file called books.ser
	public void serializeBooks(){
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
		
			ObjectOutputStream os = new ObjectOutputStream(fileStream);
				
			os.writeObject(books);
			os.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
	}

	// This method will deserialize the books ArrayList when called, 
	// i.e. it will restore the ArrayList from the file books.ser
	public void deserializeBooks(){
		try {
			// Deserialize the ArrayList...
			FileInputStream fileStream = new FileInputStream(FILENAME);
		
			ObjectInputStream is = new ObjectInputStream(fileStream);
				
			books = (ArrayList<Book>)is.readObject();
			is.close();
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			System.out.println(ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}