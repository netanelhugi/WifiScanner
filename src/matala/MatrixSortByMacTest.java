/*
 * 
 */
package matala;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class MatrixSortByMacTest.
 */
public class MatrixSortByMacTest {
	
	
	
	/**
	 * Sort by mac test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void sortByMacTest() throws Exception {
		LinkedList<Wifi> a = new LinkedList<>();
		Wifi tr = new Wifi();
		tr.setMac("88:dc:96:1c:a2:00");
		a.add(tr);
		
		Wifi first = new Wifi();
		first.setMac("b4:ee:b4:36:d2:b0");
		a.add(first);
		
		Wifi sec = new Wifi();
		sec.setMac("14:ae:db:45:27:5d");
		a.add(sec);
		
		for(int i=0; i<a.size();i++){
			System.out.println(a.get(i));
		}
		
		
		
		LinkedList<Wifi> exp = new LinkedList<>();
		exp.add(sec);
		exp.add(tr);
		exp.add(first);
		
		MatrixSortByMAC ms = new MatrixSortByMAC();  
		LinkedList<Wifi> result = ms.sortByMac(a);
		for(int i=0; i<result.size();i++){
			System.out.println(result.get(i));
		}
		assertEquals(exp, result);
	}
	
	
	/**
	 * Findsort by signal test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void sortBySignalTest() throws Exception {
		LinkedList<Wifi> a = new LinkedList<>();
		Wifi tr = new Wifi();
		tr.setSignal(-70);
		a.add(tr);
		
		Wifi first = new Wifi();
		first.setSignal(-50);
		a.add(first);
		
		Wifi sec = new Wifi();
		sec.setSignal(-60);
		a.add(sec);
		
		
		
		LinkedList<Wifi> exp = new LinkedList<>();
		exp.add(first);
		exp.add(sec);
		exp.add(tr);
		
		MatrixSortByMAC ms = new MatrixSortByMAC();  
		LinkedList<Wifi> result = ms.sortBySignal(a);
		assertEquals(exp, result);
	}

	/*
	@Test
	public void sortByMa1cTest() {
		String[][] arr = new String[3][10];
		arr[0][7] = "88:dc:96:1c:a2:00";
		arr[1][7] = "b4:ee:b4:36:d2:b0";
		arr[2][7] = "14:ae:db:45:27:5d";
		arr[0][9] = "100";
		arr[1][9] = "100";
		arr[2][9] = "100";

		String[][] arrSorted = new String[3][10];
		arrSorted[1][7] = "88:dc:96:1c:a2:00";
		arrSorted[2][7] = "b4:ee:b4:36:d2:b0";
		arrSorted[0][7] = "14:ae:db:45:27:5d";
		arrSorted[0][9] = "100";
		arrSorted[1][9] = "100";
		arrSorted[2][9] = "100";

		MatrixSortByMAC ms = new MatrixSortByMAC();
		String[][] mat = ms.MacSort(arr);

		assertEquals(arrSorted[0][7], mat[0][7]);
		assertEquals(arrSorted[1][7], mat[1][7]);
		assertEquals(arrSorted[2][7], mat[2][7]);

	}
	*/

}
