/*
 * 
 */
package filters;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import matala.*;

// TODO: Auto-generated Javadoc
/**
 * Class of filters functions.
 */
public class filters {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {

	}

	/**
	 * Un filter.
	 *
	 * @param fileName the file name
	 * @return the string[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[][] UnFilter(String fileName) throws IOException {
		/**
		 * This function get file,and return just kml file without filters.
		 */
		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(fileName);
		LinkedList<Checks> a = r.CsvToList(fileName);
		
		for(int i=0; i<a.size(); i++){
			//System.out.println(a.get(i));
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = "true";
		}

		// System.out.println("unfilter matrix: ");
		// for(int i=0; i<arr.length; i++)
		// System.out.println(Arrays.toString(arr[i]));
		
		LinkedList<Wifi> lwifi = r.wifiMatrix(arr);

		toKML c = new toKML();
		c.toKml(lwifi, "unFilter");
		return arr;
	}

	/**
	 * Time filter.
	 *
	 * @param fileName the file name
	 * @param fromHour the from hour
	 * @param toHour the to hour
	 * @return the string[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[][] timeFilter(String fileName, int fromHour, int toHour) throws IOException {
		/**
		 * This function make filter by hour. she get file name, call another
		 * function to keep the data on matrix. the method get two int's to
		 * filter the data between the hours. after the filtering, the data
		 * print to kml file, and csv file by the filter.
		 */
		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(fileName);
		String hour = "";

		if (fromHour < 0 || toHour > 23 || fromHour > toHour) {
			System.out.println("Error! Wrong time.");
			return arr;
		}

		for (int i = 0; i < arr.length; i++) {
			hour = arr[i][1].substring(11, 13);
			int a = Integer.parseInt(hour);
			if (a >= fromHour && a <= toHour)
				arr[i][0] = "true";
			else
				arr[i][0] = "false";
		}

		// System.out.println("time filter matrix: ");
		// for(int i=0; i<arr.length; i++)
		// System.out.println(Arrays.toString(arr[i]));

		toCSV a = new toCSV();
		a.toCsv(arr, "timeFilter");
		
		LinkedList<Wifi> lwifi = r.wifiMatrix(arr);

		toKML c = new toKML();
		c.toKml(lwifi, "timeFilter");
		return arr;
	}

	/**
	 * Date filter.
	 *
	 * @param fileName the file name
	 * @param day the day
	 * @param month the month
	 * @param year the year
	 * @return the string[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[][] dateFilter(String fileName, int day, int month, int year) throws IOException {
		/**
		 * This function make filter by date. she get file name, call another
		 * function to keep the data on matrix. the method get 3 ints to filter
		 * the data by exact date after the filtering, the data print to kml
		 * file, and csv file by the filter.
		 */

		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(fileName);
		String day_ = "";
		String month_ = "";
		String year_ = "";

		if (day > 31 || day < 1 || month < 1 || month > 12) {
			System.out.println("Error! wrong date.");
			return arr;
		}
		for (int i = 0; i < arr.length; i++) {
			day_ = arr[i][1].substring(8, 10);
			month_ = arr[i][1].substring(5, 7);
			year_ = arr[i][1].substring(0, 4);

			int d = Integer.parseInt(day_);
			int m = Integer.parseInt(month_);
			int y = Integer.parseInt(year_);

			if (d == day && m == month && y == year)
				arr[i][0] = "true";
			else
				arr[i][0] = "false";
			
		}

		// System.out.println("date filter matrix: ");
		// for(int i=0; i<arr.length; i++)
		// System.out.println(Arrays.toString(arr[i]));

		toCSV a = new toCSV();
		a.toCsv(arr, "dateFilter");
		
		LinkedList<Wifi> lwifi = r.wifiMatrix(arr);

		toKML c = new toKML();
		c.toKml(lwifi, "dateFilter");
		return arr;
	}

	/**
	 * ID filter.
	 *
	 * @param fileName the file name
	 * @param ID the id
	 * @return the string[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[][] IDFilter(String fileName, String ID) throws IOException {
		/**
		 * This function make filter by ID. she get file name, call another
		 * function to keep the data on matrix. the method get string to filter
		 * the data by exact user id. after the filtering, the data print to kml
		 * file, and csv file by the filter.
		 */

		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(fileName);
		String a = "";
		for (int i = 0; i < arr.length; i++) {
			a = arr[i][2];
			if (a.equals(ID) == true) {
				arr[i][0] = "true";
			} else {
				arr[i][0] = "false";
			}
		}
		// System.out.println("IDfilter matrix:");
		// for(int i=0; i<arr.length; i++)
		// System.out.println(Arrays.toString(arr[i]));
		

		toCSV b = new toCSV();
		b.toCsv(arr, "IDFilter");
		
		LinkedList<Wifi> lwifi = r.wifiMatrix(arr);

		
		toKML c = new toKML();
		c.toKml(lwifi, "IDFilter");
		return arr;
	}

	/**
	 * Loc filter.
	 *
	 * @param lat the lat
	 * @param lon the lon
	 * @param fileName the file name
	 * @return the string[][]
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static String[][] locFilter(double lat, double lon, String fileName) throws IOException {
		// i3 lat //i4 lon
		//להכניס ערך של רדיוס
		/**
		 * This function make filter by location. she get file name, call
		 * another function to keep the data on matrix. the method get Doubles
		 * to filter the data by exact user location coordinates. after the
		 * filtering, the data print to kml file, and csv file by the filter.
		 */

		readCsvMatalaFormat r = new readCsvMatalaFormat();
		String[][] arr = r.ReadFile(fileName);

		for (int i = 0; i < arr.length; i++) {
			String la = arr[i][3];
			double a = Double.parseDouble(la);
			
			String lo = arr[i][4];
			double b = Double.parseDouble(lo);
			
			if (a == lat && b == lon) {
				arr[i][0] = "true";
			} else {
				arr[i][0] = "false";
			}
		}

		// System.out.println("locfilter:");
		// for(int j=0; j<arr.length; j++)
		// System.out.println(Arrays.toString(arr[j]));

		toCSV w = new toCSV();
		w.toCsv(arr, "locFilter");
		
		LinkedList<Wifi> lwifi = r.wifiMatrix(arr);

		toKML c = new toKML();
		c.toKml(lwifi, "locFilter");
		return arr;
	}

}
