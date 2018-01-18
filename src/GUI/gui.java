/*
 * 
 */
package GUI;

import java.awt.EventQueue;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Update;
import exportFiles.toCSV;
import exportFiles.toKML;

import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import mainPackage.*;
import algorithms.*;
import linkedListFilters.IDfilter;
import linkedListFilters.altFilter;
import linkedListFilters.filter;
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
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import database.*;
import javax.swing.DropMode;
import javax.swing.JTable;


// TODO: Auto-generated Javadoc
/**
 * The Class gui.
 */
public class gui extends Thread{

	

	/** The Constant OVERFLOW. */
	protected static final Kind<?> OVERFLOW = null;

	/** The frame. */
	private JFrame frame;

	/** The lc. */
	LinkedList<Checks> lc = new LinkedList<>();
	
	/** The wifi. */
	LinkedList<Wifi> wifi = new LinkedList<>();
	
	/** The folder. */
	static String folder = "";


	/** The time. */
	timeFilter time;
	
	/** The id. */
	IDfilter id;
	
	/** The lat 0. */
	latFilter lat0;
	
	/** The lon 0. */
	lonFilter lon0;
	
	/** The alt 0. */
	altFilter alt0;
	
	/** The result. */
	filter result;

	/** The time load. */
	timeFilter timeLoad;
	
	/** The id load. */
	IDfilter idLoad;
	
	/** The lat load. */
	latFilter latLoad;
	
	/** The lon load. */
	lonFilter lonLoad;
	
	/** The alt load. */
	altFilter altLoad;
	
	/** The timeload bool. */
	boolean timeloadBool = false;
	
	/** The idload bool. */
	boolean idloadBool = false;
	
	/** The latload bool. */
	boolean latloadBool = false;
	
	/** The lonload bool. */
	boolean lonloadBool = false;
	
	/** The altload bool. */
	boolean altloadBool = false;

	/** The filter type. */
	String filterType = "";
	
	/** The Smin. */
	String Smin = "";
	
	/** The Smax. */
	String Smax = "";

	/** The lines. */
	int lines = lc.size();

	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui window = new gui();
					window.frame.setVisible(true);
					
					
					Thread t1 = new Thread(window);
					
