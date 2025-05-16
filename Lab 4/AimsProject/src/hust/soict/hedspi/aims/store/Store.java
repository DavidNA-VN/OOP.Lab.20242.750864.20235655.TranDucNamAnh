package hust.soict.hedspi.aims.store;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import hust.soict.hedspi.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<>();

	public void addMedia(Media media) {
		if (media == null) {
			JOptionPane.showMessageDialog(null, "Media cannot be null!", "Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		if (itemsInStore.contains(media)) {
			JOptionPane.showMessageDialog(null, "Sản phẩm đã tồn tại trong cửa hàng!", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
		} else {
			itemsInStore.add(media);
			JOptionPane.showMessageDialog(null, "Thêm thành công sản phẩm có tên: " + media.getTitle(), "Success",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
			JOptionPane.showMessageDialog(null, "Đã xóa sản phẩm: " + media.getTitle(), "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, "Sản phẩm không tồn tại!", "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
	}

	public void printStore() {
		StringBuilder storeDetails = new StringBuilder("********** STORE **********\n");
		for (int i = 0; i < itemsInStore.size(); i++) {
			Media media = itemsInStore.get(i);
			storeDetails.append((i + 1)).append(". ").append(media.toString()).append("\n");
		}
		storeDetails.append("***************************");

		JOptionPane.showMessageDialog(null, storeDetails.toString(), "Store Inventory",
				JOptionPane.INFORMATION_MESSAGE);
	}

	public ArrayList<Media> getItemsInStore() {
		return itemsInStore;
	}

	public Media searchByTitle(String title) {
		if (title == null || title.trim().isEmpty()) {
			return null;
		}

		return itemsInStore.stream().filter(media -> media.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
	}

	public Media searchById(int id) {
		return itemsInStore.stream().filter(media -> media.getId() == id).findFirst().orElse(null);
	}
}