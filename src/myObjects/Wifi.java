/*
 * 
 */
package myObjects;

// TODO: Auto-generated Javadoc
/**
 * The Class Wifi.
 */
public class Wifi {
	
	/** The Mac. */
	private String Mac;
	
	/** The time. */
	private String time;
	
	/** The ssid. */
	private String ssid;
	
	/** The channel. */
	private int channel;
	
	/** The signal. */
	private int signal;
	
	/** The lat. */
	private double lat;
	
	/** The lon. */
	private double lon;
	
	/** The alt. */
	private double alt;
	
	/** The user. */
	private String user;
	
	/** The bool. */
	private boolean bool;
	
	/** The wdiff. */
	private double wdiff;
	
	
	/**
	 * Instantiates a new wifi.
	 *
	 * @param mac the mac
	 * @param time the time
	 * @param ssid the ssid
	 * @param channel the channel
	 * @param signal the signal
	 * @param lat the lat
	 * @param lon the lon
	 * @param alt the alt
	 * @param user the user
	 */
	public Wifi(String mac, String time, String ssid, int channel, 
			int signal, double lat, double lon, double alt, String user){
		
		this.Mac = mac;
		this.time = time;
		this.ssid = ssid;
		this.channel = channel;
		this.signal = signal;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.user = user;
		this.wdiff = 0;
	}
	
	/**
	 * Gets the wdiff.
	 *
	 * @return the wdiff
	 */
	public double getWdiff() {
		return wdiff;
	}

	/**
	 * Sets the wdiff.
	 *
	 * @param wdiff the new wdiff
	 */
	public void setWdiff(double wdiff) {
		this.wdiff = wdiff;
	}

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

	/**
	 * Gets the user.
	 *
	 * @return the user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * Sets the user.
	 *
	 * @param user the new user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Wifi [Mac=" + Mac + ", time=" + time + ", ssid=" + ssid + ", channel=" + channel + ", signal=" + signal
				+ ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", user=" + user + ", bool=" + bool + ", wdiff="
				+ wdiff + "]";
	}

	/**
	 * Instantiates a new wifi.
	 */
	public Wifi() {
		// TODO Auto-generated constructor stub
	}







	/**
	 * Gets the mac.
	 *
	 * @return the mac
	 */
	public String getMac() {
		return Mac;
	}





	/**
	 * Sets the mac.
	 *
	 * @param mac the new mac
	 */
	public void setMac(String mac) {
		Mac = mac;
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
	 * @param time the new time
	 */
	public void setTime(String time) {
		this.time = time;
	}





	/**
	 * Gets the ssid.
	 *
	 * @return the ssid
	 */
	public String getSsid() {
		return ssid;
	}





	/**
	 * Sets the ssid.
	 *
	 * @param ssid the new ssid
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}





	/**
	 * Gets the channel.
	 *
	 * @return the channel
	 */
	public int getChannel() {
		return channel;
	}





	/**
	 * Sets the channel.
	 *
	 * @param channel the new channel
	 */
	public void setChannel(int channel) {
		this.channel = channel;
	}





	/**
	 * Gets the signal.
	 *
	 * @return the signal
	 */
	public int getSignal() {
		return signal;
	}





	/**
	 * Sets the signal.
	 *
	 * @param signal the new signal
	 */
	public void setSignal(int signal) {
		this.signal = signal;
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
	 * @param lat the new lat
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
	 * @param lon the new lon
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
	 * @param alt the new alt
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}





	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
