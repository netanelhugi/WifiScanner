package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * @author Boaz
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
			if(rec.getLat()>minLon && rec.getLat()<=maxLon) {
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