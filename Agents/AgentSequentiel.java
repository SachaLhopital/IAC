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

            if (motivation.getReward("" + getLastExperience() + result) >= 0) {

                updateReward(result);

            } else {

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
            }

            saveHistorique(result);
        }

        return getLastExperience();
    }

    /***
     * Save the last experiment in the list of all interactions
     * @param result
     */
    private void saveHistorique(int result) {
        int lastExp = getLastExperience();
        Interaction previousInteraction =
                historiqueInteraction.size() > 0 ?
                        historiqueInteraction.get(historiqueInteraction.size() - 1) :
                        null;

        //ajout de la dernière expérience
        historiqueInteraction.add(
                new Interaction(
                        lastExp,
                        result,
                        motivation.getReward("" + lastExp + result),
                        previousInteraction,
                        null));
    }
}
