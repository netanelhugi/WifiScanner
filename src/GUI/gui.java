package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JFileChooser;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import mainPackage.WifiScanner;

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
import myObjects.*;

public class gui {

	private JFrame frame;

	LinkedList<Checks> lc = new LinkedList<>();
	
	
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Button button = new Button("Choose folder");
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
				} else {
				  System.out.println("No Selection ");
				}
				System.out.println(folder);
				WifiScanner ws = new WifiScanner();
				readCsvMatalaFormat rc = new readCsvMatalaFormat();
				try {
					lc = ws.filesReader(folder);
					
					for(int i=0; i<lc.size(); i++){
						System.out.println(lc.get(i));
					}
					
					
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button.setBounds(0, 0, 78, 21);
		frame.getContentPane().add(button);
		
		Button button_1 = new Button("Clean data");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setBounds(0, 51, 78, 21);
		frame.getContentPane().add(button_1);
		
		Button button_2 = new Button("to csv");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				toCSV tc = new toCSV();
				try {
					tc.toCsvFromList(lc);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		button_2.setBounds(0, 78, 78, 21);
		frame.getContentPane().add(button_2);
		
		Button button_3 = new Button("to kml");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_3.setBounds(0, 106, 78, 21);
		frame.getContentPane().add(button_3);
		
		Button button_4 = new Button("Add csv file");
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
		button_4.setBounds(0, 24, 78, 21);
		frame.getContentPane().add(button_4);
	}
}
