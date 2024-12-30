import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Bijhouden ronden en aantal keer raden binnen een ronde.
 * Spelfeedback naar speler (console).
 * Herhaalde input vragen tot gebruiker spel beëindigd.
 */

public class Spel {

    private int round, guessLeftThisRound, guessTotal;
    private Machine turingComputer = new Machine();
    private int aantalCriteria = 0; // aantal criteria in het spel
    private static ArrayList<String> alfabet = new ArrayList<>();
    private boolean eindeSpel = false;

    public Spel() {
        round = 1;
        guessLeftThisRound = 3;
        guessTotal = 0;
        alfabet.add("A");
        alfabet.add("B");
        alfabet.add("C");
        alfabet.add("D");
        alfabet.add("E");
        alfabet.add("F");
    }
    // methoden voor toevoegen vraag, met max 3 voor een nieuwe ronde start.

    public int getRound() {
        return round;
    }

    /**
     * Voeg een vraag toe aan de teller.
     */
    public void makeGuess() {
        guessLeftThisRound = guessLeftThisRound-1;
        guessTotal = guessTotal + 1;
    }

    /**
     * Methode voor het starten van een nieuwe ronde.
     */
    public void endRound() {
        System.out.println("Einde ronde " + getRound() + ".");
        guessLeftThisRound = 3;
    }

    public void startSpel() {
        System.out.println("Turing Machine spel instellen.");
        System.out.println("Hoeveel criterium kaarten zijn er nodig? (Opties: 4, 5, of 6)");
        boolean keuzeGeaccepteerd = false;
        getAantalCriteria();

        while (!keuzeGeaccepteerd) {
            if (aantalCriteria < 4 || aantalCriteria > 6) {
                System.out.println("Keuze ongeldig, kies 4, 5 of 6.");
                getAantalCriteria();
            }
            else {
                keuzeGeaccepteerd = true;
            }
        }
        System.out.println("OK. Geef nu de " + aantalCriteria + " kaartnummers op, gescheiden met een spatie");
        System.out.println("Kaartnummers bestaan uit 3 cijfers, van 201 t/m 795.");
        getKaartnummers();
        System.out.println("Oplossing ingesteld.");
    }

    public void speelSpel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Start Turing Machine spel.");
        while(!eindeSpel) {
            speelRonde(kiesCombinatie());
            System.out.println("Nog een ronde spelen? J/N");
            String antwoord = sc.nextLine().toUpperCase();
            if (antwoord.contains("N")) {
                eindeSpel = true;
            }
            else {
                round = round + 1;
            }
        }
        endSpel();
    }

    private int kiesCombinatie(){
        System.out.println("Ronde " + getRound() + ". Kies combinatie om te testen.");
        System.out.println("Een geldige combinatie bestaat uit 3 cijfers, van 1 t/m 5. Bijv. 151.");

        Scanner sc = new Scanner(System.in);
        try {
            int test = sc.nextInt();
            // controle op geldige combi
            if(turingComputer.getAntwoordVak(test) == 0){
                return kiesCombinatie();
            }
            return test;
        }
        catch (InputMismatchException e) {
            System.out.println("Ongeldige combinatie. Kies opnieuw.");
            return kiesCombinatie();
        }
    }

    private void speelRonde(int combinatie){
        if (combinatie == 0) {
            System.out.println("Ongeldige combinatie. Kies opnieuw.");
            speelRonde(kiesCombinatie());
            return;
        }
        System.out.println("Deze ronde test combinatie " + combinatie + ".");
        System.out.println("Kies 1, 2 of 3 criteria om deze combinatie op te testen. (Letter van beschikbaar criterium, bijv \"A\".");
        System.out.println("Type \"X\" om de ronde af te breken.");
        testControlekaarten(combinatie);

    }

    private void getAantalCriteria() {
        Scanner sc = new Scanner(System.in);
        try {
            aantalCriteria = sc.nextInt();
        }
        catch (InputMismatchException e) {
            System.out.println("Keuze ongeldig, kies 4, 5 of 6.");
            getAantalCriteria();
        }
    }

    private void getKaartnummers () {
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < aantalCriteria; i++ ) {
                switch (alfabet.get(i)) {
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
            System.out.println("Geef " + aantalCriteria + " kaartnummers op.");
            getKaartnummers();
        }
    }

    private void testControlekaarten(int voorstel) {
        Scanner sc = new Scanner(System.in);
        String spelerInput = sc.nextLine().strip().toUpperCase();
        if (spelerInput.isBlank()) {
            System.out.println("Geen of ongeldig criterium gekozen.");
            System.out.println("Kies 1, 2 of 3 criteria om deze combinatie op te testen. (Letter van beschikbaar criterium, bijv \"A\".");
            System.out.println("Type \"X\" om de ronde af te breken.");
            testControlekaarten(voorstel);
            return;
        }
        if (spelerInput.equalsIgnoreCase("X")) {
            endRound();
            return; // gaat nu verder met speelSpel-methode
        }

        ArrayList<String> gekozenTests = new ArrayList<>();

        for (int i = 0; i < spelerInput.length(); i++) {
            Character keuze = spelerInput.charAt(i);
            if (Character.isLetter(keuze)) {
                gekozenTests.add(keuze.toString().toUpperCase()); // voegt alles toe wat een letter is
            }
        }

        String criteria = "";  // string maken om gekozen letters mee te vergelijken
        for (int i = 0; i < aantalCriteria; i++) {
            criteria = criteria + alfabet.get(i);
        }

        for (String letter : gekozenTests) {
            if (criteria.contains(letter)) {
                if (guessLeftThisRound > 0) {
                    System.out.print("Test op " + letter + " = ");
                    System.out.println(turingComputer.testCriterium(voorstel, letter));
                    makeGuess();
                }
            }
        }

        if (guessLeftThisRound > 0) {
            System.out.println("Nog " + guessLeftThisRound + " test(s) over in deze ronde.");
            System.out.println("Kies nog een criterium om te testen of \"X\" om ronde te beëindigen.");
            testControlekaarten(voorstel);
            return;
        } else {
            endRound();
        }
    }

    public void endSpel() {
        System.out.println("Einde spel. Je hebt " + guessTotal + " tests gedaan in " + round + " ronde(n).");
    }
}
