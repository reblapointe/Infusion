package ca.cegepjonquiere.rebeccalapointe.infusion;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main
{
    enum The
    {
        NOIR(240, 95),
        OOLONG(360, 90),
        VERT(180, 65),
        BLANC(600, 65);

        private final int tempsInfusion;
        private final int temperature;

        The(int tempsInfusion, int temperature)
        {
            this.tempsInfusion = tempsInfusion;
            this.temperature = temperature;
        }
    }

    /**
     * main est le point d'entrée de mon programme
     * @param args arguments d'exécution
     */
    public static void main(String[] args)
    {
        try
        {
            Pattern patronCodePostal = Pattern.compile("^([A-Z][0-9][A-Z][0-9][A-Z][0-9])$");
            Scanner in = new Scanner(System.in);
            System.out.println("Entrez un code postal");
            String entree = in.nextLine().strip();
            Matcher matche = patronCodePostal.matcher(entree);
            if (matche.find())
                System.out.println("Merci! Code postal entré : " + matche.group());
            else
                System.out.println(entree + " n'est pas un code postal.");

            System.out.println("Quel the infusez-vous? Noir, Oolong, Vert ou Blanc\n");
            Scanner scan = new Scanner(System.in);
            String t = scan.next().toUpperCase();

            The choix = The.valueOf(t);

            System.out.println("L'eau devrait être à " + choix.temperature + "°C");
            System.out.println("Debut de l'infusion...\n");

            Thread.sleep(choix.tempsInfusion /* 1000*/);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
