/**
 * Klasse slaat op welk controlevak bij een gegeven getalcombinatie hoort.
 * Objecten worden aangemaakt door het inlezen van bronbestand ponskaarten.txt.
 * Er zijn 125 geldige combinaties.
 */

public class Ponskaart {

    private int getal;
    private int controlevak;

    public Ponskaart(int getal, int controlevak) {
        this.getal = getal;
        this.controlevak = controlevak;
    }

    public int getGetal() {
        return getal;
    }
    public int getControlevak() {
        return controlevak;
    }

    // voor testen
    public String toString() {
        return "Het controlevak voor " + getal + " is " + controlevak + ".";
    }

}
