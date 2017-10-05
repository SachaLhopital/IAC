import Environments.Env1;
import Environments.Env2;
import Environments.Environment;

import java.util.HashMap;
import java.util.Scanner;

import static java.lang.System.exit;

/**
 *
 * @author PC
 */
public class Main {

    public static final HashMap<String, Integer> SYSTEM_MOTIV_1 = new HashMap<String, Integer>() {{
        put("11", 1);
        put("12", 1);
        put("21", -1);
        put("22", -1);
    }};
    public static final HashMap<String, Integer> SYSTEM_MOTIV_2 = new HashMap<String, Integer>() {{
        put("11", -1);
        put("12", -1);
        put("21", 1);
        put("22", 1);
    }};
    public static final HashMap<String, Integer> SYSTEM_MOTIV_3 = new HashMap<String, Integer>() {{
        put("11", 1);
        put("12", -1);
        put("21", 1);
        put("22", -1);
    }};
    public static final int NB_ITERATIONS = 10;

    public static Scanner sc;
    public static String temp;


    public static void main(String[] args) {

        sc = new Scanner(System.in);

        System.out.println("-------------------------------------------\n"
                + "Code de Travaux pratiques :\n"
                + "Implémentation\u200B \u200Bd’algorithme\u200B \u200Bd’apprentissage\u200B \u200Bdéveloppemental.\n"
                + "Réalisé par A. JOUAL & S. LHOPITAL - Automne 2017\n"
                + "-------------------------------------------\n\n"
                + "Selectionner la partie avec la laquelle vous souhaitez jouer [1, 2 ou 3] : ");


        while(true) {

            temp = sc.nextLine();

            switch (temp) {

                case "1":
                    doPartieI();
                    break;

                case "2":
                    //todo
                    //res = e.getResultatEnv3(exp);
                    break;

                case "3":
                    //todo
                    break;

                case "exit":
                    System.exit(0);

                default:
                    System.out.println("Saisie non reconnue."
                            + "\nAssurez-vous d'avoir saisie un chiffre (1, 2 ou 3)\n");
            }
        }
    }

    /***
     * Manager for : Partie 1. Échauffement
     */
    private static void doPartieI() {

        Environment e;
        Motivation m;
        int exp;
        int res = 0;

        System.out.println("-------------------------------------------\n"
                + "Partie 1. Échauffement"
                + "\n-------------------------------------------\n"
                + "\nChoisissez l'environnement [1 ou 2] : ");

        temp = sc.nextLine();

        if(temp.equals("1")) {
            e = new Env1();
        } else {
            e = new Env2();
        }

        System.out.println("\nChoisissez le système motivationnel [1, 2 ou 3] : ");

        temp = sc.nextLine();

        if(temp.equals("1")) {
            m = new Motivation(SYSTEM_MOTIV_1);
        } else if(temp.equals("2")) {
            m = new Motivation(SYSTEM_MOTIV_2);
        } else {
            m = new Motivation(SYSTEM_MOTIV_3);
        }

        Agent agent = new Agent(m);

        for (int i = 0 ; i < NB_ITERATIONS ; i ++){

            exp = agent.chooseExp(res);
            res = e.getResultat(exp);

            System.out.println(" ==== >  ["
                    + exp + ","
                    + res + ","
                    + m.getReward("" + exp + res) + "]");
        }
    }
    
}
