package finalexam.task4;

public class BookstoreTester {
    public static void main(String[] args) {
        Bookstore bookstore = new Bookstore("123 Main St", "VAT123456");

        Author author1 = new Author("John Doe", "American");
        Author author2 = new Author("Jane Smith", "British");

       
        bookstore.addAuthor(author1);
        bookstore.addAuthor(author2);

        System.out.println("Current authors: " + bookstore.getAuthors());
        bookstore.saveAuthorsToFile("authors.dat");

        bookstore = new Bookstore("123 Main St", "VAT123456");


        bookstore.loadAuthorsFromFile("authors.dat");


        System.out.println("Loaded authors: " + bookstore.getAuthors());


        bookstore.removeAuthor(author1);


        System.out.println("Updated authors: " + bookstore.getAuthors());
    }
}

