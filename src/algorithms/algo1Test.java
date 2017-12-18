package algorithms;

import static org.junit.Assert.*;
import java.util.LinkedList;
import myObjects.*;

import org.junit.Test;

import mainPackage.*;

// TODO: Auto-generated Javadoc
/**
 * The Class algo1Test.
 */
public class algo1Test {
	
	/**
	 * Waverage.
	 */
	@Test
	public void Waverage(){
		
		Wifi a = new Wifi();
		a.setSignal(-30);
		a.setLat(32.103);
		a.setLon(35.208);
		a.setAlt(650);
		
		Wifi b = new Wifi();
		b.setSignal(-80);
		b.setLat(32.105);
		b.setLon(35.205);
		b.setAlt(660);
		
		Wifi c = new Wifi();
		c.setSignal(-90);
		c.setLat(32.103);
		c.setLon(35.307);
		c.setAlt(680);
		
		LinkedList<Wifi> ll = new LinkedList<>();
		ll.add(a);
		ll.add(b);
		ll.add(c);
		
		algo1 al1 = new algo1();
		
		Wifi result = al1.Waverage(ll);
		
		
		System.out.println(result);
		
		assertEquals(32.10322,result.getLat(),0.001);
		assertEquals(35.21645,result.getLon(),0.001);
		assertEquals(653.7864,result.getAlt(),0.001);

		
	}

}
