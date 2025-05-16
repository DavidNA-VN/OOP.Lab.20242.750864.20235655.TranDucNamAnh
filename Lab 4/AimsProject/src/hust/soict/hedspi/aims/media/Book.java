package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class Book extends Media {
	private static int nbBooks = 0;
	private ArrayList<String> authors = new ArrayList<>();

	public Book(String title, String category, float cost) {
		super(++nbBooks, title, category, cost);
	}

	public void addAuthor(String authorName) {
		if (!authors.contains(authorName)) {
			authors.add(authorName);
		} else {
			System.out.println("Tác giả '" + authorName + "' đã tồn tại trong danh sách.");
		}
	}

	public void removeAuthor(String authorName) {
		if (authors.contains(authorName)) {
			authors.remove(authorName);
		} else {
			System.out.println("Không tìm thấy tác giả '" + authorName + "' trong danh sách.");
		}
	}

	public ArrayList<String> getAuthorsList() {
		return authors;
	}

	@Override
	public String toString() {
		return "Book - Title: " + getTitle() + " - Category: " + getCategory() + " - Cost: $" + getCost()
				+ " - Authors: " + authors;
	}

	public static int getNbBooks() {
		return nbBooks;
	}
}