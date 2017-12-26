package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * @author Boaz
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

	
	/********** Private data can be located anywhere *************/
	private double minLat, maxLat;
}