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
     * @param newTitle
     */
//    public void setTitle(final String newTitle) {
//        this.title = newTitle;
//    }

    /**
     *
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @param newAuthor
     */
//    public void setAuthor(final String newAuthor) {
//        this.author = newAuthor;
//    }

    /**
     *
     * @return yearPublished
     */
    public int getYearPublished() {
        return yearPublished;
    }

    /**
     *
     * @param newYear
     */
//    public void setYearPublished(final int newYear) {
//        this.yearPublished = newYear;
//    }

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

    /**
     *
     */
    
    
}
