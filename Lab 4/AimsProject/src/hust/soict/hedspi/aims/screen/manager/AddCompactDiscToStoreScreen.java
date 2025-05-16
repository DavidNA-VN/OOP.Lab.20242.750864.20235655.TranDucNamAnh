package hust.soict.hedspi.aims.screen.manager;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.store.Store;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

	public AddCompactDiscToStoreScreen(Store store) {
		super(store);
	}

	@Override
	protected JPanel createCenter() {
		JPanel panel = new JPanel(new GridLayout(7, 2, 10, 10)); // 6 fields + button

		// Create labels and text fields
		JLabel titleLabel = new JLabel("Title:");
		JTextField titleField = new JTextField();
		titleField.setPreferredSize(new Dimension(200, 25));

		JLabel categoryLabel = new JLabel("Category:");
		JTextField categoryField = new JTextField();
		categoryField.setPreferredSize(new Dimension(200, 25));

		JLabel costLabel = new JLabel("Cost:");
		JTextField costField = new JTextField();
		costField.setPreferredSize(new Dimension(200, 25));

		JLabel directorLabel = new JLabel("Director:");
		JTextField directorField = new JTextField();
		directorField.setPreferredSize(new Dimension(200, 25));

		JLabel lengthLabel = new JLabel("Length:");
		JTextField lengthField = new JTextField();
		lengthField.setPreferredSize(new Dimension(200, 25));

		JLabel artistLabel = new JLabel("Artist:");
		JTextField artistField = new JTextField();
		artistField.setPreferredSize(new Dimension(200, 25));

		// Add button
		JButton addButton = new JButton("Add CD");
		addButton.addActionListener((ActionEvent e) -> addCompactDiscToStore(titleField, categoryField, costField,
				directorField, lengthField, artistField));

		panel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
		panel.add(titleLabel);
		panel.add(titleField);
		panel.add(categoryLabel);
		panel.add(categoryField);
		panel.add(costLabel);
		panel.add(costField);
		panel.add(directorLabel);
		panel.add(directorField);
		panel.add(lengthLabel);
		panel.add(lengthField);
		panel.add(artistLabel);
		panel.add(artistField);
		panel.add(new JLabel());
		panel.add(addButton);

		return panel;
	}

	private void addCompactDiscToStore(JTextField titleField, JTextField categoryField, JTextField costField,
			JTextField directorField, JTextField lengthField, JTextField artistField) {
		try {
			String title = titleField.getText().trim();
			String category = categoryField.getText().trim();
			String director = directorField.getText().trim();
			String artist = artistField.getText().trim();

			// Kiểm tra dữ liệu nhập rỗng
			if (title.isEmpty() || category.isEmpty() || artist.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Title, Category, and Artist cannot be empty.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			float cost = Float.parseFloat(costField.getText().trim());
			int length = Integer.parseInt(lengthField.getText().trim());

			if (cost < 0 || length < 0) {
				JOptionPane.showMessageDialog(null, "Cost and Length must be non-negative.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			CompactDisc cd = new CompactDisc(title, category, cost, director, length, artist);
			store.addMedia(cd);

			JOptionPane.showMessageDialog(null, "CD added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
			dispose();
			new StoreManagerScreen(store);
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Please enter valid numeric values for Cost and Length.", "Input Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}