/**
 * The Turing Machine spelen zonder kaarten sorteren!
 * Meer info en raadsels te vinden op <a href="https://www.turingmachine.info/">turingmachine.info</a>.
 * Dit programma genereert geen vraagstellingen, en kan de oplossing niet controleren.
 * Als je denkt het antwoord te weten, beëindig het spel en controleer je oplossing via de website.
 */

public class Main {
    public static void main(String[] args) {

        Spel spel = new Spel();

        // spel instellen
        spel.startSpel();

        // spel spelen
        spel.speelSpel();

    }
}