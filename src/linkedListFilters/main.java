/*
 * 
 */
package linkedListFilters;

import java.util.LinkedList;

import myObjects.Checks;

// TODO: Auto-generated Javadoc
/**
 * The Class main.
 */
public class main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList<Checks> a = new LinkedList<>();
		
		Checks c = new Checks();
		
		c.setTime("17:30:00");
		
		timeFilter tf = new timeFilter("17:00:00","18:00:00");
		
		System.out.println(tf.test(c));
		
	}

}
