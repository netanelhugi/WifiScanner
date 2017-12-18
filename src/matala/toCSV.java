/*
 * 
 */
package matala;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class toCSV.
 */
public class toCSV {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * To csv.
	 *
	 * @param arr the arr
	 * @param newFile the new file
	 * @throws FileNotFoundException the file not found exception
	 */
	public void toCsv(String[][] arr, String newFile) throws FileNotFoundException {

		/**
		 * this method get matrix and name of the new file. she print the data
		 * from the matrix to new csv file. (we use this function for the
		 * filters).
		 */

		PrintWriter pw = new PrintWriter(new File(newFile + ".csv"));
		StringBuilder writer = new StringBuilder();

		try {
			// print headers to file
			writer.append("Time");
			writer.append(",");
			writer.append("ID");
			writer.append(",");
			writer.append("Lat");
			writer.append(",");
			writer.append("Lon");
			writer.append(",");
			writer.append("Alt");
			writer.append(",");
			writer.append("#WiFi networks");
			writer.append(",");

			for (int j = 1; j < 11; j++) {
				writer.append("SSID" + j);
				writer.append(",");
				writer.append("MAC" + j);
				writer.append(",");
				writer.append("Chennel" + j);
				writer.append(",");
				writer.append("Signal" + j);
				writer.append(",");

			}
			writer.append('\n');

		}

		finally {
		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i][0] == "true") {
				for (int j = 1; j < arr[i].length; j++) {

					writer.append(arr[i][j]);
					writer.append(",");
				}

				writer.append('\n');
			}

		}

		pw.write(writer.toString());
		pw.close();

	}

}
