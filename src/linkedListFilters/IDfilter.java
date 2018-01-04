/*
 * 
 */
package linkedListFilters;

import myObjects.*;

/**
	 * This class represents a simple time filter based on a 1D time window range
	 * 
	 * this class take from assignment solution github
	 * https://github.com/benmoshe/OOP_Exe
	 * 
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

	
		
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.ID+"]";
	}



	/********** Private data can be located anywhere *************/
	private String ID;
}