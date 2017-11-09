package src.Agents;

import src.Main;
import src.Utilities.Interaction;
import src.Utilities.Motivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class AgentSequentiel extends Agent {

    public static final int SEQUENCE_SIZE = 2;

    private int lastResult;
    private int nb_iterations_babillage;
    private List<Interaction> historiqueInteraction;

    public AgentSequentiel(Motivation m) {
        super(m);
        historiqueInteraction = new ArrayList();
        nb_iterations_babillage = Main.NB_ITERATIONS / 3;
        lastResult = 0;
    }

    //////////////////////////////
    // Gettes & Setters

    public List<Interaction> getHistoriqueInteraction() {
        return historiqueInteraction;
    }

    public void setLastExperience(int action) {
        lastExperience = action;
    }

    public void setLastResult(int result) {
        lastResult = result;
        historiqueExperiences.add(getLastExperience() + "" + lastResult);
    }

    public int getLastResult() {
        return lastResult;
    }

    //////////////////////////////
    // Méthodes publiques

    @Override
    public int chooseExp(int result) {

        //Pour la première action de l'agent on ne rentre pas dans le if
        if(result != 0) {

            setLastResult(result);

            updateInteraction(result);

            if(nb_iterations_babillage > 1) {

                //Effectue une action aléatoire
                setLastExperience(motivation.getRandomAction());
                nb_iterations_babillage--;

            } else {

                int bestKey = 0;
                int bestValue = 0;

                HashMap<Integer, Integer> actions = new HashMap<>();

                for(Interaction i : getHistoriqueInteraction()) {

                    Interaction iPrev = i.getPreviousInteraction();

                    //L'intéraction est "activée"
                    if(iPrev.getAction() == getLastExperience() && iPrev.getResult() == getLastResult()) {

                        int proclativity = i.getWeight() * i.getValence();
                        Integer currentValue = actions.get(i.getAction());

                        if (currentValue != null) {
                            currentValue += proclativity;
                        } else {
                            currentValue = proclativity;
                        }

                        actions.put(i.getAction(), proclativity);

                        if (bestKey == 0 || currentValue > bestValue) {
                            bestKey = i.getAction();
                            bestValue = currentValue;
                        }
                    }
                }
                setLastExperience(bestKey);
            }
            saveInteraction();
        }
        return getLastExperience();
    }


    //////////////////////////////
    // Private méthods

    /***
     * Save the last action in interaction List
     * Save the action but 0 as the result because the agent doesn't know it yet.
     */
    private void saveInteraction() {

        Interaction previousInteraction;
        List<Interaction> histo = getHistoriqueInteraction();

        if (histo.size() > 0) {
            //on récupère l'intéraction précédente;
            previousInteraction = histo.get(histo.size() - 1);

        } else {

            String firstExp = historiqueExperiences.size() > 0 ? historiqueExperiences.get(0) : null;

            previousInteraction = new Interaction(
                    getNumberOfAction(firstExp),
                    getNumberOfResult(firstExp),
                    motivation.getReward(firstExp),
                    null);
        }

        Interaction realPreviousInteraction = new Interaction(previousInteraction);

        //On vérifie qu'on ne dépasse pas la taille de séquence définie.
        while(realPreviousInteraction.getSize() >= SEQUENCE_SIZE) {
            realPreviousInteraction.removeOlderInteraction();
        }

        Interaction newInteraction = new Interaction(
                getLastExperience(), 0, 0, realPreviousInteraction
        );

        historiqueInteraction.add(newInteraction);
    }

    /***
     * Update an interaction based on the last result
     * For instance, the last interaction was saved on the format : [eXr0],
     * This method will update the "r0" with the right result
     * @param result
     */
    private void updateInteraction(int result) {

        Interaction interactionToUpdate;
        List<Interaction> histo = getHistoriqueInteraction();

        //On récupère l'itéraction à modifier
        if(histo.size() > 0) {

            int index = histo.size() - 1;

            interactionToUpdate = histo.remove(index);
            interactionToUpdate.setResult(result);
            interactionToUpdate.setValence(
                    motivation.getReward(interactionToUpdate.getAction() + "" + result)
            );

            //On vérifie que l'intéraction n'existe pas déjà dans l'historique :
            // si c'est le cas, on ne fais que mettre à jour le poids
            for(Iterator<Interaction> iterator = getHistoriqueInteraction().iterator(); iterator.hasNext();) {

                Interaction i = iterator.next();

                if(i.equals(interactionToUpdate)) {
                    interactionToUpdate.addWeight(i.getWeight());
                    iterator.remove();
                }
            }
            histo.add(interactionToUpdate);
        }
    }
}