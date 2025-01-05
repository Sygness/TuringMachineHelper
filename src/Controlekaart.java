import java.util.ArrayList;

/**
 * Klasse bevat de informatie van een controlekaart:
 * ID en posities die true geven.
 * (Posities op de "hoeken" van de kaart worden niet gebruikt door het spel. Die zijn daarom
 * niet opgenomen in het bestand met brongegevens voor de kaarten (controlekaarten.txt),
 * en worden dus ook niet ingelezen in de objecten van deze klasse.)
 */

public class Controlekaart {

    private int kaartID;
    private ArrayList<Integer> truePosities;

    public Controlekaart(int kaartID, ArrayList<Integer> posities) {
        // ID en truePositiesArray aanmaken
        this.kaartID = kaartID;
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

    public int getKaartID() {
        return kaartID;
    }
}
