/*
 * 
 */
package linkedListFilters;

import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * This class represents a simple loction filter based on a lon range.
 */
public class lonFilter implements filter{
	
	/**
	 * Instantiates a new lon filter.
	 *
	 * @param min the min
	 * @param max the max
	 */
	public lonFilter(double min, double max) {
		minLon = min;
		maxLon = max;
	}

	
	/* (non-Javadoc)
	 * @see linkedListFilters.filter#test(myObjects.Checks)
	 */
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getLon()>minLon && rec.getLon()<=maxLon) {
				ans = true;
				}
		}
		return ans;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.minLon+","+this.maxLon+"]";
	}

	
	/** ******** Private data can be located anywhere ************. */
	private double minLon, maxLon;
}