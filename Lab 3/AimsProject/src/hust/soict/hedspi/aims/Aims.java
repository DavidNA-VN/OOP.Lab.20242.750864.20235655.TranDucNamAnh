package hust.soict.hedspi.aims;

import java.util.Collections;
import java.util.Scanner;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.Store;

public class Aims {
    private static final Store store = new Store();
    private static final Cart cart = new Cart();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Aims().originalMenuLoop();
    }

    public void originalMenuLoop() {
        while (true) {
            showMenu();
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> viewStore();
                case 2 -> updateStore();
                case 3 -> viewCart();
                case 0 -> exitProgram();
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void showMenu() {
        System.out.println("\nAIMS - QUẢN LÝ CỬA HÀNG MEDIA");
        System.out.println("----------------------------");
        System.out.println("1. Xem cửa hàng");
        System.out.println("2. Cập nhật cửa hàng");
        System.out.println("3. Xem giỏ hàng");
        System.out.println("0. Thoát");
        System.out.println("----------------------------");
    }

    public void viewStore() {
        while (true) {
            store.print();
            storeMenu();
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> seeMediaDetails();
                case 2 -> addMediaToCart();
                case 3 -> playMedia();
                case 4 -> viewCart();
                case 0 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void storeMenu() {
        System.out.println("\nTÙY CHỌN CỬA HÀNG");
        System.out.println("----------------------------");
        System.out.println("1. Xem chi tiết media");
        System.out.println("2. Thêm media vào giỏ");
        System.out.println("3. Phát media");
        System.out.println("4. Xem giỏ hàng");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }


    public void seeMediaDetails() {
        Media media = searchMediaInStore();
        if (media == null) return;

        while (true) {
            System.out.println(media.toString());
            mediaDetailsMenu();
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> cart.addMedia(media);
                case 2 -> playMedia(media);
                case 0 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void mediaDetailsMenu() {
        System.out.println("\nTÙY CHỌN MEDIA");
        System.out.println("----------------------------");
        System.out.println("1. Thêm vào giỏ hàng");
        System.out.println("2. Phát media");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }


    public void viewCart() {
        while (true) {
            cart.print();
            cartMenu();
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> filterCart();
                case 2 -> sortCart();
                case 3 -> removeMediaFromCart();
                case 4 -> playMediaInCart();
                case 5 -> placeOrder();
                case 0 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void cartMenu() {
        System.out.println("\nTÙY CHỌN GIỎ HÀNG");
        System.out.println("----------------------------");
        System.out.println("1. Lọc media");
        System.out.println("2. Sắp xếp media");
        System.out.println("3. Xóa media");
        System.out.println("4. Phát media");
        System.out.println("5. Đặt hàng");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }


    public int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số!");
            }
        }
    }

    public Media searchMediaInStore() {
        System.out.print("Nhập tiêu đề media: ");
        String title = scanner.nextLine();
        Media media = store.search(title);
        
        if (media == null) {
            System.out.println("Không tìm thấy media!");
        }
        return media;
    }

    public void playMedia(Media media) {
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media này không thể phát!");
        }
    }

    public void exitProgram() {
        System.out.println("Đang thoát chương trình...");
        System.exit(0);
    }


    public void addMediaToCart() {
        Media media = searchMediaInStore();
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Đã thêm vào giỏ hàng. Tổng số: " + cart.size());
        }
    }

    public void playMedia() {
        Media media = searchMediaInStore();
        if (media != null) {
            playMedia(media);
        }
    }

    public void updateStore() {
        while (true) {
            updateStoreMenu();
            int choice = getIntInput("Lựa chọn của bạn: ");

            switch (choice) {
                case 1 -> addMediaToStore();
                case 2 -> removeMediaFromStore();
                case 0 -> { return; }
                default -> System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    public void updateStoreMenu() {
        System.out.println("\nCẬP NHẬT CỬA HÀNG");
        System.out.println("----------------------------");
        System.out.println("1. Thêm media");
        System.out.println("2. Xóa media");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }

    public void addMediaToStore() {
        addMediaMenu();
        int choice = getIntInput("Lựa chọn của bạn: ");

        switch (choice) {
            case 1 -> store.addMedia(createDVD());
            case 2 -> store.addMedia(createCD());
            case 3 -> store.addMedia(createBook());
            case 0 -> { return; }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void addMediaMenu() {
        System.out.println("\nTHÊM MEDIA MỚI");
        System.out.println("----------------------------");
        System.out.println("1. Thêm DVD");
        System.out.println("2. Thêm CD");
        System.out.println("3. Thêm sách");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }

    public DigitalVideoDisc createDVD() {
        System.out.println("\nTHÊM DVD MỚI");
        System.out.print("Tiêu đề: ");
        String title = scanner.nextLine();
        System.out.print("Thể loại: ");
        String category = scanner.nextLine();
        System.out.print("Đạo diễn: ");
        String director = scanner.nextLine();
        System.out.print("Độ dài (phút): ");
        int length = getIntInput("");
        System.out.print("Giá: ");
        float cost = getIntInput("");

        return new DigitalVideoDisc(title, category, director, length, cost);
    }

    public CompactDisc createCD() {
        System.out.println("\nTHÊM CD MỚI");
        System.out.print("Tiêu đề: ");
        String title = scanner.nextLine();
        System.out.print("Thể loại: ");
        String category = scanner.nextLine();
        System.out.print("Đạo diễn: ");
        String director = scanner.nextLine();
        System.out.print("Giá: ");
        float cost = getIntInput("");
        System.out.print("Nghệ sĩ: ");
        String artist = scanner.nextLine();

        return new CompactDisc(title, category, director, cost, artist);
    }

    public Book createBook() {
        System.out.println("\nTHÊM SÁCH MỚI");
        System.out.print("Tiêu đề: ");
        String title = scanner.nextLine();
        System.out.print("Thể loại: ");
        String category = scanner.nextLine();
        System.out.print("Giá: ");
        float cost = getIntInput("");

        return new Book(title, category, cost);
    }

    public void removeMediaFromStore() {
        Media media = searchMediaInStore();
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Đã xóa media khỏi cửa hàng");
        }
    }

    public void filterCart() {
        filterMenu();
        int choice = getIntInput("Lựa chọn của bạn: ");

        switch (choice) {
            case 1 -> {
                int id = getIntInput("Nhập ID: ");
                cart.search(id);
            }
            case 2 -> {
                System.out.print("Nhập tiêu đề: ");
                String title = scanner.nextLine();
                cart.search(title);
            }
            case 0 -> { return; }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void filterMenu() {
        System.out.println("\nLỌC GIỎ HÀNG");
        System.out.println("----------------------------");
        System.out.println("1. Theo ID");
        System.out.println("2. Theo tiêu đề");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }

    public void sortCart() {
        sortMenu();
        int choice = getIntInput("Lựa chọn của bạn: ");

        switch (choice) {
            case 1 -> {
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
                System.out.println("Đã sắp xếp theo tiêu đề");
            }
            case 2 -> {
                Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
                System.out.println("Đã sắp xếp theo giá");
            }
            case 0 -> { return; }
            default -> System.out.println("Lựa chọn không hợp lệ!");
        }
    }

    public void sortMenu() {
        System.out.println("\nSẮP XẾP GIỎ HÀNG");
        System.out.println("----------------------------");
        System.out.println("1. Theo tiêu đề");
        System.out.println("2. Theo giá");
        System.out.println("0. Quay lại");
        System.out.println("----------------------------");
    }

    public void removeMediaFromCart() {
        System.out.print("Nhập tiêu đề media cần xóa: ");
        String title = scanner.nextLine();
        Media media = cart.searchAndReturn(title);
        
        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Đã xóa khỏi giỏ hàng");
        } else {
            System.out.println("Không tìm thấy media!");
        }
    }

    public void playMediaInCart() {
        System.out.print("Nhập tiêu đề media cần phát: ");
        String title = scanner.nextLine();
        Media media = cart.searchAndReturn(title);
        
        if (media != null) {
            playMedia(media);
        } else {
            System.out.println("Không tìm thấy media!");
        }
    }

    public void placeOrder() {
        System.out.println("Đặt hàng thành công! Giỏ hàng sẽ được xóa.");
        cart.clearCart();
    }
}