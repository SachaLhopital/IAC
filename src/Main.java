package src;

import src.Agents.Agent;
import src.Agents.AgentSequentiel;
import src.Environments.*;
import src.Utilities.BoringMotivation;
import src.Utilities.Interaction;
import src.Utilities.Motivation;

import java.util.HashMap;
import java.util.Scanner;

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
                    doPartieIII();
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

        Environment environment;

        System.out.println("-------------------------------------------\n"
                + "Partie 2. Apprentissage de Séquences"
                + "\n-------------------------------------------\n"
                + "\nChoisissez l'environnement ['1' pour un l'alternance de e1 et e2"
                + "\nou '2' pour un changement de comportement apres literation 10] : ");

        temp = sc.nextLine();

        if(temp.equals("1")) {
            environment = new Env3();
        } else {
            environment = new Env4();
        }

        Motivation m = new Motivation(SYSTEM_MOTIV_4);
        Agent agent = new AgentSequentiel(m);
        learn(environment, m, agent);

        System.out.println("\n Historique des séquences apprises par l'agent (avec leur poids) : ");
        for(Interaction i : ((AgentSequentiel) agent).getHistoriqueInteraction()) {
            System.out.println("[" + i.toString() + "]");
        }
    }

    /***
     * Manager for : Partie 3. Ouverture
     */
    private static void doPartieIII() {
        System.out.println("-------------------------------------------\n"
                + "Partie 3. Ouverture"
                + "\nNotion d'ennuie : système motivationnel qui cherche à obtenir r2"
                + "\nSi l'agent obtient r2 plus de 10 fois de suite, il cherche à obtenir r1"
                + "\nEt ainsi de suite"
                + "\n-------------------------------------------\n"
                + "\nChoisissez l'environnement [1, 2 , 3 pour un l'alternance de e1 et e2"
                + "\nou 4 pour un changement de comportement apres literation 10] : ");

        Environment environment;

        temp = sc.nextLine();

        switch (temp) {
            case "1":
                environment = new Env1();
                break;
            case "2":
                environment = new Env2();
                break;
            case "3":
                environment = new Env3();
                break;
            case "4":
                environment = new Env4();
                break;
            default:
                System.out.println("Saisie non reconnue. Environnement 1 par défaut.");
                environment = new Env1();
        }

        BoringMotivation m = new BoringMotivation(SYSTEM_MOTIV_3, SYSTEM_MOTIV_4);
        Agent agent = new AgentSequentiel(m);

        int exp;
        int res = 0;

        for (int i = 0; i < NB_ITERATIONS ; i ++){

            exp = agent.chooseExp(res);
            res = environment.getResultat(exp);

            m.setNbCorrectResult((m.getReward(exp + "" + res) == 1) ? m.getNbCorrectResult() + 1 : 0);

            if(m.getNbCorrectResult() > 10) {
                m.switchMotivation();
                System.out.println("\n Historique des séquences apprises par l'agent (avec leur poids) : ");
                for(Interaction j : ((AgentSequentiel) agent).getHistoriqueInteraction()) {
                    System.out.println("[" + j.toString() + "]");
                }
            }

            System.out.println(" ==== > (" + i + ") [e"
                    + exp + ",r"
                    + res + ","
                    + m.getReward("" + exp + res) + "]");
        }

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

            System.out.println(" ==== > (" + i + ") [e"
                    + exp + ",r"
                    + res + ","
                    + m.getReward("" + exp + res) + "]");
        }
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
