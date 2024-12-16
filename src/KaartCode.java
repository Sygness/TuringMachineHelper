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
