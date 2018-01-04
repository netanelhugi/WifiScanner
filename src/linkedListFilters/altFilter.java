/*
 * 
 */
package linkedListFilters;

import myObjects.*;

	// TODO: Auto-generated Javadoc
/**
	 * This class represents a simple loction filter based on a alt range.
	 */
public class altFilter implements filter{
	
	/**
	 * Instantiates a new alt filter.
	 *
	 * @param min the min
	 * @param max the max
	 */
	public altFilter(double min, double max) {
		minAlt = min;
		maxAlt = max;
	}

	
	/* (non-Javadoc)
	 * @see linkedListFilters.filter#test(myObjects.Checks)
	 */
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {

			if(rec.getAlt()>minAlt && rec.getAlt()<=maxAlt) {
				ans = true;
				}
			
		}
		return ans;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.minAlt+","+this.maxAlt+"]";
	}

	
	/** ******** Private data can be located anywhere ************. */
	private double minAlt, maxAlt;
}