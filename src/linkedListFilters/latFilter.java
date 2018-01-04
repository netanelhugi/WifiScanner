/*
 * 
 */
package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple loction filter based on a lat range
	 * 
	 *
	 */
public class latFilter implements filter{
	
	public latFilter(double min, double max) {
		minLat = min;
		maxLat = max;
	}

	
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getLat()>minLat && rec.getLat()<=maxLat) {
				ans = true;
				}
		}
		return ans;
	}
	
	public String toString() {
		return ""+this.getClass().getName()+" ["+minLat+","+maxLat+"]";
	}

	
	/********** Private data can be located anywhere *************/
	private double minLat, maxLat;
}