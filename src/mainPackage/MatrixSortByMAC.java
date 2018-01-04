/*
 * 
 */
package mainPackage;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import javax.crypto.Mac;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class MatrixSortByMAC.
 */
public class MatrixSortByMAC {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// String name = "C:\\Users\\netan\\workspace\\Object-Oriented
		// Programming\\WifiScanner.csv";

		// readCsvMatalaFormat m = new readCsvMatalaFormat();

		// String[][] x = m.ReadFile(name);
		// String[][] arr2 = m.wifiMatrix(x);

	}

	/**
	 * Sort by mac.
	 *
	 * @param a the a
	 * @return the linked list
	 */
	public static LinkedList<Wifi> sortByMac(LinkedList<Wifi> a) {

		Collections.sort(a, new Comparator<Wifi>() {
			// @Override
			public int compare(Wifi wifi1, Wifi wifi2) {
				return (int) (wifi1.getMac().compareTo(wifi2.getMac()));
			}
		});
		/*
		for(int i=0; i<a.size();i++){
			System.out.println(a.get(i));
		}
		*/
		return a;
	}

	/**
	 * Best signal.
	 *
	 * @param a the a
	 * @return the linked list
	 */
	public static LinkedList<Wifi> bestSignal(LinkedList<Wifi> a) {
		/**
		 * this method get linked list<wifi> sorted by mac address.
		 * the line of the check with the best signal(from duplication) or if
		 * the mac does not have a duplication.
		 */
		
		LinkedList<Wifi> re = new LinkedList<Wifi>();
		
		int n = a.size();
		
			for (int i = 0; i < n; i++) {
			

			LinkedList<Wifi> bestSig = new LinkedList<>();

			bestSig.add(a.get(i));

			boolean diff = false;
						
			while (!diff && i < n-1) {
				
				if (a.get(i).getMac().equals(a.get(i+1).getMac()))
				{
					bestSig.add(a.get(i+1));
				}
				else{
					diff = true;
				}
				
				i++;

			}

			sortBySignal(bestSig);
			re.add(bestSig.getFirst());

		
	}
			/*
			for(int i=0; i<re.size();i++){
				System.out.println(re.get(i));
			}
			*/
			return re;
	}
			
			/**
			 * Sort by signal.
			 *
			 * @param a the a
			 * @return the linked list
			 */
			public static LinkedList<Wifi> sortBySignal(LinkedList<Wifi> a) {

				Collections.sort(a, new Comparator<Wifi>() {
					// @Override
					public int compare(Wifi wifi1, Wifi wifi2) {
						return (int) (wifi2.getSignal() - wifi1.getSignal());
					}
				});
				return a;
			}
			
			/**
			 * Find mac.
			 *
			 * @param a the a
			 * @param mac the mac
			 * @return the linked list
			 */
			public static LinkedList<Wifi> findMac(LinkedList<Wifi> a, String mac){
				LinkedList<Wifi> ans = new LinkedList<Wifi>();
				for(int i=0; i<a.size(); i++){
				Wifi wi = a.get(i);
				if(wi.getMac().equals(mac)){
				ans.add(wi);
				System.out.println("yesdsf");
				}
				else{
					System.out.println(wi.getMac());
				}
				}
				return ans;
			}
			
}
