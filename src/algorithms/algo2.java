/*
 * 
 */
package algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import myObjects.*;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import de.micromata.opengis.kml.v_2_2_0.Placemark;
import mainPackage.*;

// TODO: Auto-generated Javadoc
/**
 * The Class algo2.
 */
public class algo2 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		

	}
	
	//2017-10-27 16:16:45,SHIELD Tablet,?,?,?,10,
	//HOTBOX-D1D7,fc:b4:e6:cf:d1:dd,1,-77,888Corp,0a:8d:db:6e:71:6d,1,-79,888Guest,02:8d:db:6e:71:bf,1,-80,
	//888Free,06:8d:db:6e:71:6d,1,-81,888Guest,02:8d:db:6e:71:6d,1,-81,Mouly,7c:b7:33:2e:76:73,11,-83,
	//888Corp,0a:8d:db:6e:71:bf,1,-86,888Free,06:8d:db:6e:71:bf,1,-86,,06:8d:db:6e:71:be,11,-86,,02:8d:db:6e:71:be,11,-86,
	

	
	
	/**
	 * W img.
	 *
	 * @param a the a
	 * @param mac1 the mac 1
	 * @param mac2 the mac 2
	 * @param mac3 the mac 3
	 * @param signal1 the signal 1
	 * @param signal2 the signal 2
	 * @param signal3 the signal 3
	 * @return the double[]
	 */
	public static double[] wImg(LinkedList<Checks> a, String mac1, String mac2, String mac3, int signal1, int signal2,
			int signal3) {

		LinkedList<Checks> con = new LinkedList<>();

		int power = 2;
		int norm = 10000;
		double sigDiff = 0.4;
		int minDiff = 3;
		int noSignal = -120;
		int noSigDiff = 100;
		
		
		boolean sig2 = true;
		boolean sig3 = true;

		if(signal2==0){
			sig2 = false;
		}
		if(signal3==0){
			sig3 = false;
		}


		int inSig1 = signal1;
		int inSig2 = signal2;
		int inSig3 = signal3;
		double wDiff = 0;
		double w1 = 0;
		double w2 = 0;
		double w3 = 0;
		double s1 = 0;
		double s2 = 0;
		double s3 = 0;
		double dif1 = 0;
		double dif2 = 0;
		double dif3 = 0;

		for (int i = 0; i < a.size(); i++) {
						
			boolean cont = true;
	
			 wDiff = 0;
			 w1 = 0;
			 w2 = 0;
			 w3 = 0;
			 s1 = 0;
			 s2 = 0;
			 s3 = 0;
			 dif1 = 0;
			 dif2 = 0;
			 dif3 = 0;

				s1 = a.get(i).contMAC(mac1);

				if (s1 == 1.0 || s1<=-120){
					dif1 = 100;
				}
				else{
					dif1 = Math.abs((double) inSig1 - (double) s1);
				}
				
				if(dif1<3){
					dif1 = 3;
				}
				
				
				double aa = Math.pow(dif1, sigDiff);
				double bb = Math.pow(inSig1, power);
				w1 = (norm / (aa * bb));
				
			
				if(sig2){
				s2 = a.get(i).contMAC(mac2);
				
				if (s2 == 1){
					dif2 = 100;
				}
				else{
					dif2 = Math.abs((double) inSig2 - (double) s2);
				}
				
				if(dif2<3){
					dif2 = 3;
				}
								
				double cc = Math.pow(dif2, sigDiff);
				double dd = Math.pow(inSig2, power);

				w2 = norm / (cc * dd);
				}
			
				if(sig3){
				  s3 = a.get(i).contMAC(mac3);

					if(s3==1){
						dif3 = 100;
					}
					else{
						dif3 = Math.abs((double)inSig3-(double)s3);
					}
					
					if(dif3<3){
						dif3 = 3;
					}
														
					double ee = Math.pow(dif3, sigDiff);
					double ff = Math.pow(inSig3,power);
							
					w3 = norm/(ee*ff);
				}
				
				
			if(!sig2 && !sig3){
				wDiff = w1;
			}
			else if(!sig2){
				wDiff = w1 * w3;
			}
			else if(!sig3){
				wDiff = w1 * w2;
			}
			else{
				wDiff = w1 * w2 * w3;
			}
			
			if(Double.isInfinite(wDiff)){
				
				wDiff = 0;
				
			}
			
			if(s1==1 && (s2==1 || !sig2) && (s3==1 || !sig3)){
				cont = false;
			}
			
			a.get(i).setwDiff(wDiff);

		}
		


		con = sortBywDiff(a);
		
	
		int num = a.size();
		if (num > 3)
			num = 3;

		double sumLat = 0;
		double sumLon = 0;
		double sumAlt = 0;
		double sumW = 0;

		for (int i = 0; i <= 3; i++) {			
			
			double dif = con.get(i).getwDiff();
			sumW += dif;
			sumLat += con.get(i).getLat() * dif;
			sumLon += con.get(i).getLon() * dif;
			sumAlt += con.get(i).getAlt() * dif;
		}

		
		
		double[] place = new double[3];

		double lat = sumLat / sumW;
		double lon = sumLon / sumW;
		double alt = sumAlt / sumW;
		

		place[0] = lat;
		place[1] = lon;
		place[2] = alt;

		return place;

	}

	/**
	 * Sort byw diff.
	 *
	 * @param a the a
	 * @return the linked list
	 */
	public static LinkedList<Checks> sortBywDiff(LinkedList<Checks> a) {

		Collections.sort(a, new Comparator<Checks>() {
			// @Override
			public int compare(Checks c1, Checks c2) {
			
				
				if(c1.getwDiff()>c2.getwDiff()){
					return -1;
				}
				else if(c1.getwDiff()<c2.getwDiff()){
					return 1;
				}
				else
					return 0;
				
			}
		});
		return a;

	}
	
	public static Checks wifiSort_SortbySignal(Checks c){
		
		int n = c.getWifiCount();
		
		LinkedList<WifiSort> ws = new LinkedList<>();
		
		for(int i=0; i<n; i++){
			
			if(i==0)
				ws.add(c.getWifi1());
			else if(i==1)
				ws.add(c.getWifi2());
			else if(i==2)
				ws.add(c.getWifi3());
			else if(i==3)
				ws.add(c.getWifi4());
			else if(i==4)
				ws.add(c.getWifi5());
			else if(i==5)
				ws.add(c.getWifi6());
			else if(i==6)
				ws.add(c.getWifi7());
			else if(i==7)
				ws.add(c.getWifi8());
			else if(i==8)
				ws.add(c.getWifi9());
			else if(i==9)
				ws.add(c.getWifi10());
		}
		
		ws = sortBySignal(ws);
		
		Checks ans = new Checks();
		
		ans.setWifi1(ws.get(0));
		
		if(ws.size()>1){
			ans.setWifi2(ws.get(1));
		}
		
		if(ws.size()>2){
			ans.setWifi3(ws.get(2));
		}
		
		
		return ans;
		
	}
	
	
	public static LinkedList<WifiSort> sortBySignal(LinkedList<WifiSort> a) {

		Collections.sort(a, new Comparator<WifiSort>() {
			// @Override
			public int compare(WifiSort c1, WifiSort c2) {
			
				
				if(c1.getSignal()>c2.getSignal()){
					return -1;
				}
				else if(c1.getSignal()<c2.getSignal()){
					return 1;
				}
				else
					return 0;
				
			}
		});
		return a;

	}

}
