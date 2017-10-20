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

            /*if (motivation.getReward("" + getLastExperience() + result) >= 0) {

                updateReward(result);

            } else {*/

            //updateHistorique(result);

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

            addInteractionInHistorique();
            /*}*/
        }

        return getLastExperience();
    }

    /***
     * Add (if doesn't exist yet) the last experiment in the list of all interactions
     */
    private void addInteractionInHistorique() {

        int lastExp = getLastExperience();

        //Si on est pas à la première itération
        if(historiqueExperiences.size() > 0) {

            Interaction previousInteraction;

            //Si on adéjà enregistré une intéraction
            if(historiqueInteraction.size() > 0) {
                previousInteraction = historiqueInteraction.get(historiqueInteraction.size() - 1);
            } else {

                String firstExp = historiqueExperiences.get(0);

                previousInteraction = new Interaction(
                        getNumberOfAction(firstExp),
                        0, // <= quoi mettre ici ?
                        0, // <= quoi mettre ici ? (récupérer le résultat de la 1er action
                        null);
            }

            //ajout de la dernière expérience comme intéraction
            historiqueInteraction.add(
                    new Interaction(
                            lastExp,
                            0, // <= à mettre à jour dans le update ?
                            0, // <= à mettre à jour dans le update ?
                            previousInteraction));
        }

        System.out.println("Historique : " + historiqueInteraction.toString());
    }
}
