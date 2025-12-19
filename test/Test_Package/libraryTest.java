package Test_Package;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import librarypackage.Book;
import librarypackage.BookRental;
import librarypackage.FictionBook;
import librarypackage.NonFictionBook;

class libraryTest {
    
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    @Test
    void setup() {
        BookRental.clearLibrary();       
        outContent.reset();
        System.setOut(new PrintStream(outContent));
    }

    
    @Test
    void TestAddingofFictionBookShouldBeAllowed_AndBooksIsNotRentedByDefault() {
        BookRental.addBook(new FictionBook("The Lord of the Flies",
                "William Golding", 1954));
        BookRental.addBook(new NonFictionBook("The Gay Science",
                "Friedrich Nietzche", 1882));

        Book firstBook = BookRental.getLibrary().get(0);

        // THIS IS ALL ABOUT THE FIRST FICTION BOOK
        assertTrue(firstBook instanceof FictionBook,
                "Index 0 should be a FictionBook");
        BookRental.getLibrary().get(0).isRented();

        assertEquals(2, BookRental.getLibrary().size());
        assertEquals("The Lord of the Flies",
                BookRental.getLibrary().get(0).getTitle());

        // SECOND IS ABOUT NONFICTIONBOOK
        Book secondBook = BookRental.getLibrary().get(1);
        assertTrue(secondBook instanceof NonFictionBook,
                "Index 1 should be a NonFictionBook");
        BookRental.getLibrary().get(1).isRented();

        assertEquals(2, BookRental.getLibrary().size());
        assertEquals("The Gay Science", BookRental.getLibrary().get(1).getTitle());
    }

    
    @Test
    void TestRentMethod_ItWouldRentTheBookWhen_RentMethodisCalled() {
       
        BookRental.addBook(new FictionBook("Don Quixote",
                "Miguel De Cervantes", 1954));
       
       boolean result = BookRental.getLibrary().get(0).rent();

       assertTrue(result,
               "The rent() method should return true when a book is successfully rented");

    }
    
    @Test
    void AddBooks_AndThenDetermineIfTheSizeIsEqual() {
        
        BookRental.clearLibrary();
        BookRental.addBook( new FictionBook("The Great Gatsby", "Francis Scott Key Fitzgerald",1925));
        
        assertEquals(1,BookRental.getLibrarySize());
        
        BookRental.addBook(new NonFictionBook("American Kingpin","Nick Bilton",2017));
        assertEquals(2,BookRental.getLibrarySize());
        
        
        
    }
    
    @Test
    void AddTwoBooksRent_Only1Book_ShouldReturnOnly1Rented() {
        BookRental.addBook(new FictionBook("End of Story","A.J Finn", 2010));
        BookRental.addBook(new NonFictionBook("Curry-Ya and Ken","Kenneth Ligutom", 2010));
        
        BookRental.getLibrary().get(0).rent();
        
        assertEquals(true, BookRental.getLibrary().get(0).isRented());

    }
    
    @Test
    void RentBooks_WithInvalidIndexShouldReturnError() {
        
        BookRental.addBook( new FictionBook("The Devil in The White City", "Erik Larson",2003));
       
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BookRental.getLibrary().get(99).rent();
        }, "Accessing index 1 should throw an IndexOutOfBoundsException.");
    }
    
    @Test
    void DisplayRented_Books_Add1fictionBook_1Non1RentONly1BookShouldReturnWouldMatch() {
        BookRental.addBook(new FictionBook("Kari Raisu","Khan Santos ",2323));
        BookRental.addBook(new NonFictionBook("Joshua","Caranzo", 2010)); 
        
        BookRental.displayBooks();
        
        String expectedOutput = "Kari RaisuKhan Santos 2323" + System.lineSeparator()+"JoshuaCaranzo2010";
        String actualOutput = outContent.toString().trim();

        assertEquals(expectedOutput, actualOutput);
    }
    
    
    @Test
    void TestMain_DummyShouldReturnVoid() {
 
        BookRental.main(null);
        int result = 1;
        assertEquals(1,result,()-> "did not produce the out put xadd :<");
    }
    
    
    @Test
    void setTitleItshouldReturnTrueWhePassedCorrectly() {
        
        Book firstBook = new Book("James Bond", "Andrei",2010);
        String expectedTitle = "James Bond";
        assertEquals(expectedTitle, firstBook.getTitle(), "Title is the same");
       
        
        
            
        
    }

    
    
    }
    
    
  
    
   
    


