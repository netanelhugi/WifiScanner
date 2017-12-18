/*
 * 
 */
package myObjects;

// TODO: Auto-generated Javadoc
/**
 * The Class WifiSort.
 */
public class WifiSort {
	
	/** The Mac. */
	private String Mac;
	
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
	 * Instantiates a new wifi sort.
	 *
	 * @param mac the mac
	 * @param ssid the ssid
	 * @param channel the channel
	 * @param signal the signal
	 */
	public WifiSort(String mac, String ssid, int channel, int signal) {
		super();
		Mac = mac;
		this.ssid = ssid;
		this.channel = channel;
		this.signal = signal;
	}


	/**
	 * Gets the ssid.
	 *
	 * @return the ssid
	 */
	public String getSsid() {
		return ssid;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[Mac=" + Mac + ", ssid=" + ssid + ", channel=" + channel + ", signal=" + signal + "]";
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


	/** The ssid. */
	private String ssid;
	
	/** The channel. */
	private int channel;
	
	/** The signal. */
	private int signal;
	

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
