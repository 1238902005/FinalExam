package finalexam.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Bookstore implements LegalEntity {
    private String address;
    private String vatNumber;
    private List<Author> authors;


    public Bookstore(String address, String vatNumber) {
        this.address = address;
        this.vatNumber = vatNumber;
        this.authors = new ArrayList<>();
    }


    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public String getVatNumber() {
        return vatNumber;
    }


    public void addAuthor(Author author) {
        authors.add(author);
    }

    public boolean removeAuthor(Author author) {
        return authors.remove(author);
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    }


    public void saveAuthorsToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(authors);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public void loadAuthorsFromFile(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            authors = (List<Author>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Bookstore{" +
                "address='" + address + '\'' +
                ", vatNumber='" + vatNumber + '\'' +
                ", authors=" + authors +
                '}';
    }
}
