/*
 * 
 */
package mainPackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;

import myObjects.Checks;

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
	
	public void toCsvFromList(LinkedList<Checks> a, String dir) throws FileNotFoundException {

		/**
		 * this method get matrix and name of the new file. she print the data
		 * from the matrix to new csv file. (we use this function for the
		 * filters).
		 */

		PrintWriter pw = new PrintWriter(new File(dir+"GuiCsv.csv"));
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

		for (int i = 0; i < a.size(); i++) {
			
			if(a.get(i).isBool()){

			int n = a.get(i).getWifiCount();
			
			writer.append(a.get(i).getTime());
			writer.append(",");
			writer.append(a.get(i).getId());
			writer.append(",");
			writer.append(a.get(i).getLat());
			writer.append(",");
			writer.append(a.get(i).getLon());
			writer.append(",");
			writer.append(a.get(i).getAlt());
			writer.append(",");
			writer.append(a.get(i).getWifiCount());
			writer.append(",");
			
			if(n>0){
			writer.append(a.get(i).getWifi1().getSsid());
			writer.append(",");
			writer.append(a.get(i).getWifi1().getMac());
			writer.append(",");
			writer.append(a.get(i).getWifi1().getChannel());
			writer.append(",");
			writer.append(a.get(i).getWifi1().getSignal());
			writer.append(",");
			}
			if(n>1){
				writer.append(a.get(i).getWifi2().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi2().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi2().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi2().getSignal());
				writer.append(",");
				}
			if(n>2){
				writer.append(a.get(i).getWifi3().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi3().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi3().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi3().getSignal());
				writer.append(",");
				}
			if(n>3){
				writer.append(a.get(i).getWifi4().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi4().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi4().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi4().getSignal());
				writer.append(",");
				}
			if(n>4){
				writer.append(a.get(i).getWifi5().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi5().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi5().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi5().getSignal());
				writer.append(",");
				}
			if(n>5){
				writer.append(a.get(i).getWifi6().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi6().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi6().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi6().getSignal());
				writer.append(",");
				}
			if(n>6){
				writer.append(a.get(i).getWifi7().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi7().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi7().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi7().getSignal());
				writer.append(",");
				}
			if(n>7){
				writer.append(a.get(i).getWifi8().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi8().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi8().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi8().getSignal());
				writer.append(",");
				}
			if(n>8){
				writer.append(a.get(i).getWifi9().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi9().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi9().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi9().getSignal());
				writer.append(",");
				}
			if(n>9){
				writer.append(a.get(i).getWifi10().getSsid());
				writer.append(",");
				writer.append(a.get(i).getWifi10().getMac());
				writer.append(",");
				writer.append(a.get(i).getWifi10().getChannel());
				writer.append(",");
				writer.append(a.get(i).getWifi10().getSignal());
				writer.append(",");
				}
			writer.append('\n');

			}
		}

		pw.write(writer.toString());
		pw.close();

	}

}
