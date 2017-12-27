package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * @author Boaz
	 *
	 */
public class altFilter implements filter{
	
	public altFilter(double min, double max) {
		minAlt = min;
		maxAlt = max;
	}

	
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getLat()>minAlt && rec.getLat()<=maxAlt) {
				ans = true;
				}
		}
		return ans;
	}
	
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.minAlt+","+this.maxAlt+"]";
	}

	
	/********** Private data can be located anywhere *************/
	private double minAlt, maxAlt;
}