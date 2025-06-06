package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media implements Comparable<Media> {

	private static int nbMedia = 0;
	private int id;
	private String title;
	private String category;
	private float cost;
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
		nbMedia++;
		this.id = nbMedia;
	}
	
	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) return true;
	    if (obj == null || !(obj instanceof Media)) return false;

	    Media other = (Media) obj;
	    return this.title.equals(other.title) && this.cost == other.cost;
	}
	@Override
	public int compareTo(Media other) {
	    int titleCompare = this.title.compareToIgnoreCase(other.title);
	    if (titleCompare != 0) return titleCompare;

	    return Float.compare(this.cost, other.cost);
	}

}
