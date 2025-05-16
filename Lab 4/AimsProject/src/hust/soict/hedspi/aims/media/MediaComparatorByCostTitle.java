package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByCostTitle implements Comparator<Media> {
	@Override
	public int compare(Media m1, Media m2) {
		// So sánh theo giá (giá cao xếp trước)
		int costCompare = Float.compare(m2.getCost(), m1.getCost());
		if (costCompare != 0) {
			return costCompare;
		}

		// Nếu giá bằng nhau, so sánh theo tiêu đề (tăng dần, không phân biệt chữ
		// hoa/thường)
		if (m1.getTitle() != null && m2.getTitle() != null) {
			return m1.getTitle().compareToIgnoreCase(m2.getTitle());
		}

		// Tránh lỗi nếu một trong hai tiêu đề bị null
		return (m1.getTitle() == null) ? -1 : 1;
	}
}