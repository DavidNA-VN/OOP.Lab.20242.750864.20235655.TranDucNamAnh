package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public class MediaComparatorByTitleCost implements Comparator<Media> {
	@Override
	public int compare(Media m1, Media m2) {
		// Kiểm tra tránh lỗi nếu tiêu đề bị null
		if (m1.getTitle() == null || m2.getTitle() == null) {
			return (m1.getTitle() == null) ? -1 : 1;
		}

		// So sánh theo tiêu đề (tăng dần, không phân biệt chữ hoa/thường)
		int titleCompare = m1.getTitle().compareToIgnoreCase(m2.getTitle());
		if (titleCompare != 0) {
			return titleCompare;
		}

		// Nếu tiêu đề giống nhau, so sánh theo giá (giá cao xếp trước)
		return Float.compare(m2.getCost(), m1.getCost());
	}
}