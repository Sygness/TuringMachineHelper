import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * De zwarte doos, de machine die luistert naar je vraag en antwoord geeft, goed of fout.
 * Zoekt voor een gegeven getalkaart het bijbehorende controlevak op.
 *
 * Later toevoegen: controlekaarten, zodat controlevak aan een antwoord gekoppeld kan worden.
 */
public class Machine {

    private ArrayList<Ponskaart> ponskaartData;
    private ArrayList<KaartCode> controlekaartLijst;
    private ArrayList<Controlekaart> controlekaartData;

    private int kaartlijst[] = new int[380]; // array om kaartID mee op te zoeken. Niet de meest handige methode, maar wilde eens wat anders proberen dan objecten in ArrayList

    public Machine() {
        // inlezen ponskaart gegevens
        ponskaartData = getPonskaartData();

        // inlezen lijst om kaarten op te zoeken
        controlekaartLijst = getControlekaartLijst();
        kaartlijst = getKaartlijst();

        // inlezen kaartdata
        controlekaartData = getControlekaartData();
    }

    private ArrayList<Ponskaart> getPonskaartData() {
        Scanner inputStream = null;
        ponskaartData = new ArrayList<>();

        try
        {
            inputStream = new Scanner(new FileInputStream("src/resources/ponskaarten.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Bestand ponskaarten.txt niet gevonden");
            System.out.println("of niet kunnen openen.");
            System.exit(0);
        }

        // bestand uitlezen en in array met Ponskaart objecten zetten
        while(inputStream.hasNextLine()) {
            Ponskaart kaart = new Ponskaart(inputStream.nextInt(),inputStream.nextInt());
            // System.out.println(kaart); //test inlezen
            ponskaartData.add(kaart);
        }
        inputStream.close();
        return ponskaartData;
    }

    private ArrayList<KaartCode> getControlekaartLijst(){
        Scanner inputStream = null;
        controlekaartLijst = new ArrayList<>();

        try
        {
            inputStream = new Scanner(new FileInputStream("src/resources/ControlekaartTabel.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Bestand ControlekaartTabel.txt niet gevonden");
            System.out.println("of niet kunnen openen.");
            System.exit(0);
        }

        // bestand omzetten naar array om in te kunnen zoeken
        while (inputStream.hasNextLine()) {
            KaartCode code = new KaartCode(inputStream.nextInt(), inputStream.nextInt());
            controlekaartLijst.add(code);
        }
        inputStream.close();
        return controlekaartLijst;
    }

    private int[] getKaartlijst() {
        Scanner kaarten = null;

        try {
            kaarten = new Scanner(new FileInputStream("src/resources/kaartlijst.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Bestand kaartlijst.txt niet gevonden of niet kunnen openen.");
            System.exit(0);
        }

        for (int i = 0; kaarten.hasNextInt(); i++) {
            kaartlijst[i] = kaarten.nextInt();
        }

        return kaartlijst;

    }

    private ArrayList<Controlekaart> getControlekaartData(){    // alleen laden voor gebruikte kaarten

        Scanner inputStream = null;
        controlekaartData = new ArrayList<>();

        try
        {
            inputStream = new Scanner(new FileInputStream("src/resources/controlekaarten.txt"));
        }
        catch (FileNotFoundException e) {
            System.out.println("Bestand controlekaarten.txt niet gevonden");
            System.out.println("of niet kunnen openen.");
            System.exit(0);
        }

        // uitlezen en een array met Controlekaart objecten maken
        while(inputStream.hasNextLine()) {
            String regel = inputStream.nextLine();
            Scanner inputRegel = new Scanner(regel);

            // argumenten controlekaart: int ID, array kleurcodes, array trueposities
            int idnr = inputRegel.nextInt();


            ArrayList<Integer> kleurcodes = new ArrayList<>();
            ArrayList<Integer> trueposities = new ArrayList<>();

            kleurcodes.add(inputRegel.nextInt()); //groen
            kleurcodes.add(inputRegel.nextInt()); //geel
            kleurcodes.add(inputRegel.nextInt()); //blauw
            kleurcodes.add(inputRegel.nextInt()); //paars

            // variabel aantal true posities per kaart, rest van regel
            while (inputRegel.hasNextInt()) {
                trueposities.add(inputRegel.nextInt());
            }

            Controlekaart kaart = new Controlekaart(idnr, kleurcodes, trueposities);
            controlekaartData.add(kaart);

        }
        inputStream.close();
        return controlekaartData;

    }

    public int getKaartID(int kaartnummer) {

        for (int i = 0; i < kaartlijst.length; i++) {
            if (kaartlijst[i] == kaartnummer) {
                return berekenID(i);
            }
        }
        return 0; // dit betekent dat kaart niet gevonden is
    }

    private int berekenID(int positieInKaartlijst) {
        if (positieInKaartlijst < 95) {
            return positieInKaartlijst+1;           // groene kaartnummers
        } else if (positieInKaartlijst < 190) {
            return positieInKaartlijst - 94;        // gele kaartnummers
        } else if (positieInKaartlijst < 285) {
            return positieInKaartlijst - 189;       // blauwe kaartnummers
        } else {
            return positieInKaartlijst - 284;       // paarse kaartnummers
        }
    }

    public int getAntwoordVak(int combinatie){
        for (Ponskaart k : ponskaartData) {
            if (k.getGetal() == combinatie) {
                return k.getControlevak();
            }
        }
        System.out.println("Gekozen combinatie is ongeldig.");
        return 0; // misschien gebruiken voor looping ipv exit

    } // verplaatsen naar Spel?



}
