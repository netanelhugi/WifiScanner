package linkedListFilters;

import java.io.Serializable;

import mainPackage.*;
import algorithms.*;
import GUI.*;
import myObjects.*;

/**
 * This interface represents a simple boolean filter
 * @author Boaz
 *
 */
public interface filter{
	/**
	 * test if the Record rec is pass the filter 
	 * @param rec
	 * @return true iff: the record pass the filter, else returns false 
	 */
	public boolean test(Checks rec);
}