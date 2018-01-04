/*
 * 
 */
package linkedListFilters;

import myObjects.*;

// TODO: Auto-generated Javadoc
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
	
	/**
	 * Instantiates a new i dfilter.
	 *
	 * @param name the name
	 */
	public IDfilter(String name) {
			ID = name;
	}

	
	/* (non-Javadoc)
	 * @see linkedListFilters.filter#test(myObjects.Checks)
	 */
	public boolean test(Checks rec) {
		boolean ans = false;
		if(rec!=null) {
			if(rec.getId().contains(ID)) {
				ans = true;
				}
		}
		return ans;
	}

	
		
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return ""+this.getClass().getName()+" ["+this.ID+"]";
	}



	/** ******** Private data can be located anywhere ************. */
	private String ID;
}