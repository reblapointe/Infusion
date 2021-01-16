package ca.cegepjonquiere.rebeccalapointe.infusion;

import java.util.Scanner;

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

    public static void main(String[] args)
    {
        try
        {
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
            System.out.println(e.toString());
        }
    }
}
