package hust.soict.hedspi.aims.cart;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Media;

public class Cart {
	private ArrayList<Media> itemsOrdered = new ArrayList<>();

	public void addMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			JOptionPane.showMessageDialog(null, "Sản phẩm đã có trong giỏ hàng!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		} else {
			itemsOrdered.add(media);
			JOptionPane.showMessageDialog(null, "Đã thêm: " + media.getTitle(), "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
			JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm: " + media.getTitle(), "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại trong giỏ hàng!", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public float totalCost() {
		float total = 0;
		for (Media media : itemsOrdered) {
			total += media.getCost();
		}
		return total;
	}

	public void printCart() {
		StringBuilder cartDetails = new StringBuilder("********** GIỎ HÀNG **********\n");
		for (int i = 0; i < itemsOrdered.size(); i++) {
			Media media = itemsOrdered.get(i);
			cartDetails.append((i + 1)).append(". ").append(media.toString()).append("\n");
		}
		cartDetails.append(String.format("Tổng chi phí: %.2f\n", totalCost()));
		cartDetails.append("***************************");

		JOptionPane.showMessageDialog(null, cartDetails.toString(), "Giỏ hàng", JOptionPane.INFORMATION_MESSAGE);
	}

	public ArrayList<Media> getItemsOrdered() {
		return itemsOrdered;
	}

	public void sortByTitleCost() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_TITLE_COST);
	}

	public void sortByCostTitle() {
		Collections.sort(itemsOrdered, Media.COMPARE_BY_COST_TITLE);
	}

	public Media searchByTitle(String title) {
		for (Media media : itemsOrdered) {
			if (media.getTitle().equalsIgnoreCase(title)) {
				return media;
			}
		}
		return null;
	}

	public Media searchById(int id) {
		for (Media media : itemsOrdered) {
			if (media.getId() == id) {
				return media;
			}
		}
		return null;
	}

	public void clear() {
		itemsOrdered.clear();
	}
}