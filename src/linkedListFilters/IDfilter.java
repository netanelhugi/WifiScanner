package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * @author Boaz
	 *
	 */
public class IDfilter implements filter{
	
	public IDfilter(String name) {
			ID = name;
	}

	
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getId().contains(ID)) {
				ans = true;
				}
		}
		return ans;
	}

	
		
	@Override
	public String toString() {
		return "IDfilter [ID=" + ID + "]";
	}



	/********** Private data can be located anywhere *************/
	private String ID;
}