					t1.start();
					
					
					
					

					
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent arg0) {
				System.out.println("netanel");
			}
		});
		frame.getContentPane().setBackground(new Color(240, 240, 240));
		frame.getContentPane().setForeground(Color.BLUE);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(1000, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("wifi scanner system");

		final JTextPane txtpnLines = new JTextPane();
		txtpnLines.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnLines.setText("Lines:");
		txtpnLines.setForeground(Color.BLUE);
		txtpnLines.setBackground(SystemColor.menu);
		txtpnLines.setBounds(0, 292, 57, 22);
		frame.getContentPane().add(txtpnLines);

		final JTextPane txtpnNetworks = new JTextPane();
		txtpnNetworks.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnNetworks.setText("Networks:");
		txtpnNetworks.setForeground(Color.BLUE);
		txtpnNetworks.setEditable(false);
		txtpnNetworks.setBackground(SystemColor.menu);
		txtpnNetworks.setBounds(0, 321, 94, 22);
		frame.getContentPane().add(txtpnNetworks);

		final TextField textField_lines = new TextField();
		textField_lines.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_lines.setEnabled(false);
		textField_lines.setEditable(false);
		textField_lines.setBounds(100, 292, 54, 21);
		frame.getContentPane().add(textField_lines);

		final TextField textField_networks = new TextField();
		textField_networks.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_networks.setEnabled(false);
		textField_networks.setEditable(false);
		textField_networks.setBounds(100, 322, 54, 21);
		frame.getContentPane().add(textField_networks);

		final Button button = new Button("Choose folder");
		button.setBounds(0, 0, 125, 52);
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * take from:
				 * https://stackoverflow.com/questions/10621687/how-to-get-full-path-directory-from-file-chooser
				 */
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Choose folder");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
					folder = chooser.getSelectedFile().getAbsolutePath();
				} else {
					System.out.println("No Selection ");
				}

				final WifiScanner ws = new WifiScanner();
				final readCsvMatalaFormat rc = new readCsvMatalaFormat();
				try {

					if (folder != "") {

						LinkedList<Checks> fromFolder = new LinkedList<>();
						fromFolder = ws.filesReader(folder);

						lc.addAll(fromFolder);

						for (int i = 0; i < lc.size(); i++) {

							lc.get(i).setBool(true);

						}

						LinkedList<Wifi> wifiFromFolder = rc.checksToWifi(lc);
						wifi.addAll(wifiFromFolder);

						//System.out.println(lc.size());

						textField_lines.setText(Integer.toString(lc.size()));
						textField_networks.setText(Integer.toString(wifi.size()));
						
						
						
				            new Thread() {
				                @Override
				                public void run() {
				                	
				                	WatchService watcher = null;
				            		
				            		try {
				            			watcher = FileSystems.getDefault().newWatchService();
				            		} catch (IOException e1) {
				            			// TODO Auto-generated catch block
				            			e1.printStackTrace();
				            		}
				            		
				            		Path dir = Paths.get(folder);
				            		try {
				            			dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
				            		} catch (IOException e1) {
				            			// TODO Auto-generated catch block
				            			e1.printStackTrace();
				            		}
				            		
				            		while (true) {
				            		    WatchKey key = null;
				            		    try {
				            		        // wait for a key to be available
				            		        key = watcher.take();
				            		    } catch (InterruptedException ex) {
				            		    }
				            		 
				            		    for (WatchEvent<?> event : key.pollEvents()) {
				            		        // get event type
				            		        WatchEvent.Kind<?> kind = event.kind();
				            		 
				            		        // get file name
				            		        @SuppressWarnings("unchecked")
				            		        WatchEvent<Path> ev = (WatchEvent<Path>) event;
				            		        Path fileName = ev.context();
				            		 
				            		        System.out.println(kind.name() + ": " + fileName);
				            		 
				            		        if (kind == OVERFLOW) {
				            		            continue;
				            		        } 
				            		        else if (kind == ENTRY_CREATE || kind == ENTRY_DELETE || kind == ENTRY_MODIFY) {
				            		 
				            					
				            					LinkedList<Checks> fromFolder2 = new LinkedList<>();
				            					try {
				            						
					            					JOptionPane.showMessageDialog(frame, "The file folder has been changed");
					            					
					            					
					        						fromFolder2 = ws.filesReader(folder);
					        						lc.clear();
					        						lc.addAll(fromFolder2);

					        						for (int i = 0; i < lc.size(); i++) {

					        							lc.get(i).setBool(true);

					        						}

					        						LinkedList<Wifi> wifiFromFolder2 = rc.checksToWifi(lc);
					        						wifi.clear();
					        						wifi.addAll(wifiFromFolder2);

					        						System.out.println(lc.size());

					        						textField_lines.setText(Integer.toString(lc.size()));
					        						textField_networks.setText(Integer.toString(wifi.size()));
					        						
					        						
					            					
				            						
				            					} 
				            					catch (Exception e1) {
				            						
				            						return;
				            						
				            					}
				            					
				            		

				            					break;
				            		 
				            		        } 
				            		       
				            		    }
				            		 
				            		    // IMPORTANT: The key must be reset after processed
				            		    boolean valid = key.reset();
				            		    if (!valid) {
				            		        break;
				            		    }
				            		}
				            		
				   
				                    
				                }
				            }.start();
						
						


					}
				} catch (Exception FileNotFoundException) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();

					System.out.println("close please");
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

				textField_lines.setText("0");
				textField_networks.setText("0");

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
				chooser.setDialogTitle("Save as \"GuiCsv.csv\" ");
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
				
				String dir = null;

				
				JFileChooser chooser = new JFileChooser();
				chooser.setCurrentDirectory(new java.io.File("."));
				chooser.setDialogTitle("Save as \"toKmlGUI\" ");
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);

				if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					System.out.println("getCurrentDirectory(): " + chooser.getCurrentDirectory());
					System.out.println("getSelectedFile() : " + chooser.getSelectedFile());
					dir = chooser.getSelectedFile().getAbsolutePath() + "/";
				} else {
					System.out.println("No Selection ");
				}

				readCsvMatalaFormat rcmf = new readCsvMatalaFormat();
				LinkedList<Wifi> wifiList = rcmf.checksToWifi(lc);

				for (int i = 0; i < wifiList.size(); i++) {

					wifiList.get(i).setBool(true);
				}

				toKML tk = new toKML();
				try {
					tk.toKml(wifiList,dir+"toKmlGUI");
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
				chooser.setDialogTitle("Add csv file to database");
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
					lc.addAll(temp);

					LinkedList<Wifi> update = rc.checksToWifi(lc);
					wifi.clear();
					wifi.addAll(update);

					textField_lines.setText(Integer.toString(lc.size()));
					textField_networks.setText(Integer.toString(wifi.size()));

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

		final JRadioButton rdbtnTimeFilter = new JRadioButton("time filter");
		rdbtnTimeFilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnTimeFilter.setForeground(Color.BLUE);
		final JRadioButton rdbtnIDfilter = new JRadioButton("ID filter");
		rdbtnIDfilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtnIDfilter.setForeground(Color.BLUE);
		final JRadioButton rdbtLOCfilter = new JRadioButton("Loction filter by:");
		rdbtLOCfilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		rdbtLOCfilter.setForeground(Color.BLUE);

		final JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.BLUE);
		comboBox.setEnabled(false);
		comboBox.setToolTipText("Hour");

		comboBox.addItem("Hour");

		for (int i = 0; i < 24; i++) {
			comboBox.addItem(i);

		}

		comboBox.setBounds(262, 39, 57, 22);
		frame.getContentPane().add(comboBox);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setForeground(Color.BLUE);
		comboBox_1.setEnabled(false);
		comboBox_1.setToolTipText("Min");

		comboBox_1.addItem("Min");

		for (int i = 0; i < 60; i++) {
			comboBox_1.addItem(i);

		}

		comboBox_1.setBounds(328, 39, 57, 22);
		frame.getContentPane().add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
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
		txtpnMaxTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMaxTime.setEditable(false);
		txtpnMaxTime.setForeground(Color.BLUE);
		txtpnMaxTime.setText("Max Time: ");
		txtpnMaxTime.setBackground(SystemColor.menu);
		txtpnMaxTime.setBounds(182, 69, 77, 22);
		frame.getContentPane().add(txtpnMaxTime);

		final JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setForeground(Color.BLUE);
		comboBox_3.setEnabled(false);
		comboBox_3.setToolTipText("Hour");

		comboBox_3.addItem("Hour");

		for (int i = 0; i < 24; i++) {
			comboBox_3.addItem(i);

		}

		comboBox_3.setBounds(262, 69, 57, 22);
		frame.getContentPane().add(comboBox_3);

		final JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setForeground(Color.BLUE);
		comboBox_4.setEnabled(false);
		comboBox_4.setToolTipText("Min");

		comboBox_4.addItem("Min");

		for (int i = 0; i < 60; i++) {
			comboBox_4.addItem(i);

		}

		comboBox_4.setBounds(328, 69, 57, 22);
		frame.getContentPane().add(comboBox_4);

		final JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setForeground(Color.BLUE);
		comboBox_5.setEnabled(false);
		comboBox_5.setToolTipText("Sec");

		comboBox_5.addItem("Sec");

		for (int i = 0; i < 60; i++) {
			comboBox_5.addItem(i);

		}

		comboBox_5.setBounds(391, 69, 57, 22);
		frame.getContentPane().add(comboBox_5);

		final JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setForeground(Color.BLUE);
		comboBox_6.setToolTipText("Day");
		comboBox_6.setEnabled(false);

		comboBox_6.addItem("Day");

		for (int i = 1; i < 32; i++) {
			comboBox_6.addItem(i);
		}

		comboBox_6.setBounds(476, 39, 57, 22);
		frame.getContentPane().add(comboBox_6);

		final JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setForeground(Color.BLUE);
		comboBox_7.setToolTipText("Month");
		comboBox_7.setEnabled(false);

		comboBox_7.addItem("Month");

		for (int i = 1; i < 13; i++) {
			comboBox_7.addItem(i);
		}

		comboBox_7.setBounds(542, 39, 57, 22);
		frame.getContentPane().add(comboBox_7);

		final JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setForeground(Color.BLUE);
		comboBox_8.setToolTipText("Year");
		comboBox_8.setEnabled(false);

		comboBox_8.addItem("Year");

		for (int i = 2000; i < 2020; i++) {
			comboBox_8.addItem(i);
		}

		comboBox_8.setBounds(605, 39, 57, 22);
		frame.getContentPane().add(comboBox_8);

		final JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setForeground(Color.BLUE);
		comboBox_9.setToolTipText("Day");
		comboBox_9.setEnabled(false);

		comboBox_9.addItem("Day");

		for (int i = 1; i < 32; i++) {
			comboBox_9.addItem(i);
		}

		comboBox_9.setBounds(476, 69, 57, 22);
		frame.getContentPane().add(comboBox_9);

		final JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setForeground(Color.BLUE);
		comboBox_10.setToolTipText("Month");
		comboBox_10.setEnabled(false);

		comboBox_10.addItem("Month");

		for (int i = 1; i < 13; i++) {
			comboBox_10.addItem(i);
		}

		comboBox_10.setBounds(542, 69, 57, 22);
		frame.getContentPane().add(comboBox_10);

		final JComboBox comboBox_11 = new JComboBox();
		comboBox_11.setForeground(Color.BLUE);
		comboBox_11.setToolTipText("Year");
		comboBox_11.setEnabled(false);

		comboBox_11.addItem("Year");

		for (int i = 2000; i < 2020; i++) {
			comboBox_11.addItem(i);
		}

		comboBox_11.setBounds(605, 69, 57, 22);
		frame.getContentPane().add(comboBox_11);

		final TextField textField_UserName = new TextField();
		textField_UserName.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_UserName.setForeground(Color.BLUE);
		textField_UserName.setEnabled(false);
		textField_UserName.setBounds(242, 128, 251, 21);
		frame.getContentPane().add(textField_UserName);

		JTextPane txtpnMinTime = new JTextPane();
		txtpnMinTime.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMinTime.setEditable(false);
		txtpnMinTime.setForeground(Color.BLUE);
		txtpnMinTime.setBackground(UIManager.getColor("Button.background"));
		txtpnMinTime.setText("Min Time: ");
		txtpnMinTime.setBounds(182, 39, 68, 22);
		frame.getContentPane().add(txtpnMinTime);

		JTextPane txtpnUserName = new JTextPane();
		txtpnUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnUserName.setEditable(false);
		txtpnUserName.setForeground(Color.BLUE);
		txtpnUserName.setText("User name:");
		txtpnUserName.setBackground(SystemColor.menu);
		txtpnUserName.setBounds(160, 127, 77, 22);
		frame.getContentPane().add(txtpnUserName);

		JTextPane txtpnMinLat = new JTextPane();
		txtpnMinLat.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMinLat.setEditable(false);
		txtpnMinLat.setForeground(Color.BLUE);
		txtpnMinLat.setText("Min Lat: ");
		txtpnMinLat.setBackground(SystemColor.menu);
		txtpnMinLat.setBounds(160, 198, 70, 22);
		frame.getContentPane().add(txtpnMinLat);

		final TextField textField_latMin = new TextField();
		textField_latMin.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_latMin.setForeground(Color.BLUE);
		textField_latMin.setEnabled(false);
		textField_latMin.setBounds(235, 196, 77, 21);
		frame.getContentPane().add(textField_latMin);

		JTextPane txtpnMinLon = new JTextPane();
		txtpnMinLon.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMinLon.setEditable(false);
		txtpnMinLon.setForeground(Color.BLUE);
		txtpnMinLon.setText("Min Lon:");
		txtpnMinLon.setBackground(SystemColor.menu);
		txtpnMinLon.setBounds(160, 226, 70, 22);
		frame.getContentPane().add(txtpnMinLon);

		JTextPane txtpnMinAlt = new JTextPane();
		txtpnMinAlt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMinAlt.setEditable(false);
		txtpnMinAlt.setForeground(Color.BLUE);
		txtpnMinAlt.setText("Min Alt:");
		txtpnMinAlt.setBackground(SystemColor.menu);
		txtpnMinAlt.setBounds(160, 255, 70, 22);
		frame.getContentPane().add(txtpnMinAlt);

		final TextField textField_LonMin = new TextField();
		textField_LonMin.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_LonMin.setForeground(Color.BLUE);
		textField_LonMin.setEnabled(false);
		textField_LonMin.setBounds(235, 223, 77, 21);
		frame.getContentPane().add(textField_LonMin);

		final TextField textField_AltMin = new TextField();
		textField_AltMin.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_AltMin.setForeground(Color.BLUE);
		textField_AltMin.setEnabled(false);
		textField_AltMin.setBounds(235, 253, 77, 21);
		frame.getContentPane().add(textField_AltMin);

		JTextPane txtpnMaxLat = new JTextPane();
		txtpnMaxLat.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMaxLat.setEditable(false);
		txtpnMaxLat.setForeground(Color.BLUE);
		txtpnMaxLat.setText("Max Lat:");
		txtpnMaxLat.setBackground(SystemColor.menu);
		txtpnMaxLat.setBounds(338, 195, 72, 22);
		frame.getContentPane().add(txtpnMaxLat);

		final TextField textField_latMax = new TextField();
		textField_latMax.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_latMax.setForeground(Color.BLUE);
		textField_latMax.setEnabled(false);
		textField_latMax.setBounds(416, 196, 77, 21);
		frame.getContentPane().add(textField_latMax);

		JTextPane txtpnMaxLon = new JTextPane();
		txtpnMaxLon.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMaxLon.setEditable(false);
		txtpnMaxLon.setForeground(Color.BLUE);
		txtpnMaxLon.setText("Max Lon:");
		txtpnMaxLon.setBackground(SystemColor.menu);
		txtpnMaxLon.setBounds(338, 223, 75, 22);
		frame.getContentPane().add(txtpnMaxLon);

		JTextPane txtpnMaxAlt = new JTextPane();
		txtpnMaxAlt.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMaxAlt.setEditable(false);
		txtpnMaxAlt.setForeground(Color.BLUE);
		txtpnMaxAlt.setText("Max Alt:");
		txtpnMaxAlt.setBackground(SystemColor.menu);
		txtpnMaxAlt.setBounds(338, 252, 68, 22);
		frame.getContentPane().add(txtpnMaxAlt);

		final TextField textField_LonMax = new TextField();
		textField_LonMax.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_LonMax.setForeground(Color.BLUE);
		textField_LonMax.setEnabled(false);
		textField_LonMax.setBounds(416, 223, 77, 21);
		frame.getContentPane().add(textField_LonMax);

		final TextField textField_AltMax = new TextField();
		textField_AltMax.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_AltMax.setForeground(Color.BLUE);
		textField_AltMax.setEnabled(false);
		textField_AltMax.setBounds(416, 253, 77, 21);
		frame.getContentPane().add(textField_AltMax);

		JButton btnUnfilter = new JButton("Unfilter");
		btnUnfilter.setForeground(Color.BLUE);
		btnUnfilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (int i = 0; i < lc.size(); i++) {
					lc.get(i).setBool(false);
				}

				wifi = readCsvMatalaFormat.checksToWifi(lc);

				textField_lines.setText(Integer.toString(lc.size()));
				textField_networks.setText(Integer.toString(wifi.size()));

			}
		});
		btnUnfilter.setBounds(323, 290, 143, 41);
		frame.getContentPane().add(btnUnfilter);

		final JCheckBox chckbxLat = new JCheckBox("Lat");
		chckbxLat.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLat.setForeground(Color.BLUE);
		final JCheckBox chckbxLon = new JCheckBox("Lon");
		chckbxLon.setFont(new Font("Tahoma", Font.BOLD, 15));
		chckbxLon.setForeground(Color.BLUE);
		final JCheckBox checkbxAlt = new JCheckBox("Alt");
		checkbxAlt.setFont(new Font("Tahoma", Font.BOLD, 15));
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
		chckbxLat.setBounds(328, 164, 57, 25);
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
		chckbxLon.setBounds(385, 165, 63, 25);
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
		checkbxAlt.setBounds(444, 165, 49, 25);
		frame.getContentPane().add(checkbxAlt);

		final JCheckBox CheckBoxMinTime = new JCheckBox("");
		CheckBoxMinTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (CheckBoxMinTime.isSelected()) {
					comboBox.setEnabled(true);
					comboBox_1.setEnabled(true);
					comboBox_2.setEnabled(true);
					comboBox_6.setEnabled(true);
					comboBox_7.setEnabled(true);
					comboBox_8.setEnabled(true);
				}

				else {

					comboBox.setEnabled(false);
					comboBox_1.setEnabled(false);
					comboBox_2.setEnabled(false);
					comboBox_6.setEnabled(false);
					comboBox_7.setEnabled(false);
					comboBox_8.setEnabled(false);

				}

				/*
				 * comboBox_3.setEnabled(true); comboBox_4.setEnabled(true);
				 * comboBox_5.setEnabled(true);
				 */
				/*
				 * comboBox_9.setEnabled(true); comboBox_10.setEnabled(true);
				 * comboBox_11.setEnabled(true);
				 */

			}
		});
		CheckBoxMinTime.setEnabled(false);
		CheckBoxMinTime.setBounds(160, 39, 25, 25);
		frame.getContentPane().add(CheckBoxMinTime);

		final JCheckBox checkBoxMaxTime = new JCheckBox("");
		checkBoxMaxTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (checkBoxMaxTime.isSelected()) {
					comboBox_3.setEnabled(true);
					comboBox_4.setEnabled(true);
					comboBox_5.setEnabled(true);
					comboBox_9.setEnabled(true);
					comboBox_10.setEnabled(true);
					comboBox_11.setEnabled(true);
				}

				else {

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

		/////////////////// actions filters////////////////////////

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

		rdbtLOCfilter.setBounds(160, 164, 155, 25);
		frame.getContentPane().add(rdbtLOCfilter);
		
		final TextField textField_corFilter = new TextField();
		textField_corFilter.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_corFilter.setEnabled(false);
		textField_corFilter.setEditable(false);
		textField_corFilter.setBounds(140, 380, 353, 21);
		frame.getContentPane().add(textField_corFilter);

		///////////////////////// sumbit filters////////////////////

		JButton btnSumbitFilter = new JButton("Submit filter");
		btnSumbitFilter.setForeground(Color.BLUE);
		btnSumbitFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnTimeFilter.isSelected()) {

					boolean chooseMin = true;
					boolean chooseMax = true;

					if (CheckBoxMinTime.isSelected()) {

						if (comboBox.getSelectedIndex() == 0) {
							comboBox.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox.setBackground(new Color(240, 240, 240));

						}

						if (comboBox_1.getSelectedIndex() == 0) {
							comboBox_1.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox_1.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_2.getSelectedIndex() == 0) {
							comboBox_2.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox_2.setBackground(new Color(240, 240, 240));
						}

						if (comboBox_6.getSelectedIndex() == 0) {
							comboBox_6.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox_6.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_7.getSelectedIndex() == 0) {
							comboBox_7.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox_7.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_8.getSelectedIndex() == 0) {
							comboBox_8.setBackground(new Color(255, 0, 0));
							chooseMin = false;
						} else {
							comboBox_8.setBackground(new Color(240, 240, 240));
						}

						if (chooseMin == false) {
							return;
						}

						int minHour = (int) comboBox.getSelectedItem();
						int minMint = (int) comboBox_1.getSelectedItem();
						int minSec = (int) comboBox_2.getSelectedItem();

						int minYear = (int) comboBox_8.getSelectedItem();
						int minMonth = (int) comboBox_7.getSelectedItem();
						int minDay = (int) comboBox_6.getSelectedItem();

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

						Smin = SminY + "-" + SminMon + "-" + SminD + " " + SminH + ":" + SminM + ":" + SminS;
						
					}

					else {

						Smin = "1900-01-01 00-00-00";

					}

					if (checkBoxMaxTime.isSelected()) {

						if (comboBox_3.getSelectedIndex() == 0) {
							comboBox_3.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_3.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_4.getSelectedIndex() == 0) {
							comboBox_4.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_4.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_5.getSelectedIndex() == 0) {
							comboBox_5.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_5.setBackground(new Color(240, 240, 240));
						}

						if (comboBox_9.getSelectedIndex() == 0) {
							comboBox_9.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_9.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_10.getSelectedIndex() == 0) {
							comboBox_10.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_10.setBackground(new Color(240, 240, 240));
						}
						if (comboBox_11.getSelectedIndex() == 0) {
							comboBox_11.setBackground(new Color(255, 0, 0));
							chooseMax = false;
						} else {
							comboBox_11.setBackground(new Color(240, 240, 240));
						}

						if (chooseMax == false) {
							return;
						}

						int maxHour = (int) comboBox_3.getSelectedItem();
						int maxMint = (int) comboBox_4.getSelectedItem();
						int maxSec = (int) comboBox_5.getSelectedItem();

						int maxYear = (int) comboBox_11.getSelectedItem();
						int maxMonth = (int) comboBox_10.getSelectedItem();
						int maxDay = (int) comboBox_9.getSelectedItem();

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

						Smax = SmaxY + "-" + SmaxMon + "-" + SmaxD + " " + SmaxH + ":" + SmaxM + ":" + SmaxS;

					}

					else {

						Smax = "2100-12-31 23-59-59";

					}

					System.out.println(Smin);
					System.out.println(Smax);

					if (Smax.compareTo(Smin) < 0) {
						JOptionPane.showMessageDialog(frame, "The min time is greater than max time!");
					} else {

						timeFilter tf = new timeFilter(Smin, Smax);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = tf.test(lc.get(i));

							lc.get(i).setBool(ce);

							// System.out.println(ce);
						}

						wifi = readCsvMatalaFormat.checksToWifi(lc);

						time = tf;
						textField_corFilter.setText(time.toString());

					}
					
					
					
				}

				else if (rdbtnIDfilter.isSelected()) {

					if (textField_UserName.getText().isEmpty()) {
						textField_UserName.setBackground(new Color(255, 0, 0));
					}

					else {

						String id1 = textField_UserName.getText();

						IDfilter ifd = new IDfilter(id1);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = ifd.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

						wifi = readCsvMatalaFormat.checksToWifi(lc);

						id = ifd;
						textField_corFilter.setText(id.toString());


					}

				}

				else if (rdbtLOCfilter.isSelected()) {

					if (chckbxLat.isSelected()) {
						double min = 0;
						double max = 0;

						try {
							min = Double.parseDouble(textField_latMin.getText());

						} catch (Exception e1) {

							textField_latMin.setBackground(new Color(255, 0, 0));

						}

						try {
							max = Double.parseDouble(textField_latMax.getText());

						} catch (Exception e1) {

							textField_latMax.setBackground(new Color(255, 0, 0));

						}

						latFilter lat = new latFilter(min, max);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = lat.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

						lat0 = lat;

						wifi = readCsvMatalaFormat.checksToWifi(lc);
						textField_corFilter.setText(lat0.toString());


					}

					if (chckbxLon.isSelected()) {
						double min = 0;
						double max = 0;

						try {
							min = Double.parseDouble(textField_LonMin.getText());

						} catch (Exception e1) {

							textField_LonMin.setBackground(new Color(255, 0, 0));

						}

						try {
							max = Double.parseDouble(textField_LonMax.getText());

						} catch (Exception e1) {

							textField_LonMax.setBackground(new Color(255, 0, 0));

						}

						lonFilter lon = new lonFilter(min, max);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = lon.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

						lon0 = lon;
						wifi = readCsvMatalaFormat.checksToWifi(lc);
						textField_corFilter.setText(lon0.toString());


					}

					if (checkbxAlt.isSelected()) {
						double min = 0;
						double max = 0;

						try {
							min = Double.parseDouble(textField_AltMin.getText());

						} catch (Exception e1) {

							textField_AltMin.setBackground(new Color(255, 0, 0));

						}

						try {
							max = Double.parseDouble(textField_AltMax.getText());

						} catch (Exception e1) {

							textField_AltMax.setBackground(new Color(255, 0, 0));

						}

						altFilter alt = new altFilter(min, max);

						for (int i = 0; i < lc.size(); i++) {

							boolean ce = alt.test(lc.get(i));

							lc.get(i).setBool(ce);

							System.out.println(lc.get(i));
						}

						alt0 = alt;

						wifi = readCsvMatalaFormat.checksToWifi(lc);
						textField_corFilter.setText(alt0.toString());

					}

				}

				counters cu = new counters();
				int c = cu.boolCount(lc);

				textField_lines.setText(Integer.toString(c));

				int c2 = cu.boolCountWifi(wifi);

				textField_networks.setText(Integer.toString(c2));

			}
		});

		btnSumbitFilter.setBounds(160, 290, 143, 41);
		frame.getContentPane().add(btnSumbitFilter);

		final TextField textField_loadFilter = new TextField();
		textField_loadFilter.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_loadFilter.setEditable(false);
		textField_loadFilter.setEnabled(false);
		textField_loadFilter.setBounds(140, 407, 353, 21);
		frame.getContentPane().add(textField_loadFilter);

		JButton btnSendToFile = new JButton("load filter");
		btnSendToFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

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

				try {

					// read object from file
					FileInputStream fis = new FileInputStream(file);
					ObjectInputStream ois = new ObjectInputStream(fis);

					filter f = (filter) ois.readObject();

					if (f.getClass().getName().equals("linkedListFilters.timeFilter")) {
						timeLoad = (timeFilter) f;
						timeloadBool = true;
					} 
					else if(f.getClass().getName().equals("linkedListFilters.IDfilter")) {
						idLoad = (IDfilter) f;
						System.out.println(idLoad);
						idloadBool = true;
					}
					else if(f.getClass().getName().equals("linkedListFilters.latFilter")) {
						latLoad = (latFilter) f;
						latloadBool = true;
					}
					else if(f.getClass().getName().equals("linkedListFilters.lonFilter")) {
						lonLoad = (lonFilter) f;
						lonloadBool = true;
					}
					else if(f.getClass().getName().equals("linkedListFilters.altFilter")) {
						altLoad = (altFilter) f;
						altloadBool = true;
					}
					else{
						System.out.println(f.getClass().getName());
					}

					ois.close();

					textField_loadFilter.setText(f.toString());

				} catch (Exception e1) {
					// TODO: handle exception
				}

			}

		});
		btnSendToFile.setForeground(Color.BLUE);
		btnSendToFile.setBounds(323, 334, 143, 41);
		frame.getContentPane().add(btnSendToFile);

		JButton btnSaveFilter = new JButton("Save filter");
		btnSaveFilter.setForeground(Color.BLUE);
		btnSaveFilter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnTimeFilter.isSelected()) {

					String dir = null;

					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Save as \"time.filter\" ");
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

						// write object to file
						FileOutputStream fos = new FileOutputStream(dir + "time.filter");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(time);
						oos.close();

					} catch (Exception e1) {
						// TODO: handle exception
					}

				}

				else if (rdbtnIDfilter.isSelected()) {

					String dir = null;

					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new java.io.File("."));
					chooser.setDialogTitle("Save as \"id.filter\" ");
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

						// write object to file
						FileOutputStream fos = new FileOutputStream(dir + "id.filter");
						ObjectOutputStream oos = new ObjectOutputStream(fos);
						oos.writeObject(id);
						oos.close();

					} catch (Exception e1) {
						// TODO: handle exception
					}

				}

				else if (rdbtLOCfilter.isSelected()) {

					if (chckbxLat.isSelected()) {

						String dir = null;

						JFileChooser chooser = new JFileChooser();
						chooser.setCurrentDirectory(new java.io.File("."));
						chooser.setDialogTitle("Save as \"lat.filter\" ");
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

							// write object to file
							FileOutputStream fos = new FileOutputStream(dir + "lat.filter");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(lat0);
							oos.close();

						} catch (Exception e1) {
							// TODO: handle exception
						}

					} else if (chckbxLon.isSelected()) {

						String dir = null;

						JFileChooser chooser = new JFileChooser();
						chooser.setCurrentDirectory(new java.io.File("."));
						chooser.setDialogTitle("Save as \"lon.filter\" ");
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

							// write object to file
							FileOutputStream fos = new FileOutputStream(dir + "lon.filter");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(lon0);
							oos.close();

						} catch (Exception e1) {
							// TODO: handle exception
						}

					}

					if (checkbxAlt.isSelected()) {

						String dir = null;

						JFileChooser chooser = new JFileChooser();
						chooser.setCurrentDirectory(new java.io.File("."));
						chooser.setDialogTitle("Save as \"alt.filter\" ");
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

							// write object to file
							FileOutputStream fos = new FileOutputStream(dir + "alt.filter");
							ObjectOutputStream oos = new ObjectOutputStream(fos);
							oos.writeObject(alt0);
							oos.close();

						} catch (Exception e1) {
							// TODO: handle exception
						}

					}

				}

				/*
				 * if(filterType==""){ JOptionPane.showMessageDialog(frame,
				 * "Please submit the filter before");
				 * 
				 * return;
				 * 
				 * }
				 * 
				 * JFileChooser chooser = new JFileChooser();
				 * chooser.setCurrentDirectory(new java.io.File("."));
				 * chooser.setDialogTitle("choosertitle");
				 * chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				 * chooser.setAcceptAllFileFilterUsed(false); String dir = null;
				 * 
				 * if (chooser.showOpenDialog(null) ==
				 * JFileChooser.APPROVE_OPTION) {
				 * System.out.println("getCurrentDirectory(): " +
				 * chooser.getCurrentDirectory());
				 * System.out.println("getSelectedFile() : " +
				 * chooser.getSelectedFile()); dir =
				 * chooser.getSelectedFile().getAbsolutePath() + "/"; } else {
				 * System.out.println("No Selection "); }
				 * 
				 * try { PrintWriter pw = new PrintWriter(new File(dir +
				 * "fil.filter")); StringBuilder writer = new StringBuilder();
				 * 
				 * writer.append(filterType);
				 * 
				 * pw.write(writer.toString()); pw.close();
				 * 
				 * } catch (FileNotFoundException e2) { // TODO Auto-generated
				 * catch block e2.printStackTrace(); }
				 */

			}

		});
		btnSaveFilter.setBounds(160, 334, 143, 41);
		frame.getContentPane().add(btnSaveFilter);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(96, 376, 16, -6);
		frame.getContentPane().add(btnNewButton);

		final TextField textField_1 = new TextField();
		textField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField_1.setBounds(819, 39, 153, 21);
		frame.getContentPane().add(textField_1);

		JTextPane txtpnMac = new JTextPane();
		txtpnMac.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMac.setForeground(Color.BLUE);
		txtpnMac.setEditable(false);
		txtpnMac.setText("Enter MAC address:");
		txtpnMac.setBackground(SystemColor.menu);
		txtpnMac.setBounds(688, 39, 125, 22);
		frame.getContentPane().add(txtpnMac);

		JTextPane txtpnMac_1 = new JTextPane();
		txtpnMac_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMac_1.setEditable(false);
		txtpnMac_1.setForeground(Color.BLUE);
		txtpnMac_1.setText("mac 1:");
		txtpnMac_1.setBackground(SystemColor.menu);
		txtpnMac_1.setBounds(539, 220, 57, 22);
		frame.getContentPane().add(txtpnMac_1);

		final TextField textField_algo2_mac1 = new TextField();
		textField_algo2_mac1.setEnabled(false);
		textField_algo2_mac1.setBounds(594, 220, 148, 21);
		frame.getContentPane().add(textField_algo2_mac1);

		JTextPane txtpnMac_2 = new JTextPane();
		txtpnMac_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMac_2.setForeground(Color.BLUE);
		txtpnMac_2.setEditable(false);
		txtpnMac_2.setText("mac 2:");
		txtpnMac_2.setBackground(SystemColor.menu);
		txtpnMac_2.setBounds(539, 248, 57, 22);
		frame.getContentPane().add(txtpnMac_2);

		JTextPane txtpnMac_3 = new JTextPane();
		txtpnMac_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnMac_3.setForeground(Color.BLUE);
		txtpnMac_3.setEditable(false);
		txtpnMac_3.setText("mac 3:");
		txtpnMac_3.setBackground(SystemColor.menu);
		txtpnMac_3.setBounds(539, 277, 57, 22);
		frame.getContentPane().add(txtpnMac_3);

		final TextField textField_algo2_mac2 = new TextField();
		textField_algo2_mac2.setEnabled(false);
		textField_algo2_mac2.setBounds(594, 248, 148, 21);
		frame.getContentPane().add(textField_algo2_mac2);

		final TextField textField_algo2_mac3 = new TextField();
		textField_algo2_mac3.setEnabled(false);
		textField_algo2_mac3.setBounds(594, 277, 148, 21);
		frame.getContentPane().add(textField_algo2_mac3);

		JTextPane txtpnSig = new JTextPane();
		txtpnSig.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnSig.setForeground(Color.BLUE);
		txtpnSig.setEditable(false);
		txtpnSig.setText("sig 1:");
		txtpnSig.setBackground(SystemColor.menu);
		txtpnSig.setBounds(764, 221, 50, 22);
		frame.getContentPane().add(txtpnSig);

		final TextField textField_algo2_sig1 = new TextField();
		textField_algo2_sig1.setEnabled(false);
		textField_algo2_sig1.setBounds(824, 221, 148, 21);
		frame.getContentPane().add(textField_algo2_sig1);

		JTextPane txtpnSig_1 = new JTextPane();
		txtpnSig_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnSig_1.setForeground(Color.BLUE);
		txtpnSig_1.setEditable(false);
		txtpnSig_1.setText("sig 2:");
		txtpnSig_1.setBackground(SystemColor.menu);
		txtpnSig_1.setBounds(764, 249, 50, 22);
		frame.getContentPane().add(txtpnSig_1);

		JTextPane txtpnSig_2 = new JTextPane();
		txtpnSig_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnSig_2.setForeground(Color.BLUE);
		txtpnSig_2.setEditable(false);
		txtpnSig_2.setText("sig 3:");
		txtpnSig_2.setBackground(SystemColor.menu);
		txtpnSig_2.setBounds(764, 277, 49, 22);
		frame.getContentPane().add(txtpnSig_2);

		final TextField textField_algo2_sig2 = new TextField();
		textField_algo2_sig2.setEnabled(false);
		textField_algo2_sig2.setBounds(824, 249, 148, 21);
		frame.getContentPane().add(textField_algo2_sig2);

		final TextField textField_algo2_sig3 = new TextField();
		textField_algo2_sig3.setEnabled(false);
		textField_algo2_sig3.setBounds(824, 278, 148, 21);
		frame.getContentPane().add(textField_algo2_sig3);
		final JRadioButton radioButton_algo2B = new JRadioButton("Enter string:");
		radioButton_algo2B.setFont(new Font("Tahoma", Font.BOLD, 15));
		radioButton_algo2B.setForeground(Color.BLUE);
		final TextField textField_algo2bInput = new TextField();

		final JRadioButton radioButton_algo2A = new JRadioButton("");
		radioButton_algo2A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				radioButton_algo2B.setSelected(false);
				textField_algo2_mac1.setEnabled(true);
				textField_algo2_mac2.setEnabled(true);
				textField_algo2_mac3.setEnabled(true);
				textField_algo2_sig1.setEnabled(true);
				textField_algo2_sig2.setEnabled(true);
				textField_algo2_sig3.setEnabled(true);
				textField_algo2bInput.setEnabled(false);

			}
		});
		radioButton_algo2A.setForeground(Color.BLUE);
		radioButton_algo2A.setBounds(539, 195, 31, 25);
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
				textField_algo2bInput.setEnabled(true);

			}
		});
		radioButton_algo2B.setBounds(539, 323, 155, 21);
		frame.getContentPane().add(radioButton_algo2B);

		textField_algo2bInput.setEnabled(false);
		textField_algo2bInput.setBounds(539, 358, 433, 21);
		frame.getContentPane().add(textField_algo2bInput);

		final TextField textField_algo1lon = new TextField();
		textField_algo1lon.setFont(new Font("Dialog", Font.BOLD, 16));
		textField_algo1lon.setEnabled(false);
		textField_algo1lon.setEditable(false);
		textField_algo1lon.setBounds(819, 102, 153, 21);
		frame.getContentPane().add(textField_algo1lon);

		final TextField textField_algo1alt = new TextField();
		textField_algo1alt.setFont(new Font("Dialog", Font.BOLD, 16));
		textField_algo1alt.setEnabled(false);
		textField_algo1alt.setEditable(false);
		textField_algo1alt.setBounds(819, 130, 153, 21);
		frame.getContentPane().add(textField_algo1alt);

		final TextField textField_algo1lat = new TextField();
		textField_algo1lat.setFont(new Font("Dialog", Font.BOLD, 16));
		textField_algo1lat.setEditable(false);
		textField_algo1lat.setEnabled(false);
		textField_algo1lat.setBounds(819, 73, 153, 21);
		frame.getContentPane().add(textField_algo1lat);

		JButton btnSubmit = new JButton("find loction");
		btnSubmit.setForeground(Color.BLUE);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MatrixSortByMAC ms = new MatrixSortByMAC();
				String mac = textField_1.getText();

				LinkedList<Wifi> algo1List = ms.findMac(wifi, mac);

				ms.sortBySignal(algo1List);

				System.out.println("size:" + wifi.size());

				Wifi w = algo1.Waverage(algo1List);

				// להחזיר מיקום
				System.out.println(w.getAlt());

				textField_algo1lat.setText(Double.toString(w.getLat()));
				textField_algo1lon.setText(Double.toString(w.getLon()));
				textField_algo1alt.setText(Double.toString(w.getAlt()));

			}
		});
		btnSubmit.setBounds(688, 73, 108, 78);
		frame.getContentPane().add(btnSubmit);

		final TextField textField_algo2lat = new TextField();
		textField_algo2lat.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_algo2lat.setEnabled(false);
		textField_algo2lat.setEditable(false);
		textField_algo2lat.setBounds(673, 397, 155, 21);
		frame.getContentPane().add(textField_algo2lat);

		final TextField textField_algo2lon = new TextField();
		textField_algo2lon.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_algo2lon.setEnabled(false);
		textField_algo2lon.setEditable(false);
		textField_algo2lon.setBounds(673, 426, 155, 21);
		frame.getContentPane().add(textField_algo2lon);

		final TextField textField_algo2alt = new TextField();
		textField_algo2alt.setFont(new Font("Dialog", Font.BOLD, 12));
		textField_algo2alt.setEnabled(false);
		textField_algo2alt.setEditable(false);
		textField_algo2alt.setBounds(673, 454, 155, 21);
		frame.getContentPane().add(textField_algo2alt);

		JButton btnSubmitAkgo = new JButton("Find loction");
		btnSubmitAkgo.setForeground(Color.BLUE);
		btnSubmitAkgo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (radioButton_algo2A.isSelected()) {

					algo2 al2 = new algo2();
					LinkedList<Checks> lcFiltered = new LinkedList<>();

					for (int i = 0; i < lc.size(); i++) {

						if (lc.get(i).isBool()) {
							lcFiltered.add(lc.get(i));
						}

					}

					System.out.println(lcFiltered.size());

					System.out.println(Integer.getInteger(textField_algo2_sig1.getText()));

					int sig1 = Integer.parseInt(textField_algo2_sig1.getText());
					int sig2 = Integer.parseInt(textField_algo2_sig2.getText());
					int sig3 = Integer.parseInt(textField_algo2_sig3.getText());

					double[] arr = al2.wImg(lcFiltered, textField_algo2_mac1.getText(), textField_algo2_mac2.getText(),
							textField_algo2_mac3.getText(), sig1, sig2, sig3);

					textField_algo2lat.setText(Double.toString(arr[0]));
					textField_algo2lon.setText(Double.toString(arr[1]));
					textField_algo2alt.setText(Double.toString(arr[2]));

				}
				
				if(radioButton_algo2B.isSelected()){
					
					//2017-10-27 16:16:45,SHIELD Tablet,32.16766121892341,34.80988155918773,39.018065819940986,10,
					//HOTBOX-D1D7,fc:b4:e6:cf:d1:dd,1,-77,888Corp,0a:8d:db:6e:71:6d,1,-79,888Guest,02:8d:db:6e:71:bf,1,-80,
					//888Free,06:8d:db:6e:71:6d,1,-81,888Guest,02:8d:db:6e:71:6d,1,-81,Mouly,7c:b7:33:2e:76:73,11,-83,
					//888Corp,0a:8d:db:6e:71:bf,1,-86,888Free,06:8d:db:6e:71:bf,1,-86,,06:8d:db:6e:71:be,11,-86,,02:8d:db:6e:71:be,11,-86,

					
					
					String str = textField_algo2bInput.getText();
					
					Checks a = readCsvMatalaFormat.StringToChecks(str);
					
					
					System.out.println(a);
					
					Checks b = algo2.wifiSort_SortbySignal(a);
					
					System.out.println(b);
					
					String mac1 = "";
					String mac2 = "";
					String mac3 = "";

					int signal1 = 0;
					int signal2 = 0;
					int signal3 = 0;
					
					if(b.getWifi1()!=null){
						mac1 = b.getWifi1().getMac();
						signal1 = b.getWifi1().getSignal();
					}
					else{
						mac1 = null;	
					}
					if(b.getWifi2()!=null){
						mac2 = b.getWifi2().getMac();
						signal2 = b.getWifi2().getSignal();

					}
					else{
						mac2 = null;	
					}
					if(b.getWifi3()!=null){
						mac3 = b.getWifi3().getMac();
						signal3 = b.getWifi3().getSignal();

					}
					else{
						mac3 = null;	
					}
					
					try{
					double[] coor = algo2.wImg(lc,mac1, mac2, mac3, signal1, signal2, signal3);
					
					textField_algo2lat.setText(Double.toString(coor[0]));
					textField_algo2lon.setText(Double.toString(coor[1]));
					textField_algo2alt.setText(Double.toString(coor[2]));
					
					}
					catch (Exception IndexOutOfBoundsException) {
						
						JOptionPane.showMessageDialog(frame, "The database is empty, please import files");

						
					}
					
					
					
					
					
					
					
				}

			}
		});
		btnSubmitAkgo.setBounds(539, 397, 108, 78);
		frame.getContentPane().add(btnSubmitAkgo);

		JTextPane algo2text = new JTextPane();
		algo2text.setFont(new Font("Tahoma", Font.BOLD, 15));
		algo2text.setText("Algorithm 2:");
		algo2text.setForeground(Color.BLUE);
		algo2text.setBackground(SystemColor.menu);
		algo2text.setBounds(539, 164, 125, 22);
		frame.getContentPane().add(algo2text);

		JTextPane txtpnAlgo = new JTextPane();
		txtpnAlgo.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnAlgo.setEditable(false);
		txtpnAlgo.setText("Algorithm 1:");
		txtpnAlgo.setForeground(Color.BLUE);
		txtpnAlgo.setBackground(SystemColor.menu);
		txtpnAlgo.setBounds(688, 9, 108, 22);
		frame.getContentPane().add(txtpnAlgo);

		JList list = new JList();
		list.setBounds(124, 292, -84, -276);
		frame.getContentPane().add(list);

		JButton Andfilters = new JButton("\"And\" filters");
		Andfilters.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (rdbtnTimeFilter.isSelected()) {

					if (timeloadBool) {
						
						System.out.println("time is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = timeLoad.test(c);
								c.setBool(a);
							}
						}

					} 
					else if (idloadBool) {
						
						System.out.println("id is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = idLoad.test(c);
								c.setBool(a);
							}
						}

					}
					else if (latloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = latLoad.test(c);
								c.setBool(a);
							}
						}

					}
					else if (lonloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = lonLoad.test(c);
								c.setBool(a);
							}
						}

					}
					else if (altloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = altLoad.test(c);
								c.setBool(a);
							}
						}

					}

				}

				else if (rdbtnIDfilter.isSelected()) {

					if (timeloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = timeLoad.test(c);
								c.setBool(a);

							}

						}

					}

				}

				int lin = counters.boolCount(lc);

				System.out.println("lin" + lin);

				textField_lines.setText(Integer.toString(lin));

				LinkedList<Wifi> update2 = readCsvMatalaFormat.checksToWifi(lc);
				wifi.clear();
				wifi.addAll(update2);

				textField_networks.setText(Integer.toString(wifi.size()));

			}
		});
		Andfilters.setForeground(Color.BLUE);
		Andfilters.setBounds(160, 434, 143, 41);
		frame.getContentPane().add(Andfilters);
		
		JButton btnorFilters = new JButton("\"Or\" filters");
		btnorFilters.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				if (rdbtnTimeFilter.isSelected()) {

					if (timeloadBool) {
						
						System.out.println("time is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool() || timeLoad.test(c)) {
								c.setBool(true);
							}
						}

					} 
					else if (idloadBool) {
						
						System.out.println("id is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool() || idLoad.test(c)) {
								c.setBool(true);
							}
						}

					}
					else if (latloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool() || latLoad.test(c)) {
								c.setBool(true);
							}
						}

					}
					else if (lonloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool() || lonLoad.test(c)) {
								c.setBool(true);
							}
						}

					}
					else if (altloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool() || altLoad.test(c)) {
								c.setBool(true);
							}
						}

					}

				}

				else if (rdbtnIDfilter.isSelected()) {

					if (timeloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = timeLoad.test(c);
								c.setBool(a);

							}

						}

					}

				}

				int lin = counters.boolCount(lc);

				System.out.println("lin" + lin);

				textField_lines.setText(Integer.toString(lin));

				LinkedList<Wifi> update2 = readCsvMatalaFormat.checksToWifi(lc);
				wifi.clear();
				wifi.addAll(update2);

				textField_networks.setText(Integer.toString(wifi.size()));
				
			}
		});
		btnorFilters.setForeground(Color.BLUE);
		btnorFilters.setBounds(323, 434, 143, 41);
		frame.getContentPane().add(btnorFilters);
		
		JButton button_notFolter = new JButton("The current filter without the imported");
		button_notFolter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (rdbtnTimeFilter.isSelected()) {

					if (timeloadBool) {
						
						System.out.println("time is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = timeLoad.test(c);
								c.setBool(!a);
							}
						}

					} 
					else if (idloadBool) {
						
						System.out.println("id is true");

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = idLoad.test(c);
								c.setBool(!a);
							}
						}

					}
					else if (latloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = latLoad.test(c);
								c.setBool(!a);
							}
						}

					}
					else if (lonloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = lonLoad.test(c);
								c.setBool(!a);
							}
						}

					}
					else if (altloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = altLoad.test(c);
								c.setBool(!a);
							}
						}

					}

				}

				else if (rdbtnIDfilter.isSelected()) {

					if (timeloadBool) {

						for (int i = 0; i < lc.size(); i++) {

							Checks c = lc.get(i);

							if (c.isBool()) {
								boolean a = timeLoad.test(c);
								c.setBool(!a);

							}

						}

					}

				}

				int lin = counters.boolCount(lc);

				System.out.println("lin" + lin);

				textField_lines.setText(Integer.toString(lin));

				LinkedList<Wifi> update2 = readCsvMatalaFormat.checksToWifi(lc);
				wifi.clear();
				wifi.addAll(update2);

				textField_networks.setText(Integer.toString(wifi.size()));
				
			}
		});
		button_notFolter.setForeground(Color.BLUE);
		button_notFolter.setBounds(160, 488, 306, 41);
		frame.getContentPane().add(button_notFolter);
		
		
		
		JTextPane txtpnCurrectFilter = new JTextPane();
		txtpnCurrectFilter.setText("Currect filter:");
		txtpnCurrectFilter.setForeground(Color.BLUE);
		txtpnCurrectFilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnCurrectFilter.setBackground(SystemColor.menu);
		txtpnCurrectFilter.setBounds(0, 381, 117, 22);
		frame.getContentPane().add(txtpnCurrectFilter);
		
		JTextPane txtpnImprotedFilter = new JTextPane();
		txtpnImprotedFilter.setText("Improted filter:");
		txtpnImprotedFilter.setForeground(Color.BLUE);
		txtpnImprotedFilter.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnImprotedFilter.setBackground(SystemColor.menu);
		txtpnImprotedFilter.setBounds(0, 405, 134, 22);
		frame.getContentPane().add(txtpnImprotedFilter);
		
		JTextPane txtpnIp = new JTextPane();
		txtpnIp.setText("IP:");
		txtpnIp.setForeground(Color.BLUE);
		txtpnIp.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnIp.setEditable(false);
		txtpnIp.setBackground(SystemColor.menu);
		txtpnIp.setBounds(12, 542, 57, 22);
		frame.getContentPane().add(txtpnIp);
		
		final TextField textField_IP = new TextField();
		textField_IP.setBounds(126, 543, 148, 21);
		frame.getContentPane().add(textField_IP);
		
		JTextPane txtpnUser = new JTextPane();
		txtpnUser.setText("USER:");
		txtpnUser.setForeground(Color.BLUE);
		txtpnUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnUser.setEditable(false);
		txtpnUser.setBackground(SystemColor.menu);
		txtpnUser.setBounds(12, 570, 57, 22);
		frame.getContentPane().add(txtpnUser);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("PASSWORD:");
		txtpnPassword.setForeground(Color.BLUE);
		txtpnPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(SystemColor.menu);
		txtpnPassword.setBounds(12, 599, 100, 22);
		frame.getContentPane().add(txtpnPassword);
		
		final TextField textField_USER = new TextField();
		textField_USER.setBounds(126, 571, 148, 21);
		frame.getContentPane().add(textField_USER);
		
		final TextField textField_PASS = new TextField();
		textField_PASS.setBounds(126, 600, 148, 21);
		frame.getContentPane().add(textField_PASS);
		
		JTextPane txtpnTable = new JTextPane();
		txtpnTable.setText("TABLE:");
		txtpnTable.setForeground(Color.BLUE);
		txtpnTable.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnTable.setEditable(false);
		txtpnTable.setBackground(SystemColor.menu);
		txtpnTable.setBounds(12, 682, 100, 22);
		frame.getContentPane().add(txtpnTable);
		
		JTextPane txtpnDatabase_1 = new JTextPane();
		txtpnDatabase_1.setText("DATABASE:");
		txtpnDatabase_1.setForeground(Color.BLUE);
		txtpnDatabase_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnDatabase_1.setEditable(false);
		txtpnDatabase_1.setBackground(SystemColor.menu);
		txtpnDatabase_1.setBounds(12, 653, 100, 22);
		frame.getContentPane().add(txtpnDatabase_1);
		
		JTextPane txtpnDatabase = new JTextPane();
		txtpnDatabase.setText("PORT:");
		txtpnDatabase.setForeground(Color.BLUE);
		txtpnDatabase.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtpnDatabase.setEditable(false);
		txtpnDatabase.setBackground(SystemColor.menu);
		txtpnDatabase.setBounds(12, 625, 100, 22);
		frame.getContentPane().add(txtpnDatabase);
		
		final TextField textField_PORT = new TextField();
		textField_PORT.setBounds(126, 626, 148, 21);
		frame.getContentPane().add(textField_PORT);
		
		final TextField textField_DB = new TextField();
		textField_DB.setBounds(126, 654, 148, 21);
		frame.getContentPane().add(textField_DB);
		
		final TextField textField_TABLE = new TextField();
		textField_TABLE.setBounds(126, 683, 148, 21);
		frame.getContentPane().add(textField_TABLE);
		
		JButton btnConnectToDb = new JButton("GET DATA FROM SQL");
		btnConnectToDb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				boolean empty = false;
				
				String ip = null;
				String user = null;
				String pass = null;
				int port = 0;
				String db = null;
				String table = null;
				
				mySQL ms = new mySQL();
				LinkedList<Checks> fromSQL = new LinkedList<>();
				
				try{
					if(textField_IP.getText().isEmpty()){
						textField_IP.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						ip = textField_IP.getText();
					}
										
					if(textField_USER.getText().isEmpty()){
						textField_USER.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						user = textField_USER.getText();
					}
										
					if(textField_PASS.getText().isEmpty()){
						textField_PASS.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						pass = textField_PASS.getText();
					}
					
					if(textField_PORT.getText().isEmpty()){
						textField_PORT.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						port = Integer.parseInt(textField_PORT.getText());
					}

					if(textField_DB.getText().isEmpty()){
						textField_DB.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						db = textField_DB.getText();
					}

					if(textField_TABLE.getText().isEmpty()){
						textField_TABLE.setBackground(new Color(255, 0, 0));
						empty = true;
					}
					else{
						table = textField_TABLE.getText();
					}
					
					
					
					
				}
				catch (Exception e) {
					// TODO: handle exception
				}
				
				if(!empty){
					try{
						fromSQL = ms.sqlConnectGui(ip, user, pass, port, db, table);
						if(fromSQL==null){
							JOptionPane.showMessageDialog(frame, "Error, please check your connection details");
						}
						
						lc.addAll(fromSQL);
						
						LinkedList<Wifi> update = readCsvMatalaFormat.checksToWifi(lc);
						wifi.clear();
						wifi.addAll(update);

						textField_lines.setText(Integer.toString(lc.size()));
						textField_networks.setText(Integer.toString(wifi.size()));
						
					}
					catch (Exception CommunicationsException) {
						JOptionPane.showMessageDialog(frame, "Error, please check your connection details");
						}
				}
				else{
					JOptionPane.showMessageDialog(frame, "Missing fields!");
				}
				
				
				
				
				
				
				
			}
		});
		btnConnectToDb.setForeground(Color.BLUE);
		btnConnectToDb.setBounds(12, 710, 262, 41);
		frame.getContentPane().add(btnConnectToDb);

	}
}
