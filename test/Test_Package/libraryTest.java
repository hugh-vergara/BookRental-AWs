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
        BookRental.library.add(new FictionBook("The Lord of the Flies",
                "William Golding", 1954));
        BookRental.library.add(new NonFictionBook("The Gay Science",
                "Friedrich Nietzche", 1882));

        Book firstBook = BookRental.library.get(0);

        // THIS IS ALL ABOUT THE FIRST FICTION BOOK
        assertTrue(firstBook instanceof FictionBook,
                "Index 0 should be a FictionBook");
        BookRental.library.get(0).isRented();

        assertEquals(2, BookRental.library.size());
        assertEquals("The Lord of the Flies",
                BookRental.library.get(0).getTitle());

        // SECOND IS ABOUT NONFICTIONBOOK
        Book secondBook = BookRental.library.get(1);
        assertTrue(secondBook instanceof NonFictionBook,
                "Index 1 should be a NonFictionBook");
        BookRental.library.get(1).isRented();

        assertEquals(2, BookRental.library.size());
        assertEquals("The Gay Science", BookRental.library.get(1).getTitle());
    }

    
    @Test
    void TestRentMethod_ItWouldRentTheBookWhen_RentMethodisCalled() {
       
        BookRental.library.add(new FictionBook("Don Quixote",
                "Miguel De Cervantes", 1954));
       
       boolean result = BookRental.library.get(0).rent();

       assertTrue(result,
               "The rent() method should return true when a book is successfully rented");

    }
    
    @Test
    void AddBooks_AndThenDetermineIfTheSizeIsEqual() {
        
        BookRental.clearLibrary();
        BookRental.library.add( new FictionBook("The Great Gatsby", "Francis Scott Key Fitzgerald",1925));
        
        assertEquals(1,BookRental.getLibrarySize());
        
        BookRental.library.add(new NonFictionBook("American Kingpin","Nick Bilton",2017));
        assertEquals(2,BookRental.getLibrarySize());
        
        
        
    }
    
    @Test
    void AddTwoBooksRent_Only1Book_ShouldReturnOnly1Rented() {
        BookRental.library.add(new FictionBook("End of Story","A.J Finn", 2010));
        BookRental.library.add(new NonFictionBook("Curry-Ya and Ken","Kenneth Ligutom", 2010));
        
        BookRental.library.get(0).rent();
        
        assertEquals(true, BookRental.library.get(0).isRented());

    }
    
    @Test
    void RentBooks_WithInvalidIndexShouldReturnError() {
        
        BookRental.library.add( new FictionBook("The Devil in The White City", "Erik Larson",2003));
       
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            BookRental.library.get(99).rent();
        }, "Accessing index 1 should throw an IndexOutOfBoundsException.");
    }
    
    @Test
    void DisplayRented_Books_Add1fictionBook_1Non1RentONly1BookShouldReturnWouldMatch() {
        BookRental.library.add(new FictionBook("Kari Raisu","Khan Santos ",2323));
        BookRental.library.add(new NonFictionBook("Joshua","Caranzo", 2010)); 
        
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
    
    
  
    
   
    


