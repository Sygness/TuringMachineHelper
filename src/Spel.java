import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bijhouden ronden en aantal keer raden binnen een ronde.
 * Spelfeedback naar speler (console).
 *
 */

//TODO controlekaarten data hier onderbrengen zodat enkel de nodige kaarten worden ingelezen?

public class Spel {

    private int round, guessThisRound, guessTotal;
    private Scanner consoleInput = new Scanner(System.in);
    private Machine turingComputer = new Machine();
    private int aantal = 0; // aantal criteria in het spel
    private static final String[] alfabet = {"A","B","C","D","E","F"};

    public Spel() {
        round = 1;
        guessThisRound = 0;
        guessTotal = 0;

    }
    // methoden voor toevoegen vraag, met max 3 voor een nieuwe ronde start.

    public int getRound() {
        return round;
    }

    public int getGuessThisRound() {
        return guessThisRound;
    }

    public int getGuessTotal() {
        return guessTotal;
    }

    /**
     * Voeg een vraag toe aan de teller.
     */
    public void makeGuess() {
        guessThisRound = guessThisRound++;
        guessTotal = guessTotal + 1;
    }

    /**
     * Methode voor het starten van een nieuwe ronde.
     */
    public void endRound() {
        round = round+1;
        guessThisRound = 0;
    }

    public void startSpel() {
        System.out.println("Turing Machine spel instellen.");
        System.out.println("Hoeveel criterium kaarten zijn er nodig? (Opties: 4, 5, of 6)");
        boolean keuzeGeaccepteerd = false;
        getAantalCriteria();

        while (!keuzeGeaccepteerd) {
            if (aantal < 4 || aantal > 6) {
                System.out.println("Keuze ongeldig, kies 4, 5 of 6.");
                getAantalCriteria();
            }
            else {
                keuzeGeaccepteerd = true;
            }
        }
        System.out.println("OK. Geef nu de " + aantal + " kaartnummers op, gescheiden met een spatie");
        System.out.println("Kaartnummers bestaan uit 3 cijfers, van 201 t/m 795.");
        getKaartnummers();
        System.out.println("Oplossing ingesteld.");
    }

    public void speelSpel() {
        Scanner sc = new Scanner(System.in);
        boolean eindeSpel = false;
        System.out.println("Start Turing Machine spel.");
        while(!eindeSpel) {
            speelRonde(kiesCombinatie());
        }
    }

    private int kiesCombinatie(){
        System.out.println("Ronde " + getRound() + ". Kies testcombinatie.");
        System.out.println("Een geldige testcombinatie bestaat uit 3 cijfers, van 1 t/m 5. Bijv. 151.");
        Scanner sc = new Scanner(System.in);
        try {
            int test = sc.nextInt();
            // controle op geldige combi
            if(turingComputer.getAntwoordVak(test) == 0){
                kiesCombinatie();
            }
            return test;
        }
        catch (InputMismatchException e) {
            System.out.println("Ongeldige testcombinatie. Kies opnieuw.");
            kiesCombinatie();
        }
        return 0;
    }

    private void speelRonde(int combinatie){
        if (combinatie == 0) {
            System.out.println("Ongeldige testcombinatie. Kies opnieuw.");
            speelRonde(kiesCombinatie());
            return;
        }
        System.out.println("Deze ronde test combinatie " + combinatie + ".");
        System.out.println("Kies 1, 2 of 3 criteria om deze combinatie op te testen. (Letter van beschikbaar criterium, bijv \"A\".");
        System.out.println("Type \"X\" om de ronde af te breken.");
        Scanner sc = new Scanner(System.in);
        try {
            String kaart = sc.next();
            System.out.println(kaart);
        }
        catch (InputMismatchException e) {
            System.out.println("Ongeldige testcombinatie. Kies opnieuw.");
            speelRonde(combinatie);
        }
    }

    private void getAantalCriteria() {
        Scanner sc = new Scanner(System.in);
        try {
            aantal = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Keuze ongeldig, kies 4, 5 of 6.");
            getAantalCriteria();
        }
    }

    private void getKaartnummers () {
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < aantal; i++ ) {
                switch (alfabet[i]) {
                    case "A":
                        int kaartA = sc.nextInt();
                        turingComputer.setKaartA(kaartA);
                        if (turingComputer.controleerKaartIDs("A") == 0) {
                            System.out.println("Gekozen kaartnummer A is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("Gekozen controlekaarten: ");
                            System.out.println("A = " + kaartA);
                        }
                        break;
                    case "B":
                        int kaartB = sc.nextInt();
                        turingComputer.setKaartB(kaartB);
                        if (turingComputer.controleerKaartIDs("B") == 0) {
                            System.out.println("Gekozen kaartnummer B is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("B = " + kaartB);
                        }
                        break;
                    case "C":
                        int kaartC = sc.nextInt();
                        turingComputer.setKaartC(kaartC);
                        if (turingComputer.controleerKaartIDs("C") == 0) {
                            System.out.println("Gekozen kaartnummer C is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("C = " + kaartC);
                        }
                        break;
                    case "D":
                        int kaartD = sc.nextInt();
                        turingComputer.setKaartD(kaartD);
                        if (turingComputer.controleerKaartIDs("D") == 0) {
                            System.out.println("Gekozen kaartnummer D is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("D = " + kaartD);
                        }
                        break;
                    case "E":
                        int kaartE = sc.nextInt();
                        turingComputer.setKaartE(kaartE);
                        if (turingComputer.controleerKaartIDs("E") == 0) {
                            System.out.println("Gekozen kaartnummer E is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("E = " + kaartE);
                        }
                        break;
                    case "F":
                        int kaartF = sc.nextInt();
                        turingComputer.setKaartF(kaartF);
                        if (turingComputer.controleerKaartIDs("F") == 0) {
                            System.out.println("Gekozen kaartnummer F is ongeldig. Probeer het opnieuw.");
                            getKaartnummers();
                            return;
                        }
                        else {
                            System.out.println("F = " + kaartF);
                        }
                        break;
                    default:
                        System.out.println("Er gaat iets mis bij het opslaan van de gekozen kaartnummers.");
                        System.out.println("Probeer het opnieuw.");
                }
            }
        }
        catch (InputMismatchException e) {
            System.out.println("Kaartnummers bestaan uit 3 cijfers, van 201 t/m 795. Kies opnieuw.");
            System.out.println("Geef " + aantal + " kaartnummers op.");
            getKaartnummers();
        }
    }

    public void endSpel() {
        System.out.println("Einde spel. Je hebt " + guessTotal + " tests gedaan in " + round + " ronde(n).");
    }
}
