import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class VintageTablewareShop extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField custid;
	private JPanel customerpanel;
	private JLabel lblNewLabel;
	private JPanel productpanel;
	private JCheckBox classicalset;
	private JCheckBox victoriaset;
	private JCheckBox charlottetray;
	private JCheckBox ashleytray;
	private JPanel paymentpanel;
	private JRadioButton masterrbtn;
	private JRadioButton visarbtn;
	private JRadioButton americanrbtn;
	private JPanel actionpanel;
	private JButton btnCalc;
	private JPanel panel_1;
	private JButton btnReset;
	private JLabel lblNewLabel_2;
	private JTextField txtField;
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				try {
					VintageTablewareShop frame = new VintageTablewareShop();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public VintageTablewareShop(){
		
		setResizable(false);
		setTitle("The Vintage Enterprise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 392);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		setPreferredSize(new Dimension(610, 350));
		pack();
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel = new JLabel("Order Form");
		panel.add(lblNewLabel);
		
		customerpanel = new JPanel();
		customerpanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		customerpanel.setPreferredSize(new Dimension(595, 50));
		panel.add(customerpanel);
		customerpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblNewLabel_1 = new JLabel("Customer ID:");
		customerpanel.add(lblNewLabel_1);
		
		custid = new JTextField();
		custid.setMinimumSize(new Dimension(7, 30));
		customerpanel.add(custid);
		custid.setColumns(10);
		
		productpanel = new JPanel();
		productpanel.setBorder(new TitledBorder(null, "Tableware Products", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		productpanel.setPreferredSize(new Dimension(590, 70));
		panel.add(productpanel);
		
		classicalset = new JCheckBox("Classical Dinner Set");
		productpanel.add(classicalset);
		
		victoriaset = new JCheckBox("Victoria Dinner Set");
		productpanel.add(victoriaset);
		
		charlottetray = new JCheckBox("Charlotte Food Tray");
		productpanel.add(charlottetray);
		
		ashleytray = new JCheckBox("Ashley Food Tray");
		productpanel.add(ashleytray);
		
		paymentpanel = new JPanel();
		paymentpanel.setBorder(new TitledBorder(null, "Payment Method", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paymentpanel.setPreferredSize(new Dimension(590, 50));
		panel.add(paymentpanel);
		paymentpanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		masterrbtn = new JRadioButton("Master Card");
		paymentpanel.add(masterrbtn);
		
		visarbtn = new JRadioButton("VISA");
		paymentpanel.add(visarbtn);
		
		americanrbtn = new JRadioButton("American Express");
		paymentpanel.add(americanrbtn);
		
		ButtonGroup paymentgroup = new ButtonGroup();
		paymentgroup.add(masterrbtn);
		paymentgroup.add(visarbtn);
		paymentgroup.add(americanrbtn);
		
		panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(10, 58));
		panel.add(panel_1);
		
		actionpanel = new JPanel();
		actionpanel.setPreferredSize(new Dimension(580, 35));
		panel.add(actionpanel);
		actionpanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblNewLabel_2 = new JLabel("Total Payment:");
		actionpanel.add(lblNewLabel_2);
		
		txtField = new JTextField();
		actionpanel.add(txtField);
		txtField.setColumns(10);
		
		btnCalc = new JButton("CALCULATE");
		btnCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double totalprice = 0;
				if (!custid.getText().isEmpty()){
					if (classicalset.isSelected() || victoriaset.isSelected() || charlottetray.isSelected() || ashleytray.isSelected()){
						if (masterrbtn.isSelected() || visarbtn.isSelected() || americanrbtn.isSelected()){
							if(classicalset.isSelected()){
								totalprice += 175;
							}
							if(victoriaset.isSelected()){
								totalprice += 200;
							}
							if(charlottetray.isSelected()){
								totalprice += 77;
							}
							if(ashleytray.isSelected()){
								totalprice += 65;
							}
							txtField.setText(String.valueOf(format.format(totalprice)));
						}
						else{
							JOptionPane.showMessageDialog(null, "Please select payment method", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else{
						JOptionPane.showMessageDialog(null, "Please select order", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please enter customer id", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		actionpanel.add(btnCalc);
		
		btnReset = new JButton("RESET");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				custid.setText("");
				classicalset.setSelected(false);
				victoriaset.setSelected(false);
				charlottetray.setSelected(false);
				ashleytray.setSelected(false);
				paymentgroup.clearSelection();
				txtField.setText("");
			}
		});
		actionpanel.add(btnReset);
	}
}
