import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class AmirulTheatre extends JFrame{

	private static final long serialVersionUID = 1L;

	DecimalFormat priceformat = new DecimalFormat("0.00");
	
	private JPanel contentPane;
	private JTextField veteranField;
	private JTextField adultField;
	private JTextField childField;
	private JTextField priceField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AmirulTheatre frame = new AmirulTheatre();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public AmirulTheatre() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		//Panel Setup
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JPanel category = new JPanel();
		category.setBorder(new TitledBorder(null, "Category Seat In Theatre", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		category.setPreferredSize(new Dimension(630, 50));
		panel.add(category);
		//Radio button setup
		JRadioButton vviprbtn = new JRadioButton("VVIP");
		category.add(vviprbtn);
		
		JRadioButton viprbtn = new JRadioButton("VIP");
		category.add(viprbtn);
		
		JRadioButton normalrbtn = new JRadioButton("Normal");
		category.add(normalrbtn);
		//Button setup
		ButtonGroup categoryseat = new ButtonGroup();
		categoryseat.add(vviprbtn);
		categoryseat.add(viprbtn);
		categoryseat.add(normalrbtn);
		//Panel1 Setup
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		contentPane.add(panel_1, BorderLayout.WEST);
		//Panel2 Setup
		JPanel panel_2 = new JPanel();
		panel_2.setPreferredSize(new Dimension(280, 250));
		panel_2.setBorder(new TitledBorder(null, "Customer Type", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		//Check box setup
		JCheckBox veteran = new JCheckBox("Veteran x Qty");
		panel_2.add(veteran);
		veteranField = new JTextField();
		panel_2.add(veteranField);
		veteranField.setColumns(10);
		
		JCheckBox adult = new JCheckBox("Adult x Qty");
		panel_2.add(adult);
		adultField = new JTextField();
		panel_2.add(adultField);
		adultField.setColumns(10);
		
		JCheckBox child = new JCheckBox("Children x Qty");
		panel_2.add(child);
		childField = new JTextField();
		panel_2.add(childField);
		childField.setColumns(10);
		//Panel3 Setup
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		//Panel4 Setup
		JPanel panel_4 = new JPanel();
		panel_4.setPreferredSize(new Dimension(270, 250));
		panel_4.setBorder(new TitledBorder(null, "Total to be Paid", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Amount to be paid:");
		panel_4.add(lblNewLabel);
		
		priceField = new JTextField();
		panel_4.add(priceField);
		priceField.setColumns(10);
		//Panel5 Setup
		JPanel panel_5 = new JPanel();
		panel_5.setPreferredSize(new Dimension(10, 40));
		contentPane.add(panel_5, BorderLayout.SOUTH);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		//Calculate button setup
		JButton btnCalc = new JButton("CALCULATE");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Price declaration
				double price = 0;
				//To check if if seat category is selected
				if(vviprbtn.isSelected() || viprbtn.isSelected() || normalrbtn.isSelected()) {
					//To check if customer type is selected
					if(veteran.isSelected() || adult.isSelected() || child.isSelected()) {
						//If customer type is veteran
						if(veteran.isSelected()) {
							if(!veteranField.getText().isEmpty()) {
								try {
									int quantity = Integer.parseInt(veteranField.getText());
									
									if(vviprbtn.isSelected()) {
										price += (17.25 * quantity);
									} 
									else if(viprbtn.isSelected()) {
										price += (16.05 * quantity);
									} 
									else if(normalrbtn.isSelected()) {
										price += (15.00 * quantity);
									}
								}catch (Exception e1){
									JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please enter quantity", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						//If customer type is adult
						if(adult.isSelected()) {
							if(!adultField.getText().isEmpty()) {
								try {
									int quantity = Integer.parseInt(adultField.getText());
									
									if(vviprbtn.isSelected()) {
										price += (28.75 * quantity);
									} 
									else if(viprbtn.isSelected()) {
										price += (26.75 * quantity);
									} 
									else if(normalrbtn.isSelected()) {
										price += (25.00 * quantity);
									}
								}catch (Exception e1){
									JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please enter quantity", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						//If customer child is adult
						if(child.isSelected()) {
							if(!adultField.getText().isEmpty()) {
								try {
									int quantity = Integer.parseInt(childField.getText());
									
									if(vviprbtn.isSelected()) {
										price += (11.50 * quantity);
									} 
									else if(viprbtn.isSelected()) {
										price += (10.70 * quantity);
									} 
									else if(normalrbtn.isSelected()) {
										price += (10.00 * quantity);
									}
								}catch (Exception e1){
									JOptionPane.showMessageDialog(null, "Invalid input", "Error", JOptionPane.ERROR_MESSAGE);
								}
							}
							else {
								JOptionPane.showMessageDialog(null, "Please enter quantity", "Error", JOptionPane.ERROR_MESSAGE);
							}
						}
						priceField.setText(String.valueOf(priceformat.format(price)));
					}
					else {
						JOptionPane.showMessageDialog(null, "Please select customer type", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Please select category seat", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCalc.setPreferredSize(new Dimension(180, 26));
		panel_5.add(btnCalc);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//RESET ALL FIELD
				categoryseat.clearSelection();
				veteran.setSelected(false);
				adult.setSelected(false);
				child.setSelected(false);
				veteranField.setText("");
				adultField.setText("");
				childField.setText("");
				priceField.setText("");
			}
		});
		btnClear.setPreferredSize(new Dimension(180, 26));
		panel_5.add(btnClear);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setPreferredSize(new Dimension(180, 26));
		panel_5.add(btnExit);
		setPreferredSize(new Dimension(650, 400));
		pack();
	}
}
