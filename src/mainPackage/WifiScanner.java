/*
 * 
 */

package mainPackage;

import java.io.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

import org.omg.CORBA.portable.UnknownException;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * Convert the file from the "wiggle-wifi" app to data structure.
 * This is our program for course assignments. The software
 * collects details about Internet networks with the app "wiggle-wifi".
 * The app export to us CSV file with all the data. all the data from the file we save
 * on data Structure. from our data Structure we create new CSV file
 * according to the desired format in the task.
 * 
 * 
 * @author matalaTeam
 *
 */
public class WifiScanner {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws Exception
	 *             the exception
	 */
	public static void main(String[] args) throws Exception {
		/*
		 * String folder = "c:\\wifiScanner"; filesReader(folder);
		 */
	}

	/**
	 * Files reader. This method get a folder of csv files read the details,
	 * keep them in linked list of Wifi objects, make new CSV file and print the data to the file.
	 * 
	 * if in the folder there is a file with different extension than csv, the
	 * method print error massage and go to the next file.
	 * 
	 * The name of the files from "Wigle-wifi" app should be in the following
	 * format: "WigleWifi_yyyymmddhhmmss".
	 * 
	 * first row of input file need to be data from app.
	 * second row is headers of lines.
	 * and others rows is wifi's data.
	 *
	 * @param folderPath            the folder path
	 * @return the Wifi[][]
	 * @throws Exception             the exception
	 */
	public static LinkedList<Checks> filesReader(String folderPath) throws Exception {
		
		if(folderPath==""){
			return null;
		}

		File directory = new File(folderPath);
		File[] fList = directory.listFiles();

		PrintWriter pw = new PrintWriter(new File("WifiScanner.csv"));
		StringBuilder writer = new StringBuilder();

		LinkedList<Wifi> wifiList = new LinkedList<>();

		try {
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
		}

		finally {
		}

		for (File file : fList) {

			System.out.println(file.getName());
			String ext = CheckExt(file);

			if (ext == "error")
				System.out.println("The file: " + file.getName() + " not supported!");

			else {
				try {
					FileReader fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
					int wifiNumber = wifiNumber(file);

					String str;
					str = br.readLine();
					

					if (str == null) {
						System.out.println(file.getName() + " is empty!");
						continue;
					}

					System.out.println("first");
					System.out.println(str);
					
					String user = userName(str);

					str = br.readLine();

					if (str == null) {
						System.out.println("Error! " + file.getName() + " is empty!");
						continue;
					}
					str = br.readLine();

					if (str == null) {
						System.out.println("Error! " + file.getName() + " is empty!");
						continue;
					}

					for (int i = 0; i < wifiNumber; i++) {
						Wifi net = new Wifi();
						System.out.println(str);
						double[] coordi = findCoordinate(str);
						net.setLat(coordi[0]);
						net.setLon(coordi[1]);
						net.setAlt(coordi[2]);
						net.setSignal(findRssi(str));
						net.setTime(findTime(str));
						net.setMac(findMac(str));
						net.setChannel(findChannel(str));
						net.setSsid(findSSID(str));
						net.setUser(user);

						wifiList.add(net);
						str = br.readLine();

					}

				}

				catch (IOException ex) {
					// System.out.print("Error reading file\n" + ex);
					// System.exit(2);
				}
			}
		}

		sortByLat(wifiList);

		int n = wifiList.size();

		Wifi[][] wifiMat = new Wifi[wifiList.size()][1];
		LinkedList<Checks> checksList = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			Wifi a = wifiList.get(i);
			wifiMat[i][0] = a;
		}

		for (int i = 0; i < n; i++) {
			
			LinkedList<Wifi> byloc = new LinkedList<>();
			writer.append('\n');

			byloc.add(wifiMat[i][0]);

			boolean diff = false;
						
			while (!diff && i < n-1) {
				
				if (wifiMat[i][0].getAlt() == wifiMat[i + 1][0].getAlt()
						&& wifiMat[i][0].getLon() == wifiMat[i + 1][0].getLon()
						&& wifiMat[i][0].getLat() == wifiMat[i + 1][0].getLat())
				{
					byloc.add(wifiMat[i+1][0]);
				}
				else{
					diff = true;
				}
				
				i++;

			}

			sortBySignal(byloc);

			int wifiNum = byloc.size();
			if (wifiNum > 10)
				wifiNum = 10;

			Wifi first = byloc.peek();
			
			Checks ac = new Checks();
			
			try{
				
			writer.append(first.getTime());
			writer.append(",");
			writer.append(first.getUser());
			writer.append(",");
			writer.append(first.getLat());
			writer.append(",");
			writer.append(first.getLon());
			writer.append(",");
			writer.append(first.getAlt());
			writer.append(",");
			writer.append(wifiNum);
			writer.append(",");
			
			ac.setTime(first.getTime());
			ac.setId(first.getUser());
			ac.setLat(first.getLat());
			ac.setLon(first.getLon());
			ac.setAlt(first.getAlt());
			ac.setWifiCount(wifiNum);
			


			
			for (int j = 0; j < wifiNum; j++) {
				Wifi a = byloc.pop();
				System.out.println(a);
				writer.append(a.getSsid());
				writer.append(",");
				writer.append(a.getMac());
				writer.append(",");
				writer.append(a.getChannel());
				writer.append(",");
				writer.append(a.getSignal());
				writer.append(",");
				
				if(j==0){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi1(ws1);
				}
				
				else if(j==1){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi2(ws1);
				}
				else if(j==2){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi3(ws1);
				}
				else if(j==3){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi4(ws1);
				}
				else if(j==4){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi5(ws1);
				}
				else if(j==5){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi6(ws1);
				}
				else if(j==6){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi7(ws1);
				}
				else if(j==7){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi8(ws1);
				}
				else if(j==8){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi9(ws1);
				}
				else if(j==9){
					WifiSort ws1 = new WifiSort(a.getMac(), a.getSsid(), a.getChannel(), a.getSignal());
					ac.setWifi10(ws1);
				}
				
				

			}
			diff = false;
			
			}
			
			finally {
				
			}
			
			checksList.add(ac);

		}
		pw.write(writer.toString());

