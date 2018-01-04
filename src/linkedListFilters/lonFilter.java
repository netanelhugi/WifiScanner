/*
 * 
 */
package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple loction filter based on a lon range
	 * 
	 *
	 */
public class lonFilter implements filter{
	
	public lonFilter(double min, double max) {
		minLon = min;
		maxLon = max;
	}

	
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getLon()>minLon && rec.getLon()<=maxLon) {
				ans = true;
				}
		}
		return ans;
	}
	
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.minLon+","+this.maxLon+"]";
	}

	
	/********** Private data can be located anywhere *************/
	private double minLon, maxLon;
}