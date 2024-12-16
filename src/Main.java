import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * The Turing Machine spelen zonder kaarten sorteren!
 * Meer info en raadsels te vinden op <a href="https://www.turingmachine.info/">turingmachine.info</a>.
 * Dit programma genereert geen vraagstellingen.
 */
public class Main {
    public static void main(String[] args) {

        // Eerst machine aanmaken, die kaarten inleest
        Machine computer = new Machine();
        int combinatie = 0;
        int aantalCriteria = 0;
        int controleA, controleB, controleC, controleD;
        int controleE = 0;
        int controleF = 0;

        int kaartlijst[] = new int[380];
        System.out.println(kaartlijst[0]);
        System.out.println(kaartlijst[kaartlijst.length-1]);

        System.out.println("kaart ID = ");
        System.out.println(computer.getKaartID(330));






        /**

        // code om spel te starten, geef controlekaartnummers en evt vraagkaarten op
        // vind manier om die te laden in de computer.

        System.out.println("Spel instellen.");
        System.out.println("Hoeveel criteria zijn er? (4, 5 of 6)");

        Scanner input = new Scanner(System.in);
        aantalCriteria = input.nextInt();

        System.out.println("Er zijn " + aantalCriteria + " criteria");
        System.out.println("Controlekaart A:");
        controleA = input.nextInt();
        System.out.println("Controlekaart B:");
        controleB = input.nextInt();
        System.out.println("Controlekaart C:");
        controleC = input.nextInt();
        System.out.println("Controlekaart D:");
        controleD = input.nextInt();
        if (aantalCriteria > 4) {
            System.out.println("Controlekaart E:");
            controleE = input.nextInt();
            if (aantalCriteria > 5) {
                System.out.println("Controlekaart F:");
                controleF = input.nextInt();
            }
        }


        System.out.println("De volgende controlekaarten zijn gekozen:");
        System.out.println("A = " + controleA);
        System.out.println("B = " + controleB);
        System.out.println("C = " + controleC);
        System.out.println("D = " + controleD);
        if (aantalCriteria > 4) {
            System.out.println("E = " + controleE);
            if (aantalCriteria > 5) {
                System.out.println("F = " + controleF);
            }
        }

        System.out.println("Begin spel, ronde 1!");
        System.out.println("Kies combinatie voor deze ronde:");
        // System.out.println("Een combinatie is een getal dat bestaat uit drie cijfers van 1 t/m 5");

        combinatie = input.nextInt();
        int antwoord = computer.getAntwoordVak(combinatie);
        System.out.println(antwoord);

         **/

    }
}