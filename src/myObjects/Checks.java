/*
 * 
 */
package myObjects;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Checks.
 * this object represents line of our csv file.
 */
public class Checks {

	/** The time. */
	private String time;

	/** The id. */
	private String id;

	/** The lat. */
	private double lat;

	/** The lon. */
	private double lon;

	/** The alt. */
	private double alt;

	/** The wifi count. */
	private int wifiCount;

	/** The wifi 1. */
	private WifiSort wifi1;

	/** The wifi 2. */
	private WifiSort wifi2;

	/** The wifi 3. */
	private WifiSort wifi3;

	/** The wifi 4. */
	private WifiSort wifi4;

	/** The wifi 5. */
	private WifiSort wifi5;

	/** The wifi 6. */
	private WifiSort wifi6;

	/** The wifi 7. */
	private WifiSort wifi7;

	/** The wifi 8. */
	private WifiSort wifi8;

	/** The wifi 9. */
	private WifiSort wifi9;

	/** The wifi 10. */
	private WifiSort wifi10;
	
	/** The w diff. */
	private double wDiff;
	
	/**
	 * Checks if is bool.
	 *
	 * @return true, if is bool
	 */
	public boolean isBool() {
		return bool;
	}

	/**
	 * Sets the bool.
	 *
	 * @param bool the new bool
	 */
	public void setBool(boolean bool) {
		this.bool = bool;
	}

	/** The bool. */
	private boolean bool;

	/**
	 * Gets the wifi 1.
	 *
	 * @return the wifi 1
	 */
	public WifiSort getWifi1() {
		return wifi1;
	}

	/**
	 * Sets the wifi 1.
	 *
	 * @param wifi1
	 *            the new wifi 1
	 */
	public void setWifi1(WifiSort wifi1) {
		this.wifi1 = wifi1;
	}

	/**
	 * Gets the wifi 2.
	 *
	 * @return the wifi 2
	 */
	public WifiSort getWifi2() {
		return wifi2;
	}

	/**
	 * Sets the wifi 2.
	 *
	 * @param wifi2
	 *            the new wifi 2
	 */
	public void setWifi2(WifiSort wifi2) {
		this.wifi2 = wifi2;
	}

	/**
	 * Gets the wifi 3.
	 *
	 * @return the wifi 3
	 */
	public WifiSort getWifi3() {
		return wifi3;
	}

	/**
	 * Sets the wifi 3.
	 *
	 * @param wifi3
	 *            the new wifi 3
	 */
	public void setWifi3(WifiSort wifi3) {
		this.wifi3 = wifi3;
	}

	/**
	 * Gets the wifi 4.
	 *
	 * @return the wifi 4
	 */
	public WifiSort getWifi4() {
		return wifi4;
	}

	/**
	 * Sets the wifi 4.
	 *
	 * @param wifi4
	 *            the new wifi 4
	 */
	public void setWifi4(WifiSort wifi4) {
		this.wifi4 = wifi4;
	}

	/**
	 * Gets the wifi 5.
	 *
	 * @return the wifi 5
	 */
	public WifiSort getWifi5() {
		return wifi5;
	}

	/**
	 * Sets the wifi 5.
	 *
	 * @param wifi5
	 *            the new wifi 5
	 */
	public void setWifi5(WifiSort wifi5) {
		this.wifi5 = wifi5;
	}

	/**
	 * Gets the wifi 6.
	 *
	 * @return the wifi 6
	 */
	public WifiSort getWifi6() {
		return wifi6;
	}

	/**
	 * Sets the wifi 6.
	 *
	 * @param wifi6
	 *            the new wifi 6
	 */
	public void setWifi6(WifiSort wifi6) {
		this.wifi6 = wifi6;
	}

	/**
	 * Gets the wifi 7.
	 *
	 * @return the wifi 7
	 */
	public WifiSort getWifi7() {
		return wifi7;
	}

	/**
	 * Sets the wifi 7.
	 *
	 * @param wifi7
	 *            the new wifi 7
	 */
	public void setWifi7(WifiSort wifi7) {
		this.wifi7 = wifi7;
	}

	/**
	 * Gets the wifi 8.
	 *
	 * @return the wifi 8
	 */
	public WifiSort getWifi8() {
		return wifi8;
	}

	/**
	 * Sets the wifi 8.
	 *
	 * @param wifi8
	 *            the new wifi 8
	 */
	public void setWifi8(WifiSort wifi8) {
		this.wifi8 = wifi8;
	}

	/**
	 * Gets the wifi 9.
	 *
	 * @return the wifi 9
	 */
	public WifiSort getWifi9() {
		return wifi9;
	}

	/**
	 * Sets the wifi 9.
	 *
	 * @param wifi9
	 *            the new wifi 9
	 */
	public void setWifi9(WifiSort wifi9) {
		this.wifi9 = wifi9;
	}

	/**
	 * Gets the wifi 10.
	 *
	 * @return the wifi 10
	 */
	public WifiSort getWifi10() {
		return wifi10;
	}

