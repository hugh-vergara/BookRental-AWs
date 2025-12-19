package librarypackage;

public class Book {
    /**
     *
     */
    private String title;
    /**
    *
    */
    private String author;
    /**
    *
    */
    private int yearPublished;
    /**
    *
    */
    private boolean isRented = false;

    /**
     * @param newTitle
     * @param newAuthor
     * @param newYearPublished
     */
    public Book(final String newTitle,
            final String newAuthor, final int newYearPublished) {
        this.title = newTitle;
        this.author = newAuthor;
        this.yearPublished = newYearPublished;
    }

    /**
     *
     * @return title
     */
    public String getTitle() {
        return title;
    }



    /**
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }



    /**
     *
     * @return yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }



    /**
     *
     * @return isRented
     */
    public boolean isRented() {
        return isRented;
    }



    /**
     *
     * @return true
     */
    public boolean rent() {
        this.isRented = true;
        return this.isRented;
    }


}
