package pixelArt;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JColorChooser;
import javax.swing.JLabel;

import interfaces.PixelArtImageInterface;

/**
 * Objekt-Klasse fuer Objekte vom Typ PixelArtImage
 * 
 * @author Bernd Mampe
 * @version 1.0
 */
public class PixelArtImage implements PixelArtImageInterface {
	// Attribute
	int width, height;
	static Color farbe = Color.white;
	public Pixel[][] pixelFeld;

	// Konstruktoren
	/**
	 * Standard-Konstruktor
	 */
	public PixelArtImage() {
		width = 0;
		height = 0;
		farbe = Color.white;
		pixelFeld = new Pixel[this.getHeight()][this.getWidth()];
	}

	/**
	 * Konstruktor fuer vordefinierte Abmessungen
	 * 
	 * @param w
	 *            Breite
	 * 
	 * @param h
	 *            Hoehe
	 */
	public PixelArtImage(int w, int h) {
		width = w;
		height = h;
		farbe = Color.white;
		pixelFeld = new Pixel[this.getHeight()][this.getWidth()];
	}

	// Getter- und Setter-Methoden
	/**
	 * Setzt Breite des Bildes
	 * 
	 * @param w
	 *            Breite
	 */
	public void setWidth(int w) {
		width = w;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#getWidth()
	 */
	public int getWidth() {
		// TODO Automatisch generierter Methodenstub
		return width;
	}

	/**
	 * Setzt Hoehe des Bildes
	 * 
	 * @param h
	 *            Hoehe
	 */
	public void setHeight(int h) {
		height = h;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#getHeight()
	 */
	public int getHeight() {
		// TODO Automatisch generierter Methodenstub
		return height;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#getPixelAt(int, int)
	 */
	public Color getPixelAt(int x, int y) {
		// TODO Automatisch generierter Methodenstub
		return pixelFeld[x][y].getForm().getBackground();
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#setPixelAt(int, int, java.awt.Color)
	 */
	public void setPixelAt(int x, int y, Color color) {
		// TODO Automatisch generierter Methodenstub
		farbe = color;
		pixelFeld[x][y].getForm().setBackground(farbe);

	}

	// Methoden
	/**
	 * Erzeugen des Arrays mit weissen Pixeln
	 * 
	 * @param h
	 *            Hoehe des Bildes
	 * 
	 * @param w
	 *            Breite des Bildes
	 * 
	 * @return gefuelltes Pixel-Array
	 */
	public Pixel[][] erstelleArray(int h, int w) {

		// Array-Groesse setzen
		pixelFeld = new Pixel[h + 1][w + 1];
		// Farbe auf Weiss setzen
		farbe = Color.white;
		// aeussere Schleife um jede Zeile durchzugehen
		for (int hoehe = 0; hoehe <= h; hoehe++) {
			// innere Schleife um jede Spalte durchzugehen
			for (int breite = 0; breite <= w; breite++) {
				// prueft nach Eckpunkt oben links
				if (hoehe == 0 && breite == 0) {
					Pixel nullPixel = new Pixel("");
					pixelFeld[hoehe][breite] = nullPixel;
					// prueft nach Ueberschrift fuer Spalten
				} else if (hoehe == 0) {
					String inhalt = new String("" + (breite - 1));
					Pixel inhaltsPixel = new Pixel(inhalt);
					pixelFeld[hoehe][breite] = inhaltsPixel;
					// prueft nach Ueberschrift fuer Zeilen
				} else if (breite == 0) {
					String inhalt = new String("" + (hoehe - 1));
					Pixel inhaltsPixel = new Pixel(inhalt);
					pixelFeld[hoehe][breite] = inhaltsPixel;

				} else if (hoehe != 0 && breite != 0) {
					Pixel kleinerPixel = new Pixel();
					pixelFeld[hoehe][breite] = kleinerPixel;
				}
			}
		}
		return pixelFeld;
	}

	/**
	 * Erzeugen des Arrays mit vordefinierten Pixeln
	 * 
	 * @param h
	 *            Hoehe des Bildes
	 * 
	 * @param w
	 *            Breite des Bildes
	 * 
	 * @param a
	 *            Array mit Farben
	 * 
	 * @return gefuelltes Pixel-Array
	 */
	public Pixel[][] erstelleArray(int h, int w, String[][] a) {
		// wandelt das eingehende String-Array in ein Integer-Array um
		int farbArray[][] = new int[h][w * 3];
		for (int y = 0; y < h; y++) {
			for (int x = 0; x < (w * 3); x++) {
				int zahl = Integer.parseInt(a[y][x]);
				farbArray[y][x] = zahl;
			}
		}
		// Array-Groesse setzen
		pixelFeld = new Pixel[h + 1][w + 1];
		// aeussere Schleife um jede Zeile durchzugehen
		for (int hoehe = 0; hoehe <= h; hoehe++) {
			// innere Schleife um jede Spalte durchzugehen
			for (int breite = 0; breite <= w; breite++) {
				// prueft nach Eckpunkt oben links
				if (hoehe == 0 && breite == 0) {
					Pixel nullPixel = new Pixel("");
					pixelFeld[hoehe][breite] = nullPixel;
					// prueft nach Ueberschrift fuer Spalten
				} else if (hoehe == 0) {
					String inhalt = new String("" + (breite - 1));
					Pixel inhaltsPixel = new Pixel(inhalt);
					pixelFeld[hoehe][breite] = inhaltsPixel;
					// prueft nach Ueberschrift fuer Zeilen
				} else if (breite == 0) {
					String inhalt = new String("" + (hoehe - 1));
					Pixel inhaltsPixel = new Pixel(inhalt);
					pixelFeld[hoehe][breite] = inhaltsPixel;
				} else if (hoehe != 0 && breite != 0) {
					// ruft Konstruktor der Klasse Pixel auf
					Pixel kleinerPixel = new Pixel(farbArray[hoehe - 1][(breite - 1) * 3],
							farbArray[hoehe - 1][(breite - 1) * 3 + 1], farbArray[hoehe - 1][(breite - 1) * 3 + 2]);
					pixelFeld[hoehe][breite] = kleinerPixel;
				}
			}
		}
		return pixelFeld;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#saveToFile(java.lang.String)
	 */
	public boolean saveToFile(String filename) {
		// TODO Automatisch generierter Methodenstub
		File file;
		// erstellt neue Datei und prueft, ob .pixelart bereits die Endung ist
		if (filename.endsWith(".pixelart") == true) {
			file = new File(filename);
		} else {
			file = new File(filename + ".pixelart");
		}
		FileWriter fw = null;
		/**
		 * @throws IOException
		 *             e wenn FileWriter fw abstuerzt wird false zurueckgegeben
		 */
		try {
			fw = new FileWriter(file);
			// schreibt PixelArt in die erste Zeile
			fw.write("PixelArt\n");
			// schreibt die Abmessungen in die zweite Zeile
			fw.write(this.getWidth() + " " + this.getHeight() + "\n");

			// prueft nach g�ltigen Werten fuer Hoehe und Breite
			if (this.getHeight() < 1 || this.getWidth() < 1) {
				fw.close();
				return false;
			} else {
				// holt den Farbwert des entsprechenden Pixels und schreibt ihn
				// in die Datei
				for (int h = 1; h <= this.getHeight(); h++) {
					for (int b = 1; b <= this.getWidth(); b++) {
						Color bunt = pixelFeld[h][b].getForm().getBackground();
						fw.write(bunt.getRed() + " " + bunt.getGreen() + " " + bunt.getBlue() + " ");
					}
					// fuegt nach jeder fertigen Zeile einen Absatz ein
					fw.write("\n");
				}
			}
			fw.close();
		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			return false;
		}
		// gibt wahr zurueck, wenn das Programm fehlerfrei bis hierhin kam
		return true;
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#loadFromFile(java.lang.String)
	 */
	public boolean loadFromFile(String filename) {
		// TODO Automatisch generierter Methodenstub
		File file = new File(filename);
		FileReader fr = null;
		/**
		 * @throws FileNotFoundException
		 *             e wenn FileReader fr abstuerzt wird false zurueckgegeben
		 */
		try {
			fr = new FileReader(file);
			// ist die Dateiendung nicht ".pixelart", breche das Oeffnen ab
			if (filename.endsWith(".pixelart") == false) {
				/*
				 * @throws IOException e wenn FileReader fr nicht geschlossen werden kann gib
				 * false zurueck
				 */
				try {
					fr.close();
				} catch (IOException e) {
					// TODO Automatisch generierter Erfassungsblock
					e.printStackTrace();
				}
				return false;
			}
		} catch (FileNotFoundException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			return false;
		}
		BufferedReader br = new BufferedReader(fr);
		String zeileArt = null;
		/**
		 * @throws IOException
		 *             e wenn BufferedReader br das Array falsch liest wird false
		 *             zurueckgegeben
		 */
		try {
			// liest erste Zeile
			zeileArt = br.readLine();
			// prueft nach Wort PixelArt
			if (zeileArt.compareTo("PixelArt") != 0) {
				br.close();
				return false;
			}
			String zeileDimension = null;
			// liest zweite Zeile
			zeileDimension = br.readLine();
			// Array mit Abmessungen des PixelArtImages
			String masse[] = zeileDimension.split("\\s");
			// erste Position des Arrays ist die Breite
			int breite = Integer.parseInt(masse[0]);
			// zweite Position des Arrays ist die Hoehe
			int hoehe = Integer.parseInt(masse[1]);
			// jede Farbe besteht aus 3 Farbwerten
			int farbpunkteBreite = breite * 3;
			String farbeGesamt[][] = new String[hoehe][farbpunkteBreite];

			String zeile = null;
			int hoch = 0;
			// liest Datei bis zum Ende
			while ((zeile = br.readLine()) != null) {
				// erzeugt neues String-Array mit den Abmessungen der Breite
				String farbeZeile[] = new String[farbpunkteBreite];
				// eingelesene Zahlen werden im Array abgelegt
				farbeZeile = zeile.split("\\s");
				// das eindimensionale Array wird in ein zweidimensionale Array
				// umgewandelt
				for (int b = 0; b < farbpunkteBreite; b++) {
					farbeGesamt[hoch][b] = farbeZeile[b];
				}
				hoch++;
			}
			br.close();
			this.setWidth(breite);
			this.setHeight(hoehe);
			// Methode zum erstellen des PixelArtImage-Arrays wird abgerufen
			this.erstelleArray(this.getHeight(), this.getWidth(), farbeGesamt);
		} catch (IOException e) {
			// TODO Automatisch generierter Erfassungsblock
			e.printStackTrace();
			return false;
		}
		// gibt wahr zurueck, wenn das Programm fehlerfrei bis hierhin kam
		return true;
	}

	// Filter-Methoden
	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#invertColors()
	 */
	public void invertColors() {
		// TODO Automatisch generierter Methodenstub
		// aeussere Schleife geht jede Zeile durch
		for (int hoehe = 1; hoehe <= this.getHeight(); hoehe++) {
			// innere Schleife geht jede Spalte durch
			for (int breite = 1; breite <= this.getWidth(); breite++) {
				// Zwischenspeicherung der Hintergrundfarbe
				Color bunt = pixelFeld[hoehe][breite].getForm().getBackground();
				// invertiert den Farbwert
				Color invert = new Color(255 - bunt.getRed(), 255 - bunt.getGreen(), 255 - bunt.getBlue());
				// faerbt den Pixel mit invertierter Farbe
				this.setPixelAt(hoehe, breite, invert);
			}
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#convertToGrayScale()
	 */
	public void convertToGrayScale() {
		// TODO Automatisch generierter Methodenstub
		// aeussere Schleife geht jede Zeile durch
		for (int hoehe = 1; hoehe <= height; hoehe++) {
			// innere Schleife geht jede Spalte durch
			for (int breite = 1; breite <= width; breite++) {
				// initialisiert Integer-Wert fuer Farbberechnung
				int grauerFarbwert = 0;
				// Zwischenspeicherung der Hintergrundfarbe
				Color bunt = pixelFeld[hoehe][breite].getForm().getBackground();
				// fuehrt Farbberechnung durch
				grauerFarbwert = (bunt.getRed() + bunt.getGreen() + bunt.getBlue()) / 3;
				// wandelt RGB-Werte in ein Objekt vom Typ Color um
				Color graueFarbe = new Color(grauerFarbwert, grauerFarbwert, grauerFarbwert);
				// faerbt den Pixel mit Graustufe
				this.setPixelAt(hoehe, breite, graueFarbe);
			}
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#mirrorHorizontally()
	 */
	public void mirrorHorizontally() {
		// TODO Automatisch generierter Methodenstub
		// aeussere Schleife geht jede Zeile durch
		for (int hoehe = 1; hoehe <= (height / 2); hoehe++) {
			// innere Schleife geht jede Spalte durch
			for (int breite = 1; breite <= width; breite++) {
				// erstellt temporaere JLabels fuer Zwischenspeicherung
				JLabel tempLeft = new JLabel();
				JLabel tempRight = new JLabel();
				// gibt temporaeren JLabeln Hintergrundfarbe
				tempLeft.setBackground(this.getPixelAt(hoehe, breite));
				tempRight.setBackground(this.getPixelAt(height + 1 - hoehe, breite));
				// setzt temporaeren Farbwert der JLabels als Hintergrundfarbe
				this.setPixelAt(hoehe, breite, tempRight.getBackground());
				this.setPixelAt(height + 1 - hoehe, breite, tempLeft.getBackground());
			}
		}
	}

	@Override
	/**
	 * {@inheritDoc}
	 * 
	 * @see interfaces.PixelArtImageInterface#mirrorVertically()
	 */
	public void mirrorVertically() {
		// TODO Automatisch generierter Methodenstub
		// aeussere Schleife geht jede Zeile durch
		for (int hoehe = 1; hoehe <= height; hoehe++) {
			// innere Schleife geht jede Spalte durch
			for (int breite = 1; breite <= (width / 2); breite++) {
				// erstellt temporaere JLabels fuer Zwischenspeicherung
				JLabel tempLeft = new JLabel();
				JLabel tempRight = new JLabel();
				// gibt temporaeren JLabeln Hintergrundfarbe
				tempLeft.setBackground(this.getPixelAt(hoehe, breite));
				tempRight.setBackground(this.getPixelAt(hoehe, width + 1 - breite));
				// setzt temporaeren Farbwert der JLabels als Hintergrundfarbe
				this.setPixelAt(hoehe, breite, tempRight.getBackground());
				this.setPixelAt(hoehe, width + 1 - breite, tempLeft.getBackground());
			}
		}
	}

	/**
	 * Kreativitaets-Aufgabe: Eine Farbe waehlen und alle Pixel in dieser Farbe
	 * einfaerben
	 */
	public void allColor() {
		// auswaehlen der Farbe
		farbe = JColorChooser.showDialog(null, "Wähle Farbe", Color.black);
		// Schleife geht jeden Pixel im Array durch
		for (int hoehe = 1; hoehe <= height; hoehe++) {
			for (int breite = 1; breite <= width; breite++) {
				// setzt gewaehlten Farbwert fuer Pixel
				this.setPixelAt(hoehe, breite, farbe);
			}
		}
	}

	/**
	 * Kreativitaets-Aufgabe: Eine Farbe waehlen und alle weissen Pixel in dieser
	 * Farbe einfaerben
	 */
	public void recolorAllWhite() {
		// auswaehlen der Farbe
		farbe = JColorChooser.showDialog(null, "Wähle Farbe", Color.black);
		// Schleife geht jeden Pixel im Array durch
		for (int hoehe = 1; hoehe <= height; hoehe++) {
			for (int breite = 1; breite <= width; breite++) {
				// prueft ob aktueller Pixel weiss ist
				if (this.getPixelAt(hoehe, breite).getRed() == 255 && this.getPixelAt(hoehe, breite).getGreen() == 255
						&& this.getPixelAt(hoehe, breite).getBlue() == 255) {
					// faerbt Pixel in gewaehlte Farbe
					this.setPixelAt(hoehe, breite, farbe);
				}
			}
		}
	}
}
