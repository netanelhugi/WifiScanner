/*
 * 
 */
package matala;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * filtersTest.
 */
public class filtersTest {

	/**
	 * Un filter test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void UnFilterTest() throws IOException {
		String name = "C:\\Users\\netan\\workspace\\Object-Oriented-Programming\\WifiScanner.csv";
		filters f = new filters();
		String[][] arr = f.UnFilter(name);

		String result = "true";

		// System.out.println(Arrays.toString(arr2[0]));
		for (int i = 0; i < arr.length; i++) {
			assertEquals(result, arr[i][0]);
		}
	}

	/**
	 * Time filter test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void timeFilterTest() throws IOException {
		String name = "c:\\wifiScanner\\testFiles\\wifiScanner.csv";
		filters f = new filters();
		String[][] arr = f.timeFilter(name, 17, 17);

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == "true")
				result++;
		}
		assertEquals(15, result);
	}

	/**
	 * Id filter test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void idFilterTest() throws IOException {
		String name = "c:\\wifiScanner\\testFiles\\wifiScanner.csv";
		filters f = new filters();
		String[][] arr = f.IDFilter(name, "MI 6");

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == "true")
				result++;
		}
		assertEquals(5, result);
	}

	/**
	 * Loc filter test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void locFilterTest() throws IOException {
		String name = "c:\\wifiScanner\\testFiles\\wifiScanner.csv";
		filters f = new filters();
		String[][] arr = f.locFilter(32.10178256034851, 35.20535588264465, name);

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == "true")
				result++;
		}
		assertEquals(1, result);
	}

	/**
	 * Date filter test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void dateFilterTest() throws IOException {
		String name = "c:\\wifiScanner\\testFiles\\wifiScanner.csv";
		filters f = new filters();
		String[][] arr = f.dateFilter(name, 29, 10, 2017);

		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i][0] == "true")
				result++;
		}
		assertEquals(20, result);
	}

}
