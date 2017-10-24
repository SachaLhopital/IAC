package Agents;

import Utilities.Interaction;
import Utilities.Motivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class AgentSequentiel extends Agent {

    public List<Interaction> historiqueInteraction;

    public AgentSequentiel(Motivation m) {
        super(m);
        historiqueInteraction = new ArrayList();
    }

    @Override
    public int chooseExp(int result) {

        //Pour la première action de l'agent on ne rentre pas dans le if
        if(result != 0) {

            //PSEUDO todo :
        /*
            Le result passé en paramètre correspond au résultat de l' action précédente.
            Dans la toute première itération, on a pas de historiqueInteraction assiocié.
            Par contre dès la 2e on ajoute une intéraction composée de l'action choisi
            avec comme action précédente l'intéraction/l'expérience précédente

            => prévoir l'ajour de l'intéraction courante dans l'historique lorsqu'on l'a choisi
            => prévoir la mise à jour de celle-ci lorsqu'on a obtenu le résultat

        */
            updateInteraction(result);

            if(historiqueInteraction.size() > 1) {

                int bestKey = 0;
                int bestValue = 0;
                int currentKey = 0;
                int currentValue = 0;
                Interaction iPrec;
                HashMap<Integer, Integer> nextActions = new HashMap<>(); //<Action, Gain>

                for (Interaction activatedInteraction : historiqueInteraction) {

                    if((iPrec = activatedInteraction.getPreviousInteraction()) != null) {

                        currentKey = iPrec.getAction();
                        currentValue = activatedInteraction.getWeight();

                        nextActions.put(currentKey, currentValue);

                        if (bestKey == 0 || currentValue > bestValue) {
                            bestKey = currentKey;
                            bestValue = currentValue;
                        }
                    }
                }

                System.out.println("Meilleur action choisie : " + bestKey + " ; value : " + bestValue);
                setLastExperience("" + bestKey + bestValue);
            } else {

                //Effectue une action non réalisée jusqu'à maintenant
                setLastExperience(getActionNotTestedYet());
            }

            saveInteraction();
        }

        return getLastExperience();
    }

    private void saveInteraction() {
        //On récupère l'intéraction précédente si elle existe
        int lastExp = getLastExperience();


        Interaction previousInteraction;

        if (historiqueInteraction.size() > 0) {
            //on récupère l'intéraction précédente
            previousInteraction = historiqueInteraction.get(historiqueInteraction.size() - 1);

        } else {

            String firstExp = historiqueExperiences.size() > 0 ? historiqueExperiences.get(0) : null;

            previousInteraction = new Interaction(
                    getNumberOfAction(firstExp),
                    getNumberOfResult(firstExp),
                    motivation.getReward("" + firstExp),
                    null);
        }

        //ajout de la dernière expérience dans la liste des intéractions
        historiqueInteraction.add(
                new Interaction(
                        lastExp,
                        0,
                        0,
                        previousInteraction));
    }

    /***
     * Update an interaction based on the last result
     * @param result
     */
    private void updateInteraction(int result) {

        Interaction interactionToUpdate;

        //On récupère l'itéraction à modifier
        if(historiqueInteraction.size() > 0) {

            int index = historiqueInteraction.size() - 1;

            interactionToUpdate = historiqueInteraction.get(index);
            interactionToUpdate.SetResult(result);
            interactionToUpdate.AddValue(motivation.getReward("" + getLastExperience() + result));

            historiqueInteraction.set(index, interactionToUpdate);
        }

        System.out.println("Update historique : " + historiqueInteraction.toString());
    }

    private int getNumberOfResult(String s) {
        return Character.getNumericValue(s.charAt(1));
    }
}
