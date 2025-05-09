package AimsProject;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	public String getTitle() {
		return title;
	}

	public DigitalVideoDisc(float cost) {
		super();
		this.cost = cost;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public DigitalVideoDisc(String title) {
        this.title = title;
        GanID(); 
    }
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	  private void GanID() {
	        nbDigitalVideoDiscs++; // Tăng số lượng DVD đã tạo
	        this.id = nbDigitalVideoDiscs; // Gán ID duy nhất cho DVD này
	    }
	  public int getID() {
	        return id;
	    }
	  public static int nbDigitalVideoDiscs1() {
	        return nbDigitalVideoDiscs;
	    }
}