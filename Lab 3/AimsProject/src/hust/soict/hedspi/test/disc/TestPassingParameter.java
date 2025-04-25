package hust.soict.hedspi.test.disc;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc actionDVD = new DigitalVideoDisc("The Matrix");
        DigitalVideoDisc fantasyDVD = new DigitalVideoDisc("Harry Potter");
        
        swap(actionDVD, fantasyDVD);
        System.out.println("Action DVD title after swap: " + actionDVD.getTitle());
        System.out.println("Fantasy DVD title after swap: " + fantasyDVD.getTitle());
        
        changeTitle(actionDVD, fantasyDVD.getTitle());
        System.out.println("Action DVD title after change: " + actionDVD.getTitle());
    }
    
    public static void swap(Object o1, Object o2) {
        Object temp = o1;
        o1 = o2;
        o2 = temp;
    }
    
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String originalTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(originalTitle);
    }
}