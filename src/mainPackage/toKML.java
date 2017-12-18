/*
 * 
 */
package mainPackage;

import java.io.File;


import algorithms.*;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.TimePrimitive;
import myObjects.*;

// TODO: Auto-generated Javadoc
/**
 * The Class toKML.
 */
public class toKML {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {

	}

	/**
	 * To kml.
	 *
	 * @param w the w
	 * @param newFile the new file
	 * @throws FileNotFoundException the file not found exception
	 */
	public void toKml(LinkedList<Wifi> w, String newFile) throws FileNotFoundException {
		/**
		 * this method get LinkedList<Wifi> and name of the new file. and use jak to
		 * create kml file. https://labs.micromata.de/projects/jak.html
		 */

		PrintWriter pw = new PrintWriter(new File(newFile + ".kml"));
		StringBuilder writer = new StringBuilder();

		MatrixSortByMAC macS = new MatrixSortByMAC();
		macS.sortByMac(w);
		
		algo1 al = new algo1();
		
		LinkedList<Wifi> wi = al.bestSignal(w);
		
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName(newFile).withOpen(true);

		Folder folder = doc.createAndAddFolder();
		folder.withName("wifi networks: ").withOpen(true);
		

		for (int i = 0; i <wi.size(); i++) {

			if (wi.get(i).isBool() == true) {

				createPlacemarkWithChart(doc, folder,wi.get(i));
			}
		}
		kml.marshal(new File(newFile + ".kml"));
	}

	/**
	 * Creates the placemark with chart.
	 *
	 * @param document the document
	 * @param folder the folder
	 * @param w the w
	 */
	private static void createPlacemarkWithChart(Document document, Folder folder, Wifi w) {
		String time = w.getTime();
		System.out.println(time);
		//2007-01-14T21:06:04Z
		String newTime = time.substring(0, 4) + "-" + time.substring(5, 7) + "-" + time.substring(8, 10) + "T"
				+ time.substring(11, 19) + "Z";
		 //System.out.println(newTime);

		Placemark placemark = folder.createAndAddPlacemark();
		placemark.withName(w.getSsid())
				.withDescription("<![CDATA[" + "<b>" + w.getSsid() + "</b><br/><br/>" + "MAC: <b>"
						+ w.getMac() + "</b><br/>Chennel: <b>" + w.getChannel() + "</b><br/>Signal: <b>"
						+ w.getSignal() + "</b><br/>")

				// coordinates and distance (zoom level) of the viewer
				.createAndSetLookAt().withLongitude(w.getLon()).withLatitude(w.getLat()).withAltitude(0)
				.withRange(12000000);

		placemark.createAndSetPoint().addToCoordinates(w.getLon(), w.getLat()); // set
																				// coordinates
		// add time stamp for timeline.
		placemark.createAndSetTimeStamp().setWhen(newTime);
	}

}
