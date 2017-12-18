/*
 * 
 */
package algorithms;

import static org.junit.Assert.*;


import java.util.Arrays;
import java.util.LinkedList;

import org.junit.Test;
import matala.*;

// TODO: Auto-generated Javadoc
/**
 * The Class algo2Test.
 */
public class algo2Test {

	/**
	 * W imgtest.
	 */
	@Test
	public void wImgtest() {
		
		LinkedList<Wifi> a = null;
		LinkedList<Checks> c = new LinkedList<>();

		WifiSort ws11 = new WifiSort("fc:b4:e6:cf:d1:dd", "ws11", 10, -62);
		WifiSort ws12 = new WifiSort("0a:8d:db:6e:71:6d", "ws12", 10, -79);
		WifiSort ws13 = new WifiSort("02:8d:db:6e:71:bf", "ws13", 10, -71);

		WifiSort ws21 = new WifiSort("fc:b4:e6:cf:d1:dd", "ws21", 10, -82);
		WifiSort ws22 = new WifiSort("0a:8d:db:6e:71:6d", "ws22", 10, -120);
		WifiSort ws23 = new WifiSort("02:8d:db:6e:71:bf", "ws23", 10, -82);

		WifiSort ws31 = new WifiSort("fc:b4:e6:cf:d1:dd", "ws31", 10, -62);
		WifiSort ws32 = new WifiSort("0a:8d:db:6e:71:6d", "ws32", 10, -89);
		WifiSort ws33 = new WifiSort("02:8d:db:6e:71:bf", "ws33", 10, -73);

		Checks c1 = new Checks("1", "net1", 32.103, 35.208, 650, 3, ws11, ws12, ws13);
		Checks c2 = new Checks("1", "net1", 32.105, 35.205, 660, 3, ws21, ws23, null);
		Checks c3 = new Checks("1", "net1", 32.103, 35.307, 680, 3, ws32, ws33, null);

		c.add(c1);
		c.add(c2);
		c.add(c3);
		
		algo2 al2 = new algo2();

		
		double[] result = al2.wImg(c, "fc:b4:e6:cf:d1:dd", "0a:8d:db:6e:71:6d", "02:8d:db:6e:71:bf", -50, -70, -90);
		
		double[] e = {32.10343, 35.22673,658.0198};
		assertEquals(e[0], result[0],0.001);
		assertEquals(e[1], result[1],0.001);
		assertEquals(e[2], result[2],0.001);

		
	}

}
