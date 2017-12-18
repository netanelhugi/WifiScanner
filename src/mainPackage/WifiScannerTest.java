/*
 * junit test class for WifiScanner
 */
package mainPackage;

import static org.junit.Assert.*;

import java.io.File;
import java.util.LinkedList;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Test;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * WifiScannerTest.
 */
public class WifiScannerTest {

	
	/**
	 * Find rssi test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findRssiTest() throws Exception {
		String s = "30:b5:c2:fe:aa:56,NGOGA,[WPA2-PSK-CCMP][WPS][ESS],2017-10-27 16:13:51,6,-87,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		int result = ws.findRssi(s);
		assertEquals(-87, result);
	}

	/**
	 * Check ext test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void CheckExtTest() throws Exception {
		String s = "c:\\wifiScanner\\testFiles\\WigleWifi_20171027164539.csv";

		WifiScanner ws = new WifiScanner();
		File f = new File(s);

		String result = ws.CheckExt(f);
		assertEquals(".csv", result);
	}

	/**
	 * Wifi number test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void wifiNumberTest() throws Exception {
		String s = "c:\\wifiScanner\\testFiles\\WigleWifi_20171027164539.csv";

		WifiScanner ws = new WifiScanner();
		File f = new File(s);

		int result = ws.wifiNumber(f);
		assertEquals(294, result);
	}

	/**
	 * User name test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void userNameTest() throws Exception {

		String s = "WigleWifi-1.4,appRelease=2.25,model=ONEPLUS A3003,release=7.1.1,device=OnePlus3T,display=ONEPLUS A3003_28_171012,board=QC_Reference_Phone,brand=OnePlus";

		WifiScanner ws = new WifiScanner();

		String result = ws.userName(s);
		assertEquals("ONEPLUS A3003", result);
	}

	/**
	 * Find coordinate test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findCoordinateTest() throws Exception {

		String s = "c0:ac:54:f5:7b:a7,osnatg370,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-10-27 16:13:51,11,-86,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		double[] result = ws.findCoordinate(s);
		double[] e = {32.16876665, 34.81320794,37};
		assertEquals(e[0], result[0],0.001);
		assertEquals(e[1], result[1],0.001);
		assertEquals(e[2], result[2],0.001);
	}
	
	/**
	 * Find time test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findTimeTest() throws Exception {

		String s = "c0:ac:54:f5:7b:a7,osnatg370,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-10-27 16:13:51,11,-86,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		String result = ws.findTime(s);
		assertEquals("2017-10-27 16:13:51", result);
	}
	
	/**
	 * Find mac test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findMacTest() throws Exception {

		String s = "c0:ac:54:f5:7b:a7,osnatg370,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-10-27 16:13:51,11,-86,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		String result = ws.findMac(s);
		assertEquals("c0:ac:54:f5:7b:a7", result);
	}
	
	/**
	 * Find channel test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findChannelTest() throws Exception {

		String s = "c0:ac:54:f5:7b:a7,osnatg370,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-10-27 16:13:51,11,-86,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		int result = ws.findChannel(s);
		assertEquals(11, result);
	}
	
	/**
	 * Find SSID test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findSSIDTest() throws Exception {

		String s = "c0:ac:54:f5:7b:a7,osnatg370,[WPA-PSK-CCMP+TKIP][WPA2-PSK-CCMP+TKIP][ESS],2017-10-27 16:13:51,11,-86,32.16876665,34.81320794,37,4.550999641418457,WIFI";

		WifiScanner ws = new WifiScanner();

		String result = ws.findSSID(s);
		assertEquals("osnatg370", result);
	}
	
	/**
	 * Findsort by lat test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findsortByLatTest() throws Exception {
		LinkedList<Wifi> a = new LinkedList<>();
		
		Wifi first = new Wifi();
		first.setLat(34.1);
		a.add(first);
		
		Wifi sec = new Wifi();
		sec.setLat(33.1);
		a.add(sec);
		
		Wifi tr = new Wifi();
		tr.setLat(20.1);
		a.add(tr);
		
		LinkedList<Wifi> exp = new LinkedList<>();
		exp.add(tr);
		exp.add(sec);
		exp.add(first);
		
		
		WifiScanner ws = new WifiScanner();
		LinkedList<Wifi> result = ws.sortByLat(a);
		assertEquals(exp, result);
	}
	
	/**
	 * Findsort by signal test.
	 *
	 * @throws Exception the exception
	 */
	@Test
	public void findsortBySignalTest() throws Exception {
		LinkedList<Wifi> a = new LinkedList<>();
		Wifi tr = new Wifi();
		tr.setSignal(-70);
		a.add(tr);
		
		Wifi first = new Wifi();
		first.setSignal(-50);
		a.add(first);
		
		Wifi sec = new Wifi();
		sec.setSignal(-60);
		a.add(sec);
		
		
		
		LinkedList<Wifi> exp = new LinkedList<>();
		exp.add(first);
		exp.add(sec);
		exp.add(tr);
		
		WifiScanner ws = new WifiScanner();
		LinkedList<Wifi> result = ws.sortBySignal(a);
		assertEquals(exp, result);
	}
	
	
	
	

}
