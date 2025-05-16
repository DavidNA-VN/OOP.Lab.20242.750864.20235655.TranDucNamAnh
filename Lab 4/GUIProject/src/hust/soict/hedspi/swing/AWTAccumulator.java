package hust.soict.hedspi.swing;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWTAccumulator extends Frame {
	private static final long serialVersionUID = 1L;
	private TextField tfInput;
	private TextField tfOutput;
	private int sum = 0; // Accumulated sum, init to 0

	// Constructor to setup the GUI components and event handlers
	public AWTAccumulator() {
		setLayout(new GridLayout(2, 2)); // 2 rows, 2 columns

		add(new Label("Enter an Integer: "));

		tfInput = new TextField(10);
		add(tfInput);
		tfInput.addActionListener(new TFInputListener()); // Anonymous inner class listener

		add(new Label("The Accumulated Sum is: "));

		tfOutput = new TextField(10);
		tfOutput.setEditable(false); // read-only
		add(tfOutput);

		setTitle("AWT Accumulator");
		setSize(350, 120);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AWTAccumulator();
	}

	/**
	 * An inner class to handle the action event triggered by the input text field.
	 */
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInput.getText());
			sum += numberIn;
			tfInput.setText(""); // Clear input TextField
			tfOutput.setText(sum + ""); // Display the accumulated sum
		}
	}
}