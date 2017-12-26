package GUI;

import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import de.micromata.opengis.kml.v_2_2_0.Folder;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import mainPackage.*;
import algorithms.*;
import filters.*;
import linkedListFilters.IDfilter;
import linkedListFilters.timeFilter;
import myObjects.*;
import java.awt.TextField;
import java.awt.event.TextListener;
import java.awt.event.TextEvent;
import java.awt.Color;
import javax.swing.JTextArea;
import com.sun.xml.bind.v2.model.core.WildcardTypeInfo;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.TextArea;
import java.awt.Canvas;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.graphics.JNextIcon;
import org.jdatepicker.util.JDatePickerUtil;

public class gui {

	private JFrame frame;

	LinkedList<Checks> lc = new LinkedList<>();
	LinkedList<Wifi> wifi = new LinkedList<>();

	int lines = lc.size();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
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
	public gui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Button button = new Button("Choose folder");
		button.setBounds(0, 0, 125, 52);
		button.setBackground(Color.LIGHT_GRAY);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * take from:
				 * https://stackoverflow.com/questions/10621687/how-to-get-full-path-directory-from-file-chooser
				 */
				String folder = "";
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				  folder = chooser.getSelectedFile().getAbsolutePath();
				} 
				else {
				  System.out.println("No Selection ");
				}
				System.out.println(folder);
				WifiScanner ws = new WifiScanner();
				readCsvMatalaFormat rc = new readCsvMatalaFormat();
				try {
					
					if(folder!=""){
					
					LinkedList<Checks> fromFolder = new LinkedList<>();
					System.out.println("folder: " + folder);
					fromFolder = ws.filesReader(folder);
					
					lc.addAll(fromFolder);
					
					LinkedList<Wifi> wifiFromFolder = rc.checksToWifi(fromFolder);
					wifi.addAll(wifiFromFolder);
					
					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Clean data");
		button_1.setBounds(0, 118, 125, 52);
		button_1.setBackground(Color.LIGHT_GRAY);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lc.clear();
				
			}
		});
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("Save to CSV file");
		button_2.setBounds(0, 176, 125, 52);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				toCSV tc = new toCSV();
				String dir = null; 

				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				  dir = chooser.getSelectedFile().getAbsolutePath() + "/";
				} 
				else {
				  System.out.println("No Selection ");
				}
				
				try {
					tc.toCsvFromList(lc, dir);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("Save to KML file");
		button_3.setBounds(0, 234, 125, 52);
		button_3.setBackground(Color.LIGHT_GRAY);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				readCsvMatalaFormat rcmf = new readCsvMatalaFormat();
				LinkedList<Wifi> wifiList = rcmf.checksToWifi(lc);
				
				for(int i=0; i<wifiList.size();i++){
					
					wifiList.get(i).setBool(true);
					//System.out.println(wifiList.get(i));

				}
				
				toKML tk = new toKML();
				try {
					tk.toKml(wifiList,"toKmlGUI");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(button_3);
		
		Button button_4 = new Button("Add csv file");
		button_4.setBounds(-5, 58, 130, 52);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String file = "";
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("choosertitle");
				chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				  System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
				  System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
				  file = chooser.getSelectedFile().getAbsolutePath();
				} 
				else {
				  System.out.println("No Selection ");
				}
				
				readCsvMatalaFormat rc = new readCsvMatalaFormat();
				
				try {
					LinkedList<Checks> temp = rc.CsvToList(file);
					System.out.println("lc before: "+ lc.size());
					lc.addAll(temp);
					
					System.out.println("temp size: " + temp.size());
					System.out.println("lc after: " + lc.size());
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		frame.getContentPane().add(button_4);
		
		TextField textField = new TextField();
		textField.setBounds(0, 305, 125, 21);
		TextField textField2 = new TextField();
		textField2.setBounds(0, 334, 125, 21);

		
		button.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            textField.setText("lines: "+ lc.size());
	            
	            MatrixSortByMAC macS = new MatrixSortByMAC();
	    		macS.sortByMac(wifi);
	    		
	    		algo1 al = new algo1();
	    		LinkedList<Wifi> wi = al.bestSignal(wifi);
	    		
	            textField2.setText("wifi: "+ wi.size());

	    		
	        }
	    });
		button_4.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            textField.setText("lines: "+ lc.size());
	        }
	    });
		button_1.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent arg0) {
	            textField.setText("lines: "+ lc.size());
	        }
	    });

		frame.getContentPane().add(textField);
		frame.getContentPane().add(textField2);
		
		JRadioButton rdbtnTimeFilter = new JRadioButton("time filter");
		JRadioButton rdbtnIDfilter = new JRadioButton("ID filter");
		JRadioButton rdbtLOCfilter = new JRadioButton("Loction filter by:");
		rdbtLOCfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtnIDfilter.setSelected(false);
				rdbtnTimeFilter.setSelected(false);
				
				
				
			}
		});

		
		JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		comboBox.setToolTipText("Hour");
		
		comboBox.addItem("Hour");

		for(int i=0; i<24; i++){
			comboBox.addItem(i);

		}
			
		comboBox.setBounds(262, 39, 57, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setToolTipText("Min");
		
		comboBox_1.addItem("Min");

		for(int i=0; i<60; i++){
			comboBox_1.addItem(i);

		}
		
		comboBox_1.setBounds(328, 39, 57, 22);
		frame.getContentPane().add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setEnabled(false);
		comboBox_2.setToolTipText("Sec");
		
		comboBox_2.addItem("Sec");

		
		for(int i=0; i<60; i++){
			comboBox_2.addItem(i);

		}
		
		comboBox_2.setBounds(391, 39, 57, 22);
		frame.getContentPane().add(comboBox_2);
		
		JTextPane txtpnMaxTime = new JTextPane();
		txtpnMaxTime.setText("Max Time: ");
		txtpnMaxTime.setBackground(SystemColor.menu);
		txtpnMaxTime.setBounds(182, 69, 77, 22);
		frame.getContentPane().add(txtpnMaxTime);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setEnabled(false);
		comboBox_3.setToolTipText("Hour");
		
		comboBox_3.addItem("Hour");

		
		for(int i=0; i<24; i++){
			comboBox_3.addItem(i);

		}
		
		comboBox_3.setBounds(262, 69, 57, 22);
		frame.getContentPane().add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setEnabled(false);
		comboBox_4.setToolTipText("Min");
		
		comboBox_4.addItem("Min");

		
		for(int i=0; i<60; i++){
			comboBox_4.addItem(i);

		}
		
		comboBox_4.setBounds(328, 69, 57, 22);
		frame.getContentPane().add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setEnabled(false);
		comboBox_5.setToolTipText("Sec");
		
		comboBox_5.addItem("Sec");

		
		for(int i=0; i<60; i++){
			comboBox_5.addItem(i);

		}
		
		comboBox_5.setBounds(391, 69, 57, 22);
		frame.getContentPane().add(comboBox_5);
		
		TextField textField_3 = new TextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(242, 128, 77, 21);
		frame.getContentPane().add(textField_3);


		
		rdbtnTimeFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				rdbtnIDfilter.setSelected(false);
				rdbtLOCfilter.setSelected(false);
				textField_3.setEnabled(false);

				
				comboBox.setEnabled(true);
				comboBox_1.setEnabled(true);
				comboBox_2.setEnabled(true);
				comboBox_3.setEnabled(true);
				comboBox_4.setEnabled(true);
				comboBox_5.setEnabled(true);


				
			}
		});
		rdbtnTimeFilter.setBounds(160, 9, 127, 25);
		frame.getContentPane().add(rdbtnTimeFilter);
		
		JTextPane txtpnMinTime = new JTextPane();
		txtpnMinTime.setBackground(UIManager.getColor("Button.background"));
		txtpnMinTime.setText("Min Time: ");
		txtpnMinTime.setBounds(182, 39, 68, 22);
		frame.getContentPane().add(txtpnMinTime);
		
		rdbtnIDfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				rdbtLOCfilter.setSelected(false);
				rdbtnTimeFilter.setSelected(false);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				comboBox_2.setEnabled(false);
				comboBox_3.setEnabled(false);
				comboBox_4.setEnabled(false);
				comboBox_5.setEnabled(false);
				
				textField_3.setEnabled(true);
				
			}
		});
		
		rdbtnIDfilter.setBounds(160, 95, 127, 25);
		frame.getContentPane().add(rdbtnIDfilter);
		
		JTextPane txtpnUserName = new JTextPane();
		txtpnUserName.setText("User name:");
		txtpnUserName.setBackground(SystemColor.menu);
		txtpnUserName.setBounds(160, 127, 77, 22);
		frame.getContentPane().add(txtpnUserName);
		
		
		
		rdbtLOCfilter.setBounds(160, 164, 125, 25);
		frame.getContentPane().add(rdbtLOCfilter);
		
		JTextPane txtpnMinLat = new JTextPane();
		txtpnMinLat.setText("Min Lat: ");
		txtpnMinLat.setBackground(SystemColor.menu);
		txtpnMinLat.setBounds(160, 198, 57, 22);
		frame.getContentPane().add(txtpnMinLat);
		
		TextField textField_4 = new TextField();
		textField_4.setBounds(230, 196, 77, 21);
		frame.getContentPane().add(textField_4);
		
		JTextPane txtpnMinLon = new JTextPane();
		txtpnMinLon.setText("Min Lon:");
		txtpnMinLon.setBackground(SystemColor.menu);
		txtpnMinLon.setBounds(160, 226, 57, 22);
		frame.getContentPane().add(txtpnMinLon);
		
		JTextPane txtpnMinAlt = new JTextPane();
		txtpnMinAlt.setText("Min Alt:");
		txtpnMinAlt.setBackground(SystemColor.menu);
		txtpnMinAlt.setBounds(160, 255, 57, 22);
		frame.getContentPane().add(txtpnMinAlt);
		
		TextField textField_5 = new TextField();
		textField_5.setBounds(230, 223, 77, 21);
		frame.getContentPane().add(textField_5);
		
		TextField textField_6 = new TextField();
		textField_6.setBounds(230, 253, 77, 21);
		frame.getContentPane().add(textField_6);
		
		
		
		JTextPane txtpnMaxLat = new JTextPane();
		txtpnMaxLat.setText("Max Lat:");
		txtpnMaxLat.setBackground(SystemColor.menu);
		txtpnMaxLat.setBounds(319, 195, 62, 22);
		frame.getContentPane().add(txtpnMaxLat);
		
		TextField textField_2 = new TextField();
		textField_2.setBounds(389, 196, 77, 21);
		frame.getContentPane().add(textField_2);
		
		JTextPane txtpnMaxLon = new JTextPane();
		txtpnMaxLon.setText("Max Lon:");
		txtpnMaxLon.setBackground(SystemColor.menu);
		txtpnMaxLon.setBounds(319, 223, 62, 22);
		frame.getContentPane().add(txtpnMaxLon);
		
		JTextPane txtpnMaxAlt = new JTextPane();
		txtpnMaxAlt.setText("Max Alt:");
		txtpnMaxAlt.setBackground(SystemColor.menu);
		txtpnMaxAlt.setBounds(319, 252, 68, 22);
		frame.getContentPane().add(txtpnMaxAlt);
		
		TextField textField_12 = new TextField();
		textField_12.setBounds(389, 223, 77, 21);
		frame.getContentPane().add(textField_12);
		
		TextField textField_13 = new TextField();
		textField_13.setBounds(389, 253, 77, 21);
		frame.getContentPane().add(textField_13);
		
		
		
		
		
		
		/////////////////////////sumbit filters////////////////////
		
		
		JButton btnSumbitFilter = new JButton("Sumbit filter");
		btnSumbitFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(rdbtnTimeFilter.isSelected()){
					int minHour = comboBox.getSelectedIndex();
					int minMint = comboBox_1.getSelectedIndex();
					int minSec = comboBox_2.getSelectedIndex();
					
					String SminH = Integer.toString(minHour);
					String SminM = Integer.toString(minMint);
					String SminS = Integer.toString(minSec);

					
					if(minHour<10){
						SminH = "0" + SminH;
					}
					if(minMint<10){
						SminM = "0" + SminM;
					}
					if(minSec<10){
						SminS = "0" + SminS;
					}
					
					String Smin = SminH + ":" + SminM + ":" + SminS;
					
					int maxHour = comboBox_3.getSelectedIndex();
					int maxMint = comboBox_4.getSelectedIndex();
					int maxSec = comboBox_5.getSelectedIndex();
					
					String SmaxH = Integer.toString(maxHour);
					String SmaxM = Integer.toString(maxMint);
					String SmaxS = Integer.toString(maxSec);

					
					if(maxHour<10){
						SmaxH = "0" + SmaxH;
					}
					if(maxMint<10){
						SmaxM = "0" + SmaxM;
					}
					if(maxSec<10){
						SmaxS = "0" + SmaxS;
					}
					
					String Smax = SmaxH + ":" + SmaxM + ":" + SmaxS;
					
					System.out.println(Smin);
					System.out.println(Smax);
					
					if(Smax.compareTo(Smin)<0){
						System.out.println("error");
					}
					else{
						
						timeFilter tf = new timeFilter(Smin, Smax);
						
						for(int i=0; i<lc.size(); i++){
							
							boolean ce = tf.test(lc.get(i));
							
							lc.get(i).setBool(ce);
							
							System.out.println(ce);	
						}	
					}	
				}
				
				else if(rdbtnIDfilter.isSelected()){
					
					String id = textField_3.getText();
					
					if(id!=""){
					
					IDfilter ifd = new IDfilter(id);
					
					for(int i=0; i<lc.size(); i++){
						
						boolean ce = ifd.test(lc.get(i));
						
						lc.get(i).setBool(ce);
						
						
						System.out.println(lc.get(i));	
					}
					}
					
					
				}
				
				counters cu = new counters();
				
				int c = cu.boolCount(lc);
				
				textField.setText("lines: " + c);
				
				
				
			}
		});
		btnSumbitFilter.setBounds(160, 290, 143, 41);
		frame.getContentPane().add(btnSumbitFilter);
		
		JButton btnUnfilter = new JButton("Unfilter");
		btnUnfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				for(int i=0; i<lc.size(); i++){
					lc.get(i).setBool(false);
				}
				
			}
		});
		btnUnfilter.setBounds(323, 290, 143, 41);
		frame.getContentPane().add(btnUnfilter);
		
		JCheckBox chckbxAlt = new JCheckBox("Lat");
		chckbxAlt.setBounds(289, 164, 49, 25);
		frame.getContentPane().add(chckbxAlt);
		
		JCheckBox chckbxLon = new JCheckBox("Lon");
		chckbxLon.setBounds(336, 164, 49, 25);
		frame.getContentPane().add(chckbxLon);
		
		JCheckBox checkBox_1 = new JCheckBox("Alt");
		checkBox_1.setBounds(382, 164, 49, 25);
		frame.getContentPane().add(checkBox_1);
		

	}
}
