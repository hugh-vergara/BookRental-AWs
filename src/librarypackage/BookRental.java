package librarypackage;

import java.util.ArrayList;

public final class BookRental {
    /**
     *
     */
    static final int TLORYEAR = 1960;
    /**
    *
    */
    static final int MOCKINGBIRDYEAR = 1960;
    /**
    *
    */
    static final int POINTYEAR = 2000;
    /**
    *
    */
    static final int GLADWELLYEAR = 1997;

    private BookRental() {
        super();
    }

    /**
     *
     */

    public static ArrayList<Book> library = new ArrayList<>();

    /**
     *
     */
    public static void addBooks() {
        library.add(new FictionBook("The Lord of the Rings", "J.R.R. Tolkien",
                TLORYEAR));
        library.add(new FictionBook("To Kill a Mockingbird", "Harper Lee",
                MOCKINGBIRDYEAR));
        library.add(new NonFictionBook("The Tipping Point", "M. Gladwell",
                POINTYEAR));
        library.add(new NonFictionBook("Guns, Germs, and Steel",
                "Jared Diamond", GLADWELLYEAR));
    }

    /***
     *
     */
    public static void rentBooks() {
        library.get(0).rent();
        library.get(2).rent();
    }

    /***
    *
    */
    public static void displayBooks() {
        for (Book b : library) {
            System.out.println(b.getTitle()+ b.getAuthor()
                    + b.getYearPublished());
        }
    }

    /***
    *
    */
    
    /**
     *
     */
    
    
    
    public static void displayRentedBooks() {
        System.out.println("\nBooks rented:");
        for (Book b : library) {
            if (b.isRented()) {
                System.out.println(b.getTitle() + "\t" + b.getAuthor() + "\t"
                        + b.getYearPublished());
            }
        }
    }

    /***
     * @param args
     */
    public static void main(final String[] args) {
        addBooks();
        displayBooks();
        rentBooks();
        displayRentedBooks();
    }
    
    /**
     * 
     */
    public static void clearLibrary() {
        library.clear();
    }
    
    /**
     * 
     * @return
     */
    public static int getLibrarySize() {
        return library.size();
    }

}
