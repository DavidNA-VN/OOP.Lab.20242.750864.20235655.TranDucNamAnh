package hust.soict.hedspi.aims.media;

public class Track implements Playable {
	private String title;
	private int length;

	public Track(String title, int length) {
		if (title == null || title.trim().isEmpty()) {
			throw new IllegalArgumentException("Title cannot be null or empty.");
		}
		if (length < 0) {
			throw new IllegalArgumentException("Length cannot be negative.");
		}
		this.title = title;
		this.length = length;
	}

	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Track))
			return false;
		Track other = (Track) obj;

		return this.title != null && this.title.equalsIgnoreCase(other.title) && this.length == other.length;
	}

	@Override
	public void play() {
		System.out.println("Playing Track: " + this.title);
		System.out.println("Track length: " + this.length + " mins");
	}

	@Override
	public String toString() {
		return "Track - Title: " + title + " - Length: " + length + " mins";
	}
}