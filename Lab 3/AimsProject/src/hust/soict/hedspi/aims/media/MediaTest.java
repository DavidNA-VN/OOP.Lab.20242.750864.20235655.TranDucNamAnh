package hust.soict.hedspi.aims.media;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<>();

        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);

        CompactDisc cd = new CompactDisc("Mystic Vibes", "Chill", "Luna Sky", 14.99f, "Nova Aura");
        cd.addTrack(new Track("Echoes of Eternity", 320));
        cd.addTrack(new Track("Midnight Mirage", 295));
        cd.addTrack(new Track("Waves of Time", 310));

        ArrayList<String> bookAuthors = new ArrayList<>();
        bookAuthors.add("Robert C. Martin");
        Book book = new Book("Clean Code", "Programming", 29.99f, bookAuthors);

        mediae.add(dvd);
        mediae.add(cd);
        mediae.add(book);

        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
