package hust.soict.hedspi.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
	private static int nbCompactDiscs = 0;
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<>();

	public CompactDisc(String title, String category, float cost, String director, int length, String artist) {
		super(++nbCompactDiscs, title, category, cost, length, director);
		this.artist = artist;
	}

	public String getArtist() {
		return artist;
	}

	public void addTrack(Track track) {
		if (!tracks.contains(track)) {
			tracks.add(track);
		} else {
			System.out.println("Track '" + track.getTitle() + "' đã tồn tại.");
		}
	}

	public void removeTrack(Track track) {
		if (tracks.contains(track)) {
			tracks.remove(track);
		} else {
			System.out.println("Không tìm thấy Track '" + track.getTitle() + "' trong danh sách.");
		}
	}

	@Override
	public int getLength() {
		return tracks.stream().mapToInt(Track::getLength).sum(); // Tổng chiều dài bằng cách dùng Stream API
	}

	@Override
	public void play() {
		System.out.println("Playing CD: " + this.getTitle());
		System.out.println("Artist: " + this.artist);
		tracks.forEach(Track::play);
	}

	@Override
	public String toString() {
		StringBuilder trackList = new StringBuilder();
		for (Track track : tracks) {
			trackList.append("\n   - ").append(track.getTitle()).append(" (").append(track.getLength())
					.append(" mins)");
		}
		return "CD - Title: " + getTitle() + " - Artist: " + getArtist() + " - Cost: $" + getCost() + "\nTracks: "
				+ trackList;
	}

	public static int getNbCompactDiscs() {
		return nbCompactDiscs;
	}
}