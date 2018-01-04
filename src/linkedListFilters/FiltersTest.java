/*
 * 
 */
package linkedListFilters;

import static org.junit.Assert.*;

import org.junit.Test;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class FiltersTest.
 */
public class FiltersTest {
	
	
	/**
	 * Time test.
	 */
	@Test
	public void TimeTest() {

		Checks c = new Checks();
		
		c.setTime("2017-10-10 22:22:22");
		
		timeFilter time = new timeFilter("2010-10-10 22:22:22", "2018-10-10 22:22:22");
		
		boolean result = time.test(c);
		
		assertEquals(true,result);
	
	
	}
	
	
	/**
	 * I dtest.
	 */
	@Test
	public void IDtest() {

		Checks c = new Checks();
		
		c.setId("someOne");
		
		IDfilter id = new IDfilter("someOne");
		
		boolean result = id.test(c);
		
		assertEquals(true,result);
	
	
	}
	
	
	/**
	 * Lat test.
	 */
	@Test
	public void LatTest() {

		Checks c = new Checks();
		
		c.setLat(32.0);
		
		latFilter lat = new latFilter(30.0,32.0);
		
		boolean result = lat.test(c);
		
		assertEquals(true,result);
	
	
	}
	
	/**
	 * Lon test.
	 */
	@Test
	public void LonTest() {

		Checks c = new Checks();
		
		c.setLon(32.0);
		
		lonFilter lon = new lonFilter(30.0,32.0);
		
		boolean result = lon.test(c);
		
		assertEquals(true,result);
	
	
	}

	/**
	 * Alttest.
	 */
	@Test
	public void Alttest() {

		Checks c = new Checks();
		
		c.setAlt(32.0);
		
		altFilter alt = new altFilter(30.0,32.0);
		
		boolean result = alt.test(c);
		
		assertEquals(true,result);
	
	
	}

}
