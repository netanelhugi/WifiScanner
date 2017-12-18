/*
 * 
 */
package mainPackage;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;

import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class readCsvMatalaFormatTest.
 */
public class readCsvMatalaFormatTest {

	/**
	 * Row number test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void rowNumberTest() throws IOException {
		String name = "C:\\Users\\netan\\workspace\\Object-Oriented-Programming\\WifiScanner.csv";

		readCsvMatalaFormat r = new readCsvMatalaFormat();
		int result = r.rowNumber(name);

		assertEquals(11, result);
	}

	/**
	 * Wifi count test.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	@Test
	public void wifiCountTest() throws IOException {
		String name = "C:\\Users\\netan\\workspace\\Object-Oriented-Programming\\WifiScanner.csv";

		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(name);

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = "true";
		}

		int result = r.wifiCount(arr);

		assertEquals(109, result);
	}

}
