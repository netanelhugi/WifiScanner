package GUI;

import java.util.LinkedList;

import myObjects.Checks;
import myObjects.Wifi;

public class counters {

	public static int boolCount(LinkedList<Checks> a) {

		int cou = 0;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i).isBool()) {
				cou++;
			}
		}
		return cou;

	}

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
