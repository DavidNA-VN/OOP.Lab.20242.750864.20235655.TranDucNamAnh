package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import hust.soict.hedspi.aims.media.Media;

public class Cart {

    public static final int MAX_NUMBERS_ORDERED = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<>();

    public Cart() {
    }

    public void addMedia(Media media) {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            System.out.println("The cart is full. Cannot add more items.");
        } else if (itemsOrdered.contains(media)) {
            System.out.println("The item \"" + media.getTitle() + "\" already exists.");
        } else {
            itemsOrdered.add(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been added to the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println("The item \"" + media.getTitle() + "\" has been removed from the cart.");
        } else {
            System.out.println("The item \"" + media.getTitle() + "\" doesn't exist.");
        }
    }

    public float totalCost() {
        float sum = 0;
        for (Media media : itemsOrdered) {
            sum += media.getCost();
        }
        return sum;
    }

    public void displayCart() {
        System.out.println("*********************** CART CONTENT ***********************");
        for (Media media : itemsOrdered) {
            System.out.printf("%s : %.2f\n", media.getTitle(), media.getCost());
        }
        System.out.printf("Total Cost: %.2f\n", totalCost());
        System.out.println("************************************************************");
    }

    public void print() {
        System.out.println("*********************** CART ***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media);
        }
        System.out.printf("Total Cost: %.2f\n", totalCost());
        System.out.println("****************************************************");
    }

    public void search(int mediaId) {
        for (Media media : itemsOrdered) {
            if (media.getId() == mediaId) {
                System.out.printf("Item with ID %d found:\n", mediaId);
                System.out.println(media);
                return;
            }
        }
        System.out.printf("Item with ID %d doesn't exist.\n", mediaId);
    }

    public void search(String mediaTitle) {
        boolean found = false;
        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
                System.out.printf("Item with title \"%s\" found:\n", mediaTitle);
                System.out.println(media);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("Item with title \"%s\" doesn't exist.\n", mediaTitle);
        }
    }

    public Media searchAndReturn(String mediaTitle) {
        for (int i = itemsOrdered.size() - 1; i >= 0; i--) {
            Media media = itemsOrdered.get(i);
            if (media.getTitle().equalsIgnoreCase(mediaTitle)) {
                return media;
            }
        }
        return null;
    }

    public void sortByTitle() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
        System.out.println("Cart sorted by title then cost.");
    }

    public void sortByCost() {
        Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
        System.out.println("Cart sorted by cost then title.");
    }

    public void clearCart() {
        itemsOrdered.clear();
        System.out.println("Cart has been cleared.");
    }

    public int size() {
        return itemsOrdered.size();
    }

    public ArrayList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
}
