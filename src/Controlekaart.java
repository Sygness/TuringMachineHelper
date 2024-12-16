import java.util.ArrayList;

/**
 * Klasse bevat de informatie van de controlekaarten, ID en posities die true geven.
 * Op dit moment bevast deze klasse nog expliciet de kleurgegevens, en wordt aangemaakt op basis van
 * het bestand controlekaarten.txt. Het kleurdeel is overbodig en wordt niet gebruikt.
 * Later er nog uit halen, maar bestand bewaren als data overzicht.
 */

//TODO kaartnummers array verwijderen. Zijn niet nodig.

public class Controlekaart {

    private int kaartID;
    private ArrayList<Integer> kleurnummers;
    private ArrayList<Integer> truePosities;

    public Controlekaart(int kaartID, ArrayList<Integer> kleuren, ArrayList<Integer> posities) {
        // ID, kleurnrs Array, en truePositiesArray aanmaken
        this.kaartID = kaartID;
        this.kleurnummers = kleuren;
        this.truePosities = posities;
    }

    // methode om voor een gegeven positie op te zoeken of die true geeft of niet
    public boolean checkCriterium(int positie) {
        for (int pos : truePosities) {
            if (pos == positie) {
                return true;
            }
        }
        return false;
    }
}
