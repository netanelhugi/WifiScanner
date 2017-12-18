package algorithms;

import java.io.File;
import matala.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class algo1Testing.
 */
public class algo1Testing {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		String test1 = "C:\\wifiscanner\\boaztest\\test\\algo1\\_comb_all_BM3_.csv";
		
		readCsvMatalaFormat r = new readCsvMatalaFormat();		
		String[][] arr = r.ReadFile(test1);
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = "true";
		}
		
		LinkedList<Wifi> wlist = r.wifiMatrix(arr);
		
		MatrixSortByMAC ms = new MatrixSortByMAC();
		
		ms.sortByMac(wlist);
		
		for(int i=0; i<wlist.size(); i++){
			//System.out.println(wlist.get(i));
		}
		
		LinkedList<Wifi> ans = new LinkedList<>();
		
		algo1 al1 = new algo1();
				
		ans = al1.bestSignal(wlist);
		ms.sortByMac(ans);

		for(int i=0; i<ans.size(); i++){
			System.out.println(ans.get(i));
		}
		
		algo1print(ans);


	}
	
/**
 * Algo 1 print.
 *
 * @param a the a
 * @throws FileNotFoundException the file not found exception
 */
public static void algo1print(LinkedList<Wifi> a) throws FileNotFoundException{
		
		PrintWriter pw = new PrintWriter(new File("test1-algo1.csv"));
		StringBuilder writer = new StringBuilder();
		
		try {
			
			for(int i=0; i<a.size(); i++){
				
				writer.append(i);
				writer.append(",");
				writer.append(a.get(i).getMac());
				writer.append(",");
				writer.append(a.get(i).getSsid());
				writer.append(",");
				writer.append(a.get(i).getChannel());
				writer.append(",");
				writer.append(a.get(i).getSignal());
				writer.append(",");
				writer.append(a.get(i).getLat());
				writer.append(",");
				writer.append(a.get(i).getLon());
				writer.append(",");
				writer.append(a.get(i).getAlt());
				writer.append(",");
				writer.append(a.get(i).getTime());
				writer.append('\n');

				
			}
	
		}

		finally {
		}

		pw.write(writer.toString());
		pw.close();
		
	}

}
