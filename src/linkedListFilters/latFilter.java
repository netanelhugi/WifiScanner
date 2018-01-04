/*
 * 
 */
package linkedListFilters;

import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * This class represents a simple loction filter based on a lat range.
 */
public class latFilter implements filter{
	
	/**
	 * Instantiates a new lat filter.
	 *
	 * @param min the min
	 * @param max the max
	 */
	public latFilter(double min, double max) {
		minLat = min;
		maxLat = max;
	}

	
	/* (non-Javadoc)
	 * @see linkedListFilters.filter#test(myObjects.Checks)
	 */
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getLat()>minLat && rec.getLat()<=maxLat) {
				ans = true;
				}
		}
		return ans;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ""+this.getClass().getName()+" ["+minLat+","+maxLat+"]";
	}

	
	/** ******** Private data can be located anywhere ************. */
	private double minLat, maxLat;
}