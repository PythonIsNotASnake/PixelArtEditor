package interfaces;

import java.awt.Color;

/**
 * Interface for PixelArt images.
 * 
 * @author weiss
 */
public interface PixelArtImageInterface {
    /**
     * Gibt die Breite des Bildes zurück.
     * @return Breite des Bildes
     */
    public int getWidth();

    /**
     * Gibt die Höhe des Bildes zurück.
     * @return Höhe des Bildes
     */
    public int getHeight();

    /**
     * Gibt den Farbwert an einer bestimmten Position zurück.
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @return Farbwert
     */
    public Color getPixelAt(int x, int y);

    /**
     * Setzt den Farbwert an einer bestimmten Position.
     * @param x X-Koordinate
     * @param y Y-Koordinate
     * @param color Farbwert
     */
    public void setPixelAt(int x, int y, Color color);

    /**
     * Speichert das Bild in einer Datei.
     * @param filename Dateiname
     * @return true, wenn das Speichern erfolgreich war, sonst false
     */
    public boolean saveToFile(String filename);

    /**
     * Lädt das Bild aus einer Datei.
     * @param filename Dateiname
     * @return true, wenn das Laden erfolgreich war, sonst false
     */
    public boolean loadFromFile(String filename);

    /**
     * Invertiert alle Farben im Bild.
     */
    public void invertColors();

    /**
     * Konvertiert das Bild in ein Graustufenbild.
     */
    public void convertToGrayScale();

    /**
     * Spiegelt das Bild horizontal.
     */
    public void mirrorHorizontally();

    /**
     * Spiegelt das Bild vertikal.
     */
    public void mirrorVertically();
}