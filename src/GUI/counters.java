/*
 * 
 */
package GUI;

import java.util.LinkedList;

import myObjects.Checks;
import myObjects.Wifi;

// TODO: Auto-generated Javadoc
/**
 * The Class counters.
 */
public class counters {

	/**
	 * Bool count.
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int boolCount(LinkedList<Checks> a) {

		int cou = 0;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i).isBool()) {
				cou++;
			}
		}
		return cou;

	}

	/**
	 * Bool count wifi.
	 *
	 * @param a the a
	 * @return the int
	 */
	public static int boolCountWifi(LinkedList<Wifi> a) {

		int cou = 0;
		for (int i = 0; i < a.size(); i++) {

			if (a.get(i).isBool()) {
				cou++;
				System.out.println(a.get(i));
			}
		}
		return cou;

	}

}
