/**
 * Klasse slaat voor elke controlekaart een kleurnummer op (het groene, gele, blauwe of paarse nummer op de kaart),
 * en koppelt dit aan een ID-nummer. Gegevens worden bij het aanmaken van een object van de klasse Machine
 * ingelezen vanuit het bestand controlekaarttabel.txt.
 * Er zijn 95 unieke kaarten, maar omdat deze voor elke kleur een nummer hebben, worden er 380
 * KaartCode objecten aangemaakt.
 *
 * In de versie van 5-jan-2024 is deze klasse (en bijbehorende bronbestand/methoden) wel opgenomen,
 * maar wordt niet gebruikt.
 * In plaats daarvan wordt het bestand kaartlijst.txt gebruikt om een array aan te maken van kaartnummers.
 * Het ID wordt vervolgens berekend met behulp van de positie in de array.
 */

public class KaartCode {

    private int kaartID;
    private int kleurNummer;

    public KaartCode(int id, int nummer) {
        kaartID = id;
        kleurNummer = nummer;
    }

    public int getKaartID() {
        return kaartID;
    }

    public int getKleurNummer() {
        return kleurNummer;
    }
}
