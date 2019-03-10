import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Scrollbar;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import java.awt.Checkbox;

public class deneme {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deneme window = new deneme();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deneme() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		Checkbox checkbox = new Checkbox("New check box");
		panel.add(checkbox);
		
		Checkbox checkbox_3 = new Checkbox("New check box");
		panel.add(checkbox_3);
		
		Checkbox checkbox_2 = new Checkbox("New check box");
		panel.add(checkbox_2);
		
		Checkbox checkbox_1 = new Checkbox("New check box");
		panel.add(checkbox_1);
		
		textField_1 = new JTextField();
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		Scrollbar scrollbar = new Scrollbar();
		panel.add(scrollbar);
		
		JScrollBar scrollBar = new JScrollBar();
		panel.add(scrollBar);
		
		table = new JTable();
		panel.add(table);
		
		textField = new JTextField();
		textField.setText("");
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnButton = new JButton("login");
		panel.add(btnButton);
	}

}
