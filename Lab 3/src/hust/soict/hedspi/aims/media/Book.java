package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<>();

    public Book(String title) {
        super(title);
    }

    public Book(String title, String category, float cost) {
        super(title, category, cost);
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = new ArrayList<>(authors); 
    }

    public void addAuthor(String authorName) {
        if (authors.contains(authorName)) {
            System.out.println("Author '" + authorName + "' already exists.");
        } else {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' has been added.");
        }
    }

    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' has been removed.");
        } else {
            System.out.println("Author '" + authorName + "' is not in the authors list.");
        }
    }

    public String toString() {
        return "Book - " + this.getId() + " - " + this.getTitle() + " - "
                + this.getCategory() + " - " + this.authors + " : "
                + this.getCost() + " $";
    }

    public List<String> getAuthors() {
        return authors;
    }
}
