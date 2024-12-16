import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Bijhouden ronden en aantal keer raden binnen een ronde.
 *
 */

//TODO controlekaarten data hier onderbrengen zodat enkel de nodige kaarten worden ingelezen?

public class Spel {

    // private Controlekaart controleA, controleB, controleC, controleD;
    private int round, guessThisRound, guessTotal;

    public Spel() {
        round = 1;
        guessThisRound = 0;
        guessTotal = 0;

        // inlezen controlekaart gegevens?

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
     * Methode voor het starten van een nieuwe ronde. Machine class regelt wanneer dit gebeurt.
     */
    public void endRound() {
        round = round+1;
        guessThisRound = 0;
    }

    public String endSpel() {
        return "Einde spel. Je hebt " + guessTotal + " tests gedaan over " + round + "ronden.";
    }
}
