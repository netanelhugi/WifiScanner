package linkedListFilters;

import java.util.LinkedList;

import myObjects.Checks;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LinkedList<Checks> a = new LinkedList<>();
		
		Checks c = new Checks();
		
		c.setTime("17:30:00");
		
		timeFilter tf = new timeFilter("17:00:00","18:00:00");
		
		System.out.println(tf.test(c));
	}

}
