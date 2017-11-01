package src;

import src.Agents.Agent;
import src.Agents.AgentSequentiel;
import src.Environments.Env1;
import src.Environments.Env2;
import src.Environments.Env3;
import src.Environments.Environment;
import src.Utilities.Motivation;

import java.util.HashMap;
import java.util.Scanner;

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
    public static final HashMap<String, Integer> SYSTEM_MOTIV_4 = new HashMap<String, Integer>() {{
        put("11", -1);
        put("12", 1);
        put("21", -1);
        put("22", 1);
    }};

    public static final int NB_ITERATIONS = 100;

    public static Scanner sc;
    public static String temp;

    public static void main(String[] args) {

        sc = new Scanner(System.in);

        System.out.println("-------------------------------------------\n"
                + "Code de Travaux pratiques :\n"
                + "Implémentation\u200B \u200Bd’algorithme\u200B \u200Bd’apprentissage\u200B \u200Bdéveloppemental.\n"
                + "Réalisé par A. JOUAL & S. LHOPITAL - Automne 2017\n"
                + "-------------------------------------------");


        while(true) {

            System.out.println("\nSelectionner la partie avec la laquelle vous souhaitez jouer [1, 2 ou 3]\n"
                    +"('exit' pour quitter le programme) : ");

            temp = sc.nextLine();

            switch (temp) {

                case "1":
                    doPartieI();
                    break;

                case "2":
                    doPartieII();
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

    //////////////////////////////
    // IA methodes

    /***
     * Manager for : Partie 1. Échauffement
     */
    private static void doPartieI() {

        Environment e;

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

        Motivation m = selectMotivation();
        learn(e, m, new Agent(m));
    }

    /***
     * Manager for : Partie 2. Apprentissage de Séquences
     */
    private static void doPartieII(){

        System.out.println("-------------------------------------------\n"
                + "Partie 2. Apprentissage de Séquences"
                + "\n-------------------------------------------\n");

        Environment environment = new Env3();
        Motivation m = new Motivation(SYSTEM_MOTIV_4);
        learn(environment, m, new AgentSequentiel(m));
    }

    /***
     * Do the experiment :
     * The agent choose an experiment, then use the result in his next choice
     * @param e
     * @param e
     * @param m
     * @param agent
     */
    private static void learn(Environment e, Motivation m, Agent agent) {
        int exp;
        int res = 0;

        for (int i = 0; i < NB_ITERATIONS ; i ++){

            exp = agent.chooseExp(res);
            res = e.getResultat(exp);

            System.out.println(" ==== >  [e"
                    + exp + ",r"
                    + res + ","
                    + m.getReward("" + exp + res) + "]");
        }

        System.out.println("Historique des séquences apprises par l'agent : "
                + ((AgentSequentiel) agent).historiqueInteraction.toString());
    }


    //////////////////////////////
    // Scanner methodes

    /***
     * Ask for the user the motivationnal system
     * @return
     */
    private static Motivation selectMotivation() {
        System.out.println("\nChoisissez le système motivationnel [1, 2 ou 3] : \n" +
                "(Attention, la première action de l'agent est aléatoire...) \n");

        temp = sc.nextLine();

        if(temp.equals("1")) {
            return new Motivation(SYSTEM_MOTIV_1);
        } else if(temp.equals("2")) {
            return new Motivation(SYSTEM_MOTIV_2);
        }
        return new Motivation(SYSTEM_MOTIV_3);
    }
}
