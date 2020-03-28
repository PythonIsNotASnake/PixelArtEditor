package pixelArt;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Klasse Pixel ist abgeleitet von PixelArtImage
 * 
 * @author Bernd Mampe
 * @version 1.0
 */

public class Pixel extends PixelArtImage {
	// Attribute
	JLabel form;
	int breite, hoehe;

	// Konstruktoren
	/**
	 * Konstruktor fuer weissen Pixel
	 */
	public Pixel() {
		form = new JLabel("", JLabel.CENTER);
		breite = 20;
		hoehe = 20;

		form.setSize(hoehe, breite);
		Border bcolor = new LineBorder(Color.BLACK); // Farbe fuer Rahmen
		form.setBorder(bcolor); // setzt Rahmenfarbe
		form.setOpaque(true); // erlaubt Hintergrundfarbe fuer JLabel
		form.setBackground(pixelArt.PixelArtImage.farbe); // faerbt Pixel ein
		form.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					// Farbauswahl
					pixelArt.PixelArtImage.farbe = JColorChooser.showDialog(null, "Wähle Farbe", Color.black);
					// Farbe aus Farbauswahl wird auf Pixel gesetzt
					form.setBackground(pixelArt.PixelArtImage.farbe);
					// prueft nach linker Maustaste
				} else if (SwingUtilities.isLeftMouseButton(e)) {
					// setzt aktuelle Farbbelegung als Hintergrund
					form.setBackground(pixelArt.PixelArtImage.farbe);
					// Kreativitaets-Aufgabe: Prueft nach mittleren Maustaste
				} else if (SwingUtilities.isMiddleMouseButton(e)) {
					// Mausrad kopiert die Farbe eines Feldes
					pixelArt.PixelArtImage.farbe = form.getBackground();
				}
			}
		});
	}

	/**
	 * Konstruktor fuer farblich definierten Pixel
	 * 
	 * @param r
	 *            roter Farbanteil
	 * 
	 * @param g
	 *            gruener Farbanteil
	 * 
	 * @param b
	 *            blauer Farbanteil
	 */
	public Pixel(int r, int g, int b) {
		form = new JLabel("", JLabel.CENTER);
		breite = 20;
		hoehe = 20;
		Color paint = new Color(r, g, b);
		farbe = paint;
		form.setSize(hoehe, breite);
		Border bcolor = new LineBorder(Color.BLACK); // Farbe fuer Rahmen
		form.setBorder(bcolor); // setzt Rahmenfarbe
		form.setOpaque(true); // erlaubt Hintergrundfarbe fuer JLabel
		form.setBackground(pixelArt.PixelArtImage.farbe); // faerbt Pixel ein
		form.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (SwingUtilities.isRightMouseButton(e)) {
					// Farbauswahl
					pixelArt.PixelArtImage.farbe = JColorChooser.showDialog(null, "Wähle Farbe", Color.black);
					// Farbe aus Farbauswahl wird auf Pixel gesetzt
					form.setBackground(pixelArt.PixelArtImage.farbe);
					// prueft nach linker Maustaste
				} else if (SwingUtilities.isLeftMouseButton(e)) {
					// setzt aktuelle Farbbelegung als Hintergrund
					form.setBackground(pixelArt.PixelArtImage.farbe);
					// Kreativitaets-Aufgabe: Prueft nach mittleren Maustaste
				} else if (SwingUtilities.isMiddleMouseButton(e)) {
					// Mausrad kopiert die Farbe eines Feldes
					pixelArt.PixelArtImage.farbe = form.getBackground();
				}
			}
		});
	}

	/**
	 * Konstruktor fuer Ueberschrift- bzw. Legende-Pixel
	 * 
	 * @param inhalt
	 *            Text im Pixel
	 */
	public Pixel(String inhalt) {
		form = new JLabel(inhalt, JLabel.CENTER);
		breite = 20;
		hoehe = 20;
		form.setSize(hoehe, breite);
	}

	// Getter- und Setter-Methoden

	/**
	 * Setzt die Breite des Bildes.
	 * 
	 * @param b
	 *            Breite
	 */
	public void setBreite(int b) {
		breite = b;
	}

	/**
	 * Gibt die Breite des Bildes zurueck.
	 * 
	 * @return Breite des Bildes
	 */
	public int getBreite() {
		return breite;
	}

	/**
	 * Setzt die Hoehe des Bildes.
	 * 
	 * @param h
	 *            Hoehe
	 */
	public void setHoehe(int h) {
		hoehe = h;
	}

	/**
	 * Gibt die Hoehe des Bildes zurueck.
	 * 
	 * @return Hoehe des Bildes
	 */
	public int getHoehe() {
		return hoehe;
	}

	/**
	 * Setzt ein JLabel fuer den Pixel
	 * 
	 * @param z
	 *            neues JLabel
	 */
	public void setForm(JLabel z) {
		form = z;
	}

	/**
	 * Gibt das JLabel im Pixel zurueck
	 * 
	 * @return JLabel vom Pixel
	 */
	public JLabel getForm() {
		return form;
	}

}
