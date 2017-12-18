/*
 * 
 */
package mainPackage;

import java.io.IOException;
import filters.*;
import java.util.LinkedList;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class main.
 */
public class main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws Exception the exception
	 */
	public static void main(String[] args) throws Exception {

		filters filter = new filters();
		String folder = "c:\\wifiScanner";

		WifiScanner ws = new WifiScanner();
		ws.filesReader(folder);
		

		String name = "C:\\Users\\netan\\workspace\\Object-Oriented-Programming\\WifiScanner.csv";
		//_comb_all_BM2_
		
		
		
		 filter.IDFilter(name,"SHIELD Tablet") ;
		 //filter.timeFilter(name, 16, 16);
		 //filter.dateFilter(name, 27, 10, 2017);
		 //filter.UnFilter(name);
		 //filter.locFilter(32.16766121892341,34.80988155918773, name);
		 
		


	}

	
}
