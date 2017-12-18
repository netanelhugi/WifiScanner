/*
 * 
 */
package matala;

import java.util.LinkedList;

// TODO: Auto-generated Javadoc
/**
 * The Class Checks.
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

	/** The ssid 1. */
	private String ssid1;

	/** The mac 1. */
	private String mac1;

	/** The channel 1. */
	private int channel1;

	/** The signal 1. */
	private int signal1;

	/** The ssid 2. */
	private String ssid2;

	/** The mac 2. */
	private String mac2;

	/** The channel 2. */
	private int channel2;

	/** The signal 2. */
	private int signal2;

	/** The ssid 3. */
	private String ssid3;

	/** The mac 3. */
	private String mac3;

	/** The channel 3. */
	private int channel3;

	/** The signal 3. */
	private int signal3;

	/** The ssid 4. */
	private String ssid4;

	/** The mac 4. */
	private String mac4;

	/** The channel 4. */
	private int channel4;

	/** The signal 4. */
	private int signal4;

	/** The ssid 5. */
	private String ssid5;

	/** The mac 5. */
	private String mac5;

	/** The channel 5. */
	private int channel5;

	/** The signal 5. */
	private int signal5;

	/** The ssid 6. */
	private String ssid6;

	/** The mac 6. */
	private String mac6;

	/** The channel 6. */
	private int channel6;

	/** The signal 6. */
	private int signal6;

	/** The ssid 7. */
	private String ssid7;

	/** The mac 7. */
	private String mac7;

	/** The channel 7. */
	private int channel7;

	/** The signal 7. */
	private int signal7;

	/** The ssid 8. */
	private String ssid8;

	/** The mac 8. */
	private String mac8;

	/** The channel 8. */
	private int channel8;

	/** The signal 8. */
	private int signal8;

	/** The ssid 9. */
	private String ssid9;

	/** The mac 9. */
	private String mac9;

	/** The channel 9. */
	private int channel9;

	/** The signal 9. */
	private int signal9;

	/** The ssid 10. */
	private String ssid10;

	/** The mac 10. */
	private String mac10;

	/** The channel 10. */
	private int channel10;

	/** The signal 10. */
	private int signal10;

	/** The w diff. */
	private double wDiff;

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
	 * Gets the ssid 1.
	 *
	 * @return the ssid 1
	 */
	public String getSsid1() {
		return ssid1;
	}

	/**
	 * Sets the ssid 1.
	 *
	 * @param ssid1
	 *            the new ssid 1
	 */
	public void setSsid1(String ssid1) {
		this.ssid1 = ssid1;
	}

	/**
	 * Gets the mac 1.
	 *
	 * @return the mac 1
	 */
	public String getMac1() {
		return mac1;
	}

	/**
	 * Sets the mac 1.
	 *
	 * @param mac1
	 *            the new mac 1
	 */
	public void setMac1(String mac1) {
		this.mac1 = mac1;
	}

	/**
	 * Gets the channel 1.
	 *
	 * @return the channel 1
	 */
	public int getChannel1() {
		return channel1;
	}

	/**
	 * Sets the channel 1.
	 *
	 * @param channel1
	 *            the new channel 1
	 */
	public void setChannel1(int channel1) {
		this.channel1 = channel1;
	}

	/**
	 * Gets the signal 1.
	 *
	 * @return the signal 1
	 */
	public int getSignal1() {
		return signal1;
	}

	/**
	 * Sets the signal 1.
	 *
	 * @param signal1
	 *            the new signal 1
	 */
	public void setSignal1(int signal1) {
		this.signal1 = signal1;
	}

	/**
	 * Gets the ssid 2.
	 *
	 * @return the ssid 2
	 */
	public String getSsid2() {
		return ssid2;
	}

	/**
	 * Sets the ssid 2.
	 *
	 * @param ssid2
	 *            the new ssid 2
	 */
	public void setSsid2(String ssid2) {
		this.ssid2 = ssid2;
	}

	/**
	 * Gets the mac 2.
	 *
	 * @return the mac 2
	 */
	public String getMac2() {
		return mac2;
	}

	/**
	 * Sets the mac 2.
	 *
	 * @param mac2
	 *            the new mac 2
	 */
	public void setMac2(String mac2) {
		this.mac2 = mac2;
	}

	/**
	 * Gets the channel 2.
	 *
	 * @return the channel 2
	 */
	public int getChannel2() {
		return channel2;
	}

	/**
	 * Sets the channel 2.
	 *
	 * @param channel2
	 *            the new channel 2
	 */
	public void setChannel2(int channel2) {
		this.channel2 = channel2;
	}

	/**
	 * Gets the signal 2.
	 *
	 * @return the signal 2
	 */
	public int getSignal2() {
		return signal2;
	}

	/**
	 * Sets the signal 2.
	 *
	 * @param signal2
	 *            the new signal 2
	 */
	public void setSignal2(int signal2) {
		this.signal2 = signal2;
	}

	/**
	 * Gets the ssid 3.
	 *
	 * @return the ssid 3
	 */
	public String getSsid3() {
		return ssid3;
	}

	/**
	 * Sets the ssid 3.
	 *
	 * @param ssid3
	 *            the new ssid 3
	 */
	public void setSsid3(String ssid3) {
		this.ssid3 = ssid3;
	}

	/**
	 * Gets the mac 3.
	 *
	 * @return the mac 3
	 */
	public String getMac3() {
		return mac3;
	}

	/**
	 * Sets the mac 3.
	 *
	 * @param mac3
	 *            the new mac 3
	 */
	public void setMac3(String mac3) {
		this.mac3 = mac3;
	}

	/**
	 * Gets the channel 3.
	 *
	 * @return the channel 3
	 */
	public int getChannel3() {
		return channel3;
	}

	/**
	 * Sets the channel 3.
	 *
	 * @param channel3
	 *            the new channel 3
	 */
	public void setChannel3(int channel3) {
		this.channel3 = channel3;
	}

	/**
	 * Gets the signal 3.
	 *
	 * @return the signal 3
	 */
	public int getSignal3() {
		return signal3;
	}

	/**
	 * Sets the signal 3.
	 *
	 * @param signal3
	 *            the new signal 3
	 */
	public void setSignal3(int signal3) {
		this.signal3 = signal3;
	}

	/**
	 * Gets the ssid 4.
	 *
	 * @return the ssid 4
	 */
	public String getSsid4() {
		return ssid4;
	}

	/**
	 * Sets the ssid 4.
	 *
	 * @param ssid4
	 *            the new ssid 4
	 */
	public void setSsid4(String ssid4) {
		this.ssid4 = ssid4;
	}

	/**
	 * Gets the mac 4.
	 *
	 * @return the mac 4
	 */
	public String getMac4() {
		return mac4;
	}

	/**
	 * Sets the mac 4.
	 *
	 * @param mac4
	 *            the new mac 4
	 */
	public void setMac4(String mac4) {
		this.mac4 = mac4;
	}

	/**
	 * Gets the channel 4.
	 *
	 * @return the channel 4
	 */
	public int getChannel4() {
		return channel4;
	}

	/**
	 * Sets the channel 4.
	 *
	 * @param channel4
	 *            the new channel 4
	 */
	public void setChannel4(int channel4) {
		this.channel4 = channel4;
	}

	/**
	 * Gets the signal 4.
	 *
	 * @return the signal 4
	 */
	public int getSignal4() {
		return signal4;
	}

	/**
	 * Sets the signal 4.
	 *
	 * @param signal4
	 *            the new signal 4
	 */
	public void setSignal4(int signal4) {
		this.signal4 = signal4;
	}

	/**
	 * Gets the ssid 5.
	 *
	 * @return the ssid 5
	 */
	public String getSsid5() {
		return ssid5;
	}

	/**
	 * Sets the ssid 5.
	 *
	 * @param ssid5
	 *            the new ssid 5
	 */
	public void setSsid5(String ssid5) {
		this.ssid5 = ssid5;
	}

	/**
	 * Gets the mac 5.
	 *
	 * @return the mac 5
	 */
	public String getMac5() {
		return mac5;
	}

	/**
	 * Sets the mac 5.
	 *
	 * @param mac5
	 *            the new mac 5
	 */
	public void setMac5(String mac5) {
		this.mac5 = mac5;
	}

	/**
	 * Gets the channel 5.
	 *
	 * @return the channel 5
	 */
	public int getChannel5() {
		return channel5;
	}

	/**
	 * Sets the channel 5.
	 *
	 * @param channel5
	 *            the new channel 5
	 */
	public void setChannel5(int channel5) {
		this.channel5 = channel5;
	}

	/**
	 * Gets the signal 5.
	 *
	 * @return the signal 5
	 */
	public int getSignal5() {
		return signal5;
	}

	/**
	 * Sets the signal 5.
	 *
	 * @param signal5
	 *            the new signal 5
	 */
	public void setSignal5(int signal5) {
		this.signal5 = signal5;
	}

	/**
	 * Gets the ssid 6.
	 *
	 * @return the ssid 6
	 */
	public String getSsid6() {
		return ssid6;
	}

	/**
	 * Sets the ssid 6.
	 *
	 * @param ssid6
	 *            the new ssid 6
	 */
	public void setSsid6(String ssid6) {
		this.ssid6 = ssid6;
	}

	/**
	 * Gets the mac 6.
	 *
	 * @return the mac 6
	 */
	public String getMac6() {
		return mac6;
	}

	/**
	 * Sets the mac 6.
	 *
	 * @param mac6
	 *            the new mac 6
	 */
	public void setMac6(String mac6) {
		this.mac6 = mac6;
	}

	/**
	 * Gets the channel 6.
	 *
	 * @return the channel 6
	 */
	public int getChannel6() {
		return channel6;
	}

	/**
	 * Sets the channel 6.
	 *
	 * @param channel6
	 *            the new channel 6
	 */
	public void setChannel6(int channel6) {
		this.channel6 = channel6;
	}

	/**
	 * Gets the signal 6.
	 *
	 * @return the signal 6
	 */
	public int getSignal6() {
		return signal6;
	}

	/**
	 * Sets the signal 6.
	 *
	 * @param signal6
	 *            the new signal 6
	 */
	public void setSignal6(int signal6) {
		this.signal6 = signal6;
	}

	/**
	 * Gets the ssid 7.
	 *
	 * @return the ssid 7
	 */
	public String getSsid7() {
		return ssid7;
	}

	/**
	 * Sets the ssid 7.
	 *
	 * @param ssid7
	 *            the new ssid 7
	 */
	public void setSsid7(String ssid7) {
		this.ssid7 = ssid7;
	}

	/**
	 * Gets the mac 7.
	 *
	 * @return the mac 7
	 */
	public String getMac7() {
		return mac7;
	}

	/**
	 * Sets the mac 7.
	 *
	 * @param mac7
	 *            the new mac 7
	 */
	public void setMac7(String mac7) {
		this.mac7 = mac7;
	}

	/**
	 * Gets the channel 7.
	 *
	 * @return the channel 7
	 */
	public int getChannel7() {
		return channel7;
	}

	/**
	 * Sets the channel 7.
	 *
	 * @param channel7
	 *            the new channel 7
	 */
	public void setChannel7(int channel7) {
		this.channel7 = channel7;
	}

	/**
	 * Gets the signal 7.
	 *
	 * @return the signal 7
	 */
	public int getSignal7() {
		return signal7;
	}

	/**
	 * Sets the signal 7.
	 *
	 * @param signal7
	 *            the new signal 7
	 */
	public void setSignal7(int signal7) {
		this.signal7 = signal7;
	}

	/**
	 * Gets the ssid 8.
	 *
	 * @return the ssid 8
	 */
	public String getSsid8() {
		return ssid8;
	}

	/**
	 * Sets the ssid 8.
	 *
	 * @param ssid8
	 *            the new ssid 8
	 */
	public void setSsid8(String ssid8) {
		this.ssid8 = ssid8;
	}

	/**
	 * Gets the mac 8.
	 *
	 * @return the mac 8
	 */
	public String getMac8() {
		return mac8;
	}

	/**
	 * Sets the mac 8.
	 *
	 * @param mac8
	 *            the new mac 8
	 */
	public void setMac8(String mac8) {
		this.mac8 = mac8;
	}

	/**
	 * Gets the channel 8.
	 *
	 * @return the channel 8
	 */
	public int getChannel8() {
		return channel8;
	}

	/**
	 * Sets the channel 8.
	 *
	 * @param channel8
	 *            the new channel 8
	 */
	public void setChannel8(int channel8) {
		this.channel8 = channel8;
	}

	/**
	 * Gets the signal 8.
	 *
	 * @return the signal 8
	 */
	public int getSignal8() {
		return signal8;
	}

	/**
	 * Sets the signal 8.
	 *
	 * @param signal8
	 *            the new signal 8
	 */
	public void setSignal8(int signal8) {
		this.signal8 = signal8;
	}

	/**
	 * Gets the ssid 9.
	 *
	 * @return the ssid 9
	 */
	public String getSsid9() {
		return ssid9;
	}

	/**
	 * Sets the ssid 9.
	 *
	 * @param ssid9
	 *            the new ssid 9
	 */
	public void setSsid9(String ssid9) {
		this.ssid9 = ssid9;
	}

	/**
	 * Gets the mac 9.
	 *
	 * @return the mac 9
	 */
	public String getMac9() {
		return mac9;
	}

	/**
	 * Sets the mac 9.
	 *
	 * @param mac9
	 *            the new mac 9
	 */
	public void setMac9(String mac9) {
		this.mac9 = mac9;
	}

	/**
	 * Gets the channel 9.
	 *
	 * @return the channel 9
	 */
	public int getChannel9() {
		return channel9;
	}

	/**
	 * Sets the channel 9.
	 *
	 * @param channel9
	 *            the new channel 9
	 */
	public void setChannel9(int channel9) {
		this.channel9 = channel9;
	}

	/**
	 * Gets the signal 9.
	 *
	 * @return the signal 9
	 */
	public int getSignal9() {
		return signal9;
	}

	/**
	 * Sets the signal 9.
	 *
	 * @param signal9
	 *            the new signal 9
	 */
	public void setSignal9(int signal9) {
		this.signal9 = signal9;
	}

	/**
	 * Gets the ssid 10.
	 *
	 * @return the ssid 10
	 */
	public String getSsid10() {
		return ssid10;
	}

	/**
	 * Sets the ssid 10.
	 *
	 * @param ssid10
	 *            the new ssid 10
	 */
	public void setSsid10(String ssid10) {
		this.ssid10 = ssid10;
	}

	/**
	 * Gets the mac 10.
	 *
	 * @return the mac 10
	 */
	public String getMac10() {
		return mac10;
	}

	/**
	 * Sets the mac 10.
	 *
	 * @param mac10
	 *            the new mac 10
	 */
	public void setMac10(String mac10) {
		this.mac10 = mac10;
	}

	/**
	 * Gets the channel 10.
	 *
	 * @return the channel 10
	 */
	public int getChannel10() {
		return channel10;
	}

	/**
	 * Sets the channel 10.
	 *
	 * @param channel10
	 *            the new channel 10
	 */
	public void setChannel10(int channel10) {
		this.channel10 = channel10;
	}

	/**
	 * Gets the signal 10.
	 *
	 * @return the signal 10
	 */
	public int getSignal10() {
		return signal10;
	}

	/**
	 * Sets the signal 10.
	 *
	 * @param signal10
	 *            the new signal 10
	 */
	public void setSignal10(int signal10) {
		this.signal10 = signal10;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Checks [ wDiff=" + wDiff + " time=" + time + ", id=" + id + ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", wifiCount="
				+ wifiCount + ", wifi1=" + wifi1 + ", wifi2=" + wifi2 + ", wifi3=" + wifi3 + ", wifi4=" + wifi4
				+ ", wifi5=" + wifi5 + ", wifi6=" + wifi6 + ", wifi7=" + wifi7 + ", wifi8=" + wifi8 + ", wifi9=" + wifi9
				+ ", wifi10=" + wifi10+"]";
	}

}