	/**
	 * Sets the wifi 10.
	 *
	 * @param wifi10
	 *            the new wifi 10
	 */
	public void setWifi10(WifiSort wifi10) {
		this.wifi10 = wifi10;
	}


	

	/**
	 * Gets the w diff.
	 *
	 * @return the w diff
	 */
	public double getwDiff() {
		return wDiff;
	}

	/**
	 * Sets the w diff.
	 *
	 * @param wDiff
	 *            the new w diff
	 */
	public void setwDiff(double wDiff) {
		this.wDiff = wDiff;
	}

	/**
	 * Cont MAC.
	 *
	 * @param mac the mac
	 * @return the int
	 */
	public int contMAC(String mac){
		
		if(wifi1!=null){
		if(mac.equals(wifi1.getMac())){
		//	System.out.println("equals: " + wifi1.getSignal());
			return wifi1.getSignal();
		}
		}
		
		if(wifi2!=null){
		if(mac.equals(wifi2.getMac())){
		//	System.out.println("equals: " + wifi2.getSignal());

			return wifi2.getSignal();

		}
		}
		
		if(wifi3!=null){
		if(mac.equals(wifi3.getMac())){
			//System.out.println("equals: " + wifi3.getSignal());

			return wifi3.getSignal();

		}
		}
		if(wifi4!=null){
		if(mac.equals(wifi4.getMac())){
			//System.out.println("equals: " + wifi4.getSignal());

			return wifi4.getSignal();
		}
		}
		
		if(wifi5!=null){
		if(mac.equals(wifi5.getMac())){
			//System.out.println("equals: " + wifi5.getSignal());

			return wifi5.getSignal();

		}
		}
		if(wifi6!=null){
		if(mac.equals(wifi6.getMac())){
			//System.out.println("equals: " + wifi6.getSignal());

			return wifi6.getSignal();

		}
		}
		if(wifi7!=null){
		if(mac.equals(wifi7.getMac())){
			//System.out.println("equals: " + wifi7.getSignal());

			return wifi7.getSignal();

		}
		}
		if(wifi8!=null){
		if(mac.equals(wifi8.getMac())){
			//System.out.println("equals: " + wifi8.getSignal());

			return wifi8.getSignal();

		}
		}
		
		if(wifi9!=null){
		if(mac.equals(wifi9.getMac())){
			//System.out.println("equals: " + wifi9.getSignal());

			return wifi9.getSignal();

		}
		}
		 
		if(wifi10!=null){	
			if(mac.equals(wifi10.getMac())){
				//System.out.println("equals: " + wifi10.getSignal());

			return wifi10.getSignal();

		}
		}
		
		
		return 1;
	}

	/**
	 * Instantiates a new checks.
	 *
	 * @param time
	 *            the time
	 * @param id
	 *            the id
	 * @param lat
	 *            the lat
	 * @param lon
	 *            the lon
	 * @param alt
	 *            the alt
	 * @param wifiCount
	 *            the wifi count
	 * @param wifi1
	 *            the wifi 1
	 * @param wifi2
	 *            the wifi 2
	 * @param wifi3
	 *            the wifi 3
	 */
	public Checks(String time, String id, double lat, double lon, double alt, int wifiCount, WifiSort wifi1,
			WifiSort wifi2, WifiSort wifi3) {
		super();
		this.time = time;
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.wifiCount = wifiCount;
		this.wifi1 = wifi1;
		this.wifi2 = wifi2;
		this.wifi3 = wifi3;
	}

	/**
	 * Instantiates a new checks.
	 */
	public Checks() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the time.
	 *
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * Sets the time.
	 *
	 * @param time
	 *            the new time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the lat.
	 *
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * Sets the lat.
	 *
	 * @param lat
	 *            the new lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * Gets the lon.
	 *
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * Sets the lon.
	 *
	 * @param lon
	 *            the new lon
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * Gets the alt.
	 *
	 * @return the alt
	 */
	public double getAlt() {
		return alt;
	}

	/**
	 * Sets the alt.
	 *
	 * @param alt
	 *            the new alt
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}

	/**
	 * Gets the wifi count.
	 *
	 * @return the wifi count
	 */
	public int getWifiCount() {
		return wifiCount;
	}

	/**
	 * Sets the wifi count.
	 *
	 * @param wifiCount
	 *            the new wifi count
	 */
	public void setWifiCount(int wifiCount) {
		this.wifiCount = wifiCount;
	}

	

	

	/**
	 * The main method.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "Checks [time=" + time + ", id=" + id + ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", wifiCount="
				+ wifiCount + ", wifi1=" + wifi1 + ", wifi2=" + wifi2 + ", wifi3=" + wifi3 + ", wifi4=" + wifi4
				+ ", wifi5=" + wifi5 + ", wifi6=" + wifi6 + ", wifi7=" + wifi7 + ", wifi8=" + wifi8 + ", wifi9=" + wifi9
				+ ", wifi10=" + wifi10 + ", wDiff=" + wDiff + ", bool=" + bool + "]";
	}

}
