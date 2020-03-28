package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import pixelArt.PixelArtImage;

/**
 * Klasse zur Erzeugung der grafischen Benutzeroberflaeche
 * 
 * @author Bernd Mampe
 * @version 1.0
 */
public class GraphicalUI implements ActionListener {
	// Objekte auf die jede Methode der Klasse zugreifen soll
	public static JFrame window;
	public static JPanel contentPane;
	public static JScrollPane scrollPanel;
	public PixelArtImage pixelArt;
	// Menu-Unterpunkte
	private final String close = "Beenden";
	private final String impressum = "Ueber Pixel-Art";
	private final String newImage = "Neu";
	private final String open = "Oeffnen";
	private final String save = "Speichern";
	private final String invert = "Invertieren";
	private final String grayScale = "Graustufen";
	private final String horizontal = "Horizontal spiegeln";
	private final String vertical = "Vertikal spiegeln";
	private final String allColor = "Alles einfaerben";
	private final String recolor = "Alle weissen Felder umfaerben";

	/**
	 * Konstruktor zum Erstellen der grafischen Benutzeroberflaeche
	 */
	public GraphicalUI() {

		pixelArt = new PixelArtImage();
		window = new JFrame("Pixel Art Editor - Definitive Edition");
		// Parameter des Fensters
		window.setSize(1024, 768);
		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		window.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				beendenDialog();
			}
		});
		contentPane = new JPanel();

		Border bo = new LineBorder(Color.GRAY);
		JMenuBar menubar = new JMenuBar();
		menubar.setBorder(bo);
		// Menukategorien werden erstellt
		JMenu menuData = new JMenu("Datei");
		JMenu menuFilter = new JMenu("Filter");
		JMenu menuHelp = new JMenu("Hilfe");
		// MenuItems werden erstellt
		JMenuItem itemClose = new JMenuItem(close);
		JMenuItem itemImpressum = new JMenuItem(impressum);
		JMenuItem itemNewImage = new JMenuItem(newImage);
		JMenuItem itemOpen = new JMenuItem(open);
		JMenuItem itemSave = new JMenuItem(save);
		JMenuItem itemInvert = new JMenuItem(invert);
		JMenuItem itemGrayStages = new JMenuItem(grayScale);
		JMenuItem itemHorizontal = new JMenuItem(horizontal);
		JMenuItem itemVertical = new JMenuItem(vertical);
		JMenuItem itemAllColor = new JMenuItem(allColor);
		JMenuItem itemRecolor = new JMenuItem(recolor);
		// Befehl wird MenuItem hinzugefuegt
		itemClose.addActionListener(this);
		itemImpressum.addActionListener(this);
		itemNewImage.addActionListener(this);
		itemOpen.addActionListener(this);
		itemSave.addActionListener(this);
		itemInvert.addActionListener(this);
		itemGrayStages.addActionListener(this);
		itemHorizontal.addActionListener(this);
		itemVertical.addActionListener(this);
		itemAllColor.addActionListener(this);
		itemRecolor.addActionListener(this);
		// Eintraege Menuleiste
		menubar.add(menuData);
		menubar.add(menuFilter);
		menubar.add(menuHelp);
		// Eintraege Menupunkt Datei
		menuData.add(itemNewImage);
		menuData.add(itemOpen);
		menuData.add(itemSave);
		menuData.add(itemClose);
		// Eintraege Menupunkt Filter
		menuFilter.add(itemInvert);
		menuFilter.add(itemGrayStages);
		menuFilter.add(itemHorizontal);
		menuFilter.add(itemVertical);
		menuFilter.add(itemAllColor);
		menuFilter.add(itemRecolor);
		// Eintraege Menupunkt Hilfe
		menuHelp.add(itemImpressum);

		Dimension abmessung = new Dimension(1024, 768);

		contentPane.setPreferredSize(abmessung);

		scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		// scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		// JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPanel.setViewportView(contentPane);
		window.setContentPane(scrollPanel);

		scrollPanel.setVisible(true);
		contentPane.setVisible(true);
		window.setJMenuBar(menubar);
		window.setVisible(true);

	}

	// Getter- und Setter-Methoden
	/**
	 * Gibt ein PixelArtImage zurueck
	 * 
	 * @return PixelArtImage
	 */
	public PixelArtImage getPixelArt() {
		return pixelArt;
	}

	// Methoden
	/**
	 * Oeffnet eine Dateiauswahl und uebergibt Dateinamen an die Methode saveToFile
	 * 
	 * @return true, wenn das Speichern erfolgreich war, sonst false
	 */
	public boolean speichernDialog() {
		// Fenster fuer Dateiauswahl
		JFileChooser chooser = new JFileChooser();
		int rueckgabeWert = chooser.showSaveDialog(null);
		// prueft, ob eine Datei ausgewaehlt wurde
		if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			// uebergibt den Dateipfad an die Methode saveToFile und prueft
			// deren Rueckgabewert
			if (this.getPixelArt().saveToFile(chooser.getSelectedFile().getAbsolutePath()) == true) {
				// Dialogfenster, wenn speichern erfolgreich war
				JOptionPane.showMessageDialog(gui.GraphicalUI.window, "PixelArtImage wurde erfolgreich gespeichert.",
						"Speichern erfolgreich", JOptionPane.PLAIN_MESSAGE);
				gui.GraphicalUI.contentPane.setVisible(true);
				gui.GraphicalUI.window.setVisible(true);
				return true;
			} else {
				// Dialogfenster, wenn speichern fehlschlug
				JOptionPane.showMessageDialog(gui.GraphicalUI.window, "PixelArtImage wurde nicht gespeichert.",
						"Speichern fehlgeschlagen", JOptionPane.PLAIN_MESSAGE);
				return false;
			}
		}
		return false;
	}

	/**
	 * oeffnet ein Dialogfenster, welches fragt, ob vor dem beenden gespeichert
	 * werden soll
	 */
	public void beendenDialog() {
		Object[] options = { "Speichern und beenden", "Beenden ohne zu speichern" };
		// prueft welche Auswahl vom Nutzer gewaehlt wurde und speichert sie als
		// Integer
		// Wert ab
		int n = JOptionPane.showOptionDialog(gui.GraphicalUI.window,
				"Moechten Sie Ihr PixelArtImage speichern bevor Sie die Anwendung beenden?", "Beenden",
				JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[1]);
		// wenn Option 1 gewaehlt wurde, wird die Methode speichernDialog
		// aufgerufen
		if (n == 0) {
			/*
			 * ruft {@link #speichernDialog()} auf
			 */
			if (speichernDialog()) {
				// wenn das Speichern erfolgreich war, wird das Programm beendet
				gui.GraphicalUI.window.dispose();
			}
			// wenn Option 2 gewaehlt wurde, wird das Programm beendet
		} else if (n == 1) {
			gui.GraphicalUI.window.dispose();
		}
	}

	/**
	 * oeffnet eine Dateiauswahl und uebergibt Datei an die Methode loadFromFile
	 */
	public void openDialog() {
		// leert den Container
		contentPane.removeAll();
		// Fenster fuer Dateiauswahl
		JFileChooser chooser = new JFileChooser();
		int rueckgabeWert = chooser.showOpenDialog(null);
		// prueft, ob "oeffnen" oder "abbrechen" gedrueckt wurde
		if (rueckgabeWert == JFileChooser.APPROVE_OPTION) {
			// prueft, ob das Laden funktioniert hat
			if (this.getPixelArt().loadFromFile(chooser.getSelectedFile().getAbsolutePath()) == true) {
				// setzt neues GridLayout
				contentPane.setLayout(
						new GridLayout(this.getPixelArt().getHeight() + 1, this.getPixelArt().getWidth() + 1));
				// setzt die Pixel in das GridLayout ein
				for (int hoehe = 0; hoehe <= this.getPixelArt().getHeight(); hoehe++) {
					for (int breite = 0; breite <= this.getPixelArt().getWidth(); breite++) {
						contentPane.add(this.getPixelArt().pixelFeld[hoehe][breite].getForm());
					}
				}
				contentPane.setVisible(true);
				window.setVisible(true);
				// Dialog, der anzeigt, dass das Laden erfolgreich war
				JOptionPane.showMessageDialog(gui.GraphicalUI.window, "PixelArtImage wurde erfolgreich geladen.",
						"Laden erfolgreich", JOptionPane.PLAIN_MESSAGE);
			} else {
				// contentPane.removeAll();
				// Dialog, der anzeigt, dass das Laden fehlschlug
				JOptionPane.showMessageDialog(gui.GraphicalUI.window, "PixelArtImage wurde nicht geladen.",
						"Laden fehlgeschlagen", JOptionPane.PLAIN_MESSAGE);
				// contentPane.setVisible(true);
				// window.setVisible(true);
			}
		} else {
			window.repaint();
			contentPane
					.setLayout(new GridLayout(this.getPixelArt().getHeight() + 1, this.getPixelArt().getWidth() + 1));
			// setzt die Pixel in das GridLayout ein
			for (int hoehe = 0; hoehe <= this.getPixelArt().getHeight(); hoehe++) {
				for (int breite = 0; breite <= this.getPixelArt().getWidth(); breite++) {
					contentPane.add(this.getPixelArt().pixelFeld[hoehe][breite].getForm());
				}
			}
			// contentPane.setVisible(true);
			// window.setVisible(true);
		}
	}

	/**
	 * fragt Parameter des PixelArtImages ab und erstellt ein weisses Bild
	 */
	public void newImageDialog() {
		contentPane.removeAll();
		String eingabe = null;
		double wKomma = 1.2, hKomma = 1.2;
		int w = 1, h = 1;
		/**
		 * Fragt Hoehe und Breite vom Nutzer ab und prueft ungueltige Werteingaben
		 * 
		 * @throws Exception
		 *             f prueft gueltige Werteingabe, sonst erneut eingeben
		 */
		while (wKomma - (int) wKomma != 0 || wKomma < 1) {
			try {
				eingabe = JOptionPane.showInputDialog("Bitte geben Sie die Breite des Bildes ein:");
				wKomma = Double.parseDouble(eingabe);
				w = Integer.parseInt(eingabe);
			} catch (Exception f) {
				JOptionPane.showMessageDialog(gui.GraphicalUI.window,
						"Ungueltige Werteingabe!\n" + "Geben Sie eine positive Ganzzahl ein.", "Error 404",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		while (hKomma - (int) hKomma != 0 || hKomma < 1) {
			try {
				eingabe = JOptionPane.showInputDialog("Bitte geben Sie die Hoehe des Bildes ein:");
				hKomma = Double.parseDouble(eingabe);
				h = Integer.parseInt(eingabe);
			} catch (Exception f) {
				JOptionPane.showMessageDialog(gui.GraphicalUI.window,
						"Ungueltige Werteingabe!\n" + "Geben Sie eine positive Ganzzahl ein.", "Error 404",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
		// Uebergibt abgefragte Werte an Objekt vom Typ PixelArtImage
		this.getPixelArt().setWidth(w);
		this.getPixelArt().setHeight(h);
		this.getPixelArt().erstelleArray(h, w);
		// setzt ein GridLayout und fuellt es mit den "Pixeln"
		contentPane.setLayout(new GridLayout(h + 1, w + 1));
		for (int hoehe = 0; hoehe <= h; hoehe++) {
			for (int breite = 0; breite <= w; breite++) {
				contentPane.add(this.getPixelArt().pixelFeld[hoehe][breite].getForm());

			}
		}
		contentPane.setVisible(true);
		contentPane.setAutoscrolls(true);
		window.setVisible(true);
	}

	// ActionListener
	@Override
	public void actionPerformed(ActionEvent a) {
		// TODO Automatisch generierter Methodenstub

		/**
		 * ruft Methode zum Erzeugen eines neuen Spielfeldes auf
		 * 
		 * ruft {@link #newImageDialog()} auf
		 */
		if (newImage.equals(a.getActionCommand())) {
			newImageDialog();
		}
		/**
		 * ruft Methode zum oeffnen einer .pixelart Datei auf
		 * 
		 * ruft {@link #openDialog()} auf
		 */
		if (open.equals(a.getActionCommand())) {
			openDialog();
		}
		/**
		 * ruft Methode zum speichern des aktuellen PixelArtImages auf
		 * 
		 * ruft {@link #speichernDialog()} auf
		 */
		if (save.equals(a.getActionCommand())) {
			speichernDialog();
		}
		/**
		 * ruft Methode zum beenden des Programms auf
		 * 
		 * ruft {@link #beendenDialog()} auf
		 */
		if (close.equals(a.getActionCommand())) {
			beendenDialog();
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum invertieren auf
		 */
		if (invert.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().invertColors();
			}
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum umwandeln in Graustufen auf
		 */
		if (grayScale.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().convertToGrayScale();
			}
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum horizontal spiegeln auf
		 */
		if (horizontal.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().mirrorHorizontally();
			}
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum vertikal spiegeln auf
		 */
		if (vertical.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().mirrorVertically();
			}
		}
		/**
		 * oeffnet einen MessageDialog mit Namen und Matrikelnummer
		 */
		if (impressum.equals(a.getActionCommand())) {
			JOptionPane.showMessageDialog(window, "<html>Matrikelnummer: 10006891 <br>Name: Mampe, Bernd</html>",
					"Impressum", JOptionPane.INFORMATION_MESSAGE);
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum einfaerben auf
		 */
		if (allColor.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().allColor();
			}
		}
		/**
		 * ruft Methode der Klasse PixelArtImage zum umfaerben aller weissen Felder auf
		 */
		if (recolor.equals(a.getActionCommand())) {
			if (this.getPixelArt().getHeight() <= 0 || this.getPixelArt().getWidth() <= 0) {
				JOptionPane.showMessageDialog(window,
						"Kein PixelArtImage vorhanden, auf das der Filter angewendet werden kann.",
						"Kein PixelArtImage", JOptionPane.WARNING_MESSAGE);
			} else {
				this.getPixelArt().recolorAllWhite();
			}
		}
	}
}