		pw.close();
		return checksList;

	}



	/**
	 * Find signal of wifi. The function find the wifi signal. she get string(line)from
	 * the csv file of the app, and return int.
	 *
	 * @param s
	 *            the s
	 * @return the int
	 */
	public static int findRssi(String s) {

		int psik = 0;
		int rxl = 0;
		String rx = "";
		while (psik < 6) {
			for (int i = 0; psik < 6; i++) {
				if (s.charAt(i) == ',')
					psik++;
				else if (psik == 5)
					rx += s.charAt(i);
			}
			rxl = Integer.parseInt(rx);
		}
		return rxl;
	}

	/**
	 * CheckExt This method check the file name, is extension CSV(if not, return "error").
	 *
	 * @param file
	 *            the file
	 * @return the string
	 */
	public static String CheckExt(File file) {

		String name = file.getName();
		String ext = "";
		for (int i = name.length() - 4; i < name.length(); i++) {
			ext = ext + name.charAt(i);
		}
		if (ext.equals(".csv") != true)
			return "error";

	

		return ext;
	}

	/**
	 * Wifi number.
	 * 
	 * this function get a file from the folder, and check how many networks if
	 * the file. Actually he count the lines(without the first tow)
	 *
	 * @param file
	 *            the file
	 * @return the int
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static int wifiNumber(File file) throws IOException {

		FileReader number = new FileReader(file);
		BufferedReader Nwifi = new BufferedReader(number);

		int wifiNumber = 0;
		String num = Nwifi.readLine();
		num = Nwifi.readLine();
		num = Nwifi.readLine();

		while (num != null) {
			wifiNumber++;
			num = Nwifi.readLine();
		}
		return wifiNumber;
	}

	/**
	 * User name. The function get a string(the first line of the file) and
	 * saves the ID. The ID take from "model".
	 *
	 * @param s
	 *            the s
	 * @return the string
	 */
	public static String userName(String s) {

		String str = s;
		String user = "";
		int cou1 = 0;
		while (cou1 < 3) {
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ',')
					cou1++;
				if (cou1 == 2)
					user += str.charAt(i);
			}
			System.out.println(s);
			user = user.substring(7, user.length());
		}
		return user;
	}

	/**
	 * Find coordinate. The function get the line of wifi network in
	 * the file, take from there the coordinates, and return array with the data
	 *
	 * @param s
	 *            the s
	 * @return the double[]
	 */
	public static double[] findCoordinate(String s) {

		int couStr = 0;
		double[] coordi = new double[3];
		// lat = [0]
		String lat = "";
		// lon = [1]
		String lon = "";
		// alt = [2]
		String alt = "";
		

		while (couStr < 10) {
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == ',') {
					couStr++;
				}
				if (couStr == 6)
					lat += s.charAt(i + 1);
				else if (couStr == 7)
					lon += s.charAt(i + 1);
				else if (couStr == 8)
					alt += s.charAt(i + 1);
			}
		}
		coordi[0] = Double.parseDouble(lat.substring(0, lat.length() - 1));
		coordi[1] = Double.parseDouble(lon.substring(0, lon.length() - 1));
		coordi[2] = Double.parseDouble(alt.substring(0, alt.length() - 1));

		return coordi;
	}

	/**
	 * Find time.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String findTime(String s) {

		int psik = 0;
		String time = "";

		for (int i = 0; psik < 4; i++) {

			if (s.charAt(i) == ',')
				psik++;
			else if (psik == 3)
				time += s.charAt(i);

		}
		return time;

	}

	/**
	 * Find mac.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String findMac(String s) {

		int psik = 0;
		String mac = "";

		for (int i = 0; psik < 1; i++) {

			if (s.charAt(i) == ',')
				psik++;
			else if (psik == 0)
				mac += s.charAt(i);

		}
		return mac;

	}

	/**
	 * Find channel.
	 *
	 * @param s the s
	 * @return the int
	 */
	public static int findChannel(String s) {

		int psik = 0;
		String ch = "";

		for (int i = 0; psik < 5; i++) {

			if (s.charAt(i) == ',')
				psik++;
			else if (psik == 4)
				ch += s.charAt(i);

		}
		int re = Integer.parseInt(ch);
		return re;

	}

	/**
	 * Find SSID.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String findSSID(String s) {

		int psik = 0;
		String SSID = "";

		for (int i = 0; psik < 2; i++) {

			if (s.charAt(i) == ',')
				psik++;
			else if (psik == 1)
				SSID += s.charAt(i);

		}
		return SSID;

	}

	/**
	 * Sort by lat.
	 *
	 * @param a the a
	 * @return the linked list
	 */
	public static LinkedList<Wifi> sortByLat(LinkedList<Wifi> a) {

		Collections.sort(a, new Comparator<Wifi>() {
			// @Override
			public int compare(Wifi wifi1, Wifi wifi2) {
				return (int) (wifi1.getLat() - wifi2.getLat());
			}
		});
		return a;

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

}
