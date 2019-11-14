package ie.lyit.testers;

import ie.lyit.serialize.*;
import ie.lyit.book.*;

public class BookSerializerTester {
	
	public static void main(String[] args) {
		BookSerializer bookSerializer = new BookSerializer();
		
		// Read the ArrayList from the file
		bookSerializer.deserializeBooks();
		
		// Create a Menu Object
		Menu menuObj = new Menu();
		
		do {
			// Call its display() method
			menuObj.display();
			// Call its readOption();
			menuObj.readOption();
			
			switch(menuObj.getOption()) {
				case 1: bookSerializer.add();break;
				case 2: bookSerializer.list();break;
				case 3: bookSerializer.view();break;
				case 4: bookSerializer.edit();break;
				case 5: bookSerializer.delete();break;
				case 6: break;
				default: System.out.println("Invalid option!!");
			}
		}while(menuObj.getOption()!=6);
		
		// Write the books ArrayList to file
		// THIS SERIALIZES THE ARRAYLIST
		bookSerializer.serializeBooks();
		
		// Add two records to the ArrayList
//		bookSerializer.add();
//		bookSerializer.add();
						
		// Write the ArrayList to File
		//bookSerializer.serializeBooks();

		
		// Read the ArrayList from the File
		//bookSerializer.deserializeBooks();
		
		// List all the books in the ArrayList
		//bookSerializer.list();
		
	}
}
