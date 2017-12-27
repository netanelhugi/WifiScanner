/*
 * 
 */
package algorithms;

import java.util.Collections;

import myObjects.*;
import java.util.Comparator;
import java.util.LinkedList;
import mainPackage.*;

// TODO: Auto-generated Javadoc
/**
 * The Class algo1.
 */
public class algo1 {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	
		Wifi a = new Wifi();
		a.setSignal(-50);
		a.setLat(32.103);
		a.setLon(35.208);
		a.setAlt(650);
		
		Wifi b = new Wifi();
		b.setSignal(-40);
		b.setLat(32.105);
		b.setLon(35.205);
		b.setAlt(660);
		
		Wifi c = new Wifi();
		c.setSignal(-90);
		c.setLat(32.103);
		c.setLon(35.307);
		c.setAlt(680);
		
		LinkedList<Wifi> ll = new LinkedList<>();
		ll.add(a);
		ll.add(b);
		ll.add(c);
		
		Wifi test = Waverage(ll);
		
		
		
		System.out.println(test);
		
		

	}
	
	/**
	 * Best signal.
	 *
	 * @param a the a
	 * @return the linked list
	 */
	public static LinkedList<Wifi> bestSignal(LinkedList<Wifi> a) {
		/**
		 * 
		 * 
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
					i--;
				}
				i++;
			}
			sortBySignal(bestSig);
			re.add(Waverage(bestSig));		
	}
			return re;
	
	}
	
	/**
	 * Waverage.
	 *
	 * @param a the a
	 * @return the wifi
	 */
	public static Wifi Waverage(LinkedList<Wifi> a){
		
		System.out.println(a.size());
		
		sortBySignal(a);
		
		if(a.size()==1){
			return a.getFirst();
		}
		else if(a.size()==2){
			return Wcenter(a.get(0), a.get(1), null,null);
		}
		else if(a.size()==3){
			return Wcenter(a.get(0),a.get(1),a.get(2),null);
		}
		else{
			return Wcenter(a.get(0), a.get(1), a.get(2),a.get(3));
		}		
		
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
 * Wcenter.
 *
 * @param a the a
 * @param b the b
 * @param c the c
 * @param d the d
 * @return the wifi
 */
public static Wifi Wcenter(Wifi a, Wifi b, Wifi c,Wifi d){
	
	double cW = 0;
	double dW = 0;
	double cWlat = 0;
	double cWlon = 0;
	double cWAlt = 0;
	double dWlat = 0;
	double dWlon = 0;
	double dWAlt = 0;
	int cGetSig = 0;
	int dGetSig = 0; 
	
	int aGetSig = a.getSignal();
	
	if(aGetSig==0){
		aGetSig = -120;
	}
	
	int bGetSig = b.getSignal();
	
	if(bGetSig==0){
		bGetSig = -120;
	}
	
	if(c!=null)
		 cGetSig = c.getSignal();
	
	if(cGetSig==0){
		cGetSig = -120;
	}
	
	
	if(d!=null)
		dGetSig = d.getSignal();

	if(dGetSig==0){
		dGetSig = -120;
	}
		
	if(a.getSignal()==0){
		aGetSig = -120;
	}
	

	double aW = 1/(double)(aGetSig*aGetSig);
	double bW = 1/(double)(bGetSig*bGetSig);
	
	if(c!=null){
		cW = 1/(double)(cGetSig*cGetSig);
	}
	if(d!=null){
		dW = 1/(double)(dGetSig*dGetSig);
	}
	
	double aWlat = aW*a.getLat();
	double bWlat = bW*b.getLat();

	
	if(c!=null){
		cWlat = cW*c.getLat();
	}
	if(d!=null){
		dWlat = dW*d.getLat();
	}
	
	double aWlon = aW*a.getLon();
	double bWlon = bW*b.getLon();
	if(c!=null){
		cWlon = cW*c.getLon();
	}
	if(d!=null){
		dWlon = dW*d.getLon();
	}
	
	double aAlt = aW*a.getAlt();
	double bAlt = bW*b.getAlt();
	if(c!=null){
		cWAlt = cW*c.getAlt();
	}
	if(d!=null){
		dWAlt = dW*d.getAlt();
	}

	double sumW = aW+bW;
	if(c!=null){
		sumW += cW;
	}
	if(c!=null){
		sumW += dW;
	}
	
	double sumLat = aWlat+bWlat;
	if(c!=null){
		sumLat += cWlat;
	}
	if(d!=null){
		sumLat += dWlat;
	}
	
	double sumLon = aWlon+bWlon;
	if(c!=null){
		sumLon += cWlon;
	}
	if(d!=null){
		sumLon += dWlon;
	}
	
	double sumAlt = aAlt+bAlt;
	if(c!=null){
		sumAlt += cWAlt;
	}
	if(d!=null){
		sumAlt += dWAlt;
	}

	double WcenterLat =sumLat/sumW;
	double WcenterLon=sumLon/sumW;
	double WcenterAlt=sumAlt/sumW;
	
	a.setAlt(WcenterLat);
	a.setLon(WcenterLon);
	a.setAlt(WcenterAlt);
	return a;
	}
	

}
