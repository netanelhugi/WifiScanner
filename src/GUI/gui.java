package GUI;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;

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
import linkedListFilters.altFilter;
import linkedListFilters.latFilter;
import linkedListFilters.lonFilter;
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
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.TextArea;
import java.awt.Canvas;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.JDatePanelImpl;
import javax.swing.JFormattedTextField.AbstractFormatter;
import org.jdatepicker.graphics.JNextIcon;
import org.jdatepicker.util.JDatePickerUtil;
import javax.swing.JList;

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
		frame.getContentPane().setBackground(new Color(240,240,240));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(900, 650);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("wifi scanner system");
		
		
		

		Button button = new Button("Choose folder");
		button.setBounds(0, 0, 125, 52);
		button.setBackground(Color.WHITE);
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

					if (folder != "") {

						LinkedList<Checks> fromFolder = new LinkedList<>();
						System.out.println("folder: " + folder);
						fromFolder = ws.filesReader(folder);

						lc.addAll(fromFolder);
						
						for(int i=0; i<lc.size(); i++){
							
							lc.get(i).setBool(true);
							
						}

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
		button_1.setBackground(Color.WHITE);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				lc.clear();

			}
		});
		frame.getContentPane().add(button_1);

		Button button_2 = new Button("Save to CSV file");
		button_2.setBounds(0, 176, 125, 52);
		button_2.setBackground(Color.WHITE);
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
				} else {
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
		button_3.setBackground(Color.WHITE);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				readCsvMatalaFormat rcmf = new readCsvMatalaFormat();
				LinkedList<Wifi> wifiList = rcmf.checksToWifi(lc);

				for (int i = 0; i < wifiList.size(); i++) {

					wifiList.get(i).setBool(true);
					// System.out.println(wifiList.get(i));

				}

				toKML tk = new toKML();
				try {
					tk.toKml(wifiList, "toKmlGUI");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		frame.getContentPane().add(button_3);

		Button button_4 = new Button("Add csv file");
		button_4.setBounds(-5, 58, 130, 52);
		button_4.setBackground(Color.WHITE);
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
				} else {
					System.out.println("No Selection ");
				}

				readCsvMatalaFormat rc = new readCsvMatalaFormat();

				try {
					LinkedList<Checks> temp = rc.CsvToList(file);
					System.out.println("lc before: " + lc.size());
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

		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				MatrixSortByMAC macS = new MatrixSortByMAC();
				macS.sortByMac(wifi);

				algo1 al = new algo1();
				LinkedList<Wifi> wi = al.bestSignal(wifi);


			}
		});
		button_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
			}
		});

		JRadioButton rdbtnTimeFilter = new JRadioButton("time filter");
		rdbtnTimeFilter.setForeground(Color.BLUE);
		JRadioButton rdbtnIDfilter = new JRadioButton("ID filter");
		rdbtnIDfilter.setForeground(Color.BLUE);
		JRadioButton rdbtLOCfilter = new JRadioButton("Loction filter by:");
		rdbtLOCfilter.setForeground(Color.BLUE);
		

		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setEnabled(false);
		comboBox.setToolTipText("Hour");

		comboBox.addItem("Hour");

		for (int i = 0; i < 24; i++) {
			comboBox.addItem(i);

		}

		comboBox.setBounds(262, 39, 57, 22);
		frame.getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setEnabled(false);
		comboBox_1.setToolTipText("Min");

		comboBox_1.addItem("Min");

		for (int i = 0; i < 60; i++) {
			comboBox_1.addItem(i);

		}

		comboBox_1.setBounds(328, 39, 57, 22);
		frame.getContentPane().add(comboBox_1);

		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setForeground(Color.BLUE);
		comboBox_2.setEnabled(false);
		comboBox_2.setToolTipText("Sec");

		comboBox_2.addItem("Sec");

		for (int i = 0; i < 60; i++) {
			comboBox_2.addItem(i);

		}

		comboBox_2.setBounds(391, 39, 57, 22);
		frame.getContentPane().add(comboBox_2);

		JTextPane txtpnMaxTime = new JTextPane();
		txtpnMaxTime.setEditable(false);
		txtpnMaxTime.setForeground(Color.BLUE);
		txtpnMaxTime.setText("Max Time: ");
		txtpnMaxTime.setBackground(SystemColor.menu);
		txtpnMaxTime.setBounds(182, 69, 77, 22);
		frame.getContentPane().add(txtpnMaxTime);

		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.BLUE);
		comboBox_3.setEnabled(false);
		comboBox_3.setToolTipText("Hour");

		comboBox_3.addItem("Hour");

		for (int i = 0; i < 24; i++) {
			comboBox_3.addItem(i);

		}

		comboBox_3.setBounds(262, 69, 57, 22);
		frame.getContentPane().add(comboBox_3);

		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.BLUE);
		comboBox_4.setEnabled(false);
		comboBox_4.setToolTipText("Min");

		comboBox_4.addItem("Min");

		for (int i = 0; i < 60; i++) {
			comboBox_4.addItem(i);

		}

		comboBox_4.setBounds(328, 69, 57, 22);
		frame.getContentPane().add(comboBox_4);

		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setForeground(Color.BLUE);
		comboBox_5.setEnabled(false);
		comboBox_5.setToolTipText("Sec");

		comboBox_5.addItem("Sec");

		for (int i = 0; i < 60; i++) {
			comboBox_5.addItem(i);

		}

		comboBox_5.setBounds(391, 69, 57, 22);
		frame.getContentPane().add(comboBox_5);

		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setForeground(Color.BLUE);
		comboBox_6.setToolTipText("Day");
		comboBox_6.setEnabled(false);

		comboBox_6.addItem("Day");

		for (int i = 1; i < 32; i++) {
			comboBox_6.addItem(i);
		}

		comboBox_6.setBounds(476, 39, 57, 22);
		frame.getContentPane().add(comboBox_6);

		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setForeground(Color.BLUE);
		comboBox_7.setToolTipText("Month");
		comboBox_7.setEnabled(false);

		comboBox_7.addItem("Month");

		for (int i = 1; i < 13; i++) {
			comboBox_7.addItem(i);
		}

		comboBox_7.setBounds(542, 39, 57, 22);
		frame.getContentPane().add(comboBox_7);

		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setForeground(Color.BLUE);
		comboBox_8.setToolTipText("Year");
		comboBox_8.setEnabled(false);

		comboBox_8.addItem("Year");

		for (int i = 2000; i < 2020; i++) {
			comboBox_8.addItem(i);
		}

		comboBox_8.setBounds(605, 39, 57, 22);
		frame.getContentPane().add(comboBox_8);

		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setForeground(Color.BLUE);
		comboBox_9.setToolTipText("Day");
		comboBox_9.setEnabled(false);

		comboBox_9.addItem("Day");

		for (int i = 1; i < 32; i++) {
			comboBox_9.addItem(i);
		}

		comboBox_9.setBounds(476, 69, 57, 22);
		frame.getContentPane().add(comboBox_9);

		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setForeground(Color.BLUE);
		comboBox_10.setToolTipText("Month");
		comboBox_10.setEnabled(false);

		comboBox_10.addItem("Month");

		for (int i = 1; i < 13; i++) {
			comboBox_10.addItem(i);
		}

		comboBox_10.setBounds(542, 69, 57, 22);
		frame.getContentPane().add(comboBox_10);

		JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setForeground(Color.BLUE);
		comboBox_11.setToolTipText("Year");
		comboBox_11.setEnabled(false);

		comboBox_11.addItem("Year");

		for (int i = 2000; i < 2020; i++) {
			comboBox_11.addItem(i);
		}

		comboBox_11.setBounds(605, 69, 57, 22);
		frame.getContentPane().add(comboBox_11);

		TextField textField_UserName = new TextField();
		textField_UserName.setForeground(Color.BLUE);
		textField_UserName.setEnabled(false);
		textField_UserName.setBounds(242, 128, 77, 21);
		frame.getContentPane().add(textField_UserName);

		

		JTextPane txtpnMinTime = new JTextPane();
		txtpnMinTime.setEditable(false);
		txtpnMinTime.setForeground(Color.BLUE);
		txtpnMinTime.setBackground(UIManager.getColor("Button.background"));
		txtpnMinTime.setText("Min Time: ");
		txtpnMinTime.setBounds(182, 39, 68, 22);
		frame.getContentPane().add(txtpnMinTime);

		
		
		

		JTextPane txtpnUserName = new JTextPane();
		txtpnUserName.setEditable(false);
		txtpnUserName.setForeground(Color.BLUE);
		txtpnUserName.setText("User name:");
		txtpnUserName.setBackground(SystemColor.menu);
		txtpnUserName.setBounds(160, 127, 77, 22);
		frame.getContentPane().add(txtpnUserName);

		

		JTextPane txtpnMinLat = new JTextPane();
		txtpnMinLat.setEditable(false);
		txtpnMinLat.setForeground(Color.BLUE);
		txtpnMinLat.setText("Min Lat: ");
		txtpnMinLat.setBackground(SystemColor.menu);
		txtpnMinLat.setBounds(160, 198, 57, 22);
		frame.getContentPane().add(txtpnMinLat);

		TextField textField_latMin = new TextField();
		textField_latMin.setForeground(Color.BLUE);
		textField_latMin.setEnabled(false);
		textField_latMin.setBounds(230, 196, 77, 21);
		frame.getContentPane().add(textField_latMin);

		JTextPane txtpnMinLon = new JTextPane();
		txtpnMinLon.setEditable(false);
		txtpnMinLon.setForeground(Color.BLUE);
		txtpnMinLon.setText("Min Lon:");
		txtpnMinLon.setBackground(SystemColor.menu);
		txtpnMinLon.setBounds(160, 226, 57, 22);
		frame.getContentPane().add(txtpnMinLon);

		JTextPane txtpnMinAlt = new JTextPane();
		txtpnMinAlt.setEditable(false);
		txtpnMinAlt.setForeground(Color.BLUE);
		txtpnMinAlt.setText("Min Alt:");
		txtpnMinAlt.setBackground(SystemColor.menu);
		txtpnMinAlt.setBounds(160, 255, 57, 22);
		frame.getContentPane().add(txtpnMinAlt);

		TextField textField_LonMin = new TextField();
		textField_LonMin.setForeground(Color.BLUE);
		textField_LonMin.setEnabled(false);
		textField_LonMin.setBounds(230, 223, 77, 21);
		frame.getContentPane().add(textField_LonMin);

		TextField textField_AltMin = new TextField();
		textField_AltMin.setForeground(Color.BLUE);
		textField_AltMin.setEnabled(false);
		textField_AltMin.setBounds(230, 253, 77, 21);
		frame.getContentPane().add(textField_AltMin);

		JTextPane txtpnMaxLat = new JTextPane();
		txtpnMaxLat.setEditable(false);
		txtpnMaxLat.setForeground(Color.BLUE);
		txtpnMaxLat.setText("Max Lat:");
		txtpnMaxLat.setBackground(SystemColor.menu);
		txtpnMaxLat.setBounds(319, 195, 62, 22);
		frame.getContentPane().add(txtpnMaxLat);

		TextField textField_latMax = new TextField();
		textField_latMax.setForeground(Color.BLUE);
		textField_latMax.setEnabled(false);
		textField_latMax.setBounds(389, 196, 77, 21);
		frame.getContentPane().add(textField_latMax);

		JTextPane txtpnMaxLon = new JTextPane();
		txtpnMaxLon.setEditable(false);
		txtpnMaxLon.setForeground(Color.BLUE);
		txtpnMaxLon.setText("Max Lon:");
		txtpnMaxLon.setBackground(SystemColor.menu);
		txtpnMaxLon.setBounds(319, 223, 62, 22);
		frame.getContentPane().add(txtpnMaxLon);

		JTextPane txtpnMaxAlt = new JTextPane();
		txtpnMaxAlt.setEditable(false);
		txtpnMaxAlt.setForeground(Color.BLUE);
		txtpnMaxAlt.setText("Max Alt:");
		txtpnMaxAlt.setBackground(SystemColor.menu);
		txtpnMaxAlt.setBounds(319, 252, 68, 22);
		frame.getContentPane().add(txtpnMaxAlt);

		TextField textField_LonMax = new TextField();
		textField_LonMax.setForeground(Color.BLUE);
		textField_LonMax.setEnabled(false);
		textField_LonMax.setBounds(389, 223, 77, 21);
		frame.getContentPane().add(textField_LonMax);

		TextField textField_AltMax = new TextField();
		textField_AltMax.setForeground(Color.BLUE);
		textField_AltMax.setEnabled(false);
		textField_AltMax.setBounds(389, 253, 77, 21);
		frame.getContentPane().add(textField_AltMax);

		JButton btnUnfilter = new JButton("Unfilter");
		btnUnfilter.setForeground(Color.BLUE);
		btnUnfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < lc.size(); i++) {
					lc.get(i).setBool(false);
				}

			}
		});
		btnUnfilter.setBounds(323, 290, 143, 41);
		frame.getContentPane().add(btnUnfilter);

		JCheckBox chckbxLat = new JCheckBox("Lat");
		chckbxLat.setForeground(Color.BLUE);
		JCheckBox chckbxLon = new JCheckBox("Lon");
		chckbxLon.setForeground(Color.BLUE);
		JCheckBox checkbxAlt = new JCheckBox("Alt");
		checkbxAlt.setForeground(Color.BLUE);


		chckbxLat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			textField_latMin.setEnabled(true);
			textField_latMax.setEnabled(true);
				
			chckbxLon.setSelected(false);
			textField_LonMin.setEnabled(false);
			textField_LonMax.setEnabled(false);
			
			checkbxAlt.setSelected(false);
			textField_AltMin.setEnabled(false);
			textField_AltMax.setEnabled(false);
				
			}
		});
		chckbxLat.setEnabled(false);
		chckbxLat.setBounds(289, 164, 49, 25);
		frame.getContentPane().add(chckbxLat);
		
		chckbxLon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_LonMin.setEnabled(true);
				textField_LonMax.setEnabled(true);
				
			chckbxLat.setSelected(false);
			textField_latMin.setEnabled(false);
			textField_latMax.setEnabled(false);
			
			checkbxAlt.setSelected(false);
			textField_AltMin.setEnabled(false);
			textField_AltMax.setEnabled(false);
				
			}
		});

		chckbxLon.setEnabled(false);
		chckbxLon.setBounds(336, 164, 49, 25);
		frame.getContentPane().add(chckbxLon);
		
		checkbxAlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				textField_AltMin.setEnabled(true);
				textField_AltMax.setEnabled(true);
				
			chckbxLon.setSelected(false);
			textField_LonMin.setEnabled(false);
			textField_LonMax.setEnabled(false);
			
			chckbxLat.setSelected(false);
			textField_latMin.setEnabled(false);
			textField_latMax.setEnabled(false);
				
			}
		});

		checkbxAlt.setEnabled(false);
		checkbxAlt.setBounds(382, 164, 49, 25);
		frame.getContentPane().add(checkbxAlt);
		
		JCheckBox CheckBoxMinTime = new JCheckBox("");
		CheckBoxMinTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(CheckBoxMinTime.isSelected()){
				comboBox.setEnabled(true);
				comboBox_1.setEnabled(true);
				comboBox_2.setEnabled(true);
				comboBox_6.setEnabled(true);
				comboBox_7.setEnabled(true);
				comboBox_8.setEnabled(true);
				}
				
				else{
					
					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);
					
				}
				
				/*
				comboBox_3.setEnabled(true);
				comboBox_4.setEnabled(true);
				comboBox_5.setEnabled(true);
				*/
				/*
				comboBox_9.setEnabled(true);
				comboBox_10.setEnabled(true);
				comboBox_11.setEnabled(true);
				*/
				
			}
		});
		CheckBoxMinTime.setEnabled(false);
		CheckBoxMinTime.setBounds(160, 39, 25, 25);
		frame.getContentPane().add(CheckBoxMinTime);
		
		JCheckBox checkBoxMaxTime = new JCheckBox("");
		checkBoxMaxTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(checkBoxMaxTime.isSelected()){
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					comboBox_9.setEnabled(true);
					comboBox_10.setEnabled(true);
					comboBox_11.setEnabled(true);
					}
					
					else{
						
						comboBox_3.setEnabled(false);
						comboBox_4.setEnabled(false);
						comboBox_5.setEnabled(false);
						comboBox_9.setEnabled(false);
						comboBox_10.setEnabled(false);
						comboBox_11.setEnabled(false);
						
					}	
			}
		});
		checkBoxMaxTime.setEnabled(false);
		checkBoxMaxTime.setBounds(160, 69, 25, 25);
		frame.getContentPane().add(checkBoxMaxTime);
		
		///////////////////actions filters////////////////////////
		
		rdbtnTimeFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				rdbtnIDfilter.setSelected(false);
				rdbtLOCfilter.setSelected(false);
				
				CheckBoxMinTime.setEnabled(true);
				checkBoxMaxTime.setEnabled(true);
				
				
				
				
				textField_latMax.setEnabled(false);
				textField_UserName.setEnabled(false);
				textField_latMin.setEnabled(false);
				textField_LonMin.setEnabled(false);
				textField_AltMin.setEnabled(false);
				textField_LonMax.setEnabled(false);
				textField_AltMax.setEnabled(false);
				
				chckbxLat.setEnabled(false);
				chckbxLon.setEnabled(false);
				checkbxAlt.setEnabled(false);
				
				

			}
		});
		
		
		
		rdbtnTimeFilter.setBounds(160, 9, 127, 25);
		frame.getContentPane().add(rdbtnTimeFilter);
		
		rdbtnIDfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_UserName.setEnabled(true);
	


				rdbtLOCfilter.setSelected(false);
				chckbxLat.setSelected(false);
				chckbxLat.setEnabled(false);
				chckbxLon.setSelected(false);
				chckbxLon.setEnabled(false);
				checkbxAlt.setSelected(false);
				checkbxAlt.setEnabled(false);
				textField_latMax.setEnabled(false);
				textField_latMin.setEnabled(false);
				textField_LonMin.setEnabled(false);
				textField_AltMin.setEnabled(false);
				textField_LonMax.setEnabled(false);
				textField_AltMax.setEnabled(false);
				
				
				
				
				rdbtnTimeFilter.setSelected(false);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				comboBox_2.setEnabled(false);
				comboBox_3.setEnabled(false);
				comboBox_4.setEnabled(false);
				comboBox_5.setEnabled(false);
				comboBox_6.setEnabled(false);
				comboBox_7.setEnabled(false);
				comboBox_8.setEnabled(false);
				comboBox_9.setEnabled(false);
				comboBox_10.setEnabled(false);
				comboBox_11.setEnabled(false);


			}
		});

		rdbtnIDfilter.setBounds(160, 95, 127, 25);
		frame.getContentPane().add(rdbtnIDfilter);
		
		rdbtLOCfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chckbxLat.setEnabled(true);
				chckbxLon.setEnabled(true);
				checkbxAlt.setEnabled(true);

				rdbtnIDfilter.setSelected(false);
				rdbtnTimeFilter.setSelected(false);
				rdbtnTimeFilter.setSelected(false);
				comboBox.setEnabled(false);
				comboBox_1.setEnabled(false);
				comboBox_2.setEnabled(false);
				comboBox_3.setEnabled(false);
				comboBox_4.setEnabled(false);
				comboBox_5.setEnabled(false);
				comboBox_6.setEnabled(false);
				comboBox_7.setEnabled(false);
				comboBox_8.setEnabled(false);
				comboBox_9.setEnabled(false);
				comboBox_10.setEnabled(false);
				comboBox_11.setEnabled(false);
				
				
				

			}
		});
		
		rdbtLOCfilter.setBounds(160, 164, 125, 25);
		frame.getContentPane().add(rdbtLOCfilter);

		///////////////////////// sumbit filters////////////////////

		JButton btnSumbitFilter = new JButton("Submit filter");
		btnSumbitFilter.setForeground(Color.BLUE);
		btnSumbitFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnTimeFilter.isSelected()) {
					
					boolean chooseMin = true;
					boolean chooseMax = true;

					String Smin = "";
					String Smax = "";

					if(CheckBoxMinTime.isSelected()){
						
						if (comboBox.getSelectedIndex() == 0) {
							comboBox.setBackground(new Color(255, 0, 0));
							chooseMin = false;
					}
					else{
						comboBox.setBackground(new Color(240,240,240));

					}
						
						if (comboBox_1.getSelectedIndex() == 0) {
							comboBox_1.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						}
						else{
							comboBox_1.setBackground(new Color(240,240,240));
						}
						if (comboBox_2.getSelectedIndex() == 0) {
							comboBox_2.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						}
						else{
							comboBox_2.setBackground(new Color(240,240,240));
						}
						
						if (comboBox_6.getSelectedIndex() == 0) {
							comboBox_6.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						}
						else{
							comboBox_6.setBackground(new Color(240,240,240));
						}
						if (comboBox_7.getSelectedIndex() == 0) {
							comboBox_7.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						}
						else{
							comboBox_7.setBackground(new Color(240,240,240));
						}
						if (comboBox_8.getSelectedIndex() == 0) {
							comboBox_8.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						}
						else{
							comboBox_8.setBackground(new Color(240,240,240));
						}
						
						if(chooseMin==false){
							return;
						}
						
						int minHour = (int) comboBox.getSelectedItem();
						int minMint =(int) comboBox_1.getSelectedItem();
						int minSec =(int) comboBox_2.getSelectedItem();

						int minYear = (int)comboBox_8.getSelectedItem();
						int minMonth = (int)comboBox_7.getSelectedItem();
						int minDay = (int)comboBox_6.getSelectedItem();

						String SminH = Integer.toString(minHour);
						String SminM = Integer.toString(minMint);
						String SminS = Integer.toString(minSec);
						
						String SminY = Integer.toString(minYear);
						String SminMon = Integer.toString(minMonth);
						String SminD = Integer.toString(minDay);
						
						if (minHour < 10) {
							SminH = "0" + SminH;
						}
						if (minMint < 10) {
							SminM = "0" + SminM;
						}
						if (minSec < 10) {
							SminS = "0" + SminS;
						}
						if (minMonth < 10) {
							SminMon = "0" + SminMon;
						}
						if (minDay < 10) {
							SminD = "0" + SminD;
						}
						

						Smin = SminY + "-" + SminMon + "-" + SminD + " " + SminH + "-" + SminM + "-" + SminS;
						
					}
					
					else{
						
						Smin = "1900-01-01 00-00-00";
						
					}

					if(checkBoxMaxTime.isSelected()){
						
						if (comboBox_3.getSelectedIndex() == 0) {
							comboBox_3.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_3.setBackground(new Color(240,240,240));
						}
						if (comboBox_4.getSelectedIndex() == 0) {
							comboBox_4.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_4.setBackground(new Color(240,240,240));
						}
						if (comboBox_5.getSelectedIndex() == 0) {
							comboBox_5.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_5.setBackground(new Color(240,240,240));
						}
						
						if (comboBox_9.getSelectedIndex() == 0) {
							comboBox_9.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_9.setBackground(new Color(240,240,240));
						}
						if (comboBox_10.getSelectedIndex() == 0) {
							comboBox_10.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_10.setBackground(new Color(240,240,240));
						}
						if (comboBox_11.getSelectedIndex() == 0) {
							comboBox_11.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						}
						else{
							comboBox_11.setBackground(new Color(240,240,240));
						}
						
						if(chooseMax==false){
							return;
						}
						
						int maxHour = comboBox_3.getSelectedIndex();
						int maxMint = comboBox_4.getSelectedIndex();
						int maxSec = comboBox_5.getSelectedIndex();
						
						int maxYear = (int)comboBox_11.getSelectedItem();
						int maxMonth = (int)comboBox_10.getSelectedItem();
						int maxDay = (int)comboBox_9.getSelectedItem();

						String SmaxH = Integer.toString(maxHour);
						String SmaxM = Integer.toString(maxMint);
						String SmaxS = Integer.toString(maxSec);
						
						String SmaxY = Integer.toString(maxYear);
						String SmaxMon = Integer.toString(maxMonth);
						String SmaxD = Integer.toString(maxDay);

						if (maxHour < 10) {
							SmaxH = "0" + SmaxH;
						}
						if (maxMint < 10) {
							SmaxM = "0" + SmaxM;
						}
						if (maxSec < 10) {
							SmaxS = "0" + SmaxS;
						}
						if (maxMonth < 10) {
							SmaxMon = "0" + SmaxMon;
						}
						if (maxDay < 10) {
							SmaxD = "0" + SmaxD;
						}

						Smax = SmaxY + "-" + SmaxMon + "-" + SmaxD + " " + SmaxH + "-" + SmaxM + "-" + SmaxS;
						
						
						
					}
					
					else{
						
						Smax = "2100-12-31 23-59-59";
						
					}
					
			
					System.out.println(Smin);
					System.out.println(Smax);

					if (Smax.compareTo(Smin) < 0) {
						JOptionPane.showMessageDialog(frame, "The min time is greater than max time!");
					} 
					else {

						timeFilter tf = new timeFilter(Smin, Smax);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = tf.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(ce);
						}
					}
				}

				else if (rdbtnIDfilter.isSelected()) {
					
					if(textField_UserName.getText().isEmpty()){	
							textField_UserName.setBackground(new Color(255, 0, 0));
					}
					
					else{
						
						String id = textField_UserName.getText();
						
						IDfilter ifd = new IDfilter(id);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = ifd.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

					}

					
				


			}
				
				
				else if(rdbtLOCfilter.isSelected()){
					
					
					

					
					if(chckbxLat.isSelected()){
						double min = 0;
						double max = 0;
						
						try{
							 min = Double.parseDouble(textField_latMin.getText());
						   
						}
						catch (Exception e1){
							
							textField_latMin.setBackground(new Color(255, 0, 0));
							
						}
						
						try{
							 max = Double.parseDouble(textField_latMax.getText());
						   
						}
						catch (Exception e1){
							
							textField_latMax.setBackground(new Color(255, 0, 0));
							
						}
						


						latFilter lat = new latFilter(min, max);
						
						for (int i = 0; i < lc.size(); i++) {

							boolean ce = lat.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

						
						}
					
					if(chckbxLon.isSelected()){
						double min = 0;
						double max = 0;
						
						try{
							 min = Double.parseDouble(textField_LonMin.getText());
						   
						}
						catch (Exception e1){
							
							textField_LonMin.setBackground(new Color(255, 0, 0));
							
						}
						
						try{
							 max = Double.parseDouble(textField_LonMax.getText());
						   
						}
						catch (Exception e1){
							
							textField_LonMax.setBackground(new Color(255, 0, 0));
							
						}
						


						lonFilter lon = new lonFilter(min, max);
						
						for (int i = 0; i < lc.size(); i++) {

							boolean ce = lon.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}
						
						}
					
					if(checkbxAlt.isSelected()){
						double min = 0;
						double max = 0;
						
						try{
							 min = Double.parseDouble(textField_AltMin.getText());
						   
						}
						catch (Exception e1){
							
							textField_AltMin.setBackground(new Color(255, 0, 0));
							
						}
						
						try{
							 max = Double.parseDouble(textField_AltMax.getText());
						   
						}
						catch (Exception e1){
							
							textField_AltMax.setBackground(new Color(255, 0, 0));
							
						}
						


						altFilter alt = new altFilter(min, max);
						
						for (int i = 0; i < lc.size(); i++) {

							boolean ce = alt.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}
						
						}
						

						
					}
					
				
				
				
				counters cu = new counters();
				int c = cu.boolCount(lc);
			}
		});
		
		btnSumbitFilter.setBounds(160, 290, 143, 41);
		frame.getContentPane().add(btnSumbitFilter);
		
		JButton btnSendToFile = new JButton("load filter");
		btnSendToFile.setForeground(Color.BLUE);
		btnSendToFile.setBounds(323, 334, 143, 41);
		frame.getContentPane().add(btnSendToFile);
		
		JButton btnSaveFilter = new JButton("Save filter");
		btnSaveFilter.setForeground(Color.BLUE);
		btnSaveFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSaveFilter.setBounds(160, 334, 143, 41);
		frame.getContentPane().add(btnSaveFilter);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(96, 376, 16, -6);
		frame.getContentPane().add(btnNewButton);
		
		TextField textField_1 = new TextField();
		textField_1.setBounds(641, 164, 108, 21);
		frame.getContentPane().add(textField_1);
		
		JTextPane txtpnMac = new JTextPane();
		txtpnMac.setForeground(Color.BLUE);
		txtpnMac.setEditable(false);
		txtpnMac.setText("Enter MAC address:");
		txtpnMac.setBackground(SystemColor.menu);
		txtpnMac.setBounds(510, 164, 125, 22);
		frame.getContentPane().add(txtpnMac);
		
		JTextPane txtpnMac_1 = new JTextPane();
		txtpnMac_1.setEditable(false);
		txtpnMac_1.setForeground(Color.BLUE);
		txtpnMac_1.setText("mac 1:");
		txtpnMac_1.setBackground(SystemColor.menu);
		txtpnMac_1.setBounds(510, 346, 49, 22);
		frame.getContentPane().add(txtpnMac_1);
		
		TextField textField_algo2_mac1 = new TextField();
		textField_algo2_mac1.setEnabled(false);
		textField_algo2_mac1.setBounds(565, 346, 108, 21);
		frame.getContentPane().add(textField_algo2_mac1);
		
		JTextPane txtpnMac_2 = new JTextPane();
		txtpnMac_2.setForeground(Color.BLUE);
		txtpnMac_2.setEditable(false);
		txtpnMac_2.setText("mac 2:");
		txtpnMac_2.setBackground(SystemColor.menu);
		txtpnMac_2.setBounds(510, 374, 57, 22);
		frame.getContentPane().add(txtpnMac_2);
		
		JTextPane txtpnMac_3 = new JTextPane();
		txtpnMac_3.setForeground(Color.BLUE);
		txtpnMac_3.setEditable(false);
		txtpnMac_3.setText("mac 3:");
		txtpnMac_3.setBackground(SystemColor.menu);
		txtpnMac_3.setBounds(510, 403, 57, 22);
		frame.getContentPane().add(txtpnMac_3);
		
		TextField textField_algo2_mac2 = new TextField();
		textField_algo2_mac2.setEnabled(false);
		textField_algo2_mac2.setBounds(565, 374, 108, 21);
		frame.getContentPane().add(textField_algo2_mac2);
		
		TextField textField_algo2_mac3 = new TextField();
		textField_algo2_mac3.setEnabled(false);
		textField_algo2_mac3.setBounds(565, 403, 108, 21);
		frame.getContentPane().add(textField_algo2_mac3);
		
		JTextPane txtpnSig = new JTextPane();
		txtpnSig.setForeground(Color.BLUE);
		txtpnSig.setEditable(false);
		txtpnSig.setText("sig 1:");
		txtpnSig.setBackground(SystemColor.menu);
		txtpnSig.setBounds(687, 346, 45, 22);
		frame.getContentPane().add(txtpnSig);
		
		TextField textField_algo2_sig1 = new TextField();
		textField_algo2_sig1.setEnabled(false);
		textField_algo2_sig1.setBounds(738, 346, 108, 21);
		frame.getContentPane().add(textField_algo2_sig1);
		
		JTextPane txtpnSig_1 = new JTextPane();
		txtpnSig_1.setForeground(Color.BLUE);
		txtpnSig_1.setEditable(false);
		txtpnSig_1.setText("sig 2:");
		txtpnSig_1.setBackground(SystemColor.menu);
		txtpnSig_1.setBounds(687, 374, 45, 22);
		frame.getContentPane().add(txtpnSig_1);
		
		JTextPane txtpnSig_2 = new JTextPane();
		txtpnSig_2.setForeground(Color.BLUE);
		txtpnSig_2.setEditable(false);
		txtpnSig_2.setText("sig 3:");
		txtpnSig_2.setBackground(SystemColor.menu);
		txtpnSig_2.setBounds(687, 400, 49, 22);
		frame.getContentPane().add(txtpnSig_2);
		
		TextField textField_algo2_sig2 = new TextField();
		textField_algo2_sig2.setEnabled(false);
		textField_algo2_sig2.setBounds(738, 374, 108, 21);
		frame.getContentPane().add(textField_algo2_sig2);
		
		TextField textField_algo2_sig3 = new TextField();
		textField_algo2_sig3.setEnabled(false);
		textField_algo2_sig3.setBounds(738, 403, 108, 21);
		frame.getContentPane().add(textField_algo2_sig3);
		JRadioButton radioButton_algo2B = new JRadioButton("Enter string:");
		radioButton_algo2B.setForeground(Color.BLUE);
		TextField textField_15 = new TextField();

		JRadioButton radioButton_algo2A = new JRadioButton("");
		radioButton_algo2A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				radioButton_algo2B.setSelected(false);
				textField_algo2_mac1.setEnabled(true);
				textField_algo2_mac2.setEnabled(true);
				textField_algo2_mac3.setEnabled(true);
				textField_algo2_sig1.setEnabled(true);
				textField_algo2_sig2.setEnabled(true);
				textField_algo2_sig3.setEnabled(true);
				textField_15.setEnabled(false);

				
				
			}
		});
		radioButton_algo2A.setForeground(Color.BLUE);
		radioButton_algo2A.setBounds(510, 321, 31, 25);
		frame.getContentPane().add(radioButton_algo2A);
		
		radioButton_algo2B.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				radioButton_algo2A.setSelected(false);
				textField_algo2_mac1.setEnabled(false);
				textField_algo2_mac2.setEnabled(false);
				textField_algo2_mac3.setEnabled(false);
				textField_algo2_sig1.setEnabled(false);
				textField_algo2_sig2.setEnabled(false);
				textField_algo2_sig3.setEnabled(false);
				textField_15.setEnabled(true);

				
					
				
				
			}
		});
		radioButton_algo2B.setBounds(510, 434, 110, 21);
		frame.getContentPane().add(radioButton_algo2B);
		
		
		textField_15.setEnabled(false);
		textField_15.setBounds(510, 469, 336, 21);
		frame.getContentPane().add(textField_15);
		
		TextField textField_algo1lon = new TextField();
		textField_algo1lon.setEnabled(false);
		textField_algo1lon.setEditable(false);
		textField_algo1lon.setBounds(641, 227, 108, 21);
		frame.getContentPane().add(textField_algo1lon);
		
		TextField textField_algo1alt = new TextField();
		textField_algo1alt.setEnabled(false);
		textField_algo1alt.setEditable(false);
		textField_algo1alt.setBounds(641, 255, 108, 21);
		frame.getContentPane().add(textField_algo1alt);
		
		TextField textField_algo1lat = new TextField();
		textField_algo1lat.setEditable(false);
		textField_algo1lat.setEnabled(false);
		textField_algo1lat.setBounds(641, 198, 108, 21);
		frame.getContentPane().add(textField_algo1lat);
		
		
		JButton btnSubmit = new JButton("find loction");
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MatrixSortByMAC  ms = new MatrixSortByMAC();
				String mac = textField_1.getText();
				
				LinkedList<Wifi> algo1List = ms.findMac(wifi, mac);
				
				ms.sortBySignal(algo1List);
				
				System.out.println("size:" + wifi.size());
				
				Wifi w = algo1.Waverage(algo1List);
				
				//להחזיר מיקום 
				System.out.println(w.getAlt());
				
			
				textField_algo1lat.setText(Double.toString(w.getLat()));
				textField_algo1lon.setText(Double.toString(w.getLon()));
				textField_algo1alt.setText(Double.toString(w.getAlt()));
				
				
				
				
				
				

				
			}
		});
		btnSubmit.setBounds(510, 198, 108, 78);
		frame.getContentPane().add(btnSubmit);
		
		TextField textField_algo2lat = new TextField();
		textField_algo2lat.setEnabled(false);
		textField_algo2lat.setEditable(false);
		textField_algo2lat.setBounds(641, 508, 108, 21);
		frame.getContentPane().add(textField_algo2lat);
		
		TextField textField_algo2lon = new TextField();
		textField_algo2lon.setEnabled(false);
		textField_algo2lon.setEditable(false);
		textField_algo2lon.setBounds(641, 537, 108, 21);
		frame.getContentPane().add(textField_algo2lon);
		
		TextField textField_algo2alt = new TextField();
		textField_algo2alt.setEnabled(false);
		textField_algo2alt.setEditable(false);
		textField_algo2alt.setBounds(641, 565, 108, 21);
		frame.getContentPane().add(textField_algo2alt);
		
		JButton btnSubmitAkgo = new JButton("Find loction");
		btnSubmitAkgo.setForeground(Color.BLUE);
		btnSubmitAkgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(radioButton_algo2A.isSelected()){
					
					algo2 al2 = new algo2();
					LinkedList<Checks> lcFiltered = new LinkedList<>();
					
					
					for(int i=0; i<lc.size(); i++){
						
						if(lc.get(i).isBool()){
							lcFiltered.add(lc.get(i));
						}
						
					}
					

					System.out.println(lcFiltered.size());
					
					System.out.println(Integer.getInteger(textField_algo2_sig1.getText()));
					
					int sig1 = Integer.parseInt(textField_algo2_sig1.getText());
					int sig2 = Integer.parseInt(textField_algo2_sig2.getText());
					int sig3 = Integer.parseInt(textField_algo2_sig3.getText());
					
					double[] arr = al2.wImg(lcFiltered,textField_algo2_mac1.getText(),textField_algo2_mac2.getText()
							,textField_algo2_mac3.getText(),sig1,sig2,sig3);
					
					textField_algo2lat.setText(Double.toString(arr[0]));
					textField_algo2lon.setText(Double.toString(arr[1]));
					textField_algo2alt.setText(Double.toString(arr[2]));
					
				}
				
			}
		});
		btnSubmitAkgo.setBounds(510, 508, 108, 78);
		frame.getContentPane().add(btnSubmitAkgo);
		
		JTextPane algo2text = new JTextPane();
		algo2text.setText("Algorithm 2:");
		algo2text.setForeground(Color.BLUE);
		algo2text.setBackground(SystemColor.menu);
		algo2text.setBounds(510, 290, 89, 22);
		frame.getContentPane().add(algo2text);
		
		JTextPane txtpnAlgo = new JTextPane();
		txtpnAlgo.setEditable(false);
		txtpnAlgo.setText("Algorithm 1:");
		txtpnAlgo.setForeground(Color.BLUE);
		txtpnAlgo.setBackground(SystemColor.menu);
		txtpnAlgo.setBounds(510, 127, 89, 22);
		frame.getContentPane().add(txtpnAlgo);
		
		JList list = new JList();
		list.setBounds(124, 292, -84, -276);
		frame.getContentPane().add(list);
		
		
		
		
		
		

	}
}
