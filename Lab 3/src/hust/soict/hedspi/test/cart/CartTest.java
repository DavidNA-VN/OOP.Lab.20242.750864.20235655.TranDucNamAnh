package hust.soict.hedspi.test.cart;

import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart myCart = new Cart();
        
        DigitalVideoDisc movie1 = new DigitalVideoDisc("The Avengers", "Action", "Joss Whedon", 143, 22.5f);
        myCart.addMedia(movie1);
        
        DigitalVideoDisc movie2 = new DigitalVideoDisc("Inception", "Sci-Fi", "Christopher Nolan", 148, 25.0f);
        myCart.addMedia(movie2);
        
        DigitalVideoDisc movie3 = new DigitalVideoDisc("Frozen", "Animation", 21.99f);
        myCart.addMedia(movie3);
        
        DigitalVideoDisc movie4 = new DigitalVideoDisc("Interstellar", "Sci-Fi", "Christopher Nolan", 169, 28.5f);
        myCart.addMedia(movie4);

        System.out.println("=== Danh sách DVD trong giỏ hàng ===");
        myCart.print();
        

        System.out.println("\n=== Tìm kiếm theo ID ===");
        myCart.search(1);  
        myCart.search(2);  
        myCart.search(5);  
        
        System.out.println("\n=== Tìm kiếm theo tiêu đề ===");
        myCart.search("Inception");   
        myCart.search("The Dark Knight"); 
    }
}