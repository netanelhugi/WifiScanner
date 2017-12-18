package algorithms;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

import javax.security.auth.callback.LanguageCallback;
import matala.*;

// TODO: Auto-generated Javadoc
/**
 * The Class algo2Testing.
 */
public class algo2Testing {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

		String test1 = "C:\\wifiscanner\\boaztest\\test\\algo2\\_comb_no_gps_ts1_.csv";
		String test2 = "C:\\wifiscanner\\boaztest\\test\\algo2\\_comb_no_gps_ts2_.csv";
		
		String input1 = "C:\\wifiscanner\\boaztest\\input\\algo2\\_comb_all_BM2_.csv";
		String input2 = "C:\\wifiscanner\\boaztest\\input\\algo2\\_comb_all_BM3_.csv";



		readCsvMatalaFormat rc = new readCsvMatalaFormat();
	
		LinkedList<Checks> lc = rc.CsvToList(input2);
		LinkedList<Checks> ll = rc.CsvToList(test2);

		
		algo2 al2 = new algo2();
				
		LinkedList<double[]> coorlist = new LinkedList<>();
				
		for(int i=0; i<ll.size(); i++){
			double[] a = al2.wImg(lc,ll.get(i).getWifi1().getMac(), ll.get(i).getWifi2().getMac(),ll.get(i).getWifi3().getMac(),ll.get(i).getWifi1().getSignal(),ll.get(i).getWifi2().getSignal(),ll.get(i).getWifi3().getSignal());
			coorlist.add(a);
		}
		
		algo2print(coorlist);
	
	}
	
	/**
	 * Algo 2 print.
	 *
	 * @param a the a
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void algo2print(LinkedList<double[]> a) throws FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(new File("coor.csv"));
		StringBuilder writer = new StringBuilder();
		
		try {
			
			for(int i=0; i<a.size(); i++){
				
				writer.append(a.get(i)[0]);
				writer.append(",");
				writer.append(a.get(i)[1]);
				writer.append(",");
				writer.append(a.get(i)[2]);
				writer.append('\n');

				
			}
	
		}

		finally {
		}

		pw.write(writer.toString());
		pw.close();
		
	}
	
}
