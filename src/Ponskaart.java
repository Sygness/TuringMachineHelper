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

    public String toString() {
        return "Het controlevak voor " + getal + " is " + controlevak + ".";
    }

}
