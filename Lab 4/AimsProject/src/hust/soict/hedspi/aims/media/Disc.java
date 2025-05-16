package hust.soict.hedspi.aims.media;

public class Disc extends Media {
	protected int length;
	protected String director;

	public Disc(int id, String title, String category, float cost, int length, String director) {
		super(id, title, category, cost);
		if (length < 0) {
			throw new IllegalArgumentException("Length cannot be negative.");
		}
		if (cost < 0) {
			throw new IllegalArgumentException("Cost cannot be negative.");
		}
		this.length = length;
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public String getDirector() {
		return director;
	}

	public void setLength(int length) {
		if (length >= 0) {
			this.length = length;
		} else {
			System.out.println("Length must be non-negative.");
		}
	}

	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "Disc - Title: " + getTitle() + " - Category: " + getCategory() + " - Director: " + getDirector()
				+ " - Length: " + getLength() + " mins - Cost: $" + getCost();
	}
}