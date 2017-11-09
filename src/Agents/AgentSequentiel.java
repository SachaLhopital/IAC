package src.Agents;

import src.Utilities.Interaction;
import src.Utilities.Motivation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Sachouw on 20/10/2017.
 */
public class AgentSequentiel extends Agent {

    private int nb_iterations_babillage;

    public List<Interaction> historiqueInteraction;
    private boolean inBabillage;

    public AgentSequentiel(Motivation m) {
        super(m);
        historiqueInteraction = new ArrayList();
        inBabillage = true;
        nb_iterations_babillage = 50;
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

            if(inBabillage) {
                //explore
                System.out.println("babillage en cours");
                //Effectue une action non réalisée jusqu'à maintenant
                setLastExperience(motivation.getRandomAction());
                nb_iterations_babillage--;

                if(nb_iterations_babillage < 1) {
                    inBabillage = false;
                    System.out.println("fin babillage");
                }

            } else {



                //if(historiqueInteraction.size() > 1) {

                int bestKey = 0;
                int bestValue = 0;
                int currentKey = 0;
                int currentValue = 0;
                Interaction iPrec;
                HashMap<Integer, Integer> nextActions = new HashMap<>(); //<Action, Gain>

                for (Interaction activatedInteraction : historiqueInteraction) {

                    if((iPrec = activatedInteraction.getPreviousInteraction()) != null
                            && iPrec.getAction() == getLastExperience()) {

                        currentKey = activatedInteraction.getAction();
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
            }


            saveInteraction();
        }

        return getLastExperience();
    }






    public int chooseExp2(int result) {

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

            if(inBabillage) {
                //explore
                System.out.println("babillage en cours");
                //Effectue une action non réalisée jusqu'à maintenant
                setLastExperience(motivation.getRandomAction());
                nb_iterations_babillage--;

                if(nb_iterations_babillage < 1) {
                    inBabillage = false;
                    System.out.println("fin babillage");
                }

            } else {



                //if(historiqueInteraction.size() > 1) {

                int bestKey = 0;
                int bestValue = 0;
                int currentKey = 0;
                int currentValue = 0;
                Interaction iPrec;
                HashMap<Integer, Integer> nextActions = new HashMap<>(); //<Action, Gain>

                for (Interaction activatedInteraction : historiqueInteraction) {

                    if((iPrec = activatedInteraction.getPreviousInteraction()) != null
                            && iPrec.getAction() == getLastExperience()) {

                        currentKey = activatedInteraction.getAction();
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

        }
        else {

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
            System.out.println(" index 1 ="+historiqueInteraction.get(index) + " size ="+historiqueInteraction.size());
            interactionToUpdate = historiqueInteraction.get(index);
            interactionToUpdate.SetResult(result);
            interactionToUpdate.AddValue(motivation.getReward("" + getLastExperience() + result));


            historiqueInteraction.set(index, interactionToUpdate);
            System.out.println(" index 2 ="+historiqueInteraction.get(index) + " size ="+historiqueInteraction.size() + " action  ="+historiqueInteraction.get(index).getAction() + " label  ="+historiqueInteraction.get(index).getLabel() + " precedent ="+historiqueInteraction.get(index).getPreviousInteraction().getLabel());

        }
        int h = 0 ;
        for (int i = 0 ; i < historiqueInteraction.size(); i++){
            int index = historiqueInteraction.size() - 1;
            if (i != index && historiqueInteraction.get(i).getLabel().equals(historiqueInteraction.get(index).getLabel()) && historiqueInteraction.get(i).getPreviousInteraction().getLabel().equals(historiqueInteraction.get(index).getPreviousInteraction().getLabel())) {
                historiqueInteraction.remove(i);
            }
        }

        System.out.println("Update historique : " + historiqueInteraction.toString());
    }

    /*private int getNumberOfResult(String s) {
        return Character.getNumericValue(s.charAt(1));
    }*/
}