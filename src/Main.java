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
        // Spel aanmaken, dit telt tests en ronden
        Spel spel = new Spel();

        // spel instellen
        spel.startSpel();

        // spel spelen
        spel.speelSpel();

        // spel beëindigen
        spel.endSpel();


        // tests
        /**
        int kaartlijst[] = new int[380];
        System.out.println(kaartlijst[0]);
        System.out.println(kaartlijst[kaartlijst.length-1]);

        System.out.println("kaart ID = ");
        System.out.println(computer.getKaartID(688));
        System.out.println(computer.getKaartID(758));
        System.out.println(computer.getKaartID(782));
        System.out.println(computer.getKaartID(596));


        System.out.println("Antwoordvak bij combinatie 123 =");
        System.out.println(computer.getAntwoordVak(123));
        System.out.println("");

        System.out.println("start spel A449EK, stel kaart A, B, C en D in.");
        computer.setKaartA(688);
        computer.setKaartB(758);
        computer.setKaartC(782);
        computer.setKaartD(596);

        System.out.println("tests");
        System.out.println("1e testcombinatie = 123");

        System.out.print("test op A: ");
        System.out.println(computer.testCriterium(123,"A"));
        System.out.print("test op C: ");
        System.out.println(computer.testCriterium(123,"C"));
        System.out.print("test op D: ");
        System.out.println(computer.testCriterium(123,"D"));
        System.out.print("test op F: ");
        System.out.println(computer.testCriterium(123,"F"));

        System.out.println();
        System.out.println("nieuwe ronde, 2e testcombinatie = 243");
        System.out.print("test op A: ");
        System.out.println(computer.testCriterium(243,"A"));
        System.out.print("test op B: ");
        System.out.println(computer.testCriterium(243,"B"));

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