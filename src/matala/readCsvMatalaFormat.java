/*
 * 
 */
package matala;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class readCsvMatalaFormat.
 */
public class readCsvMatalaFormat {

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String name = "C:\\Users\\netan\\workspace\\Object-Oriented-Programming\\WifiScanner.csv";
		String[][] x = ReadFile(name);

		LinkedList<Wifi> a = wifiMatrix(x);

		for (int i = 0; i < a.size(); i++) {
		}

		/*
		 * for(int i=0; i<x.length; i++){
		 * System.out.println(Arrays.toString(x[i])); }
		 * System.out.println("row: " + x.length);
		 */
	}

	/**
	 * Read file.
	 *
	 * @param name
	 *            the name
	 * @return the string[][]
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String[][] ReadFile(String name) throws IOException {
		/**
		 * This method get string(csv file name), and save the details to
		 * matrix. The first column(arr[i][0]) reserved for the filtering
		 * process. The method return metrix.
		 * 
		 * this method does not filter the data.
		 */
		int rowNum = rowNumber(name);
		String[][] n = new String[rowNum][47];
		FileReader fr = null;
		int row = 0;
		try {
			int index = 1;
			fr = new FileReader(name);
			BufferedReader br = new BufferedReader(fr);
			String t = "";
			String s = br.readLine();
			s = br.readLine();

			while (row < rowNum) {
				
				//System.out.println(s);
				
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ',' || i==s.length()-1) {
						if(i==s.length()-1){
							t += s.charAt(i);
						}
						//System.out.println("row: " + row);
					System.out.println("t: " + t);
						//System.out.println(index);
						//System.out.println(Arrays.toString(n[row]));
					
					if(t.length()>1){	
					if(t.charAt(t.length()-1)==','){
						t = t.substring(0,t.length()-1);
					}
					}
					
						n[row][index++] = t;
						t = "";
					} 
					else{
						t += s.charAt(i);
					}
				}
				row++;
				index = 1;
				s = br.readLine();
			}
			// matrix print
			//for(int i=0; i<rowNum; i++)
			//System.out.println(Arrays.toString(n[i]));
		} catch (FileNotFoundException e) {
		}
		return n;
	}

	/**
	 * Row number.
	 *
	 * @param file
	 *            the file
	 * @return the int
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static int rowNumber(String file) throws IOException {
		/**
		 * this function get a file, and check how many networks if the file.
		 * Actually he count the lines(without the first one)
		 */
		FileReader number = new FileReader(file);
		BufferedReader nwifi = new BufferedReader(number);
		int wifiNumber = 0;
		String num = nwifi.readLine();
		num = nwifi.readLine();

		while (num != null) {
			wifiNumber++;
			num = nwifi.readLine();
		}
		return wifiNumber;
	}

	/**
	 * Wifi count.
	 *
	 * @param arr
	 *            the arr
	 * @return the int
	 */
	public static int wifiCount(String[][] arr) {

		int wifi = 0;
		for (int i = 0; i < arr.length; i++) {
			
			//System.out.println(Arrays.toString(arr[i]));

			if(arr[i][6]!=null){
			
			if (arr[i][0] == "true") {
				//System.out.println(arr[i][6]);
				int a = Integer.parseInt(arr[i][6]);
				wifi += a;
			}
			}
		}
		return wifi;
	}

	/**
	 * Wifi matrix.
	 *
	 * @param a
	 *            the a
	 * @return the linked list
	 */
	public static LinkedList<Wifi> wifiMatrix(String[][] a) {
		/**
		 * this method get matrix with networks data, and return linked list of
		 * wifi objects.
		 * 
		 * 
		 */

		int c = wifiCount(a);

		LinkedList<Wifi> wifiList = new LinkedList<>();

		int checkNum = 0;
		int wifi = 0;

		int i = 0;
		while (i < c) {
			int wifiNum =0;
			if(a[checkNum][6]!=null){
			 wifiNum = Integer.parseInt(a[checkNum][6]);
			}
			
			if (a[checkNum][0] == "true") {
				Wifi w = new Wifi();

				if (wifi == wifiNum) {
					checkNum++;
					wifi = 0;
				}
				w.setBool(true);
				w.setTime(a[checkNum][1]);
				w.setUser(a[checkNum][2]);
				
				double lat1;
				if(a[checkNum][3].contains("?")){
					lat1 = 0;
				}
				else{
					//System.out.println(a[checkNum][3]);
					lat1 = Double.parseDouble(a[checkNum][3]);
				}
				
				double lon1;
				if(a[checkNum][4].contains("?")){
					lon1 = 0;
				}
				else{
					lon1 = Double.parseDouble(a[checkNum][4]);
				}
				
				double alt1;
				if(a[checkNum][5].contains("?")){
					alt1 = 0;
				}
				else{
					alt1 = Double.parseDouble(a[checkNum][5]);
				}
				w.setLat(lat1);
				w.setLon(lon1);
				w.setAlt(alt1);
				
				w.setSsid(a[checkNum][7 + wifi * 4]);
				w.setMac(a[checkNum][8 + wifi * 4]);
				
				int ch;

				if(a[checkNum][9 + wifi * 4]==""){
					ch = 0;
				}
				else{
					ch = Integer.parseInt(a[checkNum][9 + wifi * 4]);

				}
				w.setChannel(ch);
				
				int sig;
				
				if(a[checkNum][10 + wifi * 4]==null || a[checkNum][10 + wifi * 4]==""){
					sig = 0;
				}
				else{
					//System.out.println(a[checkNum][10 + wifi * 4]);
					sig = (int)Double.parseDouble(a[checkNum][10 + wifi * 4]);

				}
				
				w.setSignal(sig);

				i++;
				wifi++;
				wifiList.push(w);
			} else {
				checkNum++;
			}
		}
		return wifiList;
	}

	/**
	 * Csv to list.
	 *
	 * @param name
	 *            the name
	 * @return the linked list
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static LinkedList<Checks> CsvToList(String name) throws IOException {
		/**
		 * 
		 */
		int rowNum = rowNumber(name);
		// String[][] n = new String[rowNum][47];
		LinkedList<Checks> a = new LinkedList<>();
		FileReader fr = null;
		int row = 0;
		try {
			int index = 1;
			fr = new FileReader(name);
			BufferedReader br = new BufferedReader(fr);
			String t = "";
			String s = br.readLine();
			s = br.readLine();
			int count = 1;
			int psik = 0;

			String ssid = "";
			String mac = "";
			int signal = 0;
			int ch = 0;

			while (row < rowNum) {
				Checks c = new Checks();
				for (int i = 0; i < s.length(); i++) {
					if (s.charAt(i) == ',') {

						if (psik == 0) {
							c.setTime(t);
						} 
						else if (psik == 1) {
							c.setId(t);
						} 
						else if (psik == 2) {
							double a0;

							if (t.contains("?")) {
								a0 = 0;
							} else {
								a0 = Double.parseDouble(t);
							}

							c.setLat(a0);
						} 
						else if (psik == 3) {
							double a1;

							if (t.contains("?")) {
								a1 = 0;
							} else {
								a1 = Double.parseDouble(t);
							}

							c.setLon(a1);
						} 
						else if (psik == 4) {
							double a2;
							

							if(t.contains("?")){
								a2 = 0;
							}
							else{
								a2 = Double.parseDouble(t);
							}

							c.setAlt(a2);
						} 
						else if (psik == 5) {
							
							int b = 0;
							
							if(t==""){
								b = 0;
							}
							else{
								b = Integer.parseInt(t);
							}							
							
							c.setWifiCount(b);
						} else if (psik == 6) {
							c.setSsid1(t);
							ssid = t;
						} else if (psik == 7) {
							c.setMac1(t);
							mac = t;
						} else if (psik == 8) {
							
							int ch1 = 0;
							
							if(t==""){
								ch1 = 0;
							}
							else{
								ch1 = Integer.parseInt(t);
							}							
							
							c.setChannel1(ch1);
							ch = ch1;
						} 
						else if (psik == 9) {
							int sig1 = 0;
							
							if(t==""){
								sig1 = 0;
							}
							else{
								sig1 = (int)Double.parseDouble(t);
							}							
							
							c.setSignal1(sig1);
							signal = sig1;
							WifiSort ws1 = new WifiSort(mac, ssid, ch, signal);
							c.setWifi1(ws1);
						} else if (psik == 10) {
							c.setSsid2(t);
							ssid = t;

						} else if (psik == 11) {
							mac = t;
							c.setMac2(t);
						} 
						else if (psik == 12) {
							
							int ch2 = 0;
							
							if(t==""){
								ch2 = 0;
							}
							else{
								ch2 = Integer.parseInt(t);
							}
							
							c.setChannel2(ch2);
							ch = ch2;
						} else if (psik == 13) {
							int sig2 = 0;
							
							if(t==""){
								sig2 = 0;
							}
							else{
								sig2 = (int)Double.parseDouble(t);
							}
							c.setSignal2(sig2);
							signal = sig2;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi2(ws);

						} else if (psik == 14) {
							ssid = t;

							c.setSsid3(t);
						} else if (psik == 15) {
							mac = t;

							c.setMac3(t);
						} else if (psik == 16) {
							
							int ch3 = 0;
							
							if(t==""){
								ch3 = 0;
							}
							else{
								ch3 = Integer.parseInt(t);
							}							
							
							c.setChannel3(ch3);
							ch = ch3;

						} 
						else if (psik == 17) {
							
							int sig3 = 0;
							
							if(t==""){
								sig3 = 0;
							}
							else{
								sig3 = (int)Double.parseDouble(t);
							}							
							
							c.setSignal1(sig3);
							signal = sig3;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi3(ws);

						} else if (psik == 18) {
							ssid = t;

							c.setSsid4(t);
						} else if (psik == 19) {
							mac = t;

							c.setMac4(t);
						} 
						else if (psik == 20) {
							
							int ch4 = 0;
							
							if(t==""){
								ch4 = 0;
							}
							else{
								ch4 = Integer.parseInt(t);
							}							
							c.setChannel4(ch4);
							ch = ch4;

						} else if (psik == 21) {
							
							int sig4 = 0;
							
							if(t==""){
								sig4 = 0;
							}
							else{
								sig4 = (int)Double.parseDouble(t);
							}							
							c.setSignal4(sig4);
							signal = sig4;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi4(ws);

						} else if (psik == 22) {
							ssid = t;

							c.setSsid5(t);
						} else if (psik == 23) {
							mac = t;

							c.setMac5(t);
						} else if (psik == 24) {
							
int ch5 = 0;
							
							if(t==""){
								ch5 = 0;
							}
							else{
								ch5 = Integer.parseInt(t);
							}							
							c.setChannel5(ch5);
							ch = ch5;

						} else if (psik == 25) {
							
int sig5 = 0;
							
							if(t==""){
								sig5 = 0;
							}
							else{
								sig5 = (int)Double.parseDouble(t);
							}							
							c.setSignal5(sig5);
							signal = sig5;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi5(ws);

						}

						else if (psik == 26) {
							ssid = t;

							c.setSsid6(t);
						} else if (psik == 27) {
							mac = t;

							c.setMac6(t);
						} else if (psik == 28) {
							
int ch6 = 0;
							
							if(t==""){
								ch6 = 0;
							}
							else{
								ch6 = Integer.parseInt(t);
							}							
							c.setChannel6(ch6);
							ch = ch6;

						} else if (psik == 29) {
							
int sig6 = 0;
							
							if(t==""){
								sig6 = 0;
							}
							else{
								sig6 = (int)Double.parseDouble(t);
							}							
							c.setSignal6(sig6);
							signal = sig6;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi6(ws);

						}

						else if (psik == 30) {
							ssid = t;

							c.setSsid7(t);
						} else if (psik == 31) {
							mac = t;

							c.setMac7(t);
						} else if (psik == 32) {
							
int ch7 = 0;
							
							if(t==""){
								ch7 = 0;
							}
							else{
								ch7 = Integer.parseInt(t);
							}							
							c.setChannel7(ch7);
							ch = ch7;

						} else if (psik == 33) {
							
int sig7 = 0;
							
							if(t==""){
								sig7 = 0;
							}
							else{
								sig7 = (int)Double.parseDouble(t);
							}							
							c.setSignal7(sig7);
							signal = sig7;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi7(ws);

						} else if (psik == 34) {
							ssid = t;

							c.setSsid8(t);
						} else if (psik == 35) {
							mac = t;

							c.setMac8(t);
						} else if (psik == 36) {
							int ch8;

							if(t==""){
								ch8 = 0;
							}
							else
								ch8 = Integer.parseInt(t);
							
							c.setChannel8(ch8);
							ch = ch8;

						} else if (psik == 37) {
							
int sig8 = 0;
							
							if(t==""){
								sig8 = 0;
							}
							else{
								sig8 = (int)Double.parseDouble(t);
							}							
							c.setSignal8(sig8);
							signal = sig8;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi8(ws);

						}

						else if (psik == 38) {
							ssid = t;

							c.setSsid9(t);
						} else if (psik == 39) {
							mac = t;

							c.setMac9(t);
						} else if (psik == 40) {
							
int ch9 = 0;
							
							if(t==""){
								ch9 = 0;
							}
							else{
								ch9 = Integer.parseInt(t);
							}							
							c.setChannel9(ch9);
							ch = ch9;

						} else if (psik == 41) {
							
int sig9 = 0;
							
							if(t==""){
								sig9 = 0;
							}
							else{
								sig9 = (int)Double.parseDouble(t);
							}							
							c.setSignal9(sig9);
							signal = sig9;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi9(ws);
						} else if (psik == 42) {
							ssid = t;

							c.setSsid10(t);
						} else if (psik == 43) {
							mac = t;

							c.setMac10(t);
						} else if (psik == 44) {
							
int ch10 = 0;
							
							if(t==""){
								ch10 = 0;
							}
							else{
								ch10 = Integer.parseInt(t);
							}							
							c.setChannel10(ch10);
							ch = ch10;

						} else if (psik == 45) {
							
int sig10 = 0;
							
							if(t==""){
								sig10 = 0;
							}
							else{
								sig10 = (int)Double.parseDouble(t);
							}							
							c.setSignal10(sig10);
							signal = sig10;
							WifiSort ws = new WifiSort(mac, ssid, ch, signal);
							c.setWifi10(ws);
						}

						psik++;

						// n[row][index++] = t;
						t = "";
					} else
						t += s.charAt(i);
				}
				row++;
				// System.out.println(c);
				a.add(c);

				index = 1;
				psik = 0;
				s = br.readLine();
				//System.out.println(row);
			}
			// matrix print
			// for(int i=0; i<rowNum; i++)
			// System.out.println(Arrays.toString(n[i]));
		} catch (FileNotFoundException e) {
		}
		return a;
	}
}